package com.bookpartnerportal.bookpartnerportal.titlestest;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TitlesTest {
	@Autowired
	private TestRestTemplate template;
	
  //Testing the endpoint of getbyAuthorName
	
   private static String getbyauthor="/api/titles/authorname/Johnson";
  
   String outputstr=
     """
       	[{
       	"titleId": "PS3333",
        "title": "Prolonged Data Deprivation: Four Case Studies",
        "type": "psychology",
        "price": 19.99,
        "advance": 2000.0,
        "royalty": 10,
        "ytdSales": 4072,
        "notes": "What happens when the data runs dry?  Searching evaluations of information-shortage effects.",
        "pubDate": "1991-06-12",
        "pub": {
            "pubId": "0736",
            "pubName": "New Moon Books",
            "city": "Boston",
            "state": "MA",
            "country": "USA"
        }
        }]
    """;
   
@Test
public void retrieveTitleByAuthor() throws JSONException 
{
	ResponseEntity<String> resp=template.getForEntity(getbyauthor,String.class);
	System.out.println(resp.getBody());
	System.out.println(resp.getStatusCode());
	System.out.println(resp.getHeaders());
	assertEquals("application/json",resp.getHeaders().get("Content-Type").get(0));
	assertTrue(resp.getStatusCode().is2xxSuccessful());
	JSONAssert.assertEquals(outputstr,resp.getBody(),true);
}

//Testing the endpoint for getting the title with given title id
 
  private static String getByTitleId="/api/titles/BU7832";
 String outputstr2=
		 """
		 		{
    "titleId": "BU7832",
    "title": "Straight Talk About Computers",
    "type": "business",
    "price": 19.99,
    "advance": 5000.0,
    "royalty": 10,
    "ytdSales": 4095,
    "notes": "Annotated analysis of what computers can do for you: a no-hype guide for the critical user.",
    "pubDate": "1991-06-22",
    "pub": {
        "pubId": "1389",
        "pubName": "Algodata Infosystems",
        "city": "Berkeley",
        "state": "CA",
        "country": "USA"
    }
}
""";
	
 @Test
 public void retrieveTitleByTitleId() throws JSONException{
	 ResponseEntity<String> resp=template.getForEntity(getByTitleId,String.class);
	 System.out.println(resp.getBody());
	 System.out.println(resp.getStatusCode());
	 System.out.println(resp.getHeaders());
	 assertTrue(resp.getBody().contains("business"));
	 JSONAssert.assertEquals(outputstr2,resp.getBody(),true);
	 
 }
 
 //Testing the endpoint of getByPubdate
   private static String getByPubDate="/api/titles/pubdate/1991-06-12";
   String outputstr3="""
   		[
    {"titleId": "BU1032"},
    {"titleId": "PS3333"},
    {"titleId": "PS7777"},
    {"titleId": "TC4203"},
    {"titleId": "TC7777"}
       ]
   		""";
   @Test
   public void retrievalByPubdate() throws JSONException{
	   ResponseEntity<String> resp=template.getForEntity(getByPubDate,String.class);
	   JSONAssert.assertEquals(outputstr3,resp.getBody(),false);
   }

   //Testcase for deleting with wrong titleId
   
   private static String deleteByTitleId="/api/titles/BU2";
   @Test
   public void deleteByTitleId() throws JSONException{
	   ResponseEntity<String> resp=template.exchange(deleteByTitleId,HttpMethod.DELETE, null,String.class);
	   assertTrue(resp.getStatusCode().is4xxClientError());
   }
}