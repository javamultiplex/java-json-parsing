package com.javamultiplex.databinding;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertMaptoJSON {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader input=null;
		try
		{
			Map<String, Object> map=new LinkedHashMap<>();
			input=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your name  : ");
			String name=input.readLine();
			map.put("name",name);
			System.out.println("Enter your age : ");
			int age=Integer.parseInt(input.readLine());
			map.put("age",age);
			System.out.println("Enter your address : ");
			String address = input.readLine();
			map.put("address",address);
			convertMapToJSON(map);
		}finally{
			if(input!=null){
				input.close();
			}
		}
		
	}

	private static void convertMapToJSON(Map<String, Object> map) throws IOException{
		
		ObjectMapper mapper=new ObjectMapper();
		File file=new File("src/main/resources/student.json");
		//Convert Java Object to JSON string and write into file.
		mapper.writeValue(file, map);
		//Convert Java Object to JSON string.
		String json =mapper.writeValueAsString(map);
		System.out.println(json);
		//Convert Java Object to JSON string in pretty format.
		json=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
		System.out.println(json);
	}

	
}
