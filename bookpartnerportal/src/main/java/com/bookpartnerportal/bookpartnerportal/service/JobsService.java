package com.bookpartnerportal.bookpartnerportal.service;

import java.util.Optional;

import com.bookpartnerportal.bookpartnerportal.bean.Jobs;

public interface JobsService {
	Jobs findbyId(int id);
	Jobs addJobs(Jobs jobs);

}
