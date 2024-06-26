package com.dowglasmaia.hexagonal.adapters.out.repository;

import com.dowglasmaia.hexagonal.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {

    Optional<CustomerEntity>findByCpf(String cpf);
}
