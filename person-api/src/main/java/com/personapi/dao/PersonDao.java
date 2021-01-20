package com.personapi.dao;

import java.util.List;

import com.personapi.entity.Person;

/**
 * @author Bharathidasan
 *
 */
public interface PersonDao {
	
	public List<Person> findAll();
	
	public Person findById(int id);
	
	public void save(Person person);
	
	public void deleteById(int id);

}
