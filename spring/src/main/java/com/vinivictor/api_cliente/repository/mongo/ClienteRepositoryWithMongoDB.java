package com.vinivictor.api_cliente.repository.mongo;

import com.vinivictor.api_cliente.repository.orm.ClienteOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryWithMongoDB extends MongoRepository<ClienteOrmMongo, String> {
    // Aqui o Spring gera o save, findAll, etc, automaticamente
}