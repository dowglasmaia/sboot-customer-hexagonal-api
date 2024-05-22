package com.dowglasmaia.hexagonal.adapters.out.client.mapper;

import com.dowglasmaia.hexagonal.adapters.out.client.response.AddressResponse;
import com.dowglasmaia.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
