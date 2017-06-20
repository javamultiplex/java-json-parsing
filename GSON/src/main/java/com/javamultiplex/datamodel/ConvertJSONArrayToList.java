package com.javamultiplex.datamodel;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javamultiplex.Student;

public class ConvertJSONArrayToList {

	public static void main(String[] args) {
		
		String jsonString="[{\"name\":\"Rohit\"},{\"name\":\"Bhavna\"}]";
		Gson gson=new Gson();
		List<Student> student=gson.fromJson(jsonString,new TypeToken<List<Student>>(){}.getType());
		System.out.println(student);
	}
	
}
