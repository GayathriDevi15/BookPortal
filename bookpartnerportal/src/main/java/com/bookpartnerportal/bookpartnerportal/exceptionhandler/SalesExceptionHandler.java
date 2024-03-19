package com.bookpartnerportal.bookpartnerportal.exceptionhandler;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bookpartnerportal.bookpartnerportal.authorexception.SalesNotFoundByStoreIdException;
import com.bookpartnerportal.bookpartnerportal.salesexceptions.SalesDetailsNotFoundException;
import com.bookpartnerportal.bookpartnerportal.salesexceptions.SalesNotFoundByOrderDateException;
import com.bookpartnerportal.bookpartnerportal.salesexceptions.SalesNotFoundByTitleIDException;
import com.bookpartnerportal.bookpartnerportal.salesexceptions.SalesValidationException;
import com.bookpartnerportal.bookpartnerportal.salesexceptions.SaleswithOrdnumNotFoundException;
import com.bookpartnerportal.bookpartnerportal.titlesexceptions.ValidationException;

@ControllerAdvice
public class SalesExceptionHandler {
	
	@ExceptionHandler
	  public ResponseEntity<ErrorResponse> handleException(SalesDetailsNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
			
	  }

	// Sales details by storeId not found
		@ExceptionHandler(SalesNotFoundByStoreIdException.class)
		public ResponseEntity<ErrorResponse> handlerexception(SalesNotFoundByStoreIdException ex) {
			ErrorResponse err = new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(ex.getMessage());

			return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
		}
	
	@ExceptionHandler
	  public ResponseEntity<ErrorResponse> handleException(SaleswithOrdnumNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
			
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
	@ExceptionHandler
	  public ResponseEntity<ErrorResponse> handleException(Exception exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
			
		}
	
	
	
}
