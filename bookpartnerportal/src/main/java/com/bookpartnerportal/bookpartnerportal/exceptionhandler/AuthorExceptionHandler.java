package com.bookpartnerportal.bookpartnerportal.exceptionhandler;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorAddException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorDeleteException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorUpdateException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorsNotFoundByCityException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorsNotFoundByFnameException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorsNotFoundByIdException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorsNotFoundByLnameException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorsNotFoundByPhoneException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorsNotFoundByStateException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorsNotFoundByZipException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorsNotFoundException;

@ControllerAdvice
public class AuthorExceptionHandler {

	// Author details not found
	@ExceptionHandler(AuthorsNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerexception(AuthorsNotFoundException ex) {
		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());

		err.setMessage(ex.getMessage());
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	// Author details by city not found
	@ExceptionHandler(AuthorsNotFoundByCityException.class)
	public ResponseEntity<ErrorResponse> handlerexception(AuthorsNotFoundByCityException ex) {
		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	// author details by state not found
	@ExceptionHandler(AuthorsNotFoundByStateException.class)
	public ResponseEntity<ErrorResponse> handlerexception(AuthorsNotFoundByStateException ex) {
		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	// Author details by zip not found
	@ExceptionHandler(AuthorsNotFoundByZipException.class)
	public ResponseEntity<ErrorResponse> handlerexception(AuthorsNotFoundByZipException ex) {
		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	// author details by lastname not found
	@ExceptionHandler(AuthorsNotFoundByLnameException.class)
	public ResponseEntity<ErrorResponse> handlerexception(AuthorsNotFoundByLnameException ex) {
		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	// author details by firstname not found
	@ExceptionHandler(AuthorsNotFoundByFnameException.class)
	public ResponseEntity<ErrorResponse> handlerexception(AuthorsNotFoundByFnameException ex) {
		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	// author details by id not found
	@ExceptionHandler(AuthorsNotFoundByIdException.class)
	public ResponseEntity<ErrorResponse> handlerexception(AuthorsNotFoundByIdException ex) {
		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	// author details by phone not found
	@ExceptionHandler(AuthorsNotFoundByPhoneException.class)
	public ResponseEntity<ErrorResponse> handlerexception(AuthorsNotFoundByPhoneException ex) {
		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	// author details by POST method not found
	@ExceptionHandler(AuthorAddException.class)
	public ResponseEntity<ErrorResponse> handlerexception(AuthorAddException ex) {
		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	// Author details by PUT method not found
	@ExceptionHandler(AuthorUpdateException.class)
	public ResponseEntity<ErrorResponse> handlerexception(AuthorUpdateException ex) {
		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	// Author details by DELETE method not found
	@ExceptionHandler(AuthorDeleteException.class)
	public ResponseEntity<ErrorResponse> handlerexception(AuthorDeleteException ex) {
		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	// generic exception
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleAllExceptions(Exception genericException) {
		ErrorResponse err = new ErrorResponse();
		err.setMessage(genericException.getMessage());
		err.setTimeStamp(LocalDate.now());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

}