package com.bookpartnerportal.bookpartnerportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;
import com.bookpartnerportal.bookpartnerportal.bean.Publisher;

public interface EmployeeRepository extends JpaRepository<Employee,String>{
	//List<Employee> findAll();
	List<Employee> findByPublisher(Publisher pub);

//	List<Employee> findByFname();
	List<Employee> findAllByPublisherPubIdAndFname(String pubid, String fname);

	List<Employee> deleteByPublisher(Publisher pub);


}
