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
	//delete by empId
		@Override
		public void deleteEmployeebyEmpId(String empId) {
			emprepository.deleteById(empId);
		}
	
//
//	@Override
//	public List<Employee> getAllemployes() {
//		return emprepository.findAll();
//	}
//public EmployeeServiceImplementation(EmployeeRepository emprepository) {
//	this.emprepository = emprepository;
//}
////@Override
////public List<Employee> getEmployeesByPublisherId(String publisherId) {
////    return emprepository.findByPublisher(publisherId);
////}
	
//	@Override
//	public Employee getbyempid(String empid) {
//		List<Employee> emp=new ArrayList();
//		Employee employ = null;
//		for(Employee e:emp) {
//			if(e.getEmpId()==empid) {
//				employ=e;
//			}
//			
//		}
//		return employ;
//	}
//
//	@Override
//	public List<Publisher> getbyCountry(String countryname) {
//		return publisherrepository.findByCountry(countryname);
//	}
//
//	@Override
//	public List<Publisher> getbyState(String statename) {
//		return publisherrepository.findByState(statename);
//	}
//
//	@Override
//	public List<Publisher> getbyName(String publisherName) {
//		return publisherrepository.findByPubName(publisherName);
//	}
//
//	@Override
//	public void deletePublisherbyId(String pubId) {
//////		if(publisherrepository.existsById(pubId)) {
//////			
////			publisherrepository.deleteById(pubId);
//////		}else{
////			
////			
////			
//	}
//
//	@Override
//	public Publisher updatepublisher(String pubid, Publisher publisher) {
//		if((publisherrepository.existsById(pubid))) {
//			publisher.setPubId(pubid);
//			return publisherrepository.save(publisher);
//		}
//		return null;
//	}
//
//	@Override
//	public Publisher addpublisher(Publisher publisher) {
//		return publisherrepository.save(publisher);
//	}
//
//	
////	
//
//
//
}
