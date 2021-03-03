package com.dk.comparator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name="createData")
	public Object[][] cd() throws IOException {

		String path1 = System.getProperty("user.dir")+"/file/file1.txt";
		String path2 = System.getProperty("user.dir")+"/file/file2.txt";

		BufferedReader bufReader1 = new BufferedReader(new FileReader(path1));
		ArrayList<String> list1 = new ArrayList<String>();
		String line1 = bufReader1.readLine(); 

		while (line1 != null) { 

			list1.add(line1); 

			line1 = bufReader1.readLine();
		} 

		bufReader1.close();

		// Read file2 and store in array list2		
		BufferedReader bufReader2 = new BufferedReader(new FileReader(path2));
		ArrayList<String> list2 = new ArrayList<String>();
		String line2 = bufReader2.readLine(); 

		while (line2 != null) { 

			list2.add(line2); 

			line2 = bufReader2.readLine();
		} 

		bufReader2.close();
		
		//Store 2 list elements into 2d array
		Object obj[][] = new Object[list1.size()][2];

		for (int i = 0; i < list1.size(); i++) {
			obj[i][0] = list1.get(i);
			obj[i][1] = list2.get(i);
		}

		return obj;

	}	
}