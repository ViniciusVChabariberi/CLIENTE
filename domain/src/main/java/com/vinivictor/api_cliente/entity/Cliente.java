package com.vinivictor.api_cliente.entity;

public class Cliente {
    private String id;
    private String nomeCompleto; // Note: usei nomeCompleto para diferenciar do "nome" do colega
    private Endereco endereco;

    public Cliente() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
}