package com.bookpartnerportal.bookpartnerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookpartnerportal.bookpartnerportal.bean.Publisher;
@Repository
public interface PublisherRepository extends JpaRepository<Publisher,String> {

	Publisher findByPubId(String pubId);

}
