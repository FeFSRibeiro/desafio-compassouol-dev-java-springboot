package com.github.fefsribeiro.desafio.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
	private String id;
	private String name;
	private String description;
	private BigDecimal price;
}
