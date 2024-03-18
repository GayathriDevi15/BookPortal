package com.bookpartnerportal.bookpartnerportal.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bookpartnerportal.bookpartnerportal.bean.Sales;
import com.bookpartnerportal.bookpartnerportal.bean.Stores;
import com.bookpartnerportal.bookpartnerportal.repository.SalesRepository;
import com.bookpartnerportal.bookpartnerportal.repository.StoresRepository;
import com.bookpartnerportal.bookpartnerportal.service.StoresService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;




//
//@Service
//public class StoresServiceImplementation implements StoresService{
//  private static StoresRepository storesRepository;
// // private static AuthorRepository authorRepository;
//
//public StoresServiceImplementation(StoresRepository storesRepository) {
//	super();
//	this.storesRepository = storesRepository;
//}
//@Override
//public List<Stores> getAllStores() {
//	// TODO Auto-generated method stub
//	List<Stores> storesList=storesRepository.findAll();
//	return storesList;
//}
  

@Service
public class StoresServiceImplementation implements StoresService{
	private  StoresRepository storesRepository;
	private SalesRepository salesRepository;

	//get all store
	 @PersistenceContext
	    private EntityManager entityManager;
	@Override
	public List<Stores> getAllStores() {
		// TODO Auto-generated method stub
		return storesRepository.findAll();
	}
 
 
	
	public StoresServiceImplementation(StoresRepository storesRepository, SalesRepository salesRepository) {
		super();
		this.storesRepository = storesRepository;
		this.salesRepository = salesRepository;
	}



	//get by zip
	@Override
    public List<Stores> getStoresByZipCode(String zip) {
        return storesRepository.findByZip(zip);
    }
	//get by city
	@Override
    public List<Stores> getStoresByCity(String city) {
        return storesRepository.findByCity(city);
    }
	//get by store id
	 @Override
	    public Stores getStoresByStorId(String storId) {
	        return storesRepository.findByStorId(storId);
	    }
	 
 //delete by store id
	 @Override
	    public void deleteStoreById(String storId) {
		 
		 List<Sales> salesToDelete = salesRepository.findByStoreId(storId);
		    salesRepository.deleteAll(salesToDelete);
		 storesRepository.deleteById(storId);
		   
	    }
	 
	 //update store by id
	 @Override
	    public Stores updateStore(String storId, Stores stores) {
	       if(storesRepository.existsById(storId)) {
	    	   stores.setStorId(storId);
	    	   return storesRepository.save(stores);
	       }
	       return null;
	    }
	 //post store
	 @Override
	    public Stores createStore(Stores stores) {
		 
		 String storesId=stores.getStorId();
	    	if(storesRepository.findByStorId(storesId)!=null || stores.getStorId()==null ) {
	    		 return null;
	   	    }
	    	
	    	Stores savedStores=storesRepository.save(stores);
	   	    return savedStores;
	   	   
	    	
	       // return storesRepository.save(stores);
	    }
}



