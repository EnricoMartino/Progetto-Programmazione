import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

import java.io.IOException;
import java.util.Iterator;

public class ParseJson{
	
	public static void main(String[] args) { 
	
		ArrayList<String> lista = new ArrayList<>();
		
	    try {
	      File myObj = new File("filename.json");
	      Scanner myReader = new Scanner(myObj); 
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        lista.add(data+"\n");
	        System.out.println(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    } 
	  }
}
	  

