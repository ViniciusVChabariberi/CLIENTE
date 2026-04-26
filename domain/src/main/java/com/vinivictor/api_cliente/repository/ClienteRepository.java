package com.vinivictor.api_cliente.repository;

import com.vinivictor.api_cliente.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    Cliente save(Cliente cliente);
    List<Cliente> findAll();
    Optional<Cliente> findById(String id);
    void delete(String id);
}