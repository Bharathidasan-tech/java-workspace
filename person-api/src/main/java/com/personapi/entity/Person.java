package com.personapi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



/**
 * The Class Person.
 *
 * @author Bharathidasan
 */
@Entity
@Table(name="person")
public class Person implements Serializable {



	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="person_id")
	private int id;
	
	/** The first name. */
	@Column(name="first_name")
	private String firstName;
	
	/** The last name. */
	@Column(name="last_name")
	private String lastName;
	
	/** The age. */
	private int age;
	
	/** The favourite color. */
	@Column(name="favourite_color")
	private String favouriteColor;
	
	/** The hobby. */
	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name="person_x_hobby", 
		joinColumns=@JoinColumn(name="person_id"),
		inverseJoinColumns=@JoinColumn(name="hobby_id"))
    private List<Hobby> hobby;
	
	 /**
 	 * Instantiates a new person.
 	 */
 	public Person() {

	    }
	 
		/**
		 * Instantiates a new person.
		 *
		 * @param id the id
		 * @param firstName the first name
		 * @param lastName the last name
		 * @param age the age
		 * @param favouriteColor the favourite color
		 * @param hobby the hobby
		 */
		public Person(String firstName, String lastName, int age, String favouriteColor) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.favouriteColor = favouriteColor;
		}
		
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the favouriteColor
	 */
	public String getFavouriteColor() {
		return favouriteColor;
	}

	/**
	 * @param favouriteColor the favouriteColor to set
	 */
	public void setFavouriteColor(String favouriteColor) {
		this.favouriteColor = favouriteColor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", favouriteColor=" + favouriteColor + "]";
	}

	/**
	 * @return the hobby
	 */
	public List<Hobby> getHobby() {
		return hobby;
	}

	/**
	 * @param hobby the hobby to set
	 */
	public void setHobby(List<Hobby> hobby) {
		this.hobby = hobby;
	}
	
	//for bi-directional relationship
	public void addHobby(Hobby p_hobby) {
		
		if(hobby ==null) {
			hobby = new ArrayList<Hobby>();
		}
		
		hobby.add(p_hobby);
		
	}

}
