package com.example;

import java.awt.List;
import java.io.IOException;
import java.util.Scanner;

public class MainInterface {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
	DownloadFile download = new DownloadFile();
	Serialization ser = new Serialization();
	Data data = new Data();
	Metadata metadata = new Metadata();
	Scanner on = new Scanner(System.in);
	int scelta = 0;
	boolean select=false;
	
	System.out.println("Benvenuto nel Programma di Case Vacanze di Milano\n");
	System.out.println("Per funzionare questo programma deve scaricare un file che noi chiameremo \"UnivPm.csv\"");
	System.out.println("Dopo essere scaricato, il programma farà un lavoro di serializzazione per salvare i dati");
	System.out.println("Quindi partiamo, adesso eseguo il tutto e ti chiedero alcune cose. \n");
	
	download.main(args);
	ser.serialize();
	
	System.out.println("Bene adesso abbiamo tutti i dati, possiamo elobolarli");
	System.out.println("Qua sotto ti metto delle opzioni!!\n");
	
	do {
	System.out.println("1-Serializzare i dati su di un file .ser");
	System.out.println("2-Creare un file .json dove verrano salvati i Metadata");
	System.out.println("3-Creare un file .json dove verranno salvati i Data");
	System.out.println("4-Creare un file .json dove verranno salvati i Data utilizzando un filtro scelto da te");
	System.out.println("5-Creare un file .json dove verranno salvati delle statistiche sui valori numerici in base alla tua scelta");
	System.out.println("0-Exit");
	scelta=on.nextInt();
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
