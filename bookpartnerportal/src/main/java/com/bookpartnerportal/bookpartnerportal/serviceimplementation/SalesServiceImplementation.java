package com.bookpartnerportal.bookpartnerportal.serviceimplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookpartnerportal.bookpartnerportal.bean.Sales;
import com.bookpartnerportal.bookpartnerportal.repository.SalesRepository;
import com.bookpartnerportal.bookpartnerportal.service.SalesService;
@Service
public class SalesServiceImplementation implements SalesService {
	private SalesRepository salesRepository;
	

	public SalesServiceImplementation(SalesRepository salesRepository) {
		this.salesRepository = salesRepository;
	}

    @Override
	public List<Sales> getAllSales() {
		List<Sales> salesList=salesRepository.findAll();
		return salesList;
	}
    
    @Override
	public Sales getSalesById(String ordNum) {
		Sales sales=salesRepository.findByOrdNum(ordNum);
		return sales;
	}
}
