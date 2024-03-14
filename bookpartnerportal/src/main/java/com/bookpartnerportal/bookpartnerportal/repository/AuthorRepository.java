package com.bookpartnerportal.bookpartnerportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookpartnerportal.bookpartnerportal.bean.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author,String>{

	List<Author> findByAuFname(String auFname);

}
