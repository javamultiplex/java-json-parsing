package com.javamultiplex.treemodel;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.javamultiplex.Student;

public class AddNode {

	public static void main(String[] args) throws IOException {

		BufferedReader input = null;
		try {
			input = new BufferedReader(new InputStreamReader(System.in));
			File file = new File("src/main/resources/student.json");
			ObjectMapper mapper=new ObjectMapper();
			JsonNode root=mapper.readTree(file);
			Student student = new Student();
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
			int subjectCount = Integer.parseInt(input.readLine());
			System.out.println("Enter subjects : ");
			String subject = null;
			for (int j = 0; j < subjectCount; j++) {
				subject = input.readLine();
				subjects.add(subject);
			}
			student.setSubjects(subjects);
			ObjectNode node=getObjectNode(student,mapper);
			((ArrayNode)root).add(node);
			mapper.writerWithDefaultPrettyPrinter().writeValue(file, root);
			System.out.println("Student node has been added successfully in json file.");
		} finally {
			if (input != null) {
				input.close();
			}
		}

	}
	
	
private static ObjectNode getObjectNode(Student student, ObjectMapper mapper) {
		
		ObjectNode objectNode=mapper.createObjectNode();
		objectNode.put("rollNumber", student.getRollNumber());
		objectNode.put("name", student.getName());
		objectNode.put("age", student.getAge());
		objectNode.put("address",student.getAddress());
		ArrayNode arrayNode=mapper.createArrayNode();
		List<String> subjects=student.getSubjects();
		int count=subjects.size();
		for(int i=0;i<count;i++){
			arrayNode.add(subjects.get(i));
		}
		objectNode.set("subjects", arrayNode);
		return objectNode;
	}

}
