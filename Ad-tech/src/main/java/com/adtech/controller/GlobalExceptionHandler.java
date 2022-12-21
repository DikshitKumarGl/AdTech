package com.adtech.controller;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.adtech.exception.CompanyIdNotFound;
import com.adtech.exception.CompanyNotFoundException;
import com.adtech.exception.ImageNotFoundException;
import com.adtech.model.ErrorModel;


@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
//	
//	@Override
//	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//	  Map<String, String> errors = new HashMap<>();
//	  ex.getBindingResult().getAllErrors().forEach((error) ->{
//	  String fieldName = ((FieldError) error).getField();
//	  String message = error.getDefaultMessage();
//	  errors.put(fieldName, message);
//	  });
//
//	     return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
//
//	   }
	
	
	
	
	
	
	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<ErrorModel> handleproductNotFoundException(CompanyNotFoundException ex, WebRequest req)
	{
		ErrorModel model = new ErrorModel(new Date(), ex.getMessage(),HttpStatus.NOT_FOUND.value(),req.getDescription(false));
		return new ResponseEntity<ErrorModel>(model,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(CompanyIdNotFound.class)
	public ResponseEntity<ErrorModel> handleIdNotFoundException(CompanyIdNotFound ex,WebRequest req)
	{
		ErrorModel model = new ErrorModel(new Date(), ex.getMessage(),HttpStatus.NOT_FOUND.value(),req.getDescription(false));
		return new ResponseEntity<ErrorModel>(model,HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(ImageNotFoundException.class)
	public ResponseEntity<ErrorModel> imageNotFound(ImageNotFoundException ex,WebRequest req)
	{
		ErrorModel model=new ErrorModel(new Date(),ex.getMessage(),HttpStatus.NOT_FOUND.value(),req.getDescription(false));
		return new ResponseEntity<ErrorModel>(model,HttpStatus.NOT_FOUND);
	}

}
