package com.personapi.service;

import java.util.List;

import com.personapi.entity.Person;

/**
 * @author Bharathidasan
 *
 */
public interface PersonService {
	
	public List<Person> findAll();
	
	public Person findById(int id);
	
	public void save(Person employee);
	
	public void deleteById(int id);

}
