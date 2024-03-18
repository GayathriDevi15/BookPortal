package com.bookpartnerportal.bookpartnerportal.publishertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PublisherTest {

    
 
//    @Test
//    public void testgetAllPublishersbycity() throws JSONException, org.json.JSONException {
	private	String allpublisherscity = "/api/publishers/city/Berkeley"; 
		String expectedcity = 
				"""
				[
    {
        "pubId": "1389",
        "pubName": "Algodata Infosystems",
        "city": "Berkeley",
        "state": "CA",
        "country": "USA"
    }
]
				""";
		
	private String allpublishersCountry = "/api/publishers/country/usa"; 
	String expectedcountry = 
				"""
    [
    {
        "pubId": "1389",
        "pubName": "Algodata Infosystems",
        "city": "Berkeley",
        "state": "CA",
        "country": "USA"
    },
    {
        "pubId": "1622",
        "pubName": "Five Lakes Publishing",
        "city": "Chicago",
        "state": "IL",
        "country": "USA"
    },
    {
        "pubId": "1756",
        "pubName": "Ramona Publishers",
        "city": "Dallas",
        "state": "TX",
        "country": "USA"
    },
    {
        "pubId": "9952",
        "pubName": "Scootney Books",
        "city": "New York",
        "state": "NY",
        "country": "USA"
    }
]

						""";
	private String allpublishersname = "/api/publishers/pubname/GGG&G"; 
	String expectedbyname = 
				"""
				[
    {
        "pubId": "9901",
        "pubName": "GGG&G",
        "city": "M nchen",
        "state": null,
        "country": "Germany"
    }
]
						""";
	private String allpublishersstate = "/api/publishers/state/ny"; 
	String expectedbystate = 
				"""
				[
    {
        "pubId": "9952",
        "pubName": "Scootney Books",
        "city": "New York",
        "state": "NY",
        "country": "USA"
    }
]
						""";

	
				@Autowired
			    private TestRestTemplate template;
		@Test
		public void testgetAllPublishersbycity() throws JSONException, org.json.JSONException {
			ResponseEntity<String> response = template.getForEntity(allpublisherscity, String.class);
	        System.out.println(response.getBody());
			System.out.println(response.getStatusCode());
			System.out.println(response.getHeaders());
			assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
			assertTrue(response.getStatusCode().is2xxSuccessful());
			JSONAssert.assertEquals(expectedcity, response.getBody(), true);

 
    }
		
		@Test
		public void testgetAllPublishersbycountry() throws JSONException, org.json.JSONException {
			ResponseEntity<String> response = template.getForEntity(allpublishersCountry, String.class);
	        System.out.println(response.getBody());
			System.out.println(response.getStatusCode());
			System.out.println(response.getHeaders());
			assertEquals("application/json",
					response.getHeaders().get("Content-Type").get(0));
			assertTrue(response.getStatusCode().is2xxSuccessful());
			JSONAssert.assertEquals(expectedcountry, response.getBody(), true);

 
    }
		@Test
		public void testgetAllPublishersbystate() throws JSONException, org.json.JSONException {
			ResponseEntity<String> response = template.getForEntity(allpublishersstate, String.class);
	        System.out.println(response.getBody());
			System.out.println(response.getStatusCode());
			System.out.println(response.getHeaders());
			assertEquals("application/json",
					response.getHeaders().get("Content-Type").get(0));
			assertTrue(response.getStatusCode().is2xxSuccessful());
			JSONAssert.assertEquals(expectedbystate, response.getBody(), true);

 
    }
		@Test
		public void testgetAllPublishersbyname() throws JSONException, org.json.JSONException {
			ResponseEntity<String> response = template.getForEntity(allpublishersname, String.class);
	        System.out.println(response.getBody());
			System.out.println(response.getStatusCode());
			System.out.println(response.getHeaders());
			assertEquals("application/json",
					response.getHeaders().get("Content-Type").get(0));
			assertTrue(response.getStatusCode().is2xxSuccessful());
			JSONAssert.assertEquals(expectedbyname, response.getBody(), true);

 
    }
		private static String deleteById="/api/publishers/9912";

		   @Test

		   public void deleteByTitleId() throws JSONException{

			   ResponseEntity<String> resp=template.exchange(deleteById,HttpMethod.DELETE, null,String.class);

			   assertTrue(resp.getStatusCode().is4xxClientError());

		   }
		   private static String PubById="/api/publishers/99999";
		   @Test
			public void testgetAllPublishersbyId() throws JSONException, org.json.JSONException {
				assertFalse(PublisherValidation.extractString(PubById));
				

	 
	    }

}
	
		
    
