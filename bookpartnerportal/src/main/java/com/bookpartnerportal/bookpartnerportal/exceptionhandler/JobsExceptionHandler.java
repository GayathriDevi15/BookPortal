package com.bookpartnerportal.bookpartnerportal.exceptionhandler;

import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bookpartnerportal.bookpartnerportal.publisherexception.JobsWithJobIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.publisherexception.ValidationFailedException;

@ControllerAdvice
public class JobsExceptionHandler {
  
  @ExceptionHandler(JobsWithJobIdNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleException(JobsWithJobIdNotFoundException exe){
		ErrorResponse err=new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
  
  @ExceptionHandler(ValidationFailedException.class)
  public ResponseEntity<ErrorResponse> handleException(ValidationFailedException exe){
		ErrorResponse err=new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	}
  
	// Generic Exception
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleAllExceptions(Exception genericException) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(genericException.getMessage());
		error.setTimeStamp(LocalDate.now());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
  
  
 
  	
}
