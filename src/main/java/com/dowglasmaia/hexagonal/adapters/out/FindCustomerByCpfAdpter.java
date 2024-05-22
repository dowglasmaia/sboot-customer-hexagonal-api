package com.dowglasmaia.hexagonal.adapters.out;

import com.dowglasmaia.hexagonal.adapters.out.repository.CustomerRepository;
import com.dowglasmaia.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.dowglasmaia.hexagonal.application.core.domain.Customer;
import com.dowglasmaia.hexagonal.application.ports.out.FindCustomerByCpfOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByCpfAdpter implements FindCustomerByCpfOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String cpf){
        var customerEntity = customerRepository.findByCpf(cpf);

        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
