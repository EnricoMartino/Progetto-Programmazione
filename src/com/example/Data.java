package com.example;
//some imports needed to read write and import files
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Data {
	// created and initialized a private String JSON_FILE_NAME
	private static final String JSON_FILE_NAME = "getData.json";
	//created and initialized a private String JSON_FILE_NAME_FILTER                                              
   private static final String JSON_FILE_NAME_FILTER = "getDataFilterExample.json";
    // created and initialized a String JSON_FILE_NAME_FILTER_SUMMINMAXAVG                                                                
	private static final String  JSON_FILE_NAME_FILTER_SUMMINMAXAVG = "getDataFilterMAXMINAVGSUMExample.json";
	                                                                                                            
	private Serialization s = new Serialization(); //inizialized a private Serialization called "s"
	List<Appartamento> call = s.serialize();       //list of type Appartamento called "call"
	
	public void toJsonData() {   

		try {
			//open a buffer writer of JSON_FILE_NAME
			BufferedWriter w = new BufferedWriter(new FileWriter(JSON_FILE_NAME));
			List<String> l = call.stream().map(a -> a.toString()).collect(Collectors.toList());
			Iterator<String> it = l.iterator();

			while (it.hasNext()) {  //while there is other elements keep going
				w.write("{");
				w.newLine();
				w.write(it.next());
				w.write("},\n");

			}
			w.newLine();
			w.close();  //close the BuffreWriter

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
   
	public void jsonDataFilter() {
		// System.out.println(lista.stream().filter(e ->
		// e.getCivico().equals("3")).collect(Collectors.toList())); //stampa tutte le
		// case con civico 3
		try {

			BufferedWriter w = new BufferedWriter(new FileWriter(JSON_FILE_NAME_FILTER));// open Buffer to
																							// write on a json file
			Scanner in = new Scanner(System.in);  //open scanner
			List<Appartamento> l = call.stream()
					.filter(a -> a.getPosti_abitativi() >= 7 && a.getPosti_abitativi() <= 9)
					.collect(Collectors.toList());// Use of stream and collections to create a filter of
													// Appartamento list
			Iterator<Appartamento> it = l.iterator(); //Iterator creation to scroll the Appartamento list
			System.out.println("\nGli elementi trovati per questo filtro sono: \t" + l.size()); //print the created items

			while (it.hasNext()) {//while there is other elements keep going
				w.write("{");
				w.newLine();
				w.write(it.next().toString());
				w.write("},\n");

			}
			w.newLine();
			w.close(); //close the BufferWriter

			System.out.println("E' stato creato il file json con il filtro ");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//gives the possibility to choose an int from 1 to 4 
	public String scelta(int a) {
		String str = "";
		if(a==1) {
			str="Posti Letto";
		}else if(a==2) {
			str = "Codice Via";
		}else if(a==3){
			str = "Municipio";
		}else if(a==4) {
			str = "Posti Abitativi";
		}
		return str;
	}

	public void jsonDataSumAvgMinMaxCount() throws IOException {
		BufferedWriter w = new BufferedWriter(new FileWriter(JSON_FILE_NAME_FILTER_SUMMINMAXAVG));// open Buffer 
																									// to write on a
			//initialized variables sum, count, choise	to 0																				//json file
		    //initialized variables avg, max, min to null
		int sum = 0;
		OptionalDouble avg = null;
		OptionalInt max = null;
		OptionalInt min = null;
		long count = 0;
		int choice = 0;
		Scanner in = new Scanner(System.in);
		boolean validSelection = false;  
	 //let you choose between different filter fields
		do {
			System.out.println("Scegliere il campo di utilizzo del filto\n"
					+ "Si posssono utilizzare questi campi:" + "\n1-Posti letto\n2-Codice via\n3-Municipio\n4-Posti abitativi");
			choice = in.nextInt(); //let write your choice
			//based on the choice switch case of 'choice' starts  with the 4 possible cases
			switch (choice) {
			case 1:
				sum = call.stream().filter(p -> p.getPosti_letto() != -1).mapToInt(Appartamento::getPosti_letto).sum();
				avg = call.stream().filter(p -> p.getPosti_letto() != -1).mapToInt(Appartamento::getPosti_letto).average();
				max = call.stream().filter(p -> p.getPosti_letto() != -1).mapToInt(Appartamento::getPosti_letto).max();
				min = call.stream().filter(p -> p.getPosti_letto() != -1).mapToInt(Appartamento::getPosti_letto).min();
				validSelection = true;
				break;
			case 2:
				sum = call.stream().filter(p -> p.getCodice_via() != -1).mapToInt(Appartamento::getCodice_via).sum();
				avg = call.stream().filter(p -> p.getCodice_via() != -1).mapToInt(Appartamento::getCodice_via).average();
				max = call.stream().filter(p -> p.getCodice_via() != -1).mapToInt(Appartamento::getCodice_via).max();
				min = call.stream().filter(p -> p.getCodice_via() != -1).mapToInt(Appartamento::getCodice_via).min();
				count = call.stream().filter(p -> p.getCodice_via() != -1).mapToInt(Appartamento::getCodice_via).count();
				validSelection = true;
				break;
			case 3:
				sum = call.stream().filter(p -> p.getMunicipio() != -1).mapToInt(Appartamento::getMunicipio).sum();
				avg = call.stream().filter(p -> p.getMunicipio() != -1).mapToInt(Appartamento::getMunicipio).average();
				max = call.stream().filter(p -> p.getMunicipio() != -1).mapToInt(Appartamento::getMunicipio).max();
				min = call.stream().filter(p -> p.getMunicipio() != -1).mapToInt(Appartamento::getMunicipio).min();
				count = call.stream().filter(p -> p.getMunicipio() != -1).mapToInt(Appartamento::getMunicipio).count();
				validSelection = true;
				break;
			case 4:
				sum = call.stream().filter(p -> p.getPosti_abitativi() != -1).mapToInt(Appartamento::getPosti_abitativi).sum();
				avg = call.stream().filter(p -> p.getPosti_abitativi() != -1).mapToInt(Appartamento::getPosti_abitativi).average();
				max = call.stream().filter(p -> p.getPosti_abitativi() != -1).mapToInt(Appartamento::getPosti_abitativi).max();
				min = call.stream().filter(p -> p.getPosti_abitativi() != -1).mapToInt(Appartamento::getPosti_abitativi).min();
				count = call.stream().filter(p -> p.getPosti_abitativi() != -1).mapToInt(Appartamento::getPosti_abitativi).count();
				validSelection = true;
				break;
			}
		}while(validSelection!=true);		
		//in.close();	//close input stream
		//based on the choice prints the filtered data
		w.write("{");
		w.newLine();
		w.write("\"Field\":" + this.scelta(choice));
		w.write("\n\"Sum\":" + sum);
		w.write("\n\"Avg\":" + avg);
		w.write("\n\"Max\":" + max);
		w.write("\n\"Min\":" + min);
		w.write("\n\"Count\":" + count);
		w.write("\n}");
		w.newLine();
		w.close();
		System.out.println("File " + JSON_FILE_NAME_FILTER_SUMMINMAXAVG + " creato");
	}
	

   //generate getter and setter of Serialization 's'
	public Serialization getS() {
		return s;
	}

	public void setS(Serialization s) {
		this.s = s;
	}

	public static String getJsonFileName() {
		return JSON_FILE_NAME;
	}

	public static void main(String[] args) throws IOException {
		Data d = new Data();
		//d.toJsonData();
		//d.jsonDataFilter();
		d.jsonDataSumAvgMinMaxCount();

	}

}