package oasis.feb.gestaomenu.controller;


import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import oasis.feb.gestaomenu.exception.*;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
    @ExceptionHandler(NewResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(NewResourceNotFoundException ex, WebRequest request) {
         ExceptionResponse errorDetails = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND.value());
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(NewDataIntegrityViolationException.class)
    public ResponseEntity<?> dataIntegrityViolationException(NewDataIntegrityViolationException ex, WebRequest request) {
         ExceptionResponse errorDetails = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false), HttpStatus.BAD_REQUEST.value());
         return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<?> resourceBadRequestException(ResourceBadRequestException ex, WebRequest request) {
         ExceptionResponse errorDetails = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false), HttpStatus.BAD_REQUEST.value());
         return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
   
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> globleExcpetionHandler(ResourceNotFoundException ex, WebRequest request) {
        ExceptionResponse errorDetails = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
   
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

    	ExceptionResponse errorDetails = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), ex.getBindingResult().toString(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

	}
}