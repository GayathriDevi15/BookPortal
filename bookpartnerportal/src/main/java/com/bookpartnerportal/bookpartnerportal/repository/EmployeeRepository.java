package com.bookpartnerportal.bookpartnerportal.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,String>{
	List<Employee> findAll();
	List<Employee> findByHireDate(LocalDateTime hireDate);
	List<Employee> findByLname(String lname);
	List<Employee> findByFname(String fname);
	List<Employee> findByPublisher_PubId(String pubId);
	Employee findByEmpId(String empId);
	
}
