package com.github.christian.football.controller.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.christian.football.constants.SwaggerConstants;

@RestControllerAdvice(basePackages = SwaggerConstants.PROJECT_CONTROLLER_PATH)
public class ControllerExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult()
		        .getAllErrors()
		        .forEach(error -> {
			        String fieldName = error instanceof FieldError ? ((FieldError) error).getField()
			                : error.getObjectName();
			        String errorMessage = error.getDefaultMessage();
			        errors.put(fieldName, errorMessage);
		        });
		return errors;
	}
}
