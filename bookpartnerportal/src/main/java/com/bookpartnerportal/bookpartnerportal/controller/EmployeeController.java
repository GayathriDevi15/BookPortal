package com.bookpartnerportal.bookpartnerportal.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;
import com.bookpartnerportal.bookpartnerportal.exception.EmployeeHireDateNotFoundException;
import com.bookpartnerportal.bookpartnerportal.exception.EmployeeNotFoundByEmpIDException;
import com.bookpartnerportal.bookpartnerportal.exception.EmployeeNotFoundByFNameException;
import com.bookpartnerportal.bookpartnerportal.exception.EmployeeNotFoundByLNameException;
import com.bookpartnerportal.bookpartnerportal.exception.EmployeeNotFoundByPublisherIDException;
import com.bookpartnerportal.bookpartnerportal.exception.EmployeeNotFoundException;
import com.bookpartnerportal.bookpartnerportal.exception.EmployeeValidationFailedException;
import com.bookpartnerportal.bookpartnerportal.exception.ErrorResponse;
import com.bookpartnerportal.bookpartnerportal.exception.SuccessResponse;
import com.bookpartnerportal.bookpartnerportal.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//get all employees
	@GetMapping("api/employees")
	public ResponseEntity<List<Employee>> getEmployee()
	{
		List<Employee> emp=employeeService.getAllEmployee();
		if(emp.isEmpty())
			throw new EmployeeNotFoundException("Collections not Found");
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	//get by employee hiredate
	@GetMapping("/api/employees/hiredate/{hiredate}")
	public ResponseEntity<List<Employee>> getByHireDate(@PathVariable("hiredate")LocalDateTime hireDate)
	{
		List<Employee> employee=employeeService.getByHireDate(hireDate);
		if(employee.isEmpty())
			throw new EmployeeHireDateNotFoundException("Employees with given hire date not found");
		return new ResponseEntity<>(employee, HttpStatus.OK);
		
	}
	
	//get by employee lname
	@GetMapping("/api/employees/lname/{lname}")
	public ResponseEntity<List<Employee>> getByLname(@PathVariable("lname")String lname)
	{
		List<Employee> employee=employeeService.getByLname(lname);
		if(employee.isEmpty())
			throw new EmployeeNotFoundByLNameException("Employees with given last name not found");
		return new ResponseEntity<>(employee, HttpStatus.OK);
		
	}
	
	//get by employee fname
		@GetMapping("/api/employees/fname/{fname}")
		public ResponseEntity<List<Employee>> getByFname(@PathVariable("fname")String fname)
		{
			List<Employee> employee=employeeService.getByFname(fname);
			if(employee.isEmpty())
				throw new EmployeeNotFoundByFNameException("Employees with given first name not found");
			return new ResponseEntity<>(employee, HttpStatus.OK);
			
		}
		
		//get by employee pubId
		@GetMapping("/api/employees/pubid/{pubId}")
	    public ResponseEntity<List<Employee>> getEmployeesByPublisherId(@PathVariable("pubId") String publisherId) {
	        List<Employee> employees = employeeService.getEmployeesByPubId(publisherId);
	        if(employees.isEmpty())
	        	throw new EmployeeNotFoundByPublisherIDException("Employees with given publisher id not found");
	        return ResponseEntity.ok(employees);
	    }
		
		//get by employee empId
		@GetMapping("/api/employees/{empid}")
		public ResponseEntity<Employee> getByEmpId(@PathVariable("empid")String empId)
		{
			Employee employee=employeeService.getByEmpId(empId);
			if(employee==null)
				throw new EmployeeNotFoundByEmpIDException("Employees with given employee id not found");
			return new ResponseEntity<>(employee, HttpStatus.OK);
					
		}
		
		//delete by empID
		@DeleteMapping("/api/employees/{empid}")
		   public ResponseEntity<SuccessResponse> deleteEmployeebyEmpId(@PathVariable("empid") String empid) {
			Employee employee=employeeService.getByEmpId(empid);
			if(employee==null)
			{
		        throw new  EmployeeNotFoundByEmpIDException("Employees with given employee id not found");
			}
			employeeService.deleteEmployeebyEmpId(empid);
			SuccessResponse successResponse=new SuccessResponse(LocalDate.now(),"Employee record deleted successfully");
			  return new ResponseEntity<>(successResponse,HttpStatus.OK);
			}
				
		//Update(Put) by empId
		@PutMapping("/api/employees/{empid}")
		   public ResponseEntity<SuccessResponse> updateEmployee(@PathVariable("empid") String empid, @RequestBody Employee employee){
			   Employee emp=employeeService.updateEmployee(empid, employee);
			   if(emp==null)
				   throw new EmployeeValidationFailedException("Validation Failed");
			   SuccessResponse successResponse=new SuccessResponse(LocalDate.now(),"Employee details updated succesfully");
			   return new ResponseEntity<>(successResponse,HttpStatus.OK);
		   }

		//Post Add new employee
		@PostMapping("/api/employees")
		 public ResponseEntity<SuccessResponse> addEmployee(@RequestBody Employee employee){
			   Employee newemp=employeeService.addEmployee(employee);
			   if(newemp==null)
				   throw new EmployeeValidationFailedException("Validation Failed");
			   SuccessResponse successResponse=new SuccessResponse(LocalDate.now(),"Employee Added successfully");
			   return new ResponseEntity<>(successResponse,HttpStatus.OK);
		   }

}
