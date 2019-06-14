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

public class Serializzazione {
	 private static final char DEFAULT_SEPARATOR = ',';
	    private static final char DEFAULT_QUOTE = '"';
	    
	public List<Appartamento> serie() {
		
		
		  String csvFile = "D:\\GitHub\\Progetto-Programmazione\\UnivPm.csv";
		  List<Appartamento> lista =new ArrayList();
		  String line = ""; String cvsSplitBy = ";";
		  
		  try {
		  
		  BufferedReader br = new BufferedReader(new FileReader(csvFile)); 
		  while ((line= br.readLine()) != null) {
		  
		  String[] home = line.split(cvsSplitBy,13);
		  
		  System.out.println("Case Vacanza [code= " + home[0] + " , Ubicazione=" +
		  home[1] +", Area di Competenza" + home[2] + ", Descrizione=" + home[3] +
		  ", Civico=" + home[4] + ", codice_via=" + home[5] + ", Posti abitativi=" +
		  home[6] + ", Posti letto=" + home[7] + ", Municipio=" + home[8] +
		  ", Longitudine=" + home[9] + ", Latitudine=" + home[10] + ", Location=" +
		  home[11] + "]");
		  
		  lista.add(new Appartamento(home[0],home[1],home[2],home[3],home[4],home[5],home[6],home[7],home[8],home[9],home[10],home[11]));
		  
		  
		  } br.close();
		  
		  } catch (FileNotFoundException e) {
			  e.printStackTrace(); 
		 }catch (IOException e) { 
			  e.printStackTrace(); 
			  }
		
		  
		  return lista;
		 
		
		
    }
}




