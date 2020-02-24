/**
 * 
 */
package com.bharathi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Bharathidasan
 *
 */
public class StreamExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> listofNames = new ArrayList<String>();
		
		listofNames.add("Bharathidasan");
		listofNames.add("Manickam");
		listofNames.add("Alimran");
		listofNames.add("Bharathi");
		
		//Using the Stream and Lambda expression
		long countVal=listofNames.stream().filter(names->names.length()<9).count();
		
		System.out.println("There are "+countVal+" strings with length less than 7");
		
		//operations are lazy in nature, which means they are not executed until they are needed
		  Stream.iterate(1, count->count+1)  
	        .filter(number->number%3==0)  
	        .limit(6)  
	        .forEach(System.out::println); 

	}

}
