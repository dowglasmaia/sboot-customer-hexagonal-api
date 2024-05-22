package com.dowglasmaia.hexagonal.adapters.out.client.response;

import lombok.Data;

@Data
public class AddressResponse {
    private String id;
    private String street;
    private String city;
    private String state;
}
