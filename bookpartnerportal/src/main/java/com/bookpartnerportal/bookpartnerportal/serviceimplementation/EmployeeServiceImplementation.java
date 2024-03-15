package com.bookpartnerportal.bookpartnerportal.serviceimplementation;
import java.time.LocalDateTime;
import java.util.List;
 
import org.springframework.stereotype.Service;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;
import com.bookpartnerportal.bookpartnerportal.repository.EmployeeRepository;
import com.bookpartnerportal.bookpartnerportal.service.EmployeeService;
 
@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	//get all employees
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> emplist1=employeeRepository.findAll();
		return emplist1;
	}
	
	//get employees by hiredate
	@Override
	public List<Employee> getByHireDate(LocalDateTime hireDate) {
		List<Employee> emplist2=employeeRepository.findByHireDate(hireDate);
		return emplist2;
	}
	
	//get employees by lastname
	@Override
	public List<Employee> getByLname(String lname) {
		List<Employee> emplist3=employeeRepository.findByLname(lname);
		return emplist3;
	}
	
	//get employees by firstname
	@Override
	public List<Employee> getByFname(String fname) {
		List<Employee> emplist4=employeeRepository.findByFname(fname);
		return emplist4;
	}

	//get employees by pubId
	@Override
	public List<Employee> getEmployeesByPubId(String publisherId) {
        return employeeRepository.findByPublisher_PubId(publisherId);
    }
	
	//get employees by empId
	@Override
	public Employee getByEmpId(String empId) {
		Employee emplist6=employeeRepository.findByEmpId(empId);
		return emplist6;
	}
	
	//delete by empId
	@Override
	public void deleteEmployeebyEmpId(String empId) {
		employeeRepository.deleteById(empId);
		
	}

	//Update(Put) by empId
	@Override
	public Employee updateEmployee(String empId, Employee employee) {
		if((employeeRepository.existsById(empId))) {
			employee.setEmpId(empId);
			return employeeRepository.save(employee);
		}
		return null;
	}
	
	//Add(Post) new employee
	@Override
	public Employee addEmployee(Employee employee) {
		String empid=employee.getEmpId();
		if(employeeRepository.findByEmpId(empid)==null) {
			Employee emp=employeeRepository.save(employee);
			return emp;
		}
		else {
			return null;
		}
		 
	}
	
	
	

	
 
}