package com.bookpartnerportal.bookpartnerportal.controller;


import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;
import com.bookpartnerportal.bookpartnerportal.bean.Publisher;
import com.bookpartnerportal.bookpartnerportal.publisherexception.EmployeeFirstnamebyPublisherIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.publisherexception.EmployeesbyPublisherIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.publisherexception.PublisherWithCityNotFoundException;
import com.bookpartnerportal.bookpartnerportal.publisherexception.PublisherWithCountryNotFoundException;
import com.bookpartnerportal.bookpartnerportal.publisherexception.PublisherWithIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.publisherexception.PublisherWithNameNotFoundException;
import com.bookpartnerportal.bookpartnerportal.publisherexception.PublisherWithStateNotFoundException;
import com.bookpartnerportal.bookpartnerportal.publisherexception.PublishersNotFoundException;
import com.bookpartnerportal.bookpartnerportal.publisherexception.ValidationFailedException;
import com.bookpartnerportal.bookpartnerportal.repository.PublisherRepository;
import com.bookpartnerportal.bookpartnerportal.serviceimplementation.PublisherServiceImplementation;
import com.bookpartnerportal.bookpartnerportal.success.SuccessResponse;


@RestController
public class PublisherController {
	@Autowired
	private PublisherServiceImplementation publisherImp;
	private PublisherRepository publisherrepository;



	@GetMapping("/api/publishers")
	public ResponseEntity<List<Publisher>> getPublishers(){
		List<Publisher> publishers=publisherImp.getAllPublishers();
		if(publishers.isEmpty()) {
			throw new PublishersNotFoundException("Publishers not found");
		}
		return new ResponseEntity<>(publishers,HttpStatus.OK);
	}

	
	public PublisherController(PublisherServiceImplementation publisherImp, PublisherRepository publisherrepository) {
	super();
	this.publisherImp = publisherImp;
	this.publisherrepository = publisherrepository;
}


	@GetMapping("/api/employee/pubid/{pubid}")
	public ResponseEntity<List<Employee>> getEmployeebyid(@PathVariable("pubid") String pubid) {
		List<Employee> e=publisherImp.getbypubid(pubid);
		if(e.isEmpty()) {
			throw new EmployeesbyPublisherIdNotFoundException("Employees with given publisherId not found");
		}
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	
	@GetMapping("/api/employee/pubid/{pubid}/fname/{fname}")
	public ResponseEntity<List<Employee>> getEmployeebyFname(@PathVariable("pubid") String pubid,@PathVariable("fname") String fname) {
		List<Employee> e=publisherImp.getbyempfnameubid(pubid, fname);

		if(e.isEmpty()) {
			throw new EmployeeFirstnamebyPublisherIdNotFoundException("Employees with given firstname not found");
		}
		return new ResponseEntity<>(e,HttpStatus.FOUND);
	}

	
	@GetMapping("/api/publishers/country/{countryname}")
    public ResponseEntity<List<Publisher>> getbycountry(@PathVariable("countryname") String countryname){
		List<Publisher> publisher = publisherImp.getbyCountry(countryname);
		if(publisher.isEmpty()) {
			throw new PublisherWithCountryNotFoundException("Publisher with given country not found");
		}
		return new ResponseEntity<>(publisher,HttpStatus.OK);
    }

	
	@GetMapping("/api/publishers/state/{statename}")
    public ResponseEntity<List<Publisher>> getbystate(@PathVariable("statename") String statename){
		List<Publisher> publisher = publisherImp.getbyState(statename);
		if(publisher.isEmpty()) {
			throw new PublisherWithStateNotFoundException("Publisher with given state not found");
		}
		return new ResponseEntity<>(publisher,HttpStatus.OK);
    }
	
	@GetMapping("/api/publishers/city/{name}")
    public ResponseEntity<List<Publisher>> getbycity(@PathVariable("name") String name){
		List<Publisher> publisher = publisherImp.getbyCity(name);
		if(publisher.isEmpty()) {
			throw new PublisherWithCityNotFoundException("Publisher with given city not found");
		}
        return new ResponseEntity<>(publisher,HttpStatus.OK);
    }
	
	
	@GetMapping("/api/publishers/pubname/{publishername}")
    public ResponseEntity<List<Publisher>> getbypubname(@PathVariable("publishername") String publishername){
		List<Publisher> publisher = publisherImp.getbyName(publishername);
		if(publisher.isEmpty()) {
			throw new PublisherWithNameNotFoundException("Publisher with given name not found");
		}
        return new ResponseEntity<>(publisher,HttpStatus.OK);
    }


	
   @DeleteMapping("/api/publishers/{pub_id}")
   public ResponseEntity<SuccessResponse> deletePublisher(@PathVariable("pub_id") String id) {
	   Publisher pub=publisherrepository.findByPubId(id);
	 if(pub==null) {
		   throw new PublisherWithIdNotFoundException("Publisher with this publisherId not found");
	   }
	 publisherImp.deletePublisherbyId(id);
	 SuccessResponse successResponse=new SuccessResponse(LocalDate.now(),"Publisher deleted successfully");
	  return new ResponseEntity<>(successResponse,HttpStatus.OK);
	}


   
   @PutMapping("/api/publishers/{pub_id}")
   public ResponseEntity<SuccessResponse> updatepublisher(@PathVariable("pub_id") String pub_id, @RequestBody Publisher publisher){
	   Publisher pub=publisherImp.updatepublisher(pub_id, publisher);
	   if(pub==null) {
		   throw new ValidationFailedException("Validation failed");
	   }
	   SuccessResponse successResponse=new SuccessResponse(LocalDate.now(),"Publisher updated successfully");
	   return new ResponseEntity<>(successResponse,HttpStatus.OK);
   }


   
   @PostMapping("/api/publishers")
   public ResponseEntity<SuccessResponse> addnewpublisher(@RequestBody Publisher publisher){
	   Publisher newpub=publisherImp.addpublisher(publisher);
	   if(newpub==null) {
		   throw new ValidationFailedException("Validation failed");
	   }

	   SuccessResponse successResponse=new SuccessResponse(LocalDate.now(),"New Publisher added successfully");
	   return new ResponseEntity<>(successResponse,HttpStatus.CREATED);
   }
     

}
