package com.bookpartnerportal.bookpartnerportal.jobstest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class JobsTest {
	
	@Autowired
    private TestRestTemplate template;
	
	 private static String getById="/api/jobs/5";
	    @Test
	    public void getBySalesId() throws JSONException{
	    	ResponseEntity<String> resp=template.getForEntity(getById,String.class);
	    	assertEquals(HttpStatus.FOUND,resp.getStatusCode());
	    	assertTrue(resp.getBody().contains("\"jobDesc\":\"Publisher\""));
	    }

}
