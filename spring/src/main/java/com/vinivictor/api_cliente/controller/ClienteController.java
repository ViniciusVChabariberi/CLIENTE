package com.vinivictor.api_cliente.controller;

import com.vinivictor.api_cliente.entity.Cliente;
import com.vinivictor.api_cliente.entity.Endereco;
import com.vinivictor.api_cliente.integration.EnderecoIntegration;
import com.vinivictor.api_cliente.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cadastro-clientes") // Mudei a rota para ser diferente da dele
public class ClienteController {

    private final ClienteRepository portaRepositorio;
    private final EnderecoIntegration portaIntegracao;

    // Injeção de dependência via construtor (Boa prática)
    public ClienteController(ClienteRepository portaRepositorio, EnderecoIntegration portaIntegracao) {
        this.portaRepositorio = portaRepositorio;
        this.portaIntegracao = portaIntegracao;
    }

    @PostMapping("/salvar")
    public ResponseEntity<Cliente> realizarCadastro(@RequestBody Cliente novoCliente) {

        // 1. Pega o CEP enviado no JSON
        String cepInformado = novoCliente.getEndereco().getCep();

        // 2. Usa o Adapter de Integração para completar os dados do endereço
        Endereco enderecoCompleto = portaIntegracao.buscarDetalhesCep(cepInformado);
        novoCliente.setEndereco(enderecoCompleto);

        // 3. Usa o Adapter de Repositório para salvar no MongoDB
        Cliente clienteSalvo = portaRepositorio.salvarNovoCliente(novoCliente);

        // 4. Retorna o status 201 (Created) para ser mais profissional
        return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
    }

    @GetMapping("/status")
    public String checarConexao() {
        return "API de Clientes online e operante!";
    }
}