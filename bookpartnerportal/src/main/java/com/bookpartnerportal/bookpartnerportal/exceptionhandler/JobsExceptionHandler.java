package com.bookpartnerportal.bookpartnerportal.exceptionhandler;

import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bookpartnerportal.bookpartnerportal.jobsexception.JobIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.jobsexception.JobsNotFoundException;
import com.bookpartnerportal.bookpartnerportal.jobsexception.JobsUpdateValidationException;
import com.bookpartnerportal.bookpartnerportal.jobsexception.MaxLvlNotFoundException;
import com.bookpartnerportal.bookpartnerportal.jobsexception.MinLvlNotFoundException;
import com.bookpartnerportal.bookpartnerportal.publisherexception.JobsWithJobIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.publisherexception.ValidationFailedException;

@ControllerAdvice
public class JobsExceptionHandler {

	@ExceptionHandler(JobsWithJobIdNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(JobsWithJobIdNotFoundException exe) {
		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(ValidationFailedException.class)
	public ResponseEntity<ErrorResponse> handleException(ValidationFailedException exe) {
		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(exe.getMessage());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

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

	@ExceptionHandler(JobsNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(JobsNotFoundException ex) {
		// create ErrorResponse object

		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

		// return ResponseEntity

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MaxLvlNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(MaxLvlNotFoundException ex) {
		// create ErrorResponse object

		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

		// return ResponseEntity

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MinLvlNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(MinLvlNotFoundException ex) {
		// create ErrorResponse object

		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

		// return ResponseEntity

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(JobIdNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(JobIdNotFoundException ex) {
		// create ErrorResponse object
		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

		// return ResponseEntity

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(JobsUpdateValidationException.class)
	public ResponseEntity<ErrorResponse> handleException(JobsUpdateValidationException ex) {
		// create ErrorResponse object

		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

		// return ResponseEntity

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

	}

}
