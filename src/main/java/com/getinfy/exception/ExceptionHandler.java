package com.getinfy.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleInvalidArgument(MethodArgumentNotValidException ex){
		
		Map<String,String> map=new HashMap<>();
		
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		for(FieldError error:fieldErrors) {
			
			map.put(error.getField(), error.getDefaultMessage());
			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}

}
