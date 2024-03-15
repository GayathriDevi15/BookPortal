package com.bookpartnerportal.bookpartnerportal.serviceimplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;
import com.bookpartnerportal.bookpartnerportal.bean.Publisher;
import com.bookpartnerportal.bookpartnerportal.repository.EmployeeRepository;
import com.bookpartnerportal.bookpartnerportal.repository.PublisherRepository;
//import com.bookpartnerportal.bookpartnerportal.service.EmployeeService;
import com.bookpartnerportal.bookpartnerportal.service.PublisherService;

@Service
public class PublisherServiceImplementation implements PublisherService{

	private PublisherRepository publisherrepository;
	private EmployeeRepository employeerepository;

	public PublisherServiceImplementation(PublisherRepository publisherrepository, EmployeeRepository employeerepository) {
		super();
		this.publisherrepository = publisherrepository;
		this.employeerepository = employeerepository;
	}
	
	
	@Override
	public List<Publisher> getAllPublishers() {
		return publisherrepository.findAll();
	}

	@Override
	public List<Publisher> getbyCountry(String countryname) {
		return publisherrepository.findByCountry(countryname);
	}

	@Override
	public List<Publisher> getbyState(String statename) {
		return publisherrepository.findByState(statename);
	}

	@Override
	public List<Publisher> getbyName(String publisherName) {
		return publisherrepository.findByPubName(publisherName);
	}

	@Override
	public void deletePublisherbyId(String pubId) {
////		if(publisherrepository.existsById(pubId)) {
////			
			publisherrepository.deleteById(pubId);
////		}else{
//			
//			
//			
	}

	@Override
	public Publisher updatepublisher(String pubid, Publisher publisher) {
		if((publisherrepository.existsById(pubid))) {
			publisher.setPubId(pubid);
			return publisherrepository.save(publisher);
		}
		return null;
	}

	@Override
	public Publisher addpublisher(Publisher publisher) {
		return publisherrepository.save(publisher);
	}

	@Override
	public List<Employee> getbypubid(String pubid) {
		Publisher publisher=publisherrepository.findBypubId(pubid);
		List<Employee> emplist=employeerepository.findByPublisher(publisher);
		return emplist;
	}

	@Override
	public List<Employee> getbyempfnameubid(String pubid, String fname) {
		
		List<Employee> emp=employeerepository.findAllByPublisherPubIdAndFname(pubid, fname);
		return emp;
		
	}


}
