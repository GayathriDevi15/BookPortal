package com.bookpartnerportal.bookpartnerportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookpartnerportal.bookpartnerportal.bean.Sales;
import com.bookpartnerportal.bookpartnerportal.bean.Titles;

@Repository
public interface SalesRepository extends JpaRepository<Sales,String> {

	Sales findByOrdNum(String ordNum);

	List<Sales> findByTitle(Titles title);
	
	
	//List<Sales> findByTitle(Titles title);


}
