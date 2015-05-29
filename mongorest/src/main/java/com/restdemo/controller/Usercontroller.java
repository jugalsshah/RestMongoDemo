package com.restdemo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;


import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONException;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.restdemo.component.ParseJSON;
import com.restdemo.service.SpringConfig;


@Controller
@RequestMapping(value="/mongo")
public class Usercontroller {
	
	ParseJSON parseJSON = new ParseJSON();

	
//	List<User> l= new ArrayList<>();
	@RequestMapping(value="/post", method = RequestMethod.POST, produces="application/json",consumes="multipart/form-data")    
    public @ResponseBody String getUser(@RequestParam(value = "file") MultipartFile uploadedInputStream,
    		                 @RequestParam(value="file1") MultipartFile uploadedInputStream1,
    		                 @RequestParam(value = "id",required = false,
                             defaultValue = "0") String id
    		                ) throws  IOException, JSONException
    		                {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(uploadedInputStream.getInputStream()));
		BufferedReader reader1 = new BufferedReader(new InputStreamReader(uploadedInputStream1.getInputStream()));
		StringBuilder user= new StringBuilder();
		StringBuilder address= new StringBuilder();
		
		
		String line = null;
		String line1 = null;
		 try
	        {
            while ((line = reader.readLine()) != null)
            {
                    address.append(line + "\n");
            } 
            System.out.println(address.toString());
            while ((line1 = reader1.readLine()) != null)
            {
                    user.append(line1 + "\n");
            } 
            System.out.println(user.toString());

//           parseJSON.insertJsontoDB(user, address);
//            l.add()
            System.out.println("A"+id);
                    }
        catch (IOException e)
        {
            e.printStackTrace();
        }
		 return parseJSON.insertJsontoDB(user, address,id).toString();
      }
		

	
	

}
