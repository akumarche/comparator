package com.dk.comparator;

import static io.restassured.RestAssured.given;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APICompareUtility {

	public static void main(String[] args) throws IOException {

		String path1 = System.getProperty("user.dir")+"/file/file1.txt";
		String path2 = System.getProperty("user.dir")+"/file/file2.txt";

		// Storing file 1 data line by line in list1 using bufferreader
		BufferedReader bufReader1 = new BufferedReader(new FileReader(path1));
		ArrayList<String> list1 = new ArrayList<String>();
		String line1 = bufReader1.readLine(); 

		while (line1 != null) { 

			list1.add(line1); 

			line1 = bufReader1.readLine();
		} 

		bufReader1.close();

		// Storing file 2 data line by line in list2 using bufferreader
		BufferedReader bufReader2 = new BufferedReader(new FileReader(path2));
		ArrayList<String> list2 = new ArrayList<String>();
		String line2 = bufReader2.readLine(); 

		while (line2 != null) { 

			list2.add(line2); 

			line2 = bufReader2.readLine();
		} 

		bufReader2.close();

		// Get request for each api using for loop
		for (int i =0 ; i<list1.size();i++) {

			Response res1 = given().get(list1.get(i));

			JsonPath js1 = res1.jsonPath();

			Object o1 = js1.get("$");

			Response res2 = given().get(list2.get(i));

			JsonPath js2 = res2.jsonPath();

			Object o2 = js2.get("$");

			// Comparing json response of each request
			if (o1.equals(o2)) {
				System.out.println(list1.get(i)+" --equals-- "+list2.get(i));
			}
			else {
				System.out.println(list1.get(i)+" --not equals-- "+list2.get(i));
			}			
		}

	}

}
