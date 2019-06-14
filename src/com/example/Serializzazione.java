package com.example;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.io.*;
import java.util.*;

public class Serializzazione {
	 
		public static void main(String[] args) {
		
		  String csvFile= "UnivPm.csv";
		  List<Appartamento> lista =new ArrayList<>();
		  String line = ""; String cvsSplitBy = ";";
		  
		  try {
		  
		  BufferedReader br = new BufferedReader(new FileReader(csvFile)); 
		  while ((line= br.readLine()) != null) {
		  
		  String[] home = line.split(cvsSplitBy,13);
		  
		  System.out.println("Case Vacanza [code= " + home[0] + " , Ubicazione=" +
		  home[1] +", Area di Competenza=" + home[2] + ", Descrizione=" + home[3] +
		  ", Civico=" + home[4] + ", codice_via=" + home[5] + ", Posti abitativi=" +
		  home[6] + ", Posti letto=" + home[7] + ", Municipio=" + home[8] +
		  ", Longitudine=" + home[9] + ", Latitudine=" + home[10] + ", Location=" +
		  home[11] + "]");
		  
		  lista.add(new Appartamento(home));
		  
		  
		  } br.close();
		  
		  } catch (FileNotFoundException e) {
			  e.printStackTrace(); 
		 }catch (IOException e) { 
			  e.printStackTrace(); 
			  }
		// stampa su file l'elenco degli appartamenti
		  Appartamento a = new Appartamento("Codice","Ubicazione","Area di Competenza","Descrizione","Civico",
				  "Codice via","Posti Abitativi","Posti Letto","Municipio","Longitudine","Latitudine","Location");
		  
		  		try {
		  			FileOutputStream fileOut = new FileOutputStream("appartamento.ser");
		  			ObjectOutputStream out = new ObjectOutputStream(fileOut);
		  			out.writeObject(a);
		  			out.close();
		  			fileOut.close();
		  			System.out.printf("Serialized data is saved in appartamento.ser");
		  		} catch (IOException i) {
		  			i.printStackTrace();
		  		}
		  
		  
		  
				 
		}	
		
    }





