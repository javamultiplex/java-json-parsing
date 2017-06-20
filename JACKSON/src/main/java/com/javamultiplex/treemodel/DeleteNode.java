package com.javamultiplex.treemodel;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class DeleteNode {

	public static void main(String[] args) throws IOException {

		BufferedReader input = null;
		try {
			input = new BufferedReader(new InputStreamReader(System.in));
			File file = new File("src/main/resources/student.json");
			ObjectMapper mapper=new ObjectMapper();
			JsonNode root=mapper.readTree(file);
			System.out.println("Enter student roll number : ");
			int rollNumber = Integer.parseInt(input.readLine());
			boolean result=removeObjectNode(root,mapper,rollNumber);
			if(result){
			mapper.writerWithDefaultPrettyPrinter().writeValue(file, root);
			System.out.println("Student node has been removed successfully from json file.");
			}else{
				System.out.println("Student not exist.");
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}

	}
	
	
	private static boolean removeObjectNode(JsonNode root, ObjectMapper mapper, int rollNumber) {
		
		int studentRollNumber=0;
		int i=0;
		boolean result=false;
		for(JsonNode node:root)
		{
			studentRollNumber=node.path("rollNumber").asInt();
			if(studentRollNumber==rollNumber)
			{
				((ArrayNode)root).remove(i);
				result=true;
				break;
			}
			i++;
		}
		
		return result;
	}
}
