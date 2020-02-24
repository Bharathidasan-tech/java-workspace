/**
 * 
 */
package com.bharathi;

/**
 * @author Bharathidasan
 *
 */
public class FunctionalInterfaceExampl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AppFuncationlInterface sumVal=(a,b)->a+b;
		
		System.out.println("Result is : " +sumVal.sumResult(20, 20));

	}

}

@FunctionalInterface
interface AppFuncationlInterface{
	
	public int sumResult(int a, int b);
}
