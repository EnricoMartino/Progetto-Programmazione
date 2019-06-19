package com.example;

import java.io.*;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Metadata {
	private static final String COMMA_DELIMITER = ";";
	private static final String JSON_FILE_NAME = "getMetadata.json";
	private List<String> firstLine;

	public Metadata() {
		String line = "";
		try {
			line = new BufferedReader(new FileReader("UnivPm.csv")).readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.firstLine = Arrays.asList(line.split(COMMA_DELIMITER));

	}

	public void toJSonMetadata() throws ClassNotFoundException {
		try {
			@SuppressWarnings("rawtypes")
			Class c = Class.forName("com.example.Appartamento");
			Field listaParam[] = c.getDeclaredFields();
			BufferedWriter w = new BufferedWriter(new FileWriter(JSON_FILE_NAME));
			Iterator<String> it = firstLine.iterator();
			int i = 0;
			String typeStr = "NULL";
			for(int j=0; j<firstLine.size();j++) {
				if(listaParam[i].getType()==typeStr.getClass()) {
					typeStr="String";
				}else if(listaParam[i].getType().equals(Integer.TYPE)) {
					typeStr="Integer";
				}
			}
			while (it.hasNext()) {
				w.write("{");
				w.newLine();
				w.write("\"alias\":" + listaParam[i].toString() + "\"\n");
				w.write("\"sourceField:\"" + it.next() + "\n");
				w.write("\"type:\" \"" + typeStr + "\"\n");
				w.write("},");
				i++;
			}
			w.newLine();
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void toJsonMedataWithObject() {
		try {
			Class c = Class.forName("com.example.Appartamento");
			Field listaParam[] = c.getDeclaredFields();
			BufferedWriter w = new BufferedWriter(new FileWriter(JSON_FILE_NAME));
			String typeStr = "NULL";
			JSONArray metadataArray = new JSONArray();
			
			for(int i=0; i<firstLine.size();i++) {
				JSONObject metadata = new JSONObject();
				metadata.put("alias", listaParam[i].getName());
				metadata.put("sourceField", firstLine.get(i));
				if(listaParam[i].getType()==typeStr.getClass()) {
					typeStr="String";
				}else if(listaParam[i].getType().equals(Integer.TYPE)) {
					typeStr="Integer";
				}
				metadata.put("type:", typeStr);
				metadataArray.add(metadata);
			}
			w.write(metadataArray.toJSONString());
			w.flush();
			w.close();
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
			
		}
	}

	public static void main(String args[]) {
		Metadata m = new Metadata();
		m.toJsonMedataWithObject();
		System.out.println("File json getMetadata creato");
	}

}
