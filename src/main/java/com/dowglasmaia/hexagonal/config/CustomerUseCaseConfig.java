package com.dowglasmaia.hexagonal.config;

import com.dowglasmaia.hexagonal.application.core.usecase.InsertCustomerUseCase;
import com.dowglasmaia.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.dowglasmaia.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerUseCaseConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
          FindAddressByZipCodeOutputPort findAddressByZipCode,
          InsertCustomerOutputPort insertCustomer
    ) {
        return new InsertCustomerUseCase(findAddressByZipCode, insertCustomer);
    }

}
