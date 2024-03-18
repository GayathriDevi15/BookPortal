package com.bookpartnerportal.bookpartnerportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;
import com.bookpartnerportal.bookpartnerportal.bean.Publisher;
import com.bookpartnerportal.bookpartnerportal.serviceimplementation.EmployeeServiceImplementation;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeServiceImplementation empimp;
	@GetMapping("/api/employees")
	public List<Employee> getPublishers(){
		return empimp.getAllemployes();
	}
	@GetMapping("/api/employees/pubid/{pubid}")
	public List<Employee> getPublishersbyid(@PathVariable("pubid") String id){
		return empimp.getEmployeesByPublisherId(id);
	}
	
	public EmployeeController(EmployeeServiceImplementation empimp) {
		super();
		this.empimp = empimp;
     }

}
