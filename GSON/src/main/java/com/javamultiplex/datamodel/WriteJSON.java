package com.javamultiplex.datamodel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javamultiplex.Student;

public class WriteJSON {

	public static void main(String[] args) throws IOException {

		BufferedReader input = null;
		try {
			input = new BufferedReader(new InputStreamReader(System.in));
			Student student = new Student();
			File file = new File("src/main/resources/student.json");
			List<String> subjects = new ArrayList<>();
			System.out.println("Enter student roll number : ");
			int rollNumber = Integer.parseInt(input.readLine());
			student.setRollNumber(rollNumber);
			System.out.println("Enter student name : ");
			String name = input.readLine();
			student.setName(name);
			System.out.println("Enter student age : ");
			int age = Integer.parseInt(input.readLine());
			student.setAge(age);
			System.out.println("Enter student address : ");
			String address = input.readLine();
			student.setAddress(address);
			System.out.println("Student has how many subjects ? :");
			int count = Integer.parseInt(input.readLine());
			System.out.println("Enter subjects : ");
			String subject = null;
			for (int i = 0; i < count; i++) {
				subject = input.readLine();
				subjects.add(subject);
			}
			student.setSubjects(subjects);
			convertJavaObjectToJSON(student, file);
			System.out.println("Student data has been written successfully.");
		} finally {
			if (input != null) {
				input.close();
			}
		}

	}

	private static void convertJavaObjectToJSON(Student student, File file) throws IOException {
		
		//Used for pretty printing.
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		Gson gs=new Gson();
		String json=gson.toJson(student);
		System.out.println(json);
		FileWriter writer=new FileWriter(file);
		gs.toJson(student,writer);
		writer.close();
	}
	
}
