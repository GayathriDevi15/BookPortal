package com.bookpartnerportal.bookpartnerportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookpartnerportal.bookpartnerportal.bean.Jobs;

public interface JobsRepository extends JpaRepository<Jobs, Integer>{
	Jobs findByJobId(int id);
	List<Jobs> findAll();
	  List<Jobs> findByMaxLvl(int maxLvl);
	  List<Jobs> findByMinLvl(int minLvl);
	  //void deleteJobByJobId(int jobId);
	  void deleteById(int jobId);
	 // Jobs findByJobId(int jobId);
	

}
