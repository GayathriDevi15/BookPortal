package com.bookpartnerportal.bookpartnerportal.exceptionhandler;

import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bookpartnerportal.bookpartnerportal.exception.EmployeeFirstnamebyPublisherIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.exception.EmployeesbyPublisherIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.exception.PublisherWithCityNotFoundException;
import com.bookpartnerportal.bookpartnerportal.exception.PublisherWithCountryNotFoundException;
import com.bookpartnerportal.bookpartnerportal.exception.PublisherWithIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.exception.PublisherWithNameNotFoundException;
import com.bookpartnerportal.bookpartnerportal.exception.PublisherWithStateNotFoundException;
import com.bookpartnerportal.bookpartnerportal.exception.PublishersNotFoundException;
import com.bookpartnerportal.bookpartnerportal.exception.ValidationFailedException;

@ControllerAdvice
public class PublisherExceptionHandler {
	
  @ExceptionHandler(EmployeeFirstnamebyPublisherIdNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleException(EmployeeFirstnamebyPublisherIdNotFoundException exe){
		ErrorResponse err=new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
  
  @ExceptionHandler(EmployeesbyPublisherIdNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleException(EmployeesbyPublisherIdNotFoundException exe){
		ErrorResponse err=new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
  @ExceptionHandler(PublishersNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleException(PublishersNotFoundException exe){
		ErrorResponse err=new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
  @ExceptionHandler(PublisherWithCityNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleException(PublisherWithCityNotFoundException exe){
		ErrorResponse err=new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
  @ExceptionHandler(PublisherWithCountryNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleException(PublisherWithCountryNotFoundException exe){
		ErrorResponse err=new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
  @ExceptionHandler(PublisherWithNameNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleException(PublisherWithNameNotFoundException exe){
		ErrorResponse err=new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
  @ExceptionHandler(PublisherWithStateNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleException(PublisherWithStateNotFoundException exe){
		ErrorResponse err=new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
  @ExceptionHandler(PublisherWithIdNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleException(PublisherWithIdNotFoundException exe){
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
