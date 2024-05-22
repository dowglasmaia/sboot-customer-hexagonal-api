package com.dowglasmaia.hexagonal.adapters.in.controller;


import com.dowglasmaia.hexagonal.adapters.in.controller.mapper.CustomerRequestMapper;
import com.dowglasmaia.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.dowglasmaia.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.dowglasmaia.hexagonal.application.ports.in.FindCustomerByCpfInputPort;
import com.dowglasmaia.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindCustomerByCpfInputPort findCustomerByCpfInputPort;
    private final CustomerRequestMapper customerRequestMapper;

    @Autowired
    public CustomerController(@Lazy InsertCustomerInputPort insertCustomerInputPort,
                              @Lazy FindCustomerByCpfInputPort findCustomerByCpfInputPort,
                              CustomerRequestMapper customerRequestMapper)
    {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.findCustomerByCpfInputPort = findCustomerByCpfInputPort;
        this.customerRequestMapper = customerRequestMapper;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        var request = customerRequestMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(request, customerRequest.getZipCode());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/document")
    public ResponseEntity<CustomerResponse> findByCpf(@RequestParam String cpf){
        var customer = findCustomerByCpfInputPort.find(cpf);
        var customerResponse = customerRequestMapper.toCustomerResponse(customer);
        return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
    }
}
