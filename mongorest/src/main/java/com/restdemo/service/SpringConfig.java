package com.restdemo.service;

//import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class SpringConfig {
	
	
	public SpringConfig() {
		// TODO Auto-generated constructor stub
	}
	
//	public @Bean
//	MongoTemplate mongoTemplate1() throws Exception {
// 
//		MongoTemplate mongoTemplate = 
//			new MongoTemplate(new MongoClient("127.0.0.1"),"USER_1");
//		return mongoTemplate;
// 
//	}
//	
//	public @Bean
//	MongoTemplate mongoTemplate2() throws Exception {
// 
//		MongoTemplate mongoTemplate = 
//			new MongoTemplate(new MongoClient("127.0.0.1"),"USER_2");
//		return mongoTemplate;
// 
//	}	
public String NEW_DB="User";
////public String NEW_Database="Uber";
//public String getNEW_DB() {
//	
//	return NEW_DB;
//}
//
//public void setNEW_DB(String nEW_DB) {
//	NEW_DB = NEW_DB+"_"+nEW_DB;
//	System.out.println(NEW_DB+"Ssss");
//}
	
	public @Bean
	MongoDbFactory mongoDbFactory() throws Exception {
		System.out.println(NEW_DB+"Ssssaaaas");
		return new SimpleMongoDbFactory(new MongoClient(), NEW_DB);
	}
	
	public @Bean
	MongoTemplate mongoTemplate() throws Exception {
 
//		UserserviceImpl impl= new UserserviceImpl();
		
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
 
		return mongoTemplate;
 
	}
//	
//	public @Bean MongoDbFactory mongoDbFactory() throws Exception {
//	    return new SimpleMongoDbFactory(new Mongo(), "database");
//	  }
	
//	
//	public @Bean MongoFactoryBean mongoFactoryBean() {
//        MongoFactoryBean mongo = new MongoFactoryBean();
//        mongo.setHost("127.0.0.1");
//        
//        return mongo;
//   }
//	
	
}
