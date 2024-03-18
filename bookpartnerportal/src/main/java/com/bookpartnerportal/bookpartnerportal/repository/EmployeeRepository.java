package com.bookpartnerportal.bookpartnerportal.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;


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

	List<Employee> findAll();
	List<Employee> findByHireDate(LocalDateTime hireDate);
	List<Employee> findByLname(String lname);
	List<Employee> findByFname(String fname);
	List<Employee> findByPublisher_PubId(String pubId);
	Employee findByEmpId(String empId);
	 @Query("SELECT e FROM Employee e WHERE e.job.jobId = :jobId")
	    List<Employee> findByJobId(String jobId);
	
}

