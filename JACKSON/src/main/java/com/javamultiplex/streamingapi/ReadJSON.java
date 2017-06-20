package com.javamultiplex.streamingapi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.javamultiplex.Student;

public class ReadJSON {

	public static void main(String[] args) throws IOException{
		
		File file=new File("src/main/resources/student.json");
		Student student=new Student();
		JsonFactory factory=new JsonFactory();
		JsonParser parser=factory.createParser(file);
		String propertyName=null;
		parser.nextToken();
		while(parser.nextToken() != JsonToken.END_OBJECT){
			
			propertyName=parser.getCurrentName();
			if(propertyName.equals("rollNumber")){
				
				parser.nextToken();
				student.setRollNumber(parser.getIntValue());
			}else if(propertyName.equals("name")){
				
				parser.nextToken();
				student.setName(parser.getText());
			}else if(propertyName.equals("age")){
				
				parser.nextToken();
				student.setAge(parser.getIntValue());
			}else if(propertyName.equals("address")){
				
				parser.nextToken();
				student.setAddress(parser.getText());
			}else if(propertyName.equals("subjects")){
				parser.nextToken();
				List<String> subjects=new ArrayList<>();
				while(parser.nextToken()!=JsonToken.END_ARRAY){
					subjects.add(parser.getText());
				}
				student.setSubjects(subjects);
			}
			
		}
		System.out.println(student);
	}
}
