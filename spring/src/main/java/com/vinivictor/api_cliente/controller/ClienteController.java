package com.vinivictor.api_cliente.controller;

import com.vinivictor.api_cliente.controller.adapter.ClienteControllerAdapter;
import com.vinivictor.api_cliente.controller.dto.request.ClienteRequest;
import com.vinivictor.api_cliente.controller.dto.response.ClienteResponse;
import com.vinivictor.api_cliente.model.Cliente; // Import do Domain
import com.vinivictor.api_cliente.repository.ClienteRepository; // Import do Domain
import com.vinivictor.api_cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> save(@RequestBody ClienteRequest request) {
        var cliente = ClienteControllerAdapter.castRequest(request);
        var salvo = service.save(cliente);
        return ResponseEntity.ok(ClienteControllerAdapter.castResponse(salvo));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> list() {
        var clientes = service.findAll();
        return ResponseEntity.ok(clientes.stream().map(ClienteControllerAdapter::castResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> findById(@PathVariable String id) {
        var cliente = service.findById(id);
        return ResponseEntity.ok(ClienteControllerAdapter.castResponse(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}