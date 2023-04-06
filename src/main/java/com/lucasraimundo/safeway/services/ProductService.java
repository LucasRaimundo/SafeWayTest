package com.lucasraimundo.safeway.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasraimundo.safeway.entities.Product;
import com.lucasraimundo.safeway.repositories.ProductRepository;
import com.lucasraimundo.safeway.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	

	public Product find(Integer id) {
		Optional<Product> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado!au Id: " + id + ", Tipo: " + Product.class.getName()));
	}
	
	

}
