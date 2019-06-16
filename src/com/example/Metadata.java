package com.example;
import java.io.*;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//import org.json.simple.JSONObject;

public class Metadata {
	private static final String COMMA_DELIMITER = ";";
	private static final String JSON_FILE_NAME = "json-metadata.json";
	private List<String> firstLine;
	
	public Metadata() {
		String line = "";
		try {
			 line = new BufferedReader(new FileReader("UnivPm.csv")).readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		this.firstLine = Arrays.asList(line.split(COMMA_DELIMITER));
		
	}
	
	public void toJSon() throws ClassNotFoundException {
		try {
			@SuppressWarnings("rawtypes")
			Class c=Class.forName("com.example.Appartamento");
			Field listaParam[] = c.getDeclaredFields();
			BufferedWriter w = new BufferedWriter(new FileWriter(JSON_FILE_NAME));
			Iterator<String> it = firstLine.iterator();
			int i=0;
			while(it.hasNext()) {
				 w.write("{");
				 w.newLine();
				 w.write("\"alias\":" + listaParam[i].toString() );
				 w.write("\"sourceField:\""+ it.next());
				 w.write("\"type:\" \"string\"");
				 w.write("},");
				 i++;
			}
			w.newLine();
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

		
		
		
	}
	public static void main(String args[]) {
		Metadati m= new Metadati();
		try {
			m.toJSon();
			System.out.println("Dato");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
