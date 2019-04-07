package br.com.fiap.orderservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(ServerException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(OrderNotFoundException.class)
	public final ResponseEntity<Object> handleOrderNotFoundException(OrderNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

}