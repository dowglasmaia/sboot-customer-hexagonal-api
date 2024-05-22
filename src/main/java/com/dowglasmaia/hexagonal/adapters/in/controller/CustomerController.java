package com.dowglasmaia.hexagonal.adapters.in.controller;


import com.dowglasmaia.hexagonal.adapters.in.controller.mapper.CustomerRequestMapper;
import com.dowglasmaia.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.dowglasmaia.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerRequestMapper customerRequestMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){

        var request = customerRequestMapper.toCustomer(customerRequest);

        insertCustomerInputPort.insert(request, customerRequest.getZipCode());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
