package com.bookpartnerportal.bookpartnerportal.serviceimplementation;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bookpartnerportal.bookpartnerportal.bean.Jobs;
import com.bookpartnerportal.bookpartnerportal.repository.JobsRepository;
import com.bookpartnerportal.bookpartnerportal.service.JobsService;

@Service
public class JobsServiceImplementation implements JobsService{

	private JobsRepository jobrepo;
	@Override
	public Jobs addJobs(Jobs jobs) {

		return jobrepo.save(jobs);
	}
	
	@Override
	public Jobs findbyId(int id) {

		return jobrepo.findByJobId(id);
	}

	
	public JobsServiceImplementation(JobsRepository jobrepo) {
		this.jobrepo = jobrepo;
	}
	
	

}
