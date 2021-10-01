package com.github.fefsribeiro.desafio.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFormDto {
	

	@NotBlank
	private String name;
	@NotBlank
	private String description;
	@Positive
	@Digits(integer = 10, fraction=2)
	private BigDecimal price;
}
