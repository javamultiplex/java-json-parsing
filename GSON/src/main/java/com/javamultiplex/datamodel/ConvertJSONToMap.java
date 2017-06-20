package com.javamultiplex.datamodel;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConvertJSONToMap {

public static void main(String[] args) throws IOException{
		
		File file=new File("src/main/resources/student.json");
		FileReader reader=new FileReader(file);
		Gson gson=new Gson();
		Map<String,Object> student=gson.fromJson(reader,new TypeToken<Map<String,Object>>(){}.getType());
		System.out.println(student);
	}
	
}
