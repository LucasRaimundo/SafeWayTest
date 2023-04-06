package com.lucasraimundo.safeway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasraimundo.safeway.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
