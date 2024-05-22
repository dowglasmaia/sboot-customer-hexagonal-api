package com.dowglasmaia.hexagonal.application.core.usecase;

import com.dowglasmaia.hexagonal.application.core.domain.Address;
import com.dowglasmaia.hexagonal.application.core.domain.Customer;
import com.dowglasmaia.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.dowglasmaia.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.dowglasmaia.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCode;
    private  final InsertCustomerOutputPort insertCustomer;

    public InsertCustomerUseCase(
          FindAddressByZipCodeOutputPort findAddressByZipCode,
          InsertCustomerOutputPort insertCustomer)
    {
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
    }


    @Override
    public void insert(Customer customer, String zipCode){
        Address address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);

        insertCustomer.insert(customer);
    }
}
