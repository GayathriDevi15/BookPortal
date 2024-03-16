package com.bookpartnerportal.bookpartnerportal.publishertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PublisherTest {

    
 
//    @Test
//    public void testgetAllPublishersbycity() throws JSONException, org.json.JSONException {
	private	String allpublisherscity = "/api/publishers/city/Andra"; 
		String expectedcity = 
				"""
				[
    {
        "pubId": "0736",
        "pubName": "New Moon Books",
        "city": "Andra",
        "state": "MA",
        "country": "USA"
    }
]
				""";
		
	private String allpublishersCountry = "/api/publishers/country/france"; 
	String expectedcountry = 
				"""
    [
    {
        "pubId": "9929",
        "pubName": "hari",
        "city": "Paris",
        "state": "KA",
        "country": "France"
    },
    {
        "pubId": "9936",
        "pubName": "sravs",
        "city": "asdfgh",
        "state": "AK",
        "country": "France"
    }
]

						""";
	private String allpublishersname = "/api/publishers/pubname/sravani k"; 
	String expectedbyname = 
				"""
				[
    {
        "pubId": "9919",
        "pubName": "sravani k",
        "city": "kanigiri",
        "state": "AP",
        "country": "India"
    }
]
						""";
	private String allpublishersstate = "/api/publishers/state/ma"; 
	String expectedbystate = 
				"""
				[
    {
        "pubId": "0736",
        "pubName": "New Moon Books",
        "city": "Andra",
        "state": "MA",
        "country": "USA"
    }
]
						""";
	private String allemployeeswithIDFname = "/api/employee/pubid/0736/fname/Laurence"; 
	String expectedbyPubIDname = 
				"""
				
    {
        "empId": "LAL21447M",
        "fname": "Laurence",
        "minit": "A",
        "lname": "Lebihan",
        "job": {
            "jobId": 5,
            "jobDesc": "Publisher",
            "minLvl": 150,
            "maxLvl": 250
        },
        "jobLvl": 175,
        "publisher": {
            "pubId": "0736",
            "pubName": "New Moon Books",
            "city": "Andra",
            "state": "MA",
            "country": "USA"
        },
        "hireDate": "1990-06-03T00:00:00"
    }

						""";

	private String alljobs = "/api/jobs/5"; 
	String expectedjob = 
				"""
				[{
    "jobId": 5,
    "jobDesc": "Publisher",
    "minLvl": 150,
    "maxLvl": 250
}]
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
			JSONAssert.assertEquals(expectedcity, response.getBody(), false);

 
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
			JSONAssert.assertEquals(expectedcountry, response.getBody(), false);

 
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
			JSONAssert.assertEquals(expectedbystate, response.getBody(), false);

 
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
			JSONAssert.assertEquals(expectedbyname, response.getBody(), false);

 
    }

		
		
    }
