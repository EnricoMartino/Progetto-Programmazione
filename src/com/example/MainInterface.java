package com.example;
//import java libraries
import java.awt.List;
import java.io.IOException;
import java.util.Scanner;

public class MainInterface {
   // create main of the program
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	DownloadFile download = new DownloadFile();  //create an object called "download" of "DownloadFile"
	Serialization ser = new Serialization();   //create an object called "ser" of "Serialization"
	Data data = new Data();//create an object called "data" of "Data"
	Metadata metadata = new Metadata();//create an object called "metadata" of "Metadata"
	Scanner on = new Scanner(System.in);  //create an object called "on" of "Scanner"
	int scelta = 0;                //initializes an int "scelta" to 0
	boolean select=false;          //initializes a boolean "select" to false
	//print message of welcome and give instructions on the program
	System.out.println("Benvenuto nel Programma di Case Vacanze di Milano\n");
	System.out.println("Per funzionare questo programma deve scaricare un file che noi chiameremo \"UnivPm.csv\"");
	System.out.println("Dopo il download, il programma farà un lavoro di serializzazione per salvare i dati");
	System.out.println("Quindi partiamo, adesso eseguo il tutto e ti chiederò alcune cose. \n");
	
	download.main(args); //call the method download and start the download of the file
	ser.serialize();     //call the method ser and start the serialization
	
	System.out.println("Bene adesso abbiamo tutti i dati, possiamo elobolarli");
	System.out.println("Qua sotto ti metto delle opzioni!!\n");
	//create a menu to allow to choose what to do
	do {
	System.out.println("1-Serializzare i dati su di un file .ser");
	System.out.println("2-Creare un file .json dove verrano salvati i Metadata");
	System.out.println("3-Creare un file .json dove verranno salvati i Data");
	System.out.println("4-Creare un file .json dove verranno salvati i Data utilizzando un filtro scelto da te");
	System.out.println("5-Creare un file .json dove verranno salvati delle statistiche sui valori numerici in base alla tua scelta");
	System.out.println("0-Exit");
	scelta=on.nextInt();   //allow to write a number from 1 to 5 to do various operations(0 to exit)
	switch(scelta) {
	case 1:
		ser.outputfile(ser.lista);
		break;
	case 2:
		metadata.toJSonMetadata();;
		break;
	case 3:
		data.toJsonData();
		break;
	case 4:
		data.jsonDataFilter();
		break;
	case 5:
		data.jsonDataSumAvgMinMaxCount();
		break;
	case 0:
		select=true;
		break;
	}
	}while(!select);
	
	
	
	
	
	}
	
	
}
