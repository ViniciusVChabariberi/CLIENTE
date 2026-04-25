package com.vinivictor.api_cliente.repository.adapter;

import com.vinivictor.api_cliente.model.Cliente;
import com.vinivictor.api_cliente.repository.ClienteRepository;
import com.vinivictor.api_cliente.repository.mongo.ClienteEntity;
import com.vinivictor.api_cliente.repository.mongo.ClienteMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteRepositoryAdapter implements ClienteRepository {

    @Autowired
    private ClienteMongoRepository mongoRepository;

    @Override
    public Cliente salvarNovoCliente(Cliente cliente) {
        ClienteEntity entity = new ClienteEntity(cliente);
        return mongoRepository.save(entity).toDomain();
    }

    @Override
    public List<Cliente> buscarTodos() {
        return mongoRepository.findAll().stream()
                .map(ClienteEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Cliente buscarPorId(String id) {
        return mongoRepository.findById(id)
                .map(ClienteEntity::toDomain)
                .orElse(null);
    }

    @Override
    public void deletar(String id) {
        mongoRepository.deleteById(id);
    }
}