package com.vinivictor.api_cliente.controller.adapter;

import com.vinivictor.api_cliente.controller.dto.request.ClienteRequest;
import com.vinivictor.api_cliente.controller.dto.response.ClienteResponse;
import com.vinivictor.api_cliente.controller.dto.response.EnderecoResponse;
import com.vinivictor.api_cliente.model.Cliente;
import com.vinivictor.api_cliente.model.Endereco;

public class ClienteControllerAdapter {
    public static Cliente castRequest(ClienteRequest request) {
        Endereco endereco = new Endereco(request.endereco().logradouro(), request.endereco().numero(), request.endereco().cidade(), request.endereco().estado());
        return new Cliente(null, request.nome(), request.dataNascimento(), endereco);
    }

    public static ClienteResponse castResponse(Cliente cliente) {
        EnderecoResponse dto = new EnderecoResponse(cliente.endereco().logradouro(), cliente.endereco().numero(), cliente.endereco().cidade(), cliente.endereco().estado());
        return new ClienteResponse(cliente.id(), cliente.nome(), cliente.dataNascimento(), dto);
    }
}
