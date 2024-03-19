package com.bookpartnerportal.bookpartnerportal.salestest;

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

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class SalesTest {
	//Testcase for checking get by sales Id
	@Autowired
	private TestRestTemplate template;
    private static String getById="/api/sales/6871";
    @Test
    public void getBySalesId() throws JSONException{
    	ResponseEntity<String> resp=template.getForEntity(getById,String.class);
    	assertEquals(HttpStatus.OK,resp.getStatusCode());
    	assertTrue(resp.getBody().contains("\"city\":\"Seattle\""));
    }
    private static String getbytitleid="/api/sales/titles/PC8888";
	String output1=
			"""
					[
    {
        "store": {
            "storId": "7066",
            "storName": "Barnum's",
            "storAddress": "567 Pasadena Ave.",
            "city": "Tustin",
            "state": "CA",
            "zip": "92789"
        },
        "title": {
            "titleId": "PC8888",
            "title": "Secrets of Silicon Valley",
            "type": "popular_comp",
            "price": 20.0,
            "advance": 8000.0,
            "royalty": 10,
            "ytdSales": 4095,
            "notes": "Muckraking reporting on the worlds largest computer hardware and software manufacturers.",
            "pubDate": "1994-06-12T00:00:00",
            "pub": {
                "pubId": "1389",
                "pubName": "Algodata Infosystems",
                "city": "Berkeley",
                "state": "CA",
                "country": "USA"
            }
        },
        "ordNum": "A2976",
        "ordDate": "1993-05-24T00:00:00",
        "qty": 50,
        "payTerms": "Net 30"
    }
]
					""";
	@Test
	public void getSalesByTitleId() throws JSONException 
	{
		ResponseEntity<String> resp=template.getForEntity(getbytitleid,String.class);
		System.out.println(resp.getBody());
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getHeaders());
		assertEquals("application/json",resp.getHeaders().get("Content-Type").get(0));
		assertTrue(resp.getStatusCode().is2xxSuccessful());
		JSONAssert.assertEquals(output1,resp.getBody(),true);
	}
}