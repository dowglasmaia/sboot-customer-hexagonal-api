package com.dowglasmaia.hexagonal.application.core.usecase;

import com.dowglasmaia.hexagonal.application.core.domain.Customer;
import com.dowglasmaia.hexagonal.application.ports.in.FindCustomerByCpfInputPort;
import com.dowglasmaia.hexagonal.application.ports.out.FindCustomerByCpfOutputPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class FindCustomerByCpfUseCase implements FindCustomerByCpfInputPort {

    private final FindCustomerByCpfOutputPort findCustomerByCpfOutputPort;

    public FindCustomerByCpfUseCase(FindCustomerByCpfOutputPort findCustomerByCpfOutputPort){
        this.findCustomerByCpfOutputPort = findCustomerByCpfOutputPort;
    }

    @Override
    public Customer find(String cpf){
        return findCustomerByCpfOutputPort.find(cpf)
              .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND,"Customer Not Found"));
    }
}
