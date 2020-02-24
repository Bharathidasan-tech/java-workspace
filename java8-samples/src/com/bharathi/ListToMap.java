/**
 * 
 */
package com.bharathi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Bharathidasan
 *
 */
public class ListToMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 List<UserVO> userList = new ArrayList<UserVO>();
		 
		 userList.add(new UserVO(1, "Bharathidasan", "Java Developer", "Chennai"));
		 userList.add(new UserVO(2, "John", "Sr.Java Developer", "Chennai"));
		 userList.add(new UserVO(3, "Reddy", "Java Developer", "Hyderabad"));
		 userList.add(new UserVO(4, "Raj", "Tester", "Bangalore"));
		 userList.add(new UserVO(5, "Bharathidasan", "Quality Engineer", "Chennai"));
		 
		 userList.add(new UserVO(5, "Alimran", "Quality Engineer", "Chennai"));
		 
		 Map<Integer,String> userMap=userList.stream().collect(
				 Collectors.toMap(UserVO::getUserid, UserVO::getUsername,
						 (oldValue,newValue)->newValue)); 
		 //To solve the duplicated key issue, use the third mergeFunction argument, if the key is duplicated, do we replace with old key  or new key?
		 //if we not used the third mergeFunction argument, we will get the "java.lang.IllegalStateException: Duplicate key xxxxx" Exception.
		 
		 System.out.println(userMap);
		 

	}

}
