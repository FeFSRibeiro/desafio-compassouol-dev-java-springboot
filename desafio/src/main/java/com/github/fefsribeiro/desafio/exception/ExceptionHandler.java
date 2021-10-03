package com.github.fefsribeiro.desafio.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.github.fefsribeiro.desafio.dto.ErrorDto;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request)   {
		ErrorDto error = new ErrorDto();
		error.setStatusCode(400);
		error.setMessage(ex.getAllErrors().toString());
		return ResponseEntity.badRequest().body(error);
	} 
}
