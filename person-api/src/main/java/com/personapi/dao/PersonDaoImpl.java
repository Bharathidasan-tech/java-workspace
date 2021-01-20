package com.personapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personapi.entity.Person;

/**
 * @author Bharathidasan
 *
 */
@Repository
public class PersonDaoImpl implements PersonDao {
	

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Person> findAll() {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		Query<Person> query=currentSession.createQuery("from Person", Person.class);
		
		List<Person> Person=query.getResultList();
		
		return Person;
	}

	@Override
	public Person findById(int id) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		Person Person=currentSession.get(Person.class, id);
		
		return Person;
	}

	@Override
	public void save(Person person) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(person);
		
	}

	@Override
	public void deleteById(int id) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		Query query = currentSession.createQuery("delete from Person where id=: personId");
		query.setParameter("personId", id);
		
		query.executeUpdate();

	}
	
	

}
