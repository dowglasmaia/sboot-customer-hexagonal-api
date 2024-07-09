package com.dowglasmaia.hexagonal.exeptions.handler;

import com.dowglasmaia.hexagonal.exeptions.StandardError;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ServerWebExchange;

@Log4j2
@RestControllerAdvice
public class AdviceExceptionHandle {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<StandardError> handleNotFound(HttpClientErrorException ex, ServerWebExchange servlet){
        String path = servlet.getRequest().getPath().pathWithinApplication().value();

        StandardError error = StandardError.builder()
              .timestamp(System.currentTimeMillis())
              .error("Not Found")
              .message(ex.getMessage())
              .status(HttpStatus.NOT_FOUND.value())
              .path(path)
              .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
