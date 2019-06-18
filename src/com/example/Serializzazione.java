package com.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.io.*;
import java.nio.file.Files;


public class Serializzazione {
	List<Appartamento> lista =new ArrayList<>(); //Creazione di una lista di Appartamento
	
	public List<Appartamento> serialize(){

		  String csvFile= "UnivPm.csv";
		  String line = ""; String cvsSplitBy = ";";
		  
		  try {
		  
		  BufferedReader br = new BufferedReader(new FileReader(csvFile));  //Buffer aperto per leggere il file csv
		  br.readLine();//salto la prima riga
		  while ((line= br.readLine()) != null) { //Finche non si arriva alla fine del file, si legge la riga e la si mette in line
		  
		  List<String> home = Arrays.asList(line.split(cvsSplitBy,13)); //split di line all'interno di un array di stringhe 
		  
			for (int i=0; i<home.size(); i++) {
				if ( home.get(i).equals("") == true ) {  //Se trova nelle celle di ogni posizione una cella vuota allora mette un -1
					home.set(i, "-1");
				}
			
			}
		
		  System.out.println("Case Vacanza [code= " + home.get(0) + " , Ubicazione=" +
		  home.get(1) +", Area di Competenza=" + home.get(2)+ ", Descrizione=" + home.get(3) +
		  ", Civico=" + home.get(4) + ", codice_via=" +  Integer.parseInt(home.get(5)) + ", Posti abitativi=" +
		  Integer.parseInt(home.get(6)) + ", Posti letto=" + Integer.parseInt(home.get(7)) +
		  ", Municipio=" + Integer.parseInt(home.get(8)) +
		  ", Longitudine=" + home.get(9) + ", Latitudine=" + home.get(10) + ", Location=" +
		  home.get(11) + "]"); //Stampa di tutti i dati all'interno dell'array di stringhe presi dal file csv
		  
		  lista.add(new Appartamento(home)); //Creare un appartamento per la lista
		
		  } br.close();
		  
		  }catch (FileNotFoundException e) {
			  e.printStackTrace(); 
		  }catch (IOException e) { 
			  e.printStackTrace(); 
		 }catch(NumberFormatException e) {
			 e.printStackTrace();
		 }
		  System.out.println("\nI dati serializzati sono: " + lista.size()); //Stampa la grandezza di lista per vedere se vengono stampati tutti
		  
		  return lista;
	}
	 
	public void outputfile(final List<Appartamento> lista) {
		try {
  			FileOutputStream fileOut = new FileOutputStream("appartamento.ser"); //Creazione di un file appartamento.ser per la serializzazione dei dati
  			ObjectOutputStream out = new ObjectOutputStream(fileOut);
  			out.writeObject(lista); //Scrittura dell'oggetto lista dove ci sono salvati tutti i dati del csv
  			out.close();
  			fileOut.close();
  			System.out.printf("Serialized data is saved in appartamento.ser\n");
  		} catch (IOException i) {
  			i.printStackTrace();
  		}
	}
	


		public static void main(String[] args) {
		
			Serializzazione s=  new Serializzazione();	
			s.outputfile(s.serialize());
	
		 
				 
		}	
		
    }





