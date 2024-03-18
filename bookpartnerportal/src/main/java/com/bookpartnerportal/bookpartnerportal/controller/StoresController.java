package com.bookpartnerportal.bookpartnerportal.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.bookpartnerportal.bookpartnerportal.bean.Stores;
import com.bookpartnerportal.bookpartnerportal.serviceimplementation.StoresServiceImplementation;
import com.bookpartnerportal.bookpartnerportal.storeexception.CityNotFoundException;
import com.bookpartnerportal.bookpartnerportal.storeexception.StorIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.storeexception.StoreIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.storeexception.StoresNotFoundException;
import com.bookpartnerportal.bookpartnerportal.storeexception.StoresPostValidationException;
import com.bookpartnerportal.bookpartnerportal.storeexception.StoresUpdateValidationException;
import com.bookpartnerportal.bookpartnerportal.storeexception.ZipNotFoundException;
import com.bookpartnerportal.bookpartnerportal.success.SuccessResponse;




@RestController
public class StoresController {
	@Autowired
	private StoresServiceImplementation storesserviceimplementation;
	//1.get all stores list
	@GetMapping("/api/stores")
	public ResponseEntity<List<Stores>> retrieveAll()
	{
		List<Stores> store = storesserviceimplementation.getAllStores();
		if(store.isEmpty())
			{
				throw new StoresNotFoundException("Stores not found");
				
			}
		return new ResponseEntity <> (store,HttpStatus.OK);
		//return storesserviceimplementation.getAllStores();
	}

	//get by zip
	 @GetMapping("/api/stores/zip/{zip}")
	    public ResponseEntity<List<Stores>> getStoresByZipCode(@PathVariable String zip) {
	        List<Stores> stores = storesserviceimplementation.getStoresByZipCode(zip);
	        if (stores.isEmpty()) {
	            throw new ZipNotFoundException("Zip code not found: " + zip);
	        }
	       
	        return new ResponseEntity<>(stores, HttpStatus.OK);
	    }
	 
	 //get by city
	 @GetMapping("/api/stores/city/{city}")
	    public ResponseEntity<List<Stores>> getStoresByCity(@PathVariable String city) {
	        List<Stores> stores = storesserviceimplementation.getStoresByCity(city);
	        if (stores.isEmpty()) {
	        	throw new CityNotFoundException("City  not found: " + city);
	        }
	        return new ResponseEntity<>(stores, HttpStatus.OK);
	    }
	 //get by store id
	 @GetMapping("/api/stores/storId/{storId}")
	    public ResponseEntity<Stores> getStoresByStorId(@PathVariable String storId) {
	        Stores stores = storesserviceimplementation.getStoresByStorId(storId);
	        if (stores==null) {
	        	throw new StoreIdNotFoundException("Store Id  not found: " + storId);
	        }
	        return new ResponseEntity<>(stores, HttpStatus.OK);
	 
	    }
	
	 //delete by store id
	 @DeleteMapping("/api/stores/storId/{storId}")
	    public ResponseEntity<SuccessResponse> deleteStoreById(@PathVariable String storId) {
		Stores store=storesserviceimplementation.getStoresByStorId(storId);
		 if( store==null)
			 throw new StorIdNotFoundException("Store with this store id not found");
		 storesserviceimplementation.deleteStoreById(storId);   
		 LocalDate timeStamp = LocalDate.now();
	        SuccessResponse successResponse = new SuccessResponse(timeStamp, "Store details deleted successfully");
	        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
	       // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	 
	 //update by store id

	 @PutMapping("/api/stores/storId/{storId}")
	    public ResponseEntity<SuccessResponse> updateStore(@PathVariable("storId") String storId, @RequestBody Stores stores)  {
		 Stores updatedStore = storesserviceimplementation.updateStore(storId, stores);
	       
		 if( updatedStore==null)
			 throw new StoresUpdateValidationException("Validation Failed");
		
	        LocalDate timeStamp = LocalDate.now();
	        SuccessResponse successResponse = new SuccessResponse(timeStamp, "Store details updated successfully");
	        return new ResponseEntity<>(successResponse, HttpStatus.OK);
	        // return ResponseEntity.status(HttpStatus.OK).body(successResponse);
	        //return ResponseEntity.ok(updatedStore);
	    }
	 //post store
	 @PostMapping("/api/stores")
	    public ResponseEntity<SuccessResponse> createStore(@RequestBody Stores stores) {
	        Stores createdStore = storesserviceimplementation.createStore(stores);
		   // if(createdStore.getStorId().isEmpty() || createdStore.getZip().isEmpty() || createdStore.getCity().isEmpty() || createdStore.getState().isEmpty() || createdStore.getStorAddress().isEmpty() ) {
		   	if(createdStore == null) {
		   		throw new StoresPostValidationException("Validation Failed");
		   	}
		   
		   		
	        LocalDate timeStamp = LocalDate.now();
		    SuccessResponse successResponse = new SuccessResponse(timeStamp, "Store details added successfully");
		    return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
		   	
	    }
	

}
