package com.github.fefsribeiro.desafio.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
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

	public ProductDto toSave(ProductFormDto dto) {
		Product p = modelMapper.map(dto, Product.class);
		return modelMapper.map(productRepository.save(p),ProductDto.class);
		
	}
	
	
	public Optional<ProductDto> toFindById(String id) {
		Optional<Product> op = productRepository.findById(id);
		if(op.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(modelMapper.map(op.get(),ProductDto.class));
	}
	
	public Optional<ProductDto> toUpdateById(ProductFormDto dto, String id ){
		Product p = modelMapper.map(dto, Product.class);
		p.setId(id);
		return Optional.of(modelMapper.map(productRepository.save(p),ProductDto.class));
	}
	
	public void toDeleteById(String id){
		productRepository.deleteById(id);
	}
	
	public List<ProductDto> toListBySearch(String q, BigDecimal minPrice, BigDecimal maxPrice) {
		List<Product> products = productRepository.findProductByNameOrDescriptionAndMinAndMaxPrice(q,minPrice, maxPrice);
		return products
				.stream()
				.map(p -> modelMapper.map(p, ProductDto.class))
				.collect(Collectors.toList());
	}
}
