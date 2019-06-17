package com.example;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class Serializzazione {
	
	public List<Appartamento> serialize(){

		  String csvFile= "UnivPm.csv";
		  List<Appartamento> lista =new ArrayList<>(); //Creazione di una lista di Appartamento
		  String line = ""; String cvsSplitBy = ";";
		  
		  try {
		  
		  BufferedReader br = new BufferedReader(new FileReader(csvFile));  //Buffer aperto per leggere il file csv
		  br.readLine();//salto la prima riga
		  while ((line= br.readLine()) != null) { //Finche non si arriva alla fine del file, si legge la riga e la si mette in line
		  
		  String[] home = line.split(cvsSplitBy,13); //split di line all'interno di un array di stringhe 
		  
		  System.out.println("Case Vacanza [code= " + home[0] + " , Ubicazione=" +
		  home[1] +", Area di Competenza=" + home[2] + ", Descrizione=" + home[3] +
		  ", Civico=" + home[4] + ", codice_via=" + home[5] + ", Posti abitativi=" +
		  home[6] + ", Posti letto=" + home[7] + ", Municipio=" + home[8] +
		  ", Longitudine=" + home[9] + ", Latitudine=" + home[10] + ", Location=" +
		  home[11] + "]"); //Stampa di tutti i dati all'interno dell'array di stringhe presi dal file csv
		  
		  lista.add(new Appartamento(home)); //Creare un appartamento per la lista
		  System.out.println(lista.size()); //Stampa la grandezza di lista per vedere se vengono stampati tutti
		  
		
		  } br.close();
		  
		  } catch (FileNotFoundException e) {
			  e.printStackTrace(); 
		 }catch (IOException e) { 
			  e.printStackTrace(); 
			  }

		  return lista;
	}
	 
	public void outputfile(final List<Appartamento> lista) {
		try {
  			FileOutputStream fileOut = new FileOutputStream("appartamento.ser"); //Creazione di un file appartamento.ser per la serializzazione dei dati
  			ObjectOutputStream out = new ObjectOutputStream(fileOut);
  			out.writeObject(lista); //Scrittura dell'oggetto lista dove ci sono salvati tutti i dati del csv
  			out.close();
  			fileOut.close();
  			System.out.printf("Serialized data is saved in appartamento.ser");
  		} catch (IOException i) {
  			i.printStackTrace();
  		}
	}
		public static void main(String[] args) {
		
			Serializzazione s=  new Serializzazione();	
			s.outputfile(s.serialize());
		 
				 
		}	
		
    }





