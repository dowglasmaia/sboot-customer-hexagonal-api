package com.dowglasmaia.hexagonal.adapters.out.repository.entity;

import com.dowglasmaia.hexagonal.application.core.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class CustomerEntity {

    @Id
    private String id;
    private String name;
    private Address address;
    private String cpf;
    private Boolean isValidCpf;
}
