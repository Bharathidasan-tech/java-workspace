// Java program to demonstrate simple lambda expressions
package com.bharathi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

class SampleLambda {

	public static void main(String args[]) {

	
		ArrayList<Integer> l_arrList = new ArrayList<Integer>();

		l_arrList.add(1);
		l_arrList.add(2);
		l_arrList.add(3);
		l_arrList.add(4);
		l_arrList.add(5);
		l_arrList.add(6);
		l_arrList.add(7);
		l_arrList.add(8);
		l_arrList.add(9);
		l_arrList.add(10);

		// using lambda expression, print all the elements from the list.
		l_arrList.forEach(n -> System.out.println(n));

		System.out.println();

		// print the elements if the values is >2, using lambda expression
		l_arrList.forEach(n -> {
			if (n > 2) {
				System.out.println(n);
			}
		});

		// lambda expression print the message for single parameter
		MessageDisplay msg = (String message) -> {
			System.out.println("Welcome " + message);
		};
		System.out.println();
		msg.message("Bharathidasan ");

	}
}

// MessageDisplay is implemented using lambda expressions
interface MessageDisplay {
	public void message(String p_msg);
}
