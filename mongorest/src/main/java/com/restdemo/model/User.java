package com.restdemo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="USER")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id	
	public String id;
	@Field
	public String clientId;
	@Field
	public String firstname;
	@Field
	 public String lastname;
	@Field
	 public int age;
	@Field
	 public String city;
	@Field
	 public String state;
	@Field
	 public long zipcode;
//	 private ArrayList<User> user = null;
	 
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String id, String firstname, String lastname, int age, String city, String state, long zipcode){
		this.id=id;
		this.firstname=firstname;
		this.lastname=lastname;
		this.age=age;
		this.city=city;
		this.state=state;
		this.zipcode=zipcode;
	}
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}public String getState() {
		return state;
	}public long getZipcode() {
		return zipcode;
	}
	public int getAge() {
		return age;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
    public String toString() {
          return id+"="+firstname + "=" + lastname + " =" + age+"="+city+"="+"="+state+"="+zipcode;
    }
	
}
