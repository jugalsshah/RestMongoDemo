package com.restdemo.service;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.restdemo.model.User;


@Component
public interface Userservice extends MongoRepository<User, String> {

	public User getId(String id);

public List<User> findUserQuery(String id);
//public String findCollection(String id);
public User save(String id, String firstname, String lastname, int age,
		String city, String state, long zipcode);
}
