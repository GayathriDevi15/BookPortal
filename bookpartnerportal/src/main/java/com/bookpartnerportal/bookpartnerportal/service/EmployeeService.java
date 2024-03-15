package com.bookpartnerportal.bookpartnerportal.service;

import java.time.LocalDateTime;
import java.util.List;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();
	List<Employee> getByHireDate(LocalDateTime hireDate);
	List<Employee> getByLname(String lname);
	List<Employee> getByFname(String fname);
	List<Employee> getEmployeesByPubId(String pubId);
	Employee getByEmpId(String empId);
	void deleteEmployeebyEmpId(String empId);
	Employee updateEmployee(String empId,Employee employee);
	Employee addEmployee(Employee employee);
}
