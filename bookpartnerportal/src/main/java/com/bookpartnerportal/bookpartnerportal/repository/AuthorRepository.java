package com.bookpartnerportal.bookpartnerportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookpartnerportal.bookpartnerportal.bean.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author,String>{

	List<Author> findByAuFname(String auFname);
	
	List<Author> findByCity(String city);

	List<Author> findByState(String state);

	List<Author> findByZip(String zip);

	List<Author> findByPhone(String phone);

	List<Author> findByAuLname(String au_lname);

	Author findByAuId(String auId);

}
