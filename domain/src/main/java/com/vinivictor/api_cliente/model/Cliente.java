package com.vinivictor.api_cliente.model;

import java.time.LocalDate;

public class Cliente {
    private String id;
    private String nome;
    private LocalDate dataNascimento;
    private Endereco endereco;

    public Cliente() {}

    public Cliente(String id, String nome, LocalDate dataNascimento, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
}