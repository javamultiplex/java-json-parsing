package com.javamultiplex.treemodel;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class AddProperty {

	public static void main(String[] args) throws IOException {

		BufferedReader input = null;
		try {
			input = new BufferedReader(new InputStreamReader(System.in));
			File file = new File("src/main/resources/student.json");
			ObjectMapper mapper=new ObjectMapper();
			JsonNode root=mapper.readTree(file);
			System.out.println("Enter student roll number : ");
			int rollNumber = Integer.parseInt(input.readLine());
			System.out.println("Enter Property name :  ");
			String property=input.readLine();
			System.out.println("Enter Property value : ");
			String value=input.readLine();
			boolean result=addPropertyToObjectNode(root,mapper,rollNumber,property,value);
			if(result){
			mapper.writerWithDefaultPrettyPrinter().writeValue(file, root);
			System.out.println("Student property has been added successfully in json file.");
			}else{
				System.out.println("Student not exist.");
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}

	}
	
	
	private static boolean addPropertyToObjectNode(JsonNode root, ObjectMapper mapper, int rollNumber, String property, String value) {

		int studentRollNumber=0;
		boolean result=false;
		for(JsonNode node:root)
		{
			studentRollNumber=node.path("rollNumber").asInt();
			if(studentRollNumber==rollNumber)
			{
				((ObjectNode)node).put(property, value);
				result=true;
				break;
			}
		
		}
		
		return result;
	}
}
