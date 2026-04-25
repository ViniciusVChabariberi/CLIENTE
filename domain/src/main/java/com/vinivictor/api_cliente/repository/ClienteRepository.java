package com.vinivictor.api_cliente.repository;

import com.vinivictor.api_cliente.model.Cliente;
import java.util.List;

public interface ClienteRepository {
    Cliente salvarNovoCliente(Cliente cliente);
    List<Cliente> buscarTodos();
    Cliente buscarPorId(String id);
    void deletar(String id);
}