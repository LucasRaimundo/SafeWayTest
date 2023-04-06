package com.lucasraimundo.safeway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucasraimundo.safeway.entities.Product;
import com.lucasraimundo.safeway.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Product obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	
	
}
