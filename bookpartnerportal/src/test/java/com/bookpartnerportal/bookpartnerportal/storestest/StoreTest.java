package com.bookpartnerportal.bookpartnerportal.storestest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bookpartnerportal.bookpartnerportal.bean.Stores;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StoreTest {
	 @Autowired

	    private TestRestTemplate template;
	 
	 @Test

	    public void testStoreByCity() throws JSONException, org.json.JSONException {
	    	 String storeByCity = "/api/stores/city/Seattle";
	    	 String expectedOutput = """
	    	 [
  {
     "storId": "6380",
     "storName": "Eric the Read Books",
     "storAddress": "788 Catamaugus Ave.",
     "city": "Seattle",
     "state": "WA",
     "zip": "98056"
 }
]
//	    	 		""";

	 	    	
	    	 
	    	    
	    	 ResponseEntity<String> response = template.getForEntity(storeByCity, String.class);
	 		System.out.println(response.getBody());
	 		System.out.println(response.getStatusCode());
	 		System.out.println(response.getHeaders());
	 		assertEquals("application/json", response.getHeaders().get("Content-Type").get(0));
	 		assertTrue(response.getStatusCode().is2xxSuccessful());
	 		JSONAssert.assertEquals(expectedOutput, response.getBody(), false);
	  
	 		assertEquals("application/json", response.getHeaders().getContentType().toString());
	 		JSONAssert.assertEquals(expectedOutput, response.getBody(), false);
	    }

	//Testing the endpoint for getting the title with given title id
	  private static String getByStoreId="/api/stores/storId/7131";
	String outputstr2=
			 """
			{
		"storId": "7131",
        "storName": "Doc-U-Mat: Quality Laundry and Books",
        "storAddress": "24-A Avogadro Way",
        "city": "Remulade",
        "state": "WA",
        "zip": "98014"
	}
	""";
	@Test
	public void retrieveStoreByStoreId() throws JSONException{
		 ResponseEntity<String> resp=template.getForEntity(getByStoreId,String.class);
		 System.out.println(resp.getBody());
		 System.out.println(resp.getStatusCode());
		 System.out.println(resp.getHeaders());
	 assertTrue(resp.getBody().contains("Quality"));
		 JSONAssert.assertEquals(outputstr2,resp.getBody(),true);
	}
	
	//Testing the endpoint of 
	 private static String deleteBystorId="/api/stores/storId/1111";
	   String outputstr4="""
	   		 [{
        "storId": "7896",
        "storName": "Fricative Bookshop",
        "storAddress": "89 Madison St.",
        "city": "Fremont",
        "state": "CA",
        "zip": "90019"
    }]
	   		""";
	  
	   @Test
	   public void deleteBystorId() throws JSONException{
		   ResponseEntity<String> resp=template.exchange(deleteBystorId,HttpMethod.DELETE, null,String.class);
		   assertTrue(resp.getStatusCode().is4xxClientError());
	   }
	 
	 //Testing the endpoint of getByPubdate
	   private static String getByZip="/api/stores/zip/98014";
	   String outputstr5="""
	   	[
    {
        "storId": "7131",
        "storName": "Doc-U-Mat: Quality Laundry and Books",
        "storAddress": "24-A Avogadro Way",
        "city": "Remulade",
        "state": "WA",
        "zip": "98014"
    }
]
	   		""";
	   @Test
	   public void retrievalByZip() throws JSONException{
		   ResponseEntity<String> resp=template.getForEntity(getByZip,String.class);
		   JSONAssert.assertEquals(outputstr5,resp.getBody(),false);
	   }
	   
//	   private static String getByJobId="/api/jobs/jobId/1";
//	   String outputstr6="""
//			  [ {
//        "jobId": 1,
//        "jobDesc": "New Hire - Job not specified",
//        "minLvl": 10,
//        "maxLvl": 10
//    }]
//			   		""";
//	    @Test
//	    public void getBySalesId() throws JSONException{
//	    	ResponseEntity<String> resp=template.getForEntity(getByJobId,String.class);
//	    	assertEquals(HttpStatus.OK,resp.getStatusCode());
//	    	assertTrue(resp.getBody().contains("\"jobDesc\":\"New Hire - Job not specified\""));
//	    	//jobDesc": "New Hire - Job not specified
//	    }


}
