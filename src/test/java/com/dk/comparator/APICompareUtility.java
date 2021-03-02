package com.dk.comparator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

		System.out.println(list1);
		
		// Storing file 2 data line by line in list2 using bufferreader
		BufferedReader bufReader2 = new BufferedReader(new FileReader(path2));
		ArrayList<String> list2 = new ArrayList<String>();
		String line2 = bufReader2.readLine(); 
		
		while (line2 != null) { 
			
			list2.add(line2); 
			
			line2 = bufReader2.readLine();
			} 
		
		bufReader2.close();

		System.out.println(list2);
		
	}

}
