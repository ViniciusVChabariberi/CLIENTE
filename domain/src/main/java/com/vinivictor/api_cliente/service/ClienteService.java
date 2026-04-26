package com.vinivictor.api_cliente.service;

import com.vinivictor.api_cliente.model.Cliente;
import com.vinivictor.api_cliente.repository.ClienteRepository;

import java.util.List;

public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public void delete(String id) {
        repository.delete(id);
    }
}
