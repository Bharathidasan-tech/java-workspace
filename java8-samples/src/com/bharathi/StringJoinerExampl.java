/**
 * 
 */
package com.bharathi;

import java.util.StringJoiner;

/**
 * @author Bharathidasan
 *
 */
public class StringJoinerExampl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Passing Hyphen(-) as delimiter
        StringJoiner l_stringVal = new StringJoiner(" - ");    
          
        // Joining multiple strings by using add() method  
        l_stringVal.add("Rock");  
        l_stringVal.add("Bharathi");  
        l_stringVal.add("Dasan");  
        l_stringVal.add("Bharathidasan");  
                  
        // output String
        System.out.println(l_stringVal);  
        
        StringJoiner prefix_suffix   = new StringJoiner(",", "{", "}"); 
        
        prefix_suffix.add("Rock");  
        prefix_suffix.add("Bharathi");  
        prefix_suffix.add("Dasan");  
        prefix_suffix.add("Bharathidasan"); 
        
        // output String
        System.out.println(prefix_suffix);  
        
        StringJoiner mergedStringval = l_stringVal.merge(prefix_suffix);   
        
    	System.out.println(mergedStringval);  
        
	}

}
