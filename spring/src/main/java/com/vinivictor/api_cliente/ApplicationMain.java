package com.vinivictor.api_cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
// Adicione estas duas linhas abaixo:
@ComponentScan(basePackages = "com.vinivictor.api_cliente")
@EnableMongoRepositories(basePackages = "com.vinivictor.api_cliente.repository.mongo")
public class ApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}