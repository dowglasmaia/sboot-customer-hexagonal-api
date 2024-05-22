package com.dowglasmaia.hexagonal.adapters.in.controller.mapper;

import com.dowglasmaia.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.dowglasmaia.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.dowglasmaia.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {

    //@Mapping(target = "id",ignore = true)
    //@Mapping(target = "address",ignore = true)
    //@Mapping(target = "isValidCpf",ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);


    CustomerResponse toCustomerResponse(Customer customer);


}
