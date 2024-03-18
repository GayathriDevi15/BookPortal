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
		int jobId=jobs.getJobId();
    	if(jobrepo.findByJobId(jobId)==null && jobs.getMinLvl()>=10 && jobs.getMaxLvl()!=0 &&  jobs.getMaxLvl()<=250) {
    		if(jobs.getJobDesc()==null) {
    			jobs.setJobDesc("New Position - title not formalized yet");
    		}
   	    Jobs savedJobs= jobrepo.save(jobs);
   	    return savedJobs;
   	    }
    	else {
    		return null;
    	}	
	}
	
	@Override
	public Jobs findbyId(int id) {

		return jobrepo.findByJobId(id);
	}

	
	public JobsServiceImplementation(JobsRepository jobrepo) {
		this.jobrepo = jobrepo;
	}
	
	

}
