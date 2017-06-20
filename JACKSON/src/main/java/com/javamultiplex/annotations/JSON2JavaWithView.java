package com.javamultiplex.annotations;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON2JavaWithView {

	public static void main(String[] args) throws IOException {
		

		ObjectMapper mapper=new ObjectMapper();
		String jsonString="{\"rollNumber\":1,\"name\":\"rohit\",\"age\":23,\"address\":\"gurgaon\",\"subjects\":[\"c\",\"java\"]}";
		System.out.println("Normal View");
		Student student=mapper.readerWithView(Views.Normal.class).forType(Student.class).readValue(jsonString);
		System.out.println(student);
		System.out.println("Teacher View");
		student=mapper.readerWithView(Views.Teacher.class).forType(Student.class).readValue(jsonString);
		System.out.println(student);
		
	}
	
}
