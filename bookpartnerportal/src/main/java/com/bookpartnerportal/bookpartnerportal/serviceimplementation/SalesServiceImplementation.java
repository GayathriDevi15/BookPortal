package com.bookpartnerportal.bookpartnerportal.serviceimplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookpartnerportal.bookpartnerportal.authorexception.SalesNotFoundByStoreIdException;
import com.bookpartnerportal.bookpartnerportal.bean.Sales;
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
  //get sales by order date
    @Override
    public List<Sales> getSalesByOrderDate(LocalDateTime orderDate) {
        return salesRepository.findByOrdDate(orderDate);
    }
    
    //get sales by title
	@Override
	public List<Sales> getSalesByTitle(String titleId) {
		
		return salesRepository.findByTitleId(titleId);
	}
	
	//Post new sales
	@Override
	public Sales addSales(Sales sales) {
		String id=sales.getOrdNum();
		if(salesRepository.findByOrdNum(id)==null && sales.getStore().getStorId()!=null && id!=null && sales.getOrdDate()!=null && sales.getQty()!=0 && sales.getPayTerms()!=null && sales.getTitle().getTitleId()!=null)
		{
			Sales sale=salesRepository.save(sales);
			return sale;
		}
		else
		{
			return null;
		}
		
	}

}

