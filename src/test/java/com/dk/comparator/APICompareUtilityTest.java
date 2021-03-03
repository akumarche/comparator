package com.dk.comparator;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APICompareUtilityTest {

	/*
	 * API compare Utility test
	 * dataProvider class takes APIs from 2 files line by line and store into two lists.
	 * and then store them as a 2d array
	 * 
	 * compareTest takes API from 2d array return by dataprovider class and hit seprate get request
	 * JSON response is saved as JsonPath and then all attributes are store in an object .
	 * Then objects of both requests are compared
	 * 
	 */
		@Test(dataProvider="createData",dataProviderClass=TestData.class)	
		public void compareTest(String f1,String f2) {
				
			Response res1 = given().get(f1);

			JsonPath js1 = res1.jsonPath();

			Object o1 = js1.get("$");
			
			Response res2 = given().get(f2);

			JsonPath js2 = res2.jsonPath();

			Object o2 = js2.get("$");
			
			if(o1.equals(o2)) {
				System.out.println(f1+" equals "+f2);
			}
			else {
				System.out.println(f1+" not equals "+f2);
			}

		}
		
	}