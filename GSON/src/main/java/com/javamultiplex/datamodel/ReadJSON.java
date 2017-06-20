package com.javamultiplex.datamodel;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.javamultiplex.Student;

public class ReadJSON {

	public static void main(String[] args) throws IOException{
		
		File file=new File("src/main/resources/student.json");
		FileReader reader=new FileReader(file);
		Gson gson=new Gson();
		Student student=gson.fromJson(reader, Student.class);
		System.out.println(student);
				
		
	}
	
}
