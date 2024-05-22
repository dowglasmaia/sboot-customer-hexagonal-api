package com.dowglasmaia.hexagonal.application.ports.out;

import com.dowglasmaia.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);

}
