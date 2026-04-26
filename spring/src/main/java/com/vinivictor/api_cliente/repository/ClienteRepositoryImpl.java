package com.vinivictor.api_cliente.repository;

import com.vinivictor.api_cliente.model.Cliente;
import com.vinivictor.api_cliente.repository.adapter.ClienteRepositoryAdapter;
import com.vinivictor.api_cliente.repository.mongo.ClienteMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private final ClienteMongoRepository mongoRepository;

    public ClienteRepositoryImpl(ClienteMongoRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public Cliente save(Cliente cliente) {
        var orm = ClienteRepositoryAdapter.castEntity(cliente);
        var salvo = mongoRepository.save(orm);
        return ClienteRepositoryAdapter.castOrm(salvo);
    }

    @Override
    public List<Cliente> findAll() {
        return mongoRepository.findAll().stream()
                .map(ClienteRepositoryAdapter::castOrm)
                .toList();
    }

    @Override
    public Optional<Cliente> findById(String id) {
        return mongoRepository.findById(id).map(ClienteRepositoryAdapter::castOrm);
    }

    @Override
    public void delete(String id) {
        mongoRepository.deleteById(id);
    }
}
