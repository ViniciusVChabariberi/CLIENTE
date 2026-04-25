package com.vinivictor.api_cliente.repository.adapter;

import com.vinivictor.api_cliente.entity.Cliente;
import com.vinivictor.api_cliente.repository.ClienteRepository; // Interface do Domain
import com.vinivictor.api_cliente.repository.mongo.ClienteRepositoryWithMongoDB;
import com.vinivictor.api_cliente.repository.orm.ClienteOrmMongo;
import com.vinivictor.api_cliente.repository.orm.EnderecoMongo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class ClienteRepositoryAdapter implements ClienteRepository {

    private final ClienteRepositoryWithMongoDB mongoDB;

    public ClienteRepositoryAdapter(ClienteRepositoryWithMongoDB mongoDB) {
        this.mongoDB = mongoDB;
    }

    @Override
    public Cliente salvarNovoCliente(Cliente domain) {
        // Criando o objeto do banco (ORM) a partir do objeto de negócio (Domain)
        ClienteOrmMongo orm = new ClienteOrmMongo();
        orm.setNomeDoCliente(domain.getNomeCompleto());

        if (domain.getEndereco() != null) {
            EnderecoMongo end = new EnderecoMongo();
            end.setZipCode(domain.getEndereco().getCep());
            end.setLogradouro(domain.getEndereco().getRua());
            end.setCidade(domain.getEndereco().getCidade());
            end.setEstado(domain.getEndereco().getEstado());
            orm.setDadosEndereco(end);
        }

        // Salva no Mongo e recupera o ID gerado
        ClienteOrmMongo resultado = mongoDB.save(orm);
        domain.setId(resultado.getUuid());

        return domain;
    }

    @Override
    public <S extends Cliente> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Cliente> List<S> insert(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public <S extends Cliente> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Cliente> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Cliente> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Cliente> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Cliente> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Cliente> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Cliente, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Cliente> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Cliente> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Cliente> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Cliente> findAll() {
        return List.of();
    }

    @Override
    public List<Cliente> findAllById(Iterable<String> strings) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Cliente entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cliente> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Cliente> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        return null;
    }
}