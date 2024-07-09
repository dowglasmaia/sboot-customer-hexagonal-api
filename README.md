### Customer API

* API developed with Java 17 and Spring Boot 3

---

### ⚡ Technologies
These are some of the technologies and tools that I work with:

![Java 17](https://img.shields.io/badge/-Java%2017-007396?style=flat-square&logo=java&logoColor=white)
[![Spring Boot](https://img.shields.io/badge/-Spring%20Boot-6DB33F?style=flat-square&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![OpenTelemetry](https://img.shields.io/badge/-OpenTelemetry-2C5BB4?style=flat-square&logo=opentelemetry&logoColor=white)](https://opentelemetry.io/)
[![Jaeger](https://img.shields.io/badge/-Jaeger-00A3E0?style=flat-square&logo=jaeger&logoColor=white)](https://www.jaegertracing.io/)
[![Spring Cloud](https://img.shields.io/badge/-Spring%20Cloud-6DB33F?style=flat-square&logo=spring&logoColor=white)](https://spring.io/projects/spring-cloud)

---

## Hexagonal Architecture
<img src="./img/hexagonal-img.webp" alt="Circuit Breaker " width="860" height="600">

### 🚀 Overview
The Customer API is built using the hexagonal architecture and provides a RESTful interface for managing customer data. The API is equipped to capture traces using OpenTelemetry and Jaeger and integrates with an external address API via Spring Feign Client to fetch customer addresses. It supports the following operations:
- **POST /api/v1/customers**: Create a new customer
- **GET /api/v1/customers/document**: Retrieve a customer by CPF (query parameter)

### 🌐 API Endpoints

#### Create Customer
- **POST /api/v1/customers**
- **Description**: Creates a new customer.
- **Request Body**:
  ```json
  {
   "name": "Nome Maia",
   "cpf": "65380546099",
   "zipCode": "88000-000"
  }
  ```
- **Response**: Returns the created customer.

#### Get Customer
- **GET /api/v1/customers/document**
- **Description**: Retrieves a customer by CPF.
- **Query Parameters**:
    - `cpf`: Customer's CPF (required)
- **Response**: Returns the customer data.


---

### Technology References
* [OpenTelemetry Docs](https://opentelemetry.io/docs/)
* [Spring Boot 3](https://docs.spring.io/spring-boot/docs/3.0.0/reference/htmlsingle/)
* [Spring Cloud](https://spring.io/projects/spring-cloud)
* [Jaeger](https://www.jaegertracing.io/docs/)
