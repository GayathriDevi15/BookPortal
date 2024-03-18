package com.bookpartnerportal.bookpartnerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookpartnerportal.bookpartnerportal.bean.Author;
import com.bookpartnerportal.bookpartnerportal.bean.TitleAuthor;

@Repository
public interface TitleAuthorRepository extends JpaRepository<TitleAuthor, String> {
	@Modifying
	@Query("delete from TitleAuthor where author= :author")
	void deleteByAuthor(@Param("author") Author author);

}
