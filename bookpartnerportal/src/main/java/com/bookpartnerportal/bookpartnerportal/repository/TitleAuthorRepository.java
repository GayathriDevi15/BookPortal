package com.bookpartnerportal.bookpartnerportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookpartnerportal.bookpartnerportal.bean.Author;
import com.bookpartnerportal.bookpartnerportal.bean.TitleAuthor;
import com.bookpartnerportal.bookpartnerportal.bean.Titles;
@Repository
public interface TitleAuthorRepository extends JpaRepository<TitleAuthor,String> {
 
List<TitleAuthor> findByAuthor(Author author);

List<TitleAuthor> findByTitle(Titles title);

@Modifying
@Query("Delete from TitleAuthor ta where ta.title.titleId= :titleId")
void deleteByTitleId(String titleId);
}
