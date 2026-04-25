package com.vinivictor.api_cliente.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registro_clientes")
public class ClienteOrmMongo {

    @Id
    private String uuid;
    private String nomeDoCliente;
    private EnderecoMongo dadosEndereco;

    // Getters e Setters
    public String getUuid() { return uuid; }
    public void setUuid(String uuid) { this.uuid = uuid; }
    public String getNomeDoCliente() { return nomeDoCliente; }
    public void setNomeDoCliente(String nomeDoCliente) { this.nomeDoCliente = nomeDoCliente; }
    public EnderecoMongo getDadosEndereco() { return dadosEndereco; }
    public void setDadosEndereco(EnderecoMongo dadosEndereco) { this.dadosEndereco = dadosEndereco; }
}