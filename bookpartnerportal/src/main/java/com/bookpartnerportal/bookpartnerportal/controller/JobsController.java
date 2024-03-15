package com.bookpartnerportal.bookpartnerportal.controller;  

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookpartnerportal.bookpartnerportal.bean.Jobs;
import com.bookpartnerportal.bookpartnerportal.bean.Publisher;
import com.bookpartnerportal.bookpartnerportal.exception.JobsWithJobIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.exception.PublishersNotFoundException;
import com.bookpartnerportal.bookpartnerportal.exception.ValidationFailedException;
import com.bookpartnerportal.bookpartnerportal.serviceimplementation.JobsServiceImplementation;
import com.bookpartnerportal.bookpartnerportal.success.SuccessResponse;

@RestController
public class JobsController {
	
	@Autowired
	private JobsServiceImplementation jobimp;

	public JobsController(JobsServiceImplementation jobimp) {
		super();
		this.jobimp = jobimp;
	}
	
	@GetMapping("/api/jobs/{id}")
	public ResponseEntity<Jobs> getjobsbyid(@PathVariable("id") int id) {
		Jobs j=jobimp.findbyId(id);
		if(j==null) {
			throw new JobsWithJobIdNotFoundException("Jobs with this job id not found");
		}
		return new ResponseEntity<>(j,HttpStatus.FOUND);
	}
	
	@PostMapping("/api/jobs")
	   public ResponseEntity<Jobs> addnewjobs(@RequestBody Jobs job){
		   Jobs newjob=jobimp.addJobs(job);
		   if(newjob==null) {
				throw new ValidationFailedException("Validation failed");
			}
		SuccessResponse successResponse=new SuccessResponse(LocalDate.now(),"New Job added successfully");
		   return new ResponseEntity<>(newjob,HttpStatus.CREATED);
	   }
	

}
