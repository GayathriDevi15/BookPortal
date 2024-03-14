package com.bookpartnerportal.bookpartnerportal.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.bookpartnerportal.bookpartnerportal.bean.Titles;

public interface TitlesService {
	//@Query("SELECT t FROM Task t JOIN TaskCategory tc
	//ON t.taskID = tc.task.taskID WHERE tc.category.categoryID = :categoryId")
	
    List<Titles> getTitlesByAuthor(String auFname);
	List<Titles> getTitleByType(String type);
    List<Titles> getTitleByPubId(String pubId);
    Titles getTitleByTitle(String title);
    Titles getTitleByTitleId(String titleId);
	Titles updateTitles(String titleId,Titles title);
	void deleteTitle(String titleId);
	Titles addTitle(Titles title);
	List<Titles> getTitleByPubDate(LocalDate pubDate);
	List<Titles> getTopFiveTitles();
}
