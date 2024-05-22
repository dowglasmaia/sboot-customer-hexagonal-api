package com.dowglasmaia.hexagonal.application.ports.in;

import com.dowglasmaia.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);

}
