package com.bookpartnerportal.bookpartnerportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookpartnerportal.bookpartnerportal.bean.Roysched;
import com.bookpartnerportal.bookpartnerportal.bean.Titles;

public interface RoyschedRepository extends JpaRepository<Roysched,Integer> {
	
	List<Roysched> findByTitles(Titles title);

}
