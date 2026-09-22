package com.itvedant.basics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.basics.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	// db interaction
	// inbuilt methods - 
	// save
}
