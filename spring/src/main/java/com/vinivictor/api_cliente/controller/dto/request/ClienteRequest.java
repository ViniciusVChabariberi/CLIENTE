package com.vinivictor.api_cliente.controller.dto.request;

import com.vinivictor.api_cliente.controller.dto.response.EnderecoResponse;

import java.time.LocalDate;

public record ClienteRequest(String nome, LocalDate dataNascimento, EnderecoResponse endereco) {}
