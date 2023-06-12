package dev.lucas.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.lucas.productservice.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    
}
