package com.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class Data {

  private static final String JSON_FILE_NAME = "getData.json";
  private Serializzazione s = new Serializzazione();
  
  private List<Appartamento> appList = new ArrayList<>();
  

  
  /**
   * @throws ClassNotFoundException
   */
  public void toJsonData()  throws ClassNotFoundException{
  
  
    appList.stream().filter(e -> e.getCivico().equals("3")).collect(Collectors.toList());
    
    System.out.println(appList);
    
    
    try {
      BufferedWriter w = new BufferedWriter(new FileWriter(JSON_FILE_NAME));
      List<String> l=s.serialize().stream().map(a->a.toString()).collect(Collectors.toList());
      Iterator<String> it = l.iterator();
      System.out.println(l.size());
      
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
  
  
    public static void main(String args[]) { 
      Data d=new Data(); 
      try { 
        d.toJsonData();
        System.out.println("File json getData creato");
      } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
        e.printStackTrace(); } 
      }
   
  
  }