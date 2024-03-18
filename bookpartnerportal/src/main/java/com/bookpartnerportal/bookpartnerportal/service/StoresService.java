package com.bookpartnerportal.bookpartnerportal.service;

import java.util.List;

import com.bookpartnerportal.bookpartnerportal.bean.Stores;





public interface StoresService {
	 List<Stores> getAllStores();
	 List<Stores> getStoresByZipCode(String zip);
	 List<Stores> getStoresByCity(String city);
	 Stores getStoresByStorId(String storId);
	 void deleteStoreById(String storId);
	 Stores updateStore(String storId, Stores stores);
	 Stores createStore(Stores store);

}
