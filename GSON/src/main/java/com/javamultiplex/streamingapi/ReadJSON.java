package com.javamultiplex.streamingapi;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.stream.JsonReader;
import com.javamultiplex.Student;

public class ReadJSON {

	public static void main(String[] args) throws IOException{
		
		File file=new File("src/main/resources/student.json");
		FileReader fileReader=new FileReader(file);
		Student student=new Student();
		JsonReader jsonReader=new JsonReader(fileReader);
		String propertyName=null;
		jsonReader.beginObject();
		while(jsonReader.hasNext()){
			
			propertyName=jsonReader.nextName();
			if(propertyName.equals("rollNumber")){
				student.setRollNumber(jsonReader.nextInt());
			}else if(propertyName.equals("name")){
				student.setName(jsonReader.nextString());
			}else if(propertyName.equals("age")){
				student.setAge(jsonReader.nextInt());
			}else if(propertyName.equals("address")){
				student.setAddress(jsonReader.nextString());
			}else if(propertyName.equals("subjects")){
				jsonReader.beginArray();
				List<String> subjects=new ArrayList<>();
				while(jsonReader.hasNext()){
					subjects.add(jsonReader.nextString());
				}
				student.setSubjects(subjects);
				jsonReader.endArray();
			}
		}
		jsonReader.endObject();
		jsonReader.close();
		System.out.println(student);
	}
}
