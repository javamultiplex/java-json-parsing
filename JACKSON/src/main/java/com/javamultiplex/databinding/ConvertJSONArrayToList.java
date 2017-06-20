package com.javamultiplex.databinding;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javamultiplex.Student;

public class ConvertJSONArrayToList {

	
	public static void main(String[] args) throws IOException {
		
		ObjectMapper mapper=new ObjectMapper();
		String jsonArray="[{\"name\":\"Rohit\"}, {\"name\":\"Bhavna\"}]";
		List<Student> list=mapper.readValue(jsonArray, new TypeReference<List<Student>>(){});
		System.out.println(list);
	}
	
}
