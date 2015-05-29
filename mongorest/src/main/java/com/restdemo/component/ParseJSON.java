package com.restdemo.component;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
//import java.util.HashMap;
import java.util.LinkedHashMap;
//import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mongodb.MongoServerSelectionException;
import com.restdemo.model.User;
//import com.restdemo.service.SpringConfig;
import com.restdemo.service.Userservice;
import com.restdemo.service.UserserviceImpl;

//import com.restdemo.service.UserserviceImpl;

@Component
public class ParseJSON {

	// @Autowired
	// Userservice userservice;

	UserserviceImpl userservice = new UserserviceImpl();
//	SimpleEHCache userCache = new SimpleEHCache();

	public ParseJSON() {
		// TODO Auto-generated constructor stub
	}
	User users = new User();
	ArrayList<User> ids = new ArrayList<>();
	String s = null;
	long L = 0;

	/*
	 * 
	 * 1)this method is parsing the objects(JSON data) came from userservice
	 * class into simple form. 2)Insert data into user object and mongoDb and
	 * calling the usercache to save(put) the object. 3)Checking the condition
	 * wether the user is i serted first time or not.
	 */
	public String insertJsontoDB(StringBuilder user, StringBuilder address,String id)
			throws JSONException, UnknownHostException {
		
		JSONObject jsonuser = new JSONObject(user.toString());
		JSONArray user_json_array = jsonuser.getJSONArray("userRecords");
		JSONObject jsonaddress = new JSONObject(address.toString());
		JSONArray address_json_array = jsonaddress.getJSONArray("userAddress");
		
		// userRecords and userAddress data should be same numbers (equal
		// numbers of ids in both the files)
		int size = user_json_array.length();
		ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();
	
		users.setClientId(id);
//		userservice.findDB(id);
		for (int i = 0; i < size; i++) {

			JSONObject another_json_object = user_json_array.getJSONObject(i);
			JSONObject another_addressjson_object = address_json_array
					.getJSONObject(i);

			users.setId(another_json_object.getString("id"));
//		System.out.println(users.getId()+"Dddd");
			if (userservice.findUserQuery(users.getId()).size() == 0) {

				System.out.println("collection is empty so firstime insertion********");

				users.setFirstname(another_json_object.getString("firstname"));
				users.setLastname(another_json_object.getString("lastname"));
				users.setAge(another_json_object.getInt("age"));
				users.setCity(another_addressjson_object.getString("city"));
				users.setState(another_addressjson_object.getString("state"));
				users.setZipcode(another_addressjson_object.getLong("zipcode"));
//				users.setClientId(id);
				userservice.save(users.getId(), users.getFirstname(),
						users.getLastname(), users.getAge(), users.getCity(),
						users.getState(), users.getZipcode());
				System.out.println(userservice.findUserQuery(users.getId())
						+ "firsttime");

//				userCache.loaduserCache(users.getId(), users.getFirstname(),
//						users.getLastname(), users.getAge(), users.getCity(),
//						users.getState(), users.getZipcode());
//							ids.add(userCache.getUser(users.getId()));
//				 ids.addAll(userservice.findUserQuery(users.getId()));

			}

			else if (userservice.getId(users.getId()).getId()
					.equals(users.getId())) {

//				System.out.println("retrive from db");
				long startTime = System.currentTimeMillis();
				
//				System.out.println("comes from cache"
//						+ userCache.getUser(users.getId()));
//				 System.out.println("comes from db"+userservice.findUserQuery(users.getId()));
//				ids.add(userCache.getUser(users.getId()));
				long finishTime = System.currentTimeMillis();

				long T = finishTime - startTime;
				System.out.println("That took: " + (T) + " ms");
				L = T + L;
				System.out.println("Total Time: " + (L) + " ms");

//				 ids.addAll(userservice.findUserQuery(users.getId()));
			}

			arrays.add(another_json_object);

		}

		 System.out.println(ids + "jugal shah");
		return ids.toString();
	}

	/*
	 * this method is getting the data from the cache.
	 */

	public Map<String, String> retrivefrommongo(String s) {
		s = s.substring(0, s.length() - 1);
		String starr[] = s.split(",");
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 1; i < starr.length; i++) {
			if (!starr[i].contains("$id")) {
				String keyValue[] = starr[i].split(":");
				map.put(keyValue[0], keyValue[1]);
				System.out.println(keyValue[0] + "," + keyValue[1]);
			} else {
				String keyValue[] = starr[i].split(":");
				map.put(keyValue[0], keyValue[2]);
			}
		}
		return map;

	}

}
