package com.github.fefsribeiro.desafio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {
	private Integer statusCode;
    private String message;
}
