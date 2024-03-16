//package com.bookpartnerportal.bookpartnerportal.controller;  
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bookpartnerportal.bookpartnerportal.bean.Jobs;
//import com.bookpartnerportal.bookpartnerportal.bean.Publisher;
//import com.bookpartnerportal.bookpartnerportal.serviceimplementation.JobsServiceImplementation;
//
//@RestController
//public class JobsController {
//	
//	@Autowired
//	private JobsServiceImplementation jobimp;
//
//	public JobsController(JobsServiceImplementation jobimp) {
//		super();
//		this.jobimp = jobimp;
//	}
//	
//	@GetMapping("/api/jobs/{id}")
//	public ResponseEntity<Optional<Jobs>> getjobsbyid(@PathVariable("id") int id) {
//		Optional<Jobs> j=jobimp.findbyId(id);
//		return new ResponseEntity<>(j,HttpStatus.FOUND);
//	}
//	
//	@PostMapping("/api/jobs")
//	   public ResponseEntity<Jobs> addnewjobs(@RequestBody Jobs job){
//		   Jobs newjob=jobimp.addJobs(job);
//		   return new ResponseEntity<>(newjob,HttpStatus.CREATED);
//	   }
//	
//
//}
