package com.redbus.agent.controllerAdvice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.redbus.agent.exception.BusNotFoundException;
import com.redbus.agent.form.BusSearchResponse;
import com.redbus.agent.form.ErrorResponse;
import com.redbus.agent.util.ApplicationConstants;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value = BusNotFoundException.class)
	public ResponseEntity<BusSearchResponse> handleBusNotFoundException(BusNotFoundException exception) {
		BusSearchResponse response = new BusSearchResponse();
		response.setMessage(exception.getMessage());
		response.setResponseCode(ApplicationConstants.RESPONSE_NOT_FOUND);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		ErrorResponse response = new ErrorResponse();
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			String fieldName = error.getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		response.setErrors(errors);
		response.setMessage(ApplicationConstants.RESPONSE_MSG_INVALID_INPUT);
		response.setResponseCode(ApplicationConstants.RESPONSE_CODE_INVALID_INPUT);
		return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception exception) {
		ErrorResponse response = new ErrorResponse();
		response.setMessage("Internal Server Error : "+exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
}
