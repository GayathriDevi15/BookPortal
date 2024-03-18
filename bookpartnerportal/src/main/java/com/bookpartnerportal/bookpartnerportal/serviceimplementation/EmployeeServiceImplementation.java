package com.bookpartnerportal.bookpartnerportal.serviceimplementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;
import com.bookpartnerportal.bookpartnerportal.bean.Jobs;
import com.bookpartnerportal.bookpartnerportal.bean.Publisher;
import com.bookpartnerportal.bookpartnerportal.repository.EmployeeRepository;
import com.bookpartnerportal.bookpartnerportal.service.EmployeeService;

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

	@Override
	public void deleteEmployeebyEmpId(String empId) {
		emprepository.deleteById(empId);
	}
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> emplist1=emprepository.findAll();
		return emplist1;
	}
	
	//get employees by hiredate
	@Override
	public List<Employee> getByHireDate(LocalDateTime hireDate) {
		List<Employee> emplist2=emprepository.findByHireDate(hireDate);
		return emplist2;
	}
	
	//get employees by lastname
	@Override
	public List<Employee> getByLname(String lname) {
		List<Employee> emplist3=emprepository.findByLname(lname);
		return emplist3;
	}
	
	//get employees by firstname
	@Override
	public List<Employee> getByFname(String fname) {
		List<Employee> emplist4=emprepository.findByFname(fname);
		return emplist4;
	}

	//get employees by pubId
	@Override
	public List<Employee> getEmployeesByPubId(String publisherId) {
        return emprepository.findByPublisher_PubId(publisherId);
    }
	
	//get employees by empId
	@Override
	public Employee getByEmpId(String empId) {
		Employee emplist6=emprepository.findByEmpId(empId);
		return emplist6;
	}
	
	//Update(Put) by empId
	@Override
	public Employee updateEmployee(String empId, Employee employee) {
		if((emprepository.existsById(empId) &&  employee.getFname()!= null && employee.getLname()!=null)) {
			if(employee.getJob().getJobId()==0)
			{
				Jobs job=employee.getJob();
				job.setJobId(1);
				employee.setJob(job);
			}
			if(employee.getJobLvl()==0)
			{
				employee.setJobLvl(10);
			}
			if(employee.getPublisher().getPubId()==null)
			{
				Publisher pub=employee.getPublisher();
				pub.setPubId("9952");
				employee.setPublisher(pub);
			}
			if(employee.getHireDate()==null)
			{
				employee.setHireDate(LocalDateTime.now());
			}
			employee.setEmpId(empId);
			return emprepository.save(employee);
		}
		return null;
	}
	
	//Add(Post) new employee
	@Override
	public Employee addEmployee(Employee employee) {
		String empid=employee.getEmpId();
		if(emprepository.findByEmpId(empid)==null && empid!=null &&  employee.getFname()!= null && employee.getLname()!=null) {
			if(employee.getJob().getJobId()==0)
			{
				Jobs job=employee.getJob();
				job.setJobId(1);
				employee.setJob(job);
			}
			if(employee.getJobLvl()==0)
			{
				employee.setJobLvl(10);
			}
			if(employee.getPublisher().getPubId()==null)
			{
				Publisher pub=employee.getPublisher();
				pub.setPubId("9952");
				employee.setPublisher(pub);
			}
			if(employee.getHireDate()==null)
			{
				employee.setHireDate(LocalDateTime.now());
			}
			
			if(employee.getEmpId().matches("^[A-Z][A-Z][A-Z][1-9][0-9][0-9][0-9][0-9][FM]$")||employee.getEmpId().matches("^[A-Z]-[A-Z][1-9][0-9][0-9][0-9][0-9][FM]$")) {
				
				return emprepository.save(employee);
			}
			
		}
		
			return null;
		
		 
	}
	
}
