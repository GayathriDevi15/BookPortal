package com.bookpartnerportal.bookpartnerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookpartnerportal.bookpartnerportal.bean.Stores;

public interface StoresRepository extends JpaRepository<Stores,String>{

	Stores findByStorId(Stores store);
	

}
