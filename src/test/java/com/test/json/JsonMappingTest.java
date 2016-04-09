package com.test.json;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.bo.Ibu;


public class JsonMappingTest {
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, JSONException {
		
		String str = "{\"name\" : \"Ibrahim\", \"age\" : 31 , \"dob\" : 4101984}";
		
		ObjectMapper om = new ObjectMapper();
		Ibu ibu = om.readValue(str, Ibu.class);
		System.out.println("Name: " + ibu.getName());
		System.out.println("Age: " + ibu.getAge());
		System.out.println("DOB: " + ibu.getDob());
		
		JSONObject json = new JSONObject(str);
		
		JsonParser mapper = new JsonFactory().createJsonParser(json.toString());
		
		//ObjectMapper om1 = new ObjectMapper();
		Ibu ibu1 = om.readValue(mapper, Ibu.class);
		
		System.out.println("Name: " + ibu1.getName());
		
		Ibu ib2 = new Ibu("Nobo", 30, 19851210);
		
		System.out.println(om.writeValueAsString(ib2));
		
		System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString(ib2));
	}

}
