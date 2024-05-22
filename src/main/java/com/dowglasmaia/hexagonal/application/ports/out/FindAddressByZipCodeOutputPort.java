package com.dowglasmaia.hexagonal.application.ports.out;

import com.dowglasmaia.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);

}
