package com.mercedes.aes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercedes.model.FileInteractorInterfaceRequest;

public class JSONUtils {
	
	static ObjectMapper mapper = new ObjectMapper();
	 
	 public static String toJSON(Object o) {
	  String result = "";
	  if (o != null) {
	   ByteArrayOutputStream out = new ByteArrayOutputStream();
	   try {
	    mapper.writeValue(out, o);
	   } catch (JsonGenerationException e) {
	    e.printStackTrace();
	   } catch (JsonMappingException e) {
	    e.printStackTrace();
	   } catch (IOException e) {
	    e.printStackTrace();
	   }
	   try {
	    result = out.toString("UTF-8");
	   } catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	   }
	  }
	  return result;
	 }
	 
	 public static FileInteractorInterfaceRequest parseJSON(String jsonString, Class<FileInteractorInterfaceRequest> beanClass)
	   throws JsonParseException, JsonMappingException, IOException {
	  return mapper.readValue(jsonString, beanClass);
	 }
	 public static List<FileInteractorInterfaceRequest> parseJSONForList(String jsonString, Class<Object> class1)
			   throws JsonParseException, JsonMappingException, IOException {
			  return (List<FileInteractorInterfaceRequest>) mapper.readValue(jsonString, class1);
			 }
	}
