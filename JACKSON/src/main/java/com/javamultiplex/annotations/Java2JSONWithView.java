package com.javamultiplex.annotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Java2JSONWithView {

public static void main(String[] args) throws IOException {
		
		BufferedReader input=null;
		try
		{
			input=new BufferedReader(new InputStreamReader(System.in));
			Student student=new Student();
			List<String> subjects=new ArrayList<>();
			System.out.println("Enter student roll number : ");
			int rollNumber=Integer.parseInt(input.readLine());
			student.setRollNumber(rollNumber);
			System.out.println("Enter student name : ");
			String name=input.readLine();
			student.setName(name);
			System.out.println("Enter student age : ");
			int age=Integer.parseInt(input.readLine());
			student.setAge(age);
			System.out.println("Enter student address : ");
			String address=input.readLine();
			student.setAddress(address);
			System.out.println("Student has how many subjects ? :"); 
			int count=Integer.parseInt(input.readLine());
			System.out.println("Enter subjects : ");
			String subject=null;
			for(int i=0;i<count;i++){
				subject=input.readLine();
				subjects.add(subject);
			}
			student.setSubjects(subjects);
			System.out.println("Java Object : ");
			System.out.println(student);
			convertJavaObjectToJSON(student);
		}finally{
			if(input!=null){
				input.close();
			}
		}
		
	}

	private static void convertJavaObjectToJSON(Student student) throws IOException {
		
		ObjectMapper mapper=new ObjectMapper();
		//Convert Java Object to JSON string.
		System.out.println("---- Normat View ----\n");
		String json =mapper.writerWithView(Views.Normal.class).writeValueAsString(student);
		System.out.println(json);
		//Convert Java Object to JSON string in pretty format.
		System.out.println("---- Teacher View ----\n");
		json=mapper.writerWithDefaultPrettyPrinter().withView(Views.Teacher.class).writeValueAsString(student);
		System.out.println(json);
	}
	
}
