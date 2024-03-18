package com.bookpartnerportal.bookpartnerportal.service;

import java.util.List;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;

public interface EmployeeService {
	List<Employee> getAllemployes();
    List<Employee> getEmployeesByPublisherId(String publisherId);
    List<Employee> getEmployeesfnamesByPublisherId(String publisherId, String fname);
	void deleteEmployeebyEmpId(String empId);
}
