package com.bookpartnerportal.bookpartnerportal.exceptionhandler;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bookpartnerportal.bookpartnerportal.jobsexception.JobsUpdateValidationException;
import com.bookpartnerportal.bookpartnerportal.storeexception.CityNotFoundException;
import com.bookpartnerportal.bookpartnerportal.storeexception.StorIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.storeexception.StoreIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.storeexception.StoresNotFoundException;
import com.bookpartnerportal.bookpartnerportal.storeexception.StoresPostValidationException;
import com.bookpartnerportal.bookpartnerportal.storeexception.StoresUpdateValidationException;
import com.bookpartnerportal.bookpartnerportal.storeexception.ZipNotFoundException;

@ControllerAdvice
public class StoresExceptionHandler {
	
    @ExceptionHandler(ZipNotFoundException.class)
	public ResponseEntity<ErrorResponse>handleException(ZipNotFoundException ex)
	{
	//create ErrorResponse object
	 
    	ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

	
	
	//return ResponseEntity
	 
	return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	 
	}
    @ExceptionHandler(CityNotFoundException.class)
	public ResponseEntity<ErrorResponse>handleException(CityNotFoundException ex)
	{
	//create ErrorResponse object
	 
    	ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());
	 
	//return ResponseEntity
	 
	return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	 
	}
    @ExceptionHandler(StoreIdNotFoundException.class)
	public ResponseEntity<ErrorResponse>handleException(StoreIdNotFoundException ex)
	{
	//create ErrorResponse object
	 
    	ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());
	 
	//return ResponseEntity
	 
	return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	 
	}
    
    
    @ExceptionHandler(StorIdNotFoundException.class)
  	public ResponseEntity<ErrorResponse>handleException(StorIdNotFoundException ex)
  	{
  	//create ErrorResponse object
  	 
    	ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());
  	 
  	//return ResponseEntity
  	 
  	return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
  	 
  	}
    @ExceptionHandler(StoresNotFoundException.class)
  	public ResponseEntity<ErrorResponse>handleException(StoresNotFoundException ex)
  	{
  	//create ErrorResponse object
    	ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());
  	 
  	//return ResponseEntity
  	 
  	return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
  	 
  	}
  
    
    @ExceptionHandler(StoresUpdateValidationException.class)
  	public ResponseEntity<ErrorResponse> handleException(StoresUpdateValidationException ex)
  	{
  	//create ErrorResponse object
  	 
    	ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());
  	 
  	//return ResponseEntity
  	 
  	return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
  	 
  	}
    
    @ExceptionHandler(StoresPostValidationException.class)
  	public ResponseEntity<ErrorResponse>handleException(StoresPostValidationException ex)
  	{
  	//create ErrorResponse object
  	 
    	ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());
  	 
  	//return ResponseEntity
  	 
  	return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
  	 
  	}
    
   
    

}
