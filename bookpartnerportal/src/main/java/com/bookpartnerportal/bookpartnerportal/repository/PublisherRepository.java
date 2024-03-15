package com.bookpartnerportal.bookpartnerportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookpartnerportal.bookpartnerportal.bean.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher,String>{
	
	List<Publisher> findAll();
	List<Publisher> findByCountry(String countryname);
	List<Publisher> findByState(String statename);
	List<Publisher> findByCity(String cityname);
	List<Publisher> findByPubName(String publisherName);
	Publisher findBypubId(String pubid);
	

	
}
