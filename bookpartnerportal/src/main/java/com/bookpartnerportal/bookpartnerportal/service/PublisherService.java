package com.bookpartnerportal.bookpartnerportal.service;

import java.util.List;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;
import com.bookpartnerportal.bookpartnerportal.bean.Publisher;

public interface PublisherService {
	
	List<Publisher> getAllPublishers();
	List<Employee> getbyempfnameubid(String pubid, String fname);
	List<Publisher> getbyCountry(String countryname);
	List<Publisher> getbyState(String statename);
	List<Publisher> getbyCity(String cityname);
	List<Publisher> getbyName(String publisherName);
	void deletePublisherbyId(String pubId);
	Publisher updatepublisher(String pubid,Publisher publisher);
	Publisher addpublisher(Publisher publisher);
	List<Employee> getbypubid(String pubid);
	

}
