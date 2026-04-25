package com.vinivictor.api_cliente.repository.mongo;

import com.vinivictor.api_cliente.model.Cliente;
import com.vinivictor.api_cliente.model.Endereco;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "clientes")
public class ClienteEntity {
    @Id
    private String id;
    private String nome;
    private LocalDate dataNascimento;
    private Endereco endereco;

    public ClienteEntity() {}

    public ClienteEntity(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNascimento();
        this.endereco = cliente.getEndereco();
    }

    public Cliente toDomain() {
        Cliente cliente = new Cliente();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        cliente.setDataNascimento(this.dataNascimento);
        cliente.setEndereco(this.endereco);
        return cliente;
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