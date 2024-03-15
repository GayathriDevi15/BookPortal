package com.bookpartnerportal.bookpartnerportal.service;
 
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
 
import com.bookpartnerportal.bookpartnerportal.bean.Sales;
 
public interface SalesService {
 
	List<Sales> getAllSales();
	Sales getSalesById(String ordNum);
	List<Sales> getSalesByOrderDate(LocalDateTime orderDate);
	List<Sales> getSalesByTitle(String titleId);
	Sales addSales(Sales sales);
}