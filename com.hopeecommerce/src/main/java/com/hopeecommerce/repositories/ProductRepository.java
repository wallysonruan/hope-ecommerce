package com.hopeecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hopeecommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	//No need to insert anything here.
}