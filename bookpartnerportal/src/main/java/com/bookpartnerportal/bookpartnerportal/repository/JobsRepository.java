package com.bookpartnerportal.bookpartnerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookpartnerportal.bookpartnerportal.bean.Jobs;

public interface JobsRepository extends JpaRepository<Jobs, Integer>{
	Jobs findByJobId(int id);

}
