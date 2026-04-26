package com.vinivictor.api_cliente.model;

import java.time.LocalDate;

public record Cliente(
        String id,
        String nome,
        LocalDate dataNascimento,
        Endereco endereco
) {}