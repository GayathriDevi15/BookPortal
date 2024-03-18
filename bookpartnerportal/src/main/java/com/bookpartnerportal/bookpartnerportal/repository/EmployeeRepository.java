package com.bookpartnerportal.bookpartnerportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;
import com.bookpartnerportal.bookpartnerportal.bean.Publisher;

public interface EmployeeRepository extends JpaRepository<Employee,String>{
	//List<Employee> findAll();
	List<Employee> findByPublisher(Publisher pub);

//	List<Employee> findByFname();
	List<Employee> findAllByPublisherPubIdAndFname(String pubid, String fname);
	@Modifying
	@Query("DELETE FROM Employee e  WHERE e.publisher.pubId= :pub")
	void deleteByPublisher(String pub);

	List<Employee> deleteByPublisher(Publisher pub);

}
