package com.github.fefsribeiro.desafio.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductFormDto {
	

	@NotBlank
	private String name;
	@NotBlank
	private String description;
	@Positive
	@Digits(integer = 10, fraction=2)
	@NotNull
	private BigDecimal price;
}
