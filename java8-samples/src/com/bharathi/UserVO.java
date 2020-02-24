/**
 * 
 */
package com.bharathi;

/**
 * @author manickamb
 *
 */
public class UserVO {
	
	public UserVO(int userid, String username, String role, String location) {
		this.userid = userid;
		this.username = username;
		this.role = role;
		this.location = location;
	}

	private int userid;
	
	private String username;
	
	private String role;
	
	private String location;

	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
