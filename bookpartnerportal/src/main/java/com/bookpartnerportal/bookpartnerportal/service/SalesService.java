package com.bookpartnerportal.bookpartnerportal.service;

import java.util.List;

import com.bookpartnerportal.bookpartnerportal.bean.Sales;

public interface SalesService {

	List<Sales> getAllSales();

	Sales getSalesById(String ordNum);

}
