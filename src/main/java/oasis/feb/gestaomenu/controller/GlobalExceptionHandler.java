package oasis.feb.gestaomenu.controller;


import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.PropertyAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;


import oasis.feb.gestaomenu.exception.*;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
    @ExceptionHandler(NewResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(NewResourceNotFoundException ex, WebRequest request) {
    	
    	List<ExceptionResponse> erros = new ArrayList<>();
	     ExceptionResponse errorDetails = new ExceptionResponse(LocalDateTime.now(), "", ex.getMessage(), ExceptionUtils.getRootCauseMessage(ex), HttpStatus.NOT_FOUND.value());
	     erros.add(errorDetails);
	     return new ResponseEntity<>(erros, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(NewDataIntegrityViolationException.class)
    public ResponseEntity<?> dataIntegrityViolationException(NewDataIntegrityViolationException ex, WebRequest request) {
    	List<ExceptionResponse> erros = new ArrayList<>();
         ExceptionResponse errorDetails = new ExceptionResponse(LocalDateTime.now(), "",ex.getMessage(), ExceptionUtils.getRootCauseMessage(ex), HttpStatus.BAD_REQUEST.value());
         erros.add(errorDetails);
         return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<?> resourceBadRequestException(ResourceBadRequestException ex, WebRequest request) {
    	List<ExceptionResponse> erros = new ArrayList<>();

         ExceptionResponse errorDetails = new ExceptionResponse(LocalDateTime.now(), "", ex.getMessage(), ExceptionUtils.getRootCauseMessage(ex), HttpStatus.BAD_REQUEST.value());
         erros.add(errorDetails);
         return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }
   
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> globleExcpetionHandler(ResourceNotFoundException ex, WebRequest request) {
    	List<ExceptionResponse> erros = new ArrayList<>();
        ExceptionResponse errorDetails = new ExceptionResponse(LocalDateTime.now(), "", ex.getMessage(), ExceptionUtils.getRootCauseMessage(ex), HttpStatus.NOT_FOUND.value());
        erros.add(errorDetails);
        return new ResponseEntity<>(erros, HttpStatus.NOT_FOUND);
    }
    
  
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> argumentNotValidException (ConstraintViolationException ex, WebRequest request) {
    	//ExceptionResponse errorDetails = new ExceptionResponse(LocalDateTime.now(), "", ex.getMessage(), request.getDescription(false), HttpStatus.BAD_REQUEST.value());
    	List<ExceptionResponse> erros=criarListaDeErrosaux(ex.getConstraintViolations(), request);
        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
	}
 
    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<?> unexpectedTypeException (UnexpectedTypeException ex, WebRequest request) {
        List<ExceptionResponse> erros = new ArrayList<>();
        ExceptionResponse errorDetails = new ExceptionResponse(LocalDateTime.now(),ex.getLocalizedMessage(), ex.getMessage(), ExceptionUtils.getRootCauseMessage(ex), HttpStatus.BAD_REQUEST.value());
        erros.add(errorDetails);
        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
	}
    
    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<?> handleDataInterityViolationException (DataIntegrityViolationException ex, WebRequest request) {
        List<ExceptionResponse> erros = new ArrayList<>();
        ExceptionResponse errorDetails = new ExceptionResponse(LocalDateTime.now(),ex.getLocalizedMessage(), ex.getMessage(), ExceptionUtils.getRootCauseMessage(ex), HttpStatus.BAD_REQUEST.value());
        erros.add(errorDetails);
        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
	}
    
    @ExceptionHandler(PropertyAccessException.class)
    public ResponseEntity<?> propertyAccessException (PropertyAccessException ex, WebRequest request) {
        List<ExceptionResponse> erros = new ArrayList<>();
        ExceptionResponse errorDetails = new ExceptionResponse(LocalDateTime.now(),ex.getLocalizedMessage(), ex.getMessage(), ExceptionUtils.getRootCauseMessage(ex), HttpStatus.BAD_REQUEST.value());
        erros.add(errorDetails);
        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
	}
    
    
    
    
       
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    	List<ExceptionResponse> erros = criarListaDeErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
    
    
    //metodos auxiliare:
    private List<ExceptionResponse> criarListaDeErrosaux(Set<ConstraintViolation<?>> violations, WebRequest request){
    	List<ExceptionResponse> erros = violations.stream().map(violation -> new ExceptionResponse(LocalDateTime.now(), violation.getMessage(), violation.getConstraintDescriptor().toString(),"", HttpStatus.BAD_REQUEST.value())).collect(Collectors.toList());
    	
    	return erros;
    }
    
    private List<ExceptionResponse> criarListaDeErros(BindingResult bindingResult){
    	List<ExceptionResponse> erros = new ArrayList<>();
    	
    	for(FieldError fieldError : bindingResult.getFieldErrors()) {
    		String msgUsuario = fieldError.getField();
    		String msgDesenvolvedor = fieldError.getDefaultMessage();
    		erros.add(new ExceptionResponse(LocalDateTime.now(), msgUsuario, msgDesenvolvedor, "", HttpStatus.BAD_REQUEST.value()));
    	}
    	
    	return erros;
    }
}