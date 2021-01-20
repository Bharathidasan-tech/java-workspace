package com.personapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.personapi.dao.PersonDao;
import com.personapi.entity.Person;
import com.personapi.service.PersonService;

/**
 * The Class PersonServiceImpl.
 *
 * @author Bharathidasan
 */
@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonDao personDao;

	@Override
	@Transactional
	public List<Person> findAll() {
		return personDao.findAll();
	}

	@Override
	@Transactional
	public Person findById(int id) {
		return personDao.findById(id);
	}

	@Override
	@Transactional
	public void save(Person person) {
		personDao.save(person);		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		personDao.deleteById(id);		
	}
	
	

}
