package com.github.fefsribeiro.desafio.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.fefsribeiro.desafio.dto.ProductDto;
import com.github.fefsribeiro.desafio.dto.ProductFormDto;
import com.github.fefsribeiro.desafio.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/products")
	public List<ProductDto> toList() {
		return service.toList();
	}

	@PostMapping("/products")
	public ResponseEntity<ProductDto> toSave(@RequestBody @Valid ProductFormDto dto) {
		return ResponseEntity.created(null).body(service.toSave(dto));

	}

	@GetMapping("/products/{id}")
	public ResponseEntity<ProductDto> toFindById(@PathVariable String id) {
		Optional<ProductDto> response = service.toFindById(id);
		if (response.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(response.get());
		}
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<ProductDto> toUpdateById(@RequestBody @Valid ProductFormDto dto, @PathVariable String id) {
		Optional<ProductDto> response = service.toFindById(id);
		if (response.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(service.toUpdateById(dto, id).get());
		}
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> toDeleteById(@PathVariable String id) {
		Optional<ProductDto> response = service.toFindById(id);
		if (response.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			service.toDeleteById(id);
			return ResponseEntity.ok().build();
		}
	}

	@GetMapping("/products/search")
	public List<ProductDto> toListBySearch(@RequestParam(required = false, value = "q", defaultValue = "") String q,
										   @RequestParam(required = false, value = "min_price",defaultValue = "0.00") BigDecimal minPrice,
										   @RequestParam(required = false,  value = "max_price", defaultValue = "10000.00") BigDecimal maxPrice) {
				return service.toListBySearch(q,minPrice,maxPrice);
	}
}
