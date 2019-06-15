package com.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Data {
	private static final String COMMA_DELIMITER = ";";
	private static final String JSON_FILE_NAME = "json-data.json";
	private List<String> firstLine;
	private BufferedReader br;
	
	private List<Appartamento> appList = new ArrayList<>();
	
	public Data(String str) {
		try {
			this.br = new BufferedReader(new FileReader(str));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void elenco()  throws ClassNotFoundException{
		Appartamento app = new Appartamento("codice", "ubicazione", "area di competenza",
				"descrizione via", "civico", "codice via", "posti abitativi", "posti letto",
				"municipio", "longitudine", "latitudine", "location");
		System.out.println(app.getCodice().getClass().toString());
		System.out.println(app.getUbicazione().getClass().toString());
		System.out.println(app.getArea_di_competenza().getClass().toString());
		System.out.println(app.getDescrizione_via().getClass().toString());
		System.out.println(app.getCivico().getClass().toString());
		System.out.println(app.getCodice_via().getClass().toString());
		System.out.println(app.getPosti_abitativi().getClass().toString());
		System.out.println(app.getPosti_letto().getClass().toString());
		System.out.println(app.getMunicipio().getClass().toString());
		System.out.println(app.getLongitudine().getClass().toString());
		System.out.println(app.getLatitudine().getClass().toString());
		System.out.println(app.getLocation().getClass().toString());
	
		appList.stream().filter(e -> e.getCivico().equals("3")).collect(Collectors.toList());
		
		System.out.println(appList);
		
		
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
	
	}
	


