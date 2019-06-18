package com.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Data {

  private static final String JSON_FILE_NAME = "getData.json";
  private static final String JSON_FILE_NAME_FILTER = "getDataFilterExample.json";
  private static final String JSON_FILE_NAME_FILTER_SUMMINMAXAVG = "getDataFilterMAXMINAVGSUMExample.json";
  private Serializzazione s = new Serializzazione();
  
  
  

  
  /**
   * @throws ClassNotFoundException
   */
  public void toJsonData()  {
 
   
    try {
      BufferedWriter w = new BufferedWriter(new FileWriter(JSON_FILE_NAME));
      List<String> l=s.serialize().stream().map(a->a.toString()).collect(Collectors.toList());
      Iterator<String> it = l.iterator();
      
        while(it.hasNext()) {
        w.write("{");
        w.newLine(); 
        w.write(it.next() ); 
        w.write("},\n");
        
        } w.newLine(); w.close();
       
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
  
	public void jsonDataFilter() {
		   // System.out.println(lista.stream().filter(e -> e.getCivico().equals("3")).collect(Collectors.toList())); //stampa tutte le case con civico 3
	    try {
	        
			BufferedWriter w = new BufferedWriter(new FileWriter(JSON_FILE_NAME_FILTER));//Apertura Buffer per scrittura su un file json
			
	        List<Appartamento> l= s.serialize().stream().filter(a ->a.getPosti_abitativi()>=7 && a.getPosti_abitativi()<=9).collect(Collectors.toList());//Utilizzo dello stream e delle collection per creare un filtro della lista di appartamento
	        Iterator<Appartamento> it = l.iterator(); //Creazione iteratore per scorrere la lista di appartamento
	        System.out.println("\nGli elementi trovati per questo filtro sono: \t" + l.size());
	        
	          while(it.hasNext()) {
	          w.write("{");
	          w.newLine(); 
	          w.write(it.next().toString()); 
	          w.write("},\n");
	          
	          } w.newLine(); w.close();
	         
	          System.out.println("E' stato creato il file json con il filtro ");
	      } catch (IOException e) {
	        e.printStackTrace();
	      }	    
		  
	  }
  
	public void jsonDataSumAvgMinMaxCount() throws IOException {
			BufferedWriter w = new BufferedWriter(new FileWriter(JSON_FILE_NAME_FILTER_SUMMINMAXAVG));//Apertura Buffer per scrittura su un file json
			int sum = 0;
			OptionalDouble avg = null ;
			OptionalInt max = null;
			OptionalInt min = null;
			long count = 0;
			String choice = "";
			Scanner in = new Scanner(System.in);
			System.out.println("Scegliere il campo di utilizzo del filto\n" + 
			"Si posssono utilizzare questi campi (Codice via,Posti letto,Municipio,Posti abitativi)\n");
			choice = in.nextLine();
			
			boolean validSelection = false;
			while(!validSelection) {
			switch(choice) {
			case "Posti letto":
				sum = s.serialize().stream().filter(p->p.getPosti_letto()!=-1).mapToInt(Appartamento::getPosti_letto).sum();
		        avg = s.serialize().stream().filter(p->p.getPosti_letto()!=-1).mapToInt(Appartamento::getPosti_letto).average();
		        max = s.serialize().stream().filter(p->p.getPosti_letto()!=-1).mapToInt(Appartamento::getPosti_letto).max();
		        min = s.serialize().stream().filter(p->p.getPosti_letto()!=-1).mapToInt(Appartamento::getPosti_letto).min();
		        count = s.serialize().stream().filter(p->p.getPosti_letto()!=-1).mapToInt(Appartamento::getPosti_letto).count();
		        validSelection=true;
				break;
			case "Codice via":
		        sum = s.serialize().stream().filter(p->p.getCodice_via()!=-1).mapToInt(Appartamento::getPosti_letto).sum();
		        avg = s.serialize().stream().filter(p->p.getCodice_via()!=-1).mapToInt(Appartamento::getPosti_letto).average();
		        max = s.serialize().stream().filter(p->p.getCodice_via()!=-1).mapToInt(Appartamento::getPosti_letto).max();
		        min = s.serialize().stream().filter(p->p.getCodice_via()!=-1).mapToInt(Appartamento::getPosti_letto).min();
		        count = s.serialize().stream().filter(p->p.getCodice_via()!=-1).mapToInt(Appartamento::getPosti_letto).count();
		        validSelection=true;
				break;
			case "Municipio":
		        sum = s.serialize().stream().filter(p->p.getMunicipio()!=-1).mapToInt(Appartamento::getPosti_letto).sum();
		        avg = s.serialize().stream().filter(p->p.getMunicipio()!=-1).mapToInt(Appartamento::getPosti_letto).average();
		        max = s.serialize().stream().filter(p->p.getMunicipio()!=-1).mapToInt(Appartamento::getPosti_letto).max();
		        min = s.serialize().stream().filter(p->p.getMunicipio()!=-1).mapToInt(Appartamento::getPosti_letto).min();
		        count = s.serialize().stream().filter(p->p.getMunicipio()!=-1).mapToInt(Appartamento::getPosti_letto).count();
		        validSelection=true;
		        break;
			case "Posti abitativi":
		        sum = s.serialize().stream().filter(p->p.getPosti_abitativi()!=-1).mapToInt(Appartamento::getPosti_letto).sum();
		        avg = s.serialize().stream().filter(p->p.getPosti_abitativi()!=-1).mapToInt(Appartamento::getPosti_letto).average();
		        max = s.serialize().stream().filter(p->p.getPosti_abitativi()!=-1).mapToInt(Appartamento::getPosti_letto).max();
		        min = s.serialize().stream().filter(p->p.getPosti_abitativi()!=-1).mapToInt(Appartamento::getPosti_letto).min();
		        count = s.serialize().stream().filter(p->p.getPosti_abitativi()!=-1).mapToInt(Appartamento::getPosti_letto).count();
		        validSelection=true;
		        break;
			}
			}
	          w.write("{");
	          w.newLine(); 
	          w.write("\"Field\":" + choice);
	          w.write("\n\"Sum\":" + sum);
	          w.write("\n\"Avg\":" + avg);
	          w.write("\n\"Max\":" + max);
	          w.write("\n\"Min\":" + min);
	          w.write("\n\"Count\":" + count);
	          w.write("\n}");
	          w.newLine(); 
	          w.close();     	  
	  }
	
  
  public Serializzazione getS() {
	return s;
}

public void setS(Serializzazione s) {
	this.s = s;
}


public static String getJsonFileName() {
	return JSON_FILE_NAME;
}


  
  public static void main(String[] args) throws IOException {
	  Data d= new Data();
	  d.toJsonData();
	  d.jsonDataFilter();
	  d.jsonDataSumAvgMinMaxCount();
	 
  }
  

}