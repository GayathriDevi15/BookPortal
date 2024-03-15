package com.bookpartnerportal.bookpartnerportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;
import com.bookpartnerportal.bookpartnerportal.bean.Publisher;
import com.bookpartnerportal.bookpartnerportal.serviceimplementation.EmployeeServiceImplementation;
import com.bookpartnerportal.bookpartnerportal.success.SuccessResponse;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeServiceImplementation empimp;
//	@GetMapping("/api/employees")
//	public List<Employee> getPublishers(){
//		return empimp.getAllemployes();
//	}
//	@GetMapping("/api/employees/pubid/{pubid}")
//	public List<Employee> getPublishersbyid(@PathVariable("pubid") String id){
//		return empimp.getEmployeesByPublisherId(id);
//	}
	
//	
	//delete by empID
//			@DeleteMapping("/api/employees/{empid}")
//			   public ResponseEntity<SuccessResponse> deleteEmployeebyEmpId(@PathVariable("empid") String empid) {
//				Employee employee=employeeService.getByEmpId(empid);
//				if(employee==null)
//				{
//			        throw new EmployeeValidationFailedException("Validation Failed");
//				}
//				employeeService.deleteEmployeebyEmpId(empid);
//				SuccessResponse successResponse=new SuccessResponse(LocalDate.now(),"Employee record deleted successfully");
//				  return new ResponseEntity<>(successResponse,HttpStatus.OK);
//				}
	public EmployeeController(EmployeeServiceImplementation empimp) {
		super();
		this.empimp = empimp;
	}
//
}
