package com.restdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.restdemo.model.User;

@Repository
public class UserserviceImpl implements Userservice {

	
	
		
	ApplicationContext ctx =  new AnnotationConfigApplicationContext(SpringConfig.class);
	
	MongoTemplate mongoTemplate1 = (MongoTemplate) ctx.getBean("mongoTemplate");
//	MongoTemplate mong8oTemplate2 = (MongoTemplate) ctx.getBean("mongoTemplate2");
	
 
	
//MongoDbFactory dbFactory= (MongoDbFactory) ctx.getBean("mongoTemplate");
//MongoTemplate mongoTemplate;
//
	String NEW_DATABASE=null;
	ArrayList<String> l= new ArrayList<String>();

	@Override
//	@CacheEvict(value="users", allEntries = true)
	public User save(String id, String firstname, String lastname, int age,
			String city, String state, long zipcode) {
		User u = new User(id, firstname, lastname, age, city, state, zipcode);
		System.out.println(u.getId()+"Ddddddd");
//		if(u.getClientId()== 3){
//			System.out.println(u.getClientId()+"sssssssss");
//		mongoTemplate.save(u, USER_COLLECTION);
//		}else if(u.getClientId()==4){
//			System.out.println(u.getClientId()+"sasasasa");
		
			mongoTemplate1.save(u);
//		}
			
			
		
		return u;
	}

	@Override
	public User getId(String id) {
		List<User> users = mongoTemplate1.find(
                new Query(Criteria.where("_id").is(id)),User.class);
//		System.out.println(users.get(0)+"sssssss");
		return users.get(0);
	}

	@Override
//	@Cacheable(value="users", key="#id")
	public List<User> findUserQuery(String id) {
		
		
		List<User> users = mongoTemplate1.find(
                new Query(Criteria.where("_id").is(id)),User.class);
//	System.out.println("Time------"+mongoTemplate.find(
//            new Query(Criteria.where("_id").is(id)),User.class));
//	for(User u: users){
////		   int i=0;
////		   list.add(i, u);
//		   System.out.println(u+"new User");
////		   i++;
//	   }
	  
	   return users;
	}

	
//	public String findDB(String id){
//		
//		SpringConfig config = new SpringConfig();
//		NEW_DATABASE=USER_COLLECTION+"_"+id;
//		config.setDbname("NEW_DATABASE");
//		return null;
//	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends User> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<User> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
