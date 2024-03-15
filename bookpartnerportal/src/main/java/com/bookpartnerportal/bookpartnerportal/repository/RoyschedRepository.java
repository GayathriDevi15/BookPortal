package com.bookpartnerportal.bookpartnerportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookpartnerportal.bookpartnerportal.bean.Roysched;
import com.bookpartnerportal.bookpartnerportal.bean.Titles;

public interface RoyschedRepository extends JpaRepository<Roysched,Integer> {
	
	List<Roysched> findByTitles(Titles title);
	@Modifying
	@Query("Delete from Roysched r where r.titles.titleId= :titleId")
	void deleteByTitleId(String titleId);

}
