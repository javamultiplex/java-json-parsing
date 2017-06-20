package com.javamultiplex.databinding;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javamultiplex.Student;

public class ReadJson {

	public static void main(String[] args) throws IOException {
		
		File file=new File("src/main/resources/student.json");
		ObjectMapper mapper=new ObjectMapper();
		Student student=mapper.readValue(file, Student.class);
		System.out.println(student);
		
	}
	
}
