package com.bookpartnerportal.bookpartnerportal.service;

import java.time.LocalDateTime;
import java.util.List;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;

public interface EmployeeService {
	List<Employee> getAllemployes();
    List<Employee> getEmployeesByPublisherId(String publisherId);
    List<Employee> getEmployeesfnamesByPublisherId(String publisherId, String fname);
	void deleteEmployeebyEmpId(String empId);
<<<<<<< HEAD
	List<Employee> getEmployeeByJobId(String jobId);
=======
	List<Employee> getAllEmployee();
	List<Employee> getByHireDate(LocalDateTime hireDate);
	List<Employee> getByLname(String lname);
	List<Employee> getByFname(String fname);
	List<Employee> getEmployeesByPubId(String pubId);
	Employee getByEmpId(String empId);
	Employee updateEmployee(String empId,Employee employee);
	Employee addEmployee(Employee employee);

>>>>>>> e04c0efe1ae5548f47661e894682ec36ca0a40fc
}
