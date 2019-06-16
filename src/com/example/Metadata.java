package com.example;
import java.io.*;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;



public class Metadata {
	private static final String COMMA_DELIMITER = ";";
	private static final String JSON_FILE_NAME = "getMetadata.json";
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
	
	public void toJSonMetadata() throws ClassNotFoundException {
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
				 w.write("\"alias\":" + listaParam[i].toString() + "\n" );
				 w.write("\"sourceField:\""+ it.next() + "\n");
				 w.write("\"type:\" \"string\"\n");
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
		Metadata m= new Metadata();
		try {
			m.toJSonMetadata();
			System.out.println("File json getMetadata creato");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
