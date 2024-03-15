package com.bookpartnerportal.bookpartnerportal.salesexceptions;
public class SaleswithOrdnumNotFoundException extends RuntimeException {
  public SaleswithOrdnumNotFoundException(String message) {
	  super(message);
  }
}