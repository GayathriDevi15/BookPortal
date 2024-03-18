package com.bookpartnerportal.bookpartnerportal.service;

import java.util.List;
import java.util.Optional;

import com.bookpartnerportal.bookpartnerportal.bean.Jobs;

public interface JobsService {
	Jobs findbyId(int id);
	Jobs addJobs(Jobs jobs);
	List<Jobs> getAllJobs();
	 List<Jobs> getJobsByMaxLvl(int maxLvl);
	 List<Jobs> getJobsByMinLvl(int minLvl);
	 //void deleteByJobId (int jobId );
	 void deleteJobByJobId(int jobId);
	 Jobs getJobsByJobId(int jobId);
	 Jobs updateJob(int jobId, Jobs jobs);
//	 void updateJob(int jobId, Jobs newJobData);
	// Jobs addJobs(Jobs jobs);
	

}
