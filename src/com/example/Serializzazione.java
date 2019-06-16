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
		  List<Appartamento> lista =new ArrayList<>();
		  String line = ""; String cvsSplitBy = ";";
		  
		  try {
		  
		  BufferedReader br = new BufferedReader(new FileReader(csvFile)); 
		  br.readLine();//salto la prima riga
		  while ((line= br.readLine()) != null) {
		  
		  String[] home = line.split(cvsSplitBy,13);
		  
		  System.out.println("Case Vacanza [code= " + home[0] + " , Ubicazione=" +
		  home[1] +", Area di Competenza=" + home[2] + ", Descrizione=" + home[3] +
		  ", Civico=" + home[4] + ", codice_via=" + home[5] + ", Posti abitativi=" +
		  home[6] + ", Posti letto=" + home[7] + ", Municipio=" + home[8] +
		  ", Longitudine=" + home[9] + ", Latitudine=" + home[10] + ", Location=" +
		  home[11] + "]");
		  
		  lista.add(new Appartamento(home));
		  System.out.println(lista.size());
		  
		  System.out.println();
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
  			FileOutputStream fileOut = new FileOutputStream("appartamento.ser");
  			ObjectOutputStream out = new ObjectOutputStream(fileOut);
  			out.writeObject(lista);
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





