package com.bookpartnerportal.bookpartnerportal.authortest;

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
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AuthorTest {
	@Autowired
	private TestRestTemplate template;

//endpoint test for get author by city......................
	@Test
	public void testGetAuthorByCity() throws JSONException, org.json.JSONException {
		String authorbycity = "/api/authors/city/Oakland";
		String expectedOutput = """
									[
    {
        "auId": "213-46-8915",
        "auLname": "Green",
        "auFname": "Marjorie",
        "phone": "415 986-7020",
        "address": "309 63rd St. #411",
        "city": "Oakland",
        "state": "CA",
        "zip": "94618",
        "contract": 1
    },
    {
        "auId": "274-80-9391",
        "auLname": "Straight",
        "auFname": "Dean",
        "phone": "415 834-2919",
        "address": "5420 College Av.",
        "city": "Oakland",
        "state": "CA",
        "zip": "94609",
        "contract": 1
    },
    {
        "auId": "724-08-9931",
        "auLname": "Stringer",
        "auFname": "Dirk",
        "phone": "415 843-2991",
        "address": "5420 Telegraph Av.",
        "city": "Oakland",
        "state": "CA",
        "zip": "94609",
        "contract": 0
    },
    {
        "auId": "724-80-9391",
        "auLname": "MacFeather",
        "auFname": "Stearns",
        "phone": "415 354-7128",
        "address": "44 Upland Hts.",
        "city": "Oakland",
        "state": "CA",
        "zip": "94612",
        "contract": 1
    },
    {
        "auId": "756-30-7391",
        "auLname": "Karsen",
        "auFname": "Livia",
        "phone": "415 534-9219",
        "address": "5720 McAuley St.",
        "city": "Oakland",
        "state": "CA",
        "zip": "94609",
        "contract": 1
    }
]
												""";

		ResponseEntity<String> response = template.getForEntity(authorbycity, String.class);
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		assertEquals("application/json", response.getHeaders().get("Content-Type").get(0));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		JSONAssert.assertEquals(expectedOutput, response.getBody(), false);

		assertEquals("application/json", response.getHeaders().getContentType().toString());
		JSONAssert.assertEquals(expectedOutput, response.getBody(), false);

	}

	// endpoint test for get author by state..............
	@Test
	public void testGetAuthorByState() throws JSONException, org.json.JSONException {
		String authorbystate = "/api/authors/state/CA";
		String expectedOutput = """
												[
    {
        "auId": "172-32-1176",
        "auLname": "White",
        "auFname": "Johnson",
        "phone": "408 496-7223",
        "address": "10932 Bigge Rd.",
        "city": "Menlo Park",
        "state": "CA",
        "zip": "94025",
        "contract": 1
    },
    {
        "auId": "213-46-8915",
        "auLname": "Green",
        "auFname": "Marjorie",
        "phone": "415 986-7020",
        "address": "309 63rd St. #411",
        "city": "Oakland",
        "state": "CA",
        "zip": "94618",
        "contract": 1
    },
    {
        "auId": "238-95-7766",
        "auLname": "Carson",
        "auFname": "Cheryl",
        "phone": "415 548-7723",
        "address": "589 Darwin Ln.",
        "city": "Berkeley",
        "state": "CA",
        "zip": "94705",
        "contract": 1
    },
    {
        "auId": "267-41-2394",
        "auLname": "O'Leary",
        "auFname": "Michael",
        "phone": "408 286-2428",
        "address": "22 Cleveland Av. #14",
        "city": "San Jose",
        "state": "CA",
        "zip": "95128",
        "contract": 1
    },
    {
        "auId": "274-80-9391",
        "auLname": "Straight",
        "auFname": "Dean",
        "phone": "415 834-2919",
        "address": "5420 College Av.",
        "city": "Oakland",
        "state": "CA",
        "zip": "94609",
        "contract": 1
    },
    {
        "auId": "409-56-7008",
        "auLname": "Bennet",
        "auFname": "Abraham",
        "phone": "415 658-9932",
        "address": "6223 Bateman St.",
        "city": "Berkeley",
        "state": "CA",
        "zip": "94705",
        "contract": 1
    },
    {
        "auId": "427-17-2319",
        "auLname": "Dull",
        "auFname": "Ann",
        "phone": "415 836-7128",
        "address": "3410 Blonde St.",
        "city": "Palo Alto",
        "state": "CA",
        "zip": "94301",
        "contract": 1
    },
    {
        "auId": "472-27-2349",
        "auLname": "Gringlesby",
        "auFname": "Burt",
        "phone": "707 938-6445",
        "address": "PO Box 792",
        "city": "Covelo",
        "state": "CA",
        "zip": "95428",
        "contract": 3
    },
    {
        "auId": "486-29-1786",
        "auLname": "Locksley",
        "auFname": "Charlene",
        "phone": "415 585-4620",
        "address": "18 Broadway Av.",
        "city": "San Francisco",
        "state": "CA",
        "zip": "94130",
        "contract": 1
    },
    {
        "auId": "672-71-3249",
        "auLname": "Yokomoto",
        "auFname": "Akiko",
        "phone": "415 935-4228",
        "address": "3 Silver Ct.",
        "city": "Walnut Creek",
        "state": "CA",
        "zip": "94595",
        "contract": 1
    },
    {
        "auId": "724-08-9931",
        "auLname": "Stringer",
        "auFname": "Dirk",
        "phone": "415 843-2991",
        "address": "5420 Telegraph Av.",
        "city": "Oakland",
        "state": "CA",
        "zip": "94609",
        "contract": 0
    },
    {
        "auId": "724-80-9391",
        "auLname": "MacFeather",
        "auFname": "Stearns",
        "phone": "415 354-7128",
        "address": "44 Upland Hts.",
        "city": "Oakland",
        "state": "CA",
        "zip": "94612",
        "contract": 1
    },
    {
        "auId": "756-30-7391",
        "auLname": "Karsen",
        "auFname": "Livia",
        "phone": "415 534-9219",
        "address": "5720 McAuley St.",
        "city": "Oakland",
        "state": "CA",
        "zip": "94609",
        "contract": 1
    },
    {
        "auId": "846-92-7186",
        "auLname": "Hunter",
        "auFname": "Sheryl",
        "phone": "415 836-7128",
        "address": "3410 Blonde St.",
        "city": "Palo Alto",
        "state": "CA",
        "zip": "94301",
        "contract": 1
    },
    {
        "auId": "893-72-1158",
        "auLname": "McBadden",
        "auFname": "Heather",
        "phone": "707 448-4982",
        "address": "301 Putnam",
        "city": "Vacaville",
        "state": "CA",
        "zip": "95688",
        "contract": 0
    }
]
												""";
		ResponseEntity<String> response = template.getForEntity(authorbystate, String.class);
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		assertEquals("application/json", response.getHeaders().get("Content-Type").get(0));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		JSONAssert.assertEquals(expectedOutput, response.getBody(), false);

		assertEquals("application/json", response.getHeaders().getContentType().toString());
		JSONAssert.assertEquals(expectedOutput, response.getBody(), false);

	}

	// endpoint test for get author by first name.........
	@Test
	public void testGetAuthorByFname() throws JSONException, org.json.JSONException {
		String authorbyfname = "/api/authors/fname/Ann";
		String expectedOutput = """
												[
				    {
				        "auId": "427-17-2319",
				        "auLname": "Dull",
				        "auFname": "Ann",
				        "phone": "415 836-7128",
				        "address": "3410 Blonde St.",
				        "city": "Palo Alto",
				        "state": "CA",
				        "zip": "94301",
				        "contract": 1
				    }
				]


												""";

		ResponseEntity<String> response = template.getForEntity(authorbyfname, String.class);
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		assertEquals("application/json", response.getHeaders().get("Content-Type").get(0));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		JSONAssert.assertEquals(expectedOutput, response.getBody(), false);

		assertEquals("application/json", response.getHeaders().getContentType().toString());
		JSONAssert.assertEquals(expectedOutput, response.getBody(), false);

	}

	// endpoint test for get author details by last name....

	@Test
	public void testGetAuthorByLname() throws JSONException, org.json.JSONException {
		String authorbylname = "/api/authors/lname/Carson";
		String expectedOutput = """
				[
    {
        "auId": "238-95-7766",
        "auLname": "Carson",
        "auFname": "Cheryl",
        "phone": "415 548-7723",
        "address": "589 Darwin Ln.",
        "city": "Berkeley",
        "state": "CA",
        "zip": "94705",
        "contract": 1
    }
]
												""";

		ResponseEntity<String> response = template.getForEntity(authorbylname, String.class);
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		assertEquals("application/json", response.getHeaders().get("Content-Type").get(0));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		JSONAssert.assertEquals(expectedOutput, response.getBody(), false);

		assertEquals("application/json", response.getHeaders().getContentType().toString());
		JSONAssert.assertEquals(expectedOutput, response.getBody(), false);

	}

	// endpoint test for get author by au_id.....

	@Test
	public void testGetAuthorByAu_id() throws JSONException, org.json.JSONException {
		String authorbyau_id = "/api/authors/238-95-7766";
		String expectedOutput = """
									{
    "auId": "238-95-7766",
    "auLname": "Carson",
    "auFname": "Cheryl",
    "phone": "415 548-7723",
    "address": "589 Darwin Ln.",
    "city": "Berkeley",
    "state": "CA",
    "zip": "94705",
    "contract": 1
}
								""";
		ResponseEntity<String> response = template.getForEntity(authorbyau_id, String.class);
		assertTrue(AuthorValidation.au_idlength(authorbyau_id));// for validation method if id is correct
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		assertEquals("application/json", response.getHeaders().get("Content-Type").get(0));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		JSONAssert.assertEquals(expectedOutput, response.getBody(), false);

		assertEquals("application/json", response.getHeaders().getContentType().toString());
		JSONAssert.assertEquals(expectedOutput, response.getBody(), false);
		// assertFalse(AuthorValidation.au_idlength(authorbyau_id));

	}

}
