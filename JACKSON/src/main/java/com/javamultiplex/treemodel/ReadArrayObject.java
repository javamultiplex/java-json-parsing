package com.javamultiplex.treemodel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javamultiplex.Student;

public class ReadArrayObject {

	public static void main(String[] args) throws IOException {

		File file = new File("src/main/resources/student.json");
		List<Student> students = getStudent(file);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private static List<Student> getStudent(File file) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode nodes = mapper.readTree(file);
		List<Student> students=new ArrayList<>();
		for (JsonNode node : nodes) {
			Student student = new Student();
			List<String> subjects = new ArrayList<>();
			int rollNumber = node.path("rollNumber").asInt();
			student.setRollNumber(rollNumber);
			String name = node.path("name").asText();
			student.setName(name);
			int age = node.path("age").asInt();
			student.setAge(age);
			String address = node.path("address").asText();
			student.setAddress(address);
			JsonNode nodeArray = node.path("subjects");
			for (JsonNode subject : nodeArray) {
				subjects.add(subject.asText());
			}
			student.setSubjects(subjects);
			students.add(student);
		}
		return students;
	}

}
