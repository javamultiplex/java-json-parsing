package com.javamultiplex.databinding;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJSONtoMap {

	public static void main(String[] args) throws IOException{
		
		ObjectMapper mapper=new ObjectMapper();
		File file=new File("src/main/resources/student.json");
		Map<String,Object> map=mapper.readValue(file, new TypeReference<Map<String,Object>>(){});
		System.out.println(map);
	}
	
}
