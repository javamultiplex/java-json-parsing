package com.javamultiplex.databinding;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javamultiplex.Student;

public class ConvertJsonStringToObject {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		String jsonString="{\"rollNumber\":1,\"name\":\"rohit\",\"age\":23,\"address\":\"gurgaon\",\"subjects\":[\"c\",\"java\"]}";
		Student student=mapper.readValue(jsonString, Student.class);
		System.out.println(student);
	}
	
}
