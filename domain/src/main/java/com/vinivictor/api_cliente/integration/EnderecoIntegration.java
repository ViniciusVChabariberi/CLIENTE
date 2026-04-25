package com.vinivictor.api_cliente.integration;

import com.vinivictor.api_cliente.entity.Endereco;

public interface EnderecoIntegration {
    Endereco buscarDetalhesCep(String cep);
}