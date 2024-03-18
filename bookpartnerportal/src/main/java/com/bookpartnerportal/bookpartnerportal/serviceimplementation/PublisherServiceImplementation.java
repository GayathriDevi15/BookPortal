package com.bookpartnerportal.bookpartnerportal.serviceimplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<Publisher> getbyCity(String cityname) {
		// TODO Auto-generated method stub
		return publisherrepository.findByCity(cityname);
	}
	@Override
	public List<Publisher> getbyName(String publisherName) {
		return publisherrepository.findByPubName(publisherName);
	}

	@Override
	@Transactional
	public void deletePublisherbyId(String pubId) {
		Publisher pub=publisherrepository.findByPubId(pubId);
		
		employeerepository.deleteByPublisher(pub);
		publisherrepository.deleteById(pubId);
		
	}

	@Override
	public Publisher updatepublisher(String pubid, Publisher publisher) {
		if((publisherrepository.existsById(pubid))) {
			if(publisher.getCountry()==null) {
				 publisher.setCountry("USA");
			 }
			publisher.setPubId(pubid);
			return publisherrepository.save(publisher);
		}
		return null;
	}

	@Override
	public Publisher addpublisher(Publisher publisher) {
		String pubid=publisher.getPubId();
		if(publisherrepository.findByPubId(pubid)==null&&pubid!=null) {
			 if(publisher.getCountry()==null) {
				 publisher.setCountry("USA");
			 }
			 List<String> pubIdList=Arrays.asList("1389","0736","0877","1622","1756");
			 String pubregx="^99[0-9][0-9]$";
			 if(pubIdList.contains(pubid)||pubid.matches(pubregx))
			 {
					return publisherrepository.save(publisher);

			 }
			 
		}
			return null;
			
		
	}

	@Override
	public List<Employee> getbypubid(String pubid) {
		Publisher publisher=publisherrepository.findByPubId(pubid);
		List<Employee> emplist=employeerepository.findByPublisher(publisher);
		return emplist;
	}

	@Override
	public List<Employee> getbyempfnameubid(String pubid, String fname) {
		
		List<Employee> emp=employeerepository.findAllByPublisherPubIdAndFname(pubid, fname);
		return emp;
		
	}




}
