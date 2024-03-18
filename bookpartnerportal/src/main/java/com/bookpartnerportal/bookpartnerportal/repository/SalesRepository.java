package com.bookpartnerportal.bookpartnerportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookpartnerportal.bookpartnerportal.bean.Sales;
import com.bookpartnerportal.bookpartnerportal.bean.Stores;
import com.bookpartnerportal.bookpartnerportal.bean.Titles;

@Repository
public interface SalesRepository extends JpaRepository<Sales,String> {

	Sales findByOrdNum(String ordNum);
	List<Sales> findByTitle(Titles title);

	List<Stores> findByStore(Sales sale);
    @Modifying
    @Query("Delete from Sales s where s.title.titleId= :titleId")
	void deleteByTitleId(String titleId);
    @Query("SELECT s FROM Sales s WHERE s.store.storId = :storeId")
    List<Sales> findByStoreId(String storeId);

}
