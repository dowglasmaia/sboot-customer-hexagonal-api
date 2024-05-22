package com.dowglasmaia.hexagonal.application.ports.out;

import com.dowglasmaia.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByCpfOutputPort {

    Optional<Customer> find(String cpf);

}
