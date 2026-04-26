package com.vinivictor.api_cliente.config;

import com.vinivictor.api_cliente.repository.ClienteRepository;
import com.vinivictor.api_cliente.service.ClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public ClienteService clienteService(ClienteRepository repository) {
        return new ClienteService(repository);
    }
}
