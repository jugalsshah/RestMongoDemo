//package com.restdemo.component;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//import com.restdemo.model.User;
//import com.restdemo.service.SpringConfig;
//import com.restdemo.service.Userservice;
//
//public class PSVM {
//
//	 public static void main(String[] args) {
////	        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/WEB-INFApplicationContext ctx = 
//		  @SuppressWarnings("resource")
//		ApplicationContext ctx =  new AnnotationConfigApplicationContext(SpringConfig.class);
//	       
////                    new AnnotationConfigApplicationContext(SpringMongoConfig.class);
////	        Userservice userservice = ctx.getBean("userServ", PersonDAO.class);
//	        MongoTemplate mongoTemplate= (MongoTemplate) ctx.getBean("mongoTemplate"); 
//	        
//	        User u= new User("222", "jugal", "lass", 66, "Dallas", "texas",66666);
//	        System.out.println("Generated ID="+u.getId());
//	        mongoTemplate.save(u);
//	        
//	        
//	        User u1= new User("111", "jugal", "lass", 66, "Dallas", "texas",66666);
//	        System.out.println("Generated ID="+u1.getId());
//	        mongoTemplate.save(u1);
//	        
//	        //read
////	        Person p1 = personDAO.readById(p.getId());
////	        System.out.println("Retrieved Person="+p1);
////	         
////	        //update
////	        p1.setName("David");p1.setAddress("SFO, USA");
////	        personDAO.update(p1);
////	        Person temp = personDAO.readById(p1.getId());
////	        System.out.println("Retrieved Person after update="+temp);
////	         
////	        //delete
////	        int count = personDAO.deleteById(p1.getId());
////	        System.out.println("Number of records deleted="+count);
//	         
////	        ctx.close();
//	 
//	    }
//	
//	
//}
