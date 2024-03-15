package com.bookpartnerportal.bookpartnerportal.exceptionhandler;

import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bookpartnerportal.bookpartnerportal.titlesexceptions.TitleIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.titlesexceptions.TitlesNotFoundException;
import com.bookpartnerportal.bookpartnerportal.titlesexceptions.TitleswithPubdateNotFoundException;
import com.bookpartnerportal.bookpartnerportal.titlesexceptions.TitlewithAuthorNotFoundException;
import com.bookpartnerportal.bookpartnerportal.titlesexceptions.TitlewithPubIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.titlesexceptions.ValidationException;

@ControllerAdvice
public class TitlesExceptionHandler {
  @ExceptionHandler
  public ResponseEntity<ErrorResponse> handleException(ValidationException exe){
		ErrorResponse err=new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	}
  
  @ExceptionHandler
  public ResponseEntity<ErrorResponse> handleException(TitlesNotFoundException exe){
		ErrorResponse err=new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
  
  @ExceptionHandler
  public ResponseEntity<ErrorResponse> handleException(TitlewithAuthorNotFoundException exe){
		ErrorResponse err=new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}

  @ExceptionHandler
  public ResponseEntity<ErrorResponse> handleException(TitleswithPubdateNotFoundException exe){
		ErrorResponse err=new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
  
  @ExceptionHandler
  public ResponseEntity<ErrorResponse> handleException(TitlewithPubIdNotFoundException exe){
		ErrorResponse err=new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
  
  @ExceptionHandler
  public ResponseEntity<ErrorResponse> handleException(TitleIdNotFoundException exe){
		ErrorResponse err=new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
}
