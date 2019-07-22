package com.vsm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vsm.model.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long> {

}
