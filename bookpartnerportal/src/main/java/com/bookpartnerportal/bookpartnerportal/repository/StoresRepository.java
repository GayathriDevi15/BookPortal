package com.bookpartnerportal.bookpartnerportal.repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bookpartnerportal.bookpartnerportal.bean.Stores;





public interface StoresRepository extends JpaRepository<Stores,String>{
	List<Stores> findAll();
	List<Stores> findByZip(String zip);
	List<Stores> findByCity(String city);
	Stores findByStorId(String storId);
	 void deleteById(String storId);
	 

}