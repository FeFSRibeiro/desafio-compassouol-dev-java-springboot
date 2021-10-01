package com.github.fefsribeiro.desafio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.fefsribeiro.desafio.dto.ProductDto;
import com.github.fefsribeiro.desafio.dto.ProductFormDto;
import com.github.fefsribeiro.desafio.model.Product;
import com.github.fefsribeiro.desafio.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public List<ProductDto> toList(){
		return service.toList();
	}
	
	@PostMapping
	public ResponseEntity<Product> toSave(@RequestBody @Valid ProductFormDto dto) {
		return ResponseEntity.created(null).body(service.toSave(dto));
		
	}
}
