
package com.bookpartnerportal.bookpartnerportal.repository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bookpartnerportal.bookpartnerportal.bean.Sales;
import com.bookpartnerportal.bookpartnerportal.bean.Stores;
import com.bookpartnerportal.bookpartnerportal.bean.Titles;
@Repository
public interface SalesRepository extends JpaRepository<Sales,String> {
	Sales findByOrdNum(String ordNum);
	List<Sales> findByOrdDate(LocalDateTime ordDate);
	@Query("SELECT s FROM Sales s WHERE s.title.titleId = :titleId")
    List<Sales> findByTitleId(String titleId);
	Sales findByStoreAndTitle(Stores store, Titles title);
	
 
 
}
