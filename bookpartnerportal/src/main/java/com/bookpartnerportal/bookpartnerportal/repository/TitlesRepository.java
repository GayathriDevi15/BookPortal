package com.bookpartnerportal.bookpartnerportal.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookpartnerportal.bookpartnerportal.bean.Publisher;
import com.bookpartnerportal.bookpartnerportal.bean.Titles;
@Repository
public interface TitlesRepository extends JpaRepository<Titles,String> {

	@Query("SELECT t from Titles t JOIN TitleAuthor ta ON t.titleId=ta.title.titleId WHERE ta.author.auFname= :auFname")
	List<Titles> findByAuFname(String auFname);
	
	Titles findByTitleId(String titleId);

	List<Titles> findByType(String type);

	List<Titles> findByPubDate(LocalDate pubDate);

	List<Titles> findByPub(Publisher pub);

	Titles findByTitle(String title);
	
	Titles findByTitle(Titles title);
    
	@Query(value="SELECT t FROM Titles t ORDER BY ytdSales DESC LIMIT 5")
	List<Titles> findTopFiveTitles();
    
	@Modifying
	@Query("DELETE FROM Titles t WHERE t.titleId= :titleId")
	void deleteByTitleId(String titleId);
	@Modifying
	@Query("DELETE FROM Titles t WHERE t.pub= :pub")
	void deleteByPub(Publisher pub);
//	
     
}
