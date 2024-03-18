package com.bookpartnerportal.bookpartnerportal.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;
import com.bookpartnerportal.bookpartnerportal.bean.Jobs;
import com.bookpartnerportal.bookpartnerportal.repository.EmployeeRepository;
import com.bookpartnerportal.bookpartnerportal.repository.JobsRepository;
import com.bookpartnerportal.bookpartnerportal.service.JobsService;

@Service
public class JobsServiceImplementation implements JobsService {

	private JobsRepository jobrepo;
	private EmployeeRepository employeeRepository;

	@Override
	public Jobs addJobs(Jobs jobs) {

		return jobrepo.save(jobs);
	}

	@Override
	public Jobs findbyId(int id) {

		return jobrepo.findByJobId(id);
	}

	@Override
	public List<Jobs> getAllJobs() {
		return jobrepo.findAll();
	}

	@Override
	public List<Jobs> getJobsByMaxLvl(int maxLvl) {
		return jobrepo.findByMaxLvl(maxLvl);
	}

	@Override
	public List<Jobs> getJobsByMinLvl(int minLvl) {
		return jobrepo.findByMinLvl(minLvl);
	}
//    @Override
//    public void deleteByJobId(int jobId) {
//        jobsRepository.deleteJobByJobId(jobId);
//    }

	// doubt
	@Override
	public void deleteJobByJobId(int jobId) {
		String jobIdString = String.valueOf(jobId);

		List<Employee> jobToDelete = employeeRepository.findByJobId(jobIdString);
		employeeRepository.deleteAll(jobToDelete);
		employeeRepository.deleteById(jobIdString);
		jobrepo.deleteById(jobId);
	}

	@Override
	public Jobs getJobsByJobId(int jobId) {
		return jobrepo.findByJobId(jobId);
	}

	@Override

	public Jobs updateJob(int jobId, Jobs jobs) {
		if (jobrepo.existsById(jobId) && jobs.getMinLvl() >= 10 && jobs.getMaxLvl() != 0 && jobs.getMaxLvl() <= 250) {
			if (jobs.getJobDesc() == null) {
				jobs.setJobDesc("New Position - title not formalized yet");
			}
			jobs.setJobId(jobId);
			return jobrepo.save(jobs);
		}
		return null;

	}

	public JobsServiceImplementation(JobsRepository jobrepo) {
		this.jobrepo = jobrepo;
	}

}
