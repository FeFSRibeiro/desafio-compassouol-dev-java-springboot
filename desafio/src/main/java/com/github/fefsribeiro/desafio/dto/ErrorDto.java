package com.github.fefsribeiro.desafio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDto {
	private Integer statusCode;
    private String message;
}
