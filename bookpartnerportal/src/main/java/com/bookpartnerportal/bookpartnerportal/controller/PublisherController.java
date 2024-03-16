package com.bookpartnerportal.bookpartnerportal.controller;

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
import com.bookpartnerportal.bookpartnerportal.serviceimplementation.PublisherServiceImplementation;

@RestController
public class PublisherController {
	@Autowired
	private PublisherServiceImplementation publisherImp;

	public PublisherController(PublisherServiceImplementation publisherImp) {
		
		this.publisherImp = publisherImp;
	}
	
	
	@GetMapping("/api/publishers")
	public List<Publisher> getPublishers(){
		return publisherImp.getAllPublishers();
	}
	
	@GetMapping("/api/employee/pubid/{pubid}")
	public ResponseEntity<List<Employee>> getEmployeebyid(@PathVariable("pubid") String pubid) {
		List<Employee> e=publisherImp.getbypubid(pubid);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	
	@GetMapping("/api/employee/pubid/{pubid}/fname/{fname}")
	public ResponseEntity<List<Employee>> getEmployeebyFname(@PathVariable("pubid") String pubid,@PathVariable("fname") String fname) {
		List<Employee> e=publisherImp.getbyempfnameubid(pubid, fname);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	
	@GetMapping("/api/publishers/country/{countryname}")
   public ResponseEntity<List<Publisher>> getbycountry(@PathVariable("countryname") String countryname){
		List<Publisher> publisher = publisherImp.getbyCountry(countryname);
       return new ResponseEntity<>(publisher,HttpStatus.OK);
   }

	@GetMapping("/api/publishers/state/{statename}")
   public ResponseEntity<List<Publisher>> getbystate(@PathVariable("statename") String statename){
		List<Publisher> publisher = publisherImp.getbyState(statename);
       return new ResponseEntity<>(publisher,HttpStatus.OK);
   }
	
	@GetMapping("/api/publishers/pubname/{publishername}")
   public ResponseEntity<List<Publisher>> getbypubname(@PathVariable("publishername") String publishername){
		List<Publisher> publisher = publisherImp.getbyName(publishername);
       return new ResponseEntity<>(publisher,HttpStatus.OK);
   }

  @DeleteMapping("/api/publishers/{pub_id}")
  public ResponseEntity<Void> deletePublisher(@PathVariable("pub_id") String id) {
	 publisherImp.deletePublisherbyId(id);
	  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
  
  @PutMapping("/api/publishers/{pub_id}")
  public ResponseEntity<Publisher> updatepublisher(@PathVariable("pub_id") String pub_id, @RequestBody Publisher publisher){
	   Publisher pub=publisherImp.updatepublisher(pub_id, publisher);
	   return new ResponseEntity<>(publisher,HttpStatus.OK);
  }
  
  @PostMapping("/api/publishers")
  public ResponseEntity<Publisher> addnewpublisher(@RequestBody Publisher publisher){
	   Publisher newpub=publisherImp.addpublisher(publisher);
	   return new ResponseEntity<>(newpub,HttpStatus.CREATED);
  }
  
  
}
