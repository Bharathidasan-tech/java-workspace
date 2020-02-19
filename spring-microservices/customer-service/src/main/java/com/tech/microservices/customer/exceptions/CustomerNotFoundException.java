/**
 * 
 */
package com.tech.microservices.customer.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author manickamb
 *
 */
@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public CustomerNotFoundException(String pesel) {
		super("No such customer: " + pesel);
	}

}
