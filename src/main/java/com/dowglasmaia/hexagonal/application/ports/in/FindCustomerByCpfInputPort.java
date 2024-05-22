package com.dowglasmaia.hexagonal.application.ports.in;

import com.dowglasmaia.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByCpfInputPort {

    Customer find(String cpf);

}
