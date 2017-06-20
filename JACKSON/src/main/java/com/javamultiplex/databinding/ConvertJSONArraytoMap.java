package com.javamultiplex.databinding;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJSONArraytoMap {

	public static void main(String[] args) throws IOException{
		
		ObjectMapper mapper=new ObjectMapper();
		String jsonString="{\"name\":\"Rohit\",\"age\":24}";
		Map<String,Object> map=mapper.readValue(jsonString, new TypeReference<Map<String,Object>>(){});
		System.out.println(map);
	}
	
}
