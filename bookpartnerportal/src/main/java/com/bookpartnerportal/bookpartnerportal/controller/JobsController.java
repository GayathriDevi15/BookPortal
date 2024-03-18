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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookpartnerportal.bookpartnerportal.bean.Jobs;
import com.bookpartnerportal.bookpartnerportal.bean.Publisher;
import com.bookpartnerportal.bookpartnerportal.jobsexception.JobIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.jobsexception.JobsNotFoundException;
import com.bookpartnerportal.bookpartnerportal.jobsexception.JobsUpdateValidationException;
import com.bookpartnerportal.bookpartnerportal.jobsexception.MaxLvlNotFoundException;
import com.bookpartnerportal.bookpartnerportal.jobsexception.MinLvlNotFoundException;
import com.bookpartnerportal.bookpartnerportal.publisherexception.JobsWithJobIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.publisherexception.PublishersNotFoundException;
import com.bookpartnerportal.bookpartnerportal.publisherexception.ValidationFailedException;
import com.bookpartnerportal.bookpartnerportal.serviceimplementation.JobsServiceImplementation;
import com.bookpartnerportal.bookpartnerportal.storeexception.StorIdNotFoundException;
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
		Jobs j = jobimp.findbyId(id);
		if (j == null) {
			throw new JobsWithJobIdNotFoundException("Jobs with this job id not found");
		}
		return new ResponseEntity<>(j, HttpStatus.FOUND);
	}

	@PostMapping("/api/jobs")

	public ResponseEntity<SuccessResponse> addnewjobs(@RequestBody Jobs job) {
		Jobs newjob = jobimp.addJobs(job);
		if (newjob.getJobDesc().isEmpty()) {
			throw new ValidationFailedException("Validation failed");
		}
		SuccessResponse successResponse = new SuccessResponse(LocalDate.now(), "New Job added successfully");
		return new ResponseEntity<>(successResponse, HttpStatus.CREATED);

	}

	@RequestMapping("/api/jobs")
	public ResponseEntity<List<Jobs>> getAllJobs() {
		List<Jobs> jobs = jobimp.getAllJobs();
		if (jobs.isEmpty()) {
			throw new JobsNotFoundException("job not found");
		}
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}

	@GetMapping("/api/jobs/maxLvl/{maxLvl}")
	public ResponseEntity<List<Jobs>> getJobsByMaxLvl(@PathVariable int maxLvl) {
		List<Jobs> jobs = jobimp.getJobsByMaxLvl(maxLvl);
		if (jobs.isEmpty()) {
			throw new MaxLvlNotFoundException("Maximum level not found: " + maxLvl);
		}
		return ResponseEntity.ok(jobs);
	}

	@GetMapping("/api/jobs/minLvl/{minLvl}")
	public ResponseEntity<List<Jobs>> getJobsByMinLvl(@PathVariable int minLvl) {
		List<Jobs> jobs = jobimp.getJobsByMinLvl(minLvl);
		if (jobs.isEmpty()) {
			throw new MinLvlNotFoundException("Minium level not found: " + minLvl);
		}
		return ResponseEntity.ok(jobs);
	}

//	    @DeleteMapping("/api/jobs/jobId/{jobId}")
//	    public ResponseEntity<Void> deleteByJobId(@PathVariable int jobId) {
//	        jobsService.deleteByJobId(jobId);
//	        return ResponseEntity.noContent().build();
//	    }
	@DeleteMapping("/api/jobs/jobId/{jobId}")
	public ResponseEntity<SuccessResponse> deleteJobByJobId(@PathVariable int jobId) {
		Jobs job = jobimp.getJobsByJobId(jobId);
		if (job == null)
			throw new StorIdNotFoundException("Job with this job id not found");
		jobimp.deleteJobByJobId(jobId);
		LocalDate timeStamp = LocalDate.now();
		SuccessResponse successResponse = new SuccessResponse(timeStamp, "job details deleted successfully");
		return ResponseEntity.status(HttpStatus.OK).body(successResponse);
		// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/api/jobs/jobId/{jobId}")
	public ResponseEntity<Jobs> getJobsByJobId(@PathVariable int jobId) {
		Jobs jobs = jobimp.getJobsByJobId(jobId);

		if (jobs == null) {
			throw new JobIdNotFoundException("Job with this job id not found");
		}
		// return ResponseEntity.status(HttpStatus.OK).body(successResponse);
		return new ResponseEntity<>(jobs, HttpStatus.OK);

	}

	@PutMapping("/api/jobs/jobId/{jobId}")
	public ResponseEntity<SuccessResponse> updateJob(@PathVariable int jobId, @RequestBody Jobs jobs) {

		Jobs updatedJob = jobimp.updateJob(jobId, jobs);
		if (updatedJob == null)
			throw new JobsUpdateValidationException("Validation Failed");
		LocalDate timeStamp = LocalDate.now();
		SuccessResponse successResponse = new SuccessResponse(timeStamp, "Job details updated successfully");
		return ResponseEntity.status(HttpStatus.OK).body(successResponse);
		// return ResponseEntity.ok(updatedJob);
	}

}
