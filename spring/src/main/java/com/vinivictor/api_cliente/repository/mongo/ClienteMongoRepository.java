package com.vinivictor.api_cliente.repository.mongo;

import com.vinivictor.api_cliente.repository.orm.ClienteOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteMongoRepository extends MongoRepository<ClienteOrmMongo, String> {
}