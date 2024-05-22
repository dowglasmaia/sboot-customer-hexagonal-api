package com.dowglasmaia.hexagonal.adapters.out;

import com.dowglasmaia.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.dowglasmaia.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.dowglasmaia.hexagonal.application.core.domain.Address;
import com.dowglasmaia.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;


    @Override
    public Address find(String zipCode){
        var address = findAddressByZipCodeClient.find(zipCode);

        return addressResponseMapper.toAddress(address);
    }
}
