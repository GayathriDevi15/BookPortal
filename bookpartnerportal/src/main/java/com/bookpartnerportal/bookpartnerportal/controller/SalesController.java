package com.bookpartnerportal.bookpartnerportal.controller;
 
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;
import com.bookpartnerportal.bookpartnerportal.bean.Sales;
import com.bookpartnerportal.bookpartnerportal.bean.Titles;
import com.bookpartnerportal.bookpartnerportal.employeeexception.SuccessResponse;
import com.bookpartnerportal.bookpartnerportal.salesexceptions.SalesDetailsNotFoundException;
import com.bookpartnerportal.bookpartnerportal.salesexceptions.SalesNotFoundByOrderDateException;
import com.bookpartnerportal.bookpartnerportal.salesexceptions.SalesNotFoundByTitleIDException;
import com.bookpartnerportal.bookpartnerportal.salesexceptions.SalesValidationException;
import com.bookpartnerportal.bookpartnerportal.salesexceptions.SaleswithOrdnumNotFoundException;
import com.bookpartnerportal.bookpartnerportal.serviceimplementation.SalesServiceImplementation;
 
@RestController
@RequestMapping("/api/sales")
public class SalesController {
	
	private SalesServiceImplementation salesService;
	public SalesController(SalesServiceImplementation salesService) {
		this.salesService = salesService;
	}
 
	@GetMapping
	  public ResponseEntity<List<Sales>> getAllsales(){
		 List<Sales> salesList=salesService.getAllSales();
		 if(salesList.isEmpty())
			 throw new SalesDetailsNotFoundException("Sales details not found");
		  return new ResponseEntity<>(salesList,HttpStatus.OK);
	  }
	  @GetMapping("/{id}")
	  public ResponseEntity<Sales> getSalesById(@PathVariable("id") String ordNum){
		  Sales sales=salesService.getSalesById(ordNum);
		  if(sales==null)
			  throw new SaleswithOrdnumNotFoundException("Sales details with ordnum not found");
		  return new ResponseEntity<>(sales,HttpStatus.OK);
	  }
	  
	  //get sales by order date
	  @GetMapping("/orderdate/{orderdate}")
	  public ResponseEntity<List<Sales>> getSalesByOrderDate(@PathVariable("orderdate")LocalDateTime orderdate){
		  List<Sales> sales=salesService.getSalesByOrderDate(orderdate);
		  if(sales.isEmpty())
			  throw new SalesNotFoundByOrderDateException("Sales details with given order date not found");
		  return new ResponseEntity<>(sales,HttpStatus.OK);
	  }
	  
	  //get sales by title
	  @GetMapping("/titles/{title_id}")
	    public ResponseEntity<List<Sales>> getSalesByTitleId(@PathVariable("title_id") String titleId) {
	        List<Sales> salesList = salesService.getSalesByTitle(titleId);
	        if(salesList.isEmpty())
	        	throw new SalesNotFoundByTitleIDException("Sales details for given title not found");
	        return new ResponseEntity<>(salesList, HttpStatus.OK);
	    }
	  
	  //Post new sales
	  @PostMapping
	    public ResponseEntity<SuccessResponse> addSales(@RequestBody Sales sales) {
	        Sales sale = salesService.addSales(sales);
	        if(sale==null)
	        	throw new SalesValidationException("Validation Failed");
	        SuccessResponse successResponse=new SuccessResponse(LocalDate.now(),"New Sales added successfully");
	        return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
	    }
}