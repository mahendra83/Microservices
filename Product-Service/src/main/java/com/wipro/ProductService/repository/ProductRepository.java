package com.wipro.ProductService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.ProductService.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
