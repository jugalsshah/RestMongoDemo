//package com.restdemo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//import com.mongodb.Mongo;
//import com.restdemo.model.User;
//
////@Configuration
//@EnableAutoConfiguration
//public class PSVM implements CommandLineRunner{
//
//    @Override
//    public void run(final String... args) throws Exception {
////        add something to the default database (test)
//    	User u = new User();
//        this.userservice.save(createPerson(u.setId(),"Phillip", "Wirth", 22,"dallas","texas",44444));
//
//        System.out.println("data from test: " + this.userservice.findAll());
////        okay? fine. - lets switch the database
//       MongoDBFactory.setDatabaseNameForCurrentThread("test666");
//
////        should be empty
//        System.out.println("data from test666: " + this.userservice.findAll());
//
////        switch back and clean up
//        MongoDBFactory.setDatabaseNameForCurrentThread("test");
//        this.userservice.deleteAll();
//    }
//
////
////    public static void main(final String[] args) {
////        SpringApplication.run(Application.class, args);
////    }
//
//	
//}
