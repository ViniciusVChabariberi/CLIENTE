package com.vinivictor.api_cliente.repository.adapter;

import com.vinivictor.api_cliente.model.Cliente;
import com.vinivictor.api_cliente.model.Endereco;
import com.vinivictor.api_cliente.repository.orm.ClienteOrmMongo;
import com.vinivictor.api_cliente.repository.orm.EnderecoOrmMongo;

public class ClienteRepositoryAdapter {
    private ClienteRepositoryAdapter() {}

    public static ClienteOrmMongo castEntity(Cliente cliente) {
        EnderecoOrmMongo endOrm = new EnderecoOrmMongo(
                cliente.endereco().logradouro(),
                cliente.endereco().numero(),
                cliente.endereco().cidade(),
                cliente.endereco().estado()
        );
        return new ClienteOrmMongo(cliente.id(), cliente.nome(), cliente.dataNascimento(), endOrm);
    }

    public static Cliente castOrm(ClienteOrmMongo orm) {
        Endereco endereco = new Endereco(
                orm.endereco().logradouro(),
                orm.endereco().numero(),
                orm.endereco().cidade(),
                orm.endereco().estado()
        );
        return new Cliente(orm.id(), orm.nome(), orm.dataNascimento(), endereco);
    }
}