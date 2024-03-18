package com.bookpartnerportal.bookpartnerportal.serviceimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;
import com.bookpartnerportal.bookpartnerportal.bean.Publisher;
import com.bookpartnerportal.bookpartnerportal.repository.EmployeeRepository;
import com.bookpartnerportal.bookpartnerportal.repository.PublisherRepository;
import com.bookpartnerportal.bookpartnerportal.service.EmployeeService;
import com.bookpartnerportal.bookpartnerportal.service.PublisherService;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

	private EmployeeRepository emprepository;
	
	public EmployeeServiceImplementation(EmployeeRepository emprepository) {
		
		this.emprepository = emprepository;
	}

	@Override
	public List<Employee> getAllemployes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeesByPublisherId(String publisherId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeesfnamesByPublisherId(String publisherId, String fname) {
		List<Employee> emp=emprepository.findAllByPublisherPubIdAndFname(publisherId, fname);
		return emp;
	}

}
