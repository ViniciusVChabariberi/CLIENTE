package com.vinivictor.api_cliente.repository.orm;

public record EnderecoOrmMongo(
        String logradouro,
        String numero,
        String cidade,
        String estado
) {

}
