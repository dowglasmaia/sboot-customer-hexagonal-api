package com.dowglasmaia.hexagonal.adapters.out.repository.mapper;

import com.dowglasmaia.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.dowglasmaia.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);
}
