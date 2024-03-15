package com.bookpartnerportal.bookpartnerportal.employeeexception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bookpartnerportal.bookpartnerportal.salesexceptions.SalesNotFoundByOrderDateException;
import com.bookpartnerportal.bookpartnerportal.salesexceptions.SalesNotFoundByTitleIDException;
import com.bookpartnerportal.bookpartnerportal.salesexceptions.SalesValidationException;

@ControllerAdvice
public class EmployeeExceptionHandler{
	
	  @ExceptionHandler(EmployeeHireDateNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(EmployeeHireDateNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(EmployeeNotFoundByEmpIDException.class)
	  public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundByEmpIDException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(EmployeeNotFoundByFNameException.class)
	  public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundByFNameException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(EmployeeNotFoundByLNameException.class)
	  public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundByLNameException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(EmployeeNotFoundByPublisherIDException.class)
	  public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundByPublisherIDException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(EmployeeNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(EmployeeValidationFailedException.class)
	  public ResponseEntity<ErrorResponse> handleException(EmployeeValidationFailedException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		}
	  
	  @ExceptionHandler(SalesNotFoundByOrderDateException.class)
	  public ResponseEntity<ErrorResponse> handleException(SalesNotFoundByOrderDateException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(SalesNotFoundByTitleIDException.class)
	  public ResponseEntity<ErrorResponse> handleException(SalesNotFoundByTitleIDException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(SalesValidationException.class)
	  public ResponseEntity<ErrorResponse> handleException(SalesValidationException exe){
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
