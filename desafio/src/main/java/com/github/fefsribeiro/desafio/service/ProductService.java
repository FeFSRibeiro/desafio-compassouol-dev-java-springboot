package com.github.fefsribeiro.desafio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.fefsribeiro.desafio.dto.ProductDto;
import com.github.fefsribeiro.desafio.dto.ProductFormDto;
import com.github.fefsribeiro.desafio.model.Product;
import com.github.fefsribeiro.desafio.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	private ModelMapper modelMapper = new ModelMapper();

	public List<ProductDto> toList() {
		List<Product> products = productRepository.findAll();
		return products
				.stream()
				.map(p -> modelMapper.map(p, ProductDto.class))
				.collect(Collectors.toList());
	}

	public Product toSave(ProductFormDto dto) {
		Product p = modelMapper.map(dto, Product.class);
		return productRepository.save(p);
		 
	}
}
