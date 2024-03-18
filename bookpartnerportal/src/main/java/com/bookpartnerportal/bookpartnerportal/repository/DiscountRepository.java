package com.bookpartnerportal.bookpartnerportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookpartnerportal.bookpartnerportal.bean.Discount;
import com.bookpartnerportal.bookpartnerportal.bean.Stores;

public interface DiscountRepository extends JpaRepository<Discount,Integer>{
  


}
