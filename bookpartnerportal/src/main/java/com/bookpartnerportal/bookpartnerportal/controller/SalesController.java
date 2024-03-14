package com.bookpartnerportal.bookpartnerportal.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookpartnerportal.bookpartnerportal.bean.Sales;
import com.bookpartnerportal.bookpartnerportal.bean.Titles;
import com.bookpartnerportal.bookpartnerportal.serviceimplementation.SalesServiceImplementation;
import com.bookpartnerportal.bookpartnerportal.success.SuccessResponse;

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
		  return new ResponseEntity<>(salesList,HttpStatus.OK);
		  
	  }
	 
	  @GetMapping("/{id}")
	  public ResponseEntity<Sales> getSalesById(@PathVariable("id") String ordNum){
		  Sales sales=salesService.getSalesById(ordNum);
		  return new ResponseEntity<>(sales,HttpStatus.OK);
		  
	  }
//	  @DeleteMapping("{title_id}")
//	  public ResponseEntity<SuccessResponse> deleteTitle(@PathVariable("title_id") String titleId) {
//		  titlesService.deleteTitle(titleId);
//		  SuccessResponse successResponse=new SuccessResponse(LocalDateTime.now(),"Title deleted successfully");
//		  return new ResponseEntity<>(successResponse,HttpStatus.OK);
//	  }

}
