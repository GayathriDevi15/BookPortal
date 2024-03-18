package com.bookpartnerportal.bookpartnerportal.serviceimplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookpartnerportal.bookpartnerportal.bean.Sales;
import com.bookpartnerportal.bookpartnerportal.exception.SalesNotFoundByStoreIdException;
import com.bookpartnerportal.bookpartnerportal.repository.SalesRepository;
import com.bookpartnerportal.bookpartnerportal.service.SalesService;

@Service
public class SalesServiceImplementation implements SalesService {
	private SalesRepository salesRepository;

	public SalesServiceImplementation(SalesRepository salesRepository) {
		this.salesRepository = salesRepository;
	}

//sales details by storeId
	@Override
	public List<Sales> getSalesByStoreId(String storeId) throws SalesNotFoundByStoreIdException {
		List<Sales> salesList = salesRepository.findByStoreId(storeId);

		if (salesList.isEmpty()) {
			throw new SalesNotFoundByStoreIdException("Sales details for given store not found");
		}

		return salesList;
	}

}