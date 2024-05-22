package com.dowglasmaia.hexagonal.adapters.out.client;

import com.dowglasmaia.hexagonal.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
      name = "FindAddressByZipCodeClient",
      url = "${maia.client.address.url}"
)
public interface FindAddressByZipCodeClient {

    @GetMapping()
    AddressResponse find(@RequestParam("zipCode") String zipCode);
}
