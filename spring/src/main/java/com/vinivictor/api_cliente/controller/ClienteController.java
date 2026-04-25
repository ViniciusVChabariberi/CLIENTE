package com.vinivictor.api_cliente.controller;

import com.vinivictor.api_cliente.model.Cliente; // Import do Domain
import com.vinivictor.api_cliente.repository.ClienteRepository; // Import do Domain
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping("/salvar")
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(repository.salvarNovoCliente(cliente));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(repository.buscarTodos());
    }
}