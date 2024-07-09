package com.dowglasmaia.hexagonal.adapters.out;

import com.dowglasmaia.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.dowglasmaia.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.dowglasmaia.hexagonal.application.core.domain.Address;
import com.dowglasmaia.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;


    @Override
    public Address find(String zipCode){
        try {
            var address = findAddressByZipCodeClient.find(zipCode);

            return addressResponseMapper.toAddress(address);
        }catch (Exception e){
            log.error("Address Not Found");
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Address Not Found");
        }
    }
}
