/**
 * 
 */
package com.tech.microservices.customer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.microservices.customer.intercomm.AccountClient;
import com.tech.microservices.customer.model.Account;
import com.tech.microservices.customer.model.Customer;
import com.tech.microservices.customer.model.CustomerType;

/**
 * @author manickamb
 *
 */
@RestController
public class CustomerController {
	
	@Autowired
	private AccountClient accountClient;
	
	protected Logger logger = Logger.getLogger(CustomerController.class.getName());
	
	private List<Customer> customers;
	
	public CustomerController() {
		customers = new ArrayList<>();
		customers.add(new Customer(1, "1331", "Bharathidasan Manickam", CustomerType.COMPANY));
		customers.add(new Customer(2, "133432", "Anna Manickam", CustomerType.INDIVIDUAL));
		customers.add(new Customer(3, "033456", "Deepa A", CustomerType.INDIVIDUAL));
		customers.add(new Customer(4, "001223", "Uma Bharathi", CustomerType.INDIVIDUAL));
	}
	
	@RequestMapping("/customers/pesel/{pesel}")
	public Customer findByPesel(@PathVariable("pesel") String pesel) {
		logger.info(String.format("Customer.findByPesel(%s)", pesel));
		return customers.stream().filter(it -> it.getPesel().equals(pesel)).findFirst().get();	
	}
	
	
	@RequestMapping("/customers")
	public List<Customer> findAll() {
		logger.info("Customer.findAll()");
		return customers;
	}
	
	@RequestMapping("/customers/{id}")
	public Customer findById(@PathVariable("id") Integer id) {
		logger.info(String.format("Customer.findById(%s)", id));
		Customer customer = customers.stream().filter(it -> it.getId().intValue()==id.intValue()).findFirst().get();
		List<Account> accounts =  accountClient.getAccounts(id);
		customer.setAccounts(accounts);
		return customer;
	}

}
