package com.personapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.personapi.common.constant.PersonConstant;
import com.personapi.common.exception.NotFoundException;
import com.personapi.entity.Hobby;
import com.personapi.entity.Person;
import com.personapi.service.PersonService;

/**
 * The Class PersonController.
 *
 * @author Bharathidasan
 */
@RestController
public class PersonController {
	
	/** The person service. */
	@Autowired
	PersonService personService;
	
	/**
	 * Gets the all person details.
	 *
	 * @return the all person details
	 */
	@GetMapping(value=PersonConstant.LIST_ACCTION_REQ)
	public Map<String,List<Person>> getAllPersonDetails(){
		
		List<Person> l_listofPerson=personService.findAll();
		Map<String,List<Person>> l_map=new HashMap<String,List<Person>>();
		l_map.put(PersonConstant.PERSON, l_listofPerson);
		return l_map;
	}
	
	/**
	 * Gets the person details by id.
	 *
	 * @param personid the personid
	 * @return the person details by id
	 */
	@GetMapping(value=PersonConstant.GET_USER_BY_ID_ACTION_REQ)
	public Person getPersonDetailsById(@PathVariable int personId) {
		
		 Person personDetails=personService.findById(personId);
		 if(personDetails == null) {			 
			 throw new NotFoundException("Person Not Found - " +personId);			 
			 }
		 return personDetails;
	}
	
	/**
	 * Adds the person details.
	 *
	 * @param person the person
	 * @return the person
	 */
	@PostMapping(value=PersonConstant.ADD_ACTION_REQ)
	public Person addPersonDetails(@RequestBody Person person) {	
		
		//this is force a save of new item, instead of update
		person.setId(0);
		 personService.save(person);
		 
		return person;
				
	}
	
	/**
	 * Update person details.
	 *
	 * @param person the person
	 * @return the person
	 */
	@PutMapping(value=PersonConstant.UPDATE_ACTION_REQ)
	public Person updatePersonDetails(@RequestBody Person person) {	
		
		if(person.getHobby().size()>1) {
			for (Hobby hobbyName : person.getHobby()) {				
				person.addHobby(hobbyName);
			}
			
		}		
		 personService.save(person);
		 
		 return person;
		 
	}
	
	/**
	 * Delete person by id.
	 *
	 * @param personid the personid
	 * @return the map
	 */
	@DeleteMapping(value=PersonConstant.DELETE_ACTION_REQ)
	public Map<String,String> deletePersonById(@PathVariable int personId) {
		
		Person person=personService.findById(personId);
		 if(person == null) {			 
			 throw new NotFoundException("Person Not Found - " +personId);			 
			 }
		Map<String,String> l_map=new HashMap<String,String>();	
		personService.deleteById(personId);
		l_map.put(PersonConstant.MESSAGE, PersonConstant.DELETE_SUCCESS_MSG);
		return l_map;
				
	}
	

}
