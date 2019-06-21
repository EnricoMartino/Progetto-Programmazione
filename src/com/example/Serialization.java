package com.example;
/**
 * the Serialization class
 * starts from the "UnivPm.csv" file already downloaded thanks
 *  to the DownloadFile class and takes care of executing the
 *   file serialization in a list and  then save the serialized file 
 *   in a file called "appartamento.ser".
 * 
 * @author Enrico Pio Martino
 * @author Luca Munerati
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.io.*;
import java.nio.file.Files;

public class Serialization {
	List<Appartamento> lista = new ArrayList<>(); // create list  "Appartamento"

	/**
	 * Method for a correct creation Appartamento with data of csv
	 * @return List<Appartamento> that is the data of csv
	 */
	public List<Appartamento> serialize() {
        
		String csvFile = "UnivPm.csv"; //create and initialize  String "csvFile"
		String line = "";//create and initialize  String "line"
		String cvsSplitBy = ";";//create and initialize  String "cvsPlitBy"

		try {

			BufferedReader br = new BufferedReader(new FileReader(csvFile)); // open Buffer to read "csvFile"
			br.readLine();// skip the first line because there is no informations
			while ((line = br.readLine()) != null) { // While end of file, read line and put it in string 
				                                     //"line"
														

				List<String> home = Arrays.asList(line.split(cvsSplitBy, 13)); // split of line in an array
																				// of string

				for (int i = 0; i < home.size(); i++) {
					if (home.get(i).equals("") == true) { // if find in the cells of each position an empty cell
															// then puts -1
						home.set(i, "0");
					}

				}
				/*
				 * System.out.println("Case Vacanza [code= " + home.get(0) + " , Ubicazione=" +
				 * home.get(1) + ", Area di Competenza=" + home.get(2) + ", Descrizione=" +
				 * home.get(3) + ", Civico=" + home.get(4) + ", codice_via=" +
				 * Integer.parseInt(home.get(5)) + ", Posti abitativi=" +
				 * Integer.parseInt(home.get(6)) + ", Posti letto=" +
				 * Integer.parseInt(home.get(7)) + ", Municipio=" +
				 * Integer.parseInt(home.get(8)) + ", Longitudine=" + home.get(9) +
				 * ", Latitudine=" + home.get(10) + ", Location=" + home.get(11) + "]");
				 */
				  // Stampa di tutti i
																								// data in the array
																								// of string
																								// took from csv file
																							

				lista.add(new Appartamento(home)); //create an obj "Appartamento" to use it in the list

			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		return lista;
	}
	/**
	 * Method that create a file appartamento.ser with serialization of the data on List<Appartamento>
	 * @param lista that arrive with serialize
	 */
	public void outputfile(final List<Appartamento> lista) {
		try {
			FileOutputStream fileOut = new FileOutputStream("appartamento.ser"); // Creation of a file
																					// appartamento.ser to put
																					// the serialization of the file
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(lista); //Writing of the list object where all the data of the csv are saved
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in appartamento.ser\n");
		} catch (IOException i) {
			i.printStackTrace();
		}
		System.out.println("\nI dati serializzati sono: " + lista.size()); // Print the list size to see if
																			// everything has been saved

	}

}
