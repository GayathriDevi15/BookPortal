package com.bookpartnerportal.bookpartnerportal.salesexceptions;
public class SalesDetailsNotFoundException extends RuntimeException {
  public SalesDetailsNotFoundException(String message) {
	  super(message);
  }
}