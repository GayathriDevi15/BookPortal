package com.bookpartnerportal.bookpartnerportal.employeetest;

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
import org.springframework.http.ResponseEntity;

import com.bookpartnerportal.bookpartnerportal.bean.Employee;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeTest {
	@Autowired
	private TestRestTemplate template;
	// get by empid
	private static String getbyid = "/api/employees/A-C71970F";
	String output1 = """
							{
    "empId": "A-C71970F",
    "fname": "Aria",
    "minit": "",
    "lname": "Cruz",
    "job": {
        "jobId": 10,
        "jobDesc": "Productions Manager",
        "minLvl": 75,
        "maxLvl": 165
    },
    "jobLvl": 87,
    "publisher": {
        "pubId": "1389",
        "pubName": "Algodata Infosystems",
        "city": "Berkeley",
        "state": "CA",
        "country": "USA"
    },
    "hireDate": "1991-10-26T00:00:00"
}
								""";

	@Test
	public void getEmployeeById() throws JSONException {
		assertTrue(EmployeeValidation.checkLength(getbyid));  //validation for empid length 
		ResponseEntity<String> resp=template.getForEntity(getbyid,String.class);
		System.out.println(resp.getBody());
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getHeaders());
		assertEquals("application/json",resp.getHeaders().get("Content-Type").get(0));
		assertTrue(resp.getStatusCode().is2xxSuccessful());
		JSONAssert.assertEquals(output1,resp.getBody(),true);
		 assertFalse(EmployeeValidation.checkLength(getbyid)); //validation for empid length with wrong length
	}

	// get by fname
	private static String getbyfname = "/api/employees/fname/aria";
	String output2 = """
								[
    {
        "empId": "A-C71970F",
        "fname": "Aria",
        "minit": "",
        "lname": "Cruz",
        "job": {
            "jobId": 10,
            "jobDesc": "Productions Manager",
            "minLvl": 75,
            "maxLvl": 165
        },
        "jobLvl": 87,
        "publisher": {
            "pubId": "1389",
            "pubName": "Algodata Infosystems",
            "city": "Berkeley",
            "state": "CA",
            "country": "USA"
        },
        "hireDate": "1991-10-26T00:00:00"
    }
]
								""";

	@Test
	public void getEmployeeByFname() throws JSONException {
		ResponseEntity<String> resp = template.getForEntity(getbyfname, String.class);
		System.out.println(resp.getBody());
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getHeaders());
		assertEquals("application/json", resp.getHeaders().get("Content-Type").get(0));
		assertTrue(resp.getStatusCode().is2xxSuccessful());
		JSONAssert.assertEquals(output2, resp.getBody(), true);
	}

	// get by hiredate
	private static String getbyhiredate = "/api/employees/hiredate/1989-06-11T00:00:00";
	String output3 = """
						[
    {
        "empId": "A-C71970F",
        "fname": "Aria",
        "minit": "",
        "lname": "Cruz",
        "job": {
            "jobId": 10,
            "jobDesc": "Productions Manager",
            "minLvl": 75,
            "maxLvl": 165
        },
        "jobLvl": 87,
        "publisher": {
            "pubId": "1389",
            "pubName": "Algodata Infosystems",
            "city": "Berkeley",
            "state": "CA",
            "country": "USA"
        },
        "hireDate": "1991-10-26T00:00:00"
    }
]
									""";

	@Test
	public void getEmployeeByHiredate() throws JSONException {
		ResponseEntity<String> resp = template.getForEntity(getbyhiredate, String.class);
		JSONAssert.assertEquals(output3, resp.getBody(), true);
	}

	// Testcase for delete by wrong empid
	private static String deleteByEmpId = "/api/employees/MJP25";

	@Test
	public void deleteByTitleId() throws JSONException {
		ResponseEntity<String> resp = template.exchange(deleteByEmpId, HttpMethod.DELETE, null, String.class);
		assertTrue(resp.getStatusCode().is4xxClientError());
	}
}
