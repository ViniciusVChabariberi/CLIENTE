package com.vinivictor.api_cliente.integration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViaCepResponse {

    @JsonProperty("cep")
    private String cepRecebido;

    @JsonProperty("logradouro")
    private String ruaCompleta;

    @JsonProperty("localidade")
    private String nomeCidade;

    @JsonProperty("uf")
    private String siglaEstado;

    // Getters e Setters
    public String getCepRecebido() { return cepRecebido; }
    public void setCepRecebido(String cepRecebido) { this.cepRecebido = cepRecebido; }
    public String getRuaCompleta() { return ruaCompleta; }
    public void setRuaCompleta(String ruaCompleta) { this.ruaCompleta = ruaCompleta; }
    public String getNomeCidade() { return nomeCidade; }
    public void setNomeCidade(String nomeCidade) { this.nomeCidade = nomeCidade; }
    public String getSiglaEstado() { return siglaEstado; }
    public void setSiglaEstado(String siglaEstado) { this.siglaEstado = siglaEstado; }
}