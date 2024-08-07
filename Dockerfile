# Build
FROM maven:3.9.7-amazoncorretto-17 AS build
WORKDIR /customer
COPY pom.xml .
RUN mvn dependency:resolve
COPY src ./src
RUN mvn clean install

# Runtime
FROM amazoncorretto:17-alpine3.17
LABEL MAINTAINER="DOWGLAS MAIA"
ENV SPRING_LOGGING_LEVEL=INFO
ENV PORT=8009
WORKDIR /usr/src/app

RUN apk --no-cache add tzdata curl busybox-extras \
    && cp /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime \
    && echo "America/Sao_Paulo" > /etc/timezone \
    && apk del tzdata

# Copy the built JAR from the build stage
COPY --from=build /customer/target/*.jar /usr/src/app/customer-service-api.jar

# Copy the OpenTelemetry agent
COPY ./opentelemetry/opentelemetry-javaagent.jar /usr/src/app/opentelemetry-javaagent.jar

# Verify the OpenTelemetry agent exists
RUN if [ ! -f /usr/src/app/opentelemetry-javaagent.jar ]; then echo "OpenTelemetry agent not found"; exit 1; fi

EXPOSE ${PORT}

ENTRYPOINT ["java", \
            "-noverify", \
            "-Dfile.encoding=UTF-8", \
            "-Dlogging.level.root=${SPRING_LOGGING_LEVEL}", \
            "-javaagent:/usr/src/app/opentelemetry-javaagent.jar", \
            "-Dotel.service.name=customer-service-api", \
            "-Dotel.traces.exporter=otlp", \
            "-Dotel.metrics.exporter=none", \
            "-Dotel.exporter.otlp.endpoint=http://collector-api:4318", \
            "-Dotel.exporter.otlp.protocol=http/protobuf", \
            "-jar", "/usr/src/app/customer-service-api.jar", \
            "--server.port=${PORT}"]
