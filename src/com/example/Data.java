package com.example;
/**
 * The Data class return data (JSON format)
 *  and show filters 
 * shows the data selection filters by customers who decide to 
 * filter the houses based on their characteristics
 * With a switch case the customer can name a file
 *  and choose whether to filter a string or an integer
 *  Then the customer can choose can choose from the keyboard to filter :Posti letto, Codice via, Municipio, Posti abitativi
 * @author Enrico Pio Martino
 * @author Luca Munerati
 * 
 */
//some imports needed to read write and import files
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Data {
	// created and initialized a private String JSON_FILE_NAME
	private static final String JSON_FILE_NAME = "getData.json";
	// created and initialized a private String JSON_FILE_NAME_FILTER
	private static final String JSON_FILE_NAME_FILTER = "getDataFilter";
	// created and initialized a String JSON_FILE_NAME_FILTER_SUMMINMAXAVG
	private static final String JSON_FILE_NAME_FILTER_SUMMINMAXAVG = "getDataFilterMAXMINAVGSUM";

	private Serialization s = new Serialization(); // inizialized a private Serialization called "s"
	List<Appartamento> call = s.serialize(); // list of type Appartamento called "call"

	public void toJsonData() {

		try {
			// open a buffer writer of JSON_FILE_NAME
			BufferedWriter w = new BufferedWriter(new FileWriter(JSON_FILE_NAME));
			List<String> l = call.stream().map(a -> a.toString()).collect(Collectors.toList());
			Iterator<String> it = l.iterator();

			while (it.hasNext()) { // while there is other elements keep going
				w.write("{");
				w.newLine();
				w.write(it.next());
				w.write("},\n");

			}
			w.newLine();
			w.close(); // close the BuffreWriter

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int ritornaDato(int a) {
		boolean flag1 = false;
		Scanner in = new Scanner(System.in);
		do {
			flag1 = true;
			try {
				a = in.nextInt();
			} catch (Exception e) {
				System.out.println("Inserire un numero intero");
				flag1 = false;
				in.nextLine();
			}
		} while (!flag1);
		return a;
	}
	
	public String ritornaStringa(String app) {
		Scanner in = new Scanner(System.in);
		app = in.nextLine();
		return app;
	}
	
	
	  public void ritornaFile(Iterator<Appartamento> a,String str) { 
		  try {
			  System.out.println("Dammi il nome che vuoi mettere al file");
			  String appoggio = null;
			  appoggio=this.ritornaStringa(str);
			  BufferedWriter w = new BufferedWriter(new FileWriter(JSON_FILE_NAME_FILTER+appoggio+".json"));
			  while (a.hasNext()) {// while there is other elements keep going
			    	w.write("{");
					w.newLine();
					w.write(a.next().toString()); //put the data on file
					w.write("},\n");
			 }
		 	w.newLine();
	 		w.close();	
     		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	  }
	  

	  public void jsonDataFilter() {
		boolean select = false;
		boolean select2 = false;
		boolean select3 = false;
		int choice = 0;
		int choice2 = 0;
		int choice3 = 0;
		int primo = 0;
		int secondo = 0;
		String str="NULL";
		do {
			System.out.println("Scegli che tipo di filtro vuoi fare" + "Si posssono utilizzare questi campi:"
					+ "\n1-Filtro Su Stringa\n2-Filtro su numero");
			choice = this.ritornaDato(choice);
			switch (choice) {
				case 1:
					do {
							System.out.println("Scegliere il campo di utilizzo del filrto\n"
									+ "Si posssono utilizzare questi campi:" + "\n1-Civico\n2-Ubicazione");
							choice2 = this.ritornaDato(choice2);
							switch (choice2) {
							case 1:
								String a;
								System.out.println("Dammi la stringa da ricercare per il civico");
								a = this.ritornaStringa(str);
								List <Appartamento> list = call.stream().filter(e -> e.getCivico().equals(a)).collect(Collectors.toList());
								Iterator<Appartamento> iter = list.iterator(); // Iterator creation to scroll the Appartamento list
								System.out.println("\nGli elementi trovati per questo filtro sono: \t" + list.size()); // print the created items
								this.ritornaFile(iter,str);	
								select2 = true;
								break;
							case 2:
								String b;
								System.out.println("Dammi la stringa da ricercare per l'ubicazione");
								b = this.ritornaStringa(str);
								List <Appartamento> list2 = call.stream().filter(e -> e.getUbicazione().equals(b)).collect(Collectors.toList());
								Iterator<Appartamento> iter2 = list2.iterator(); // Iterator creation to scroll the Appartamento list
								System.out.println("\nGli elementi trovati per questo filtro sono: \t" + list2.size()); // print the  created items
								this.ritornaFile(iter2,str);							
								select2 = true;
								break;
							}
						} while (!select2);
						select=true;
						break;
				case 2:
					do {
						System.out.println("Scegliere il campo di utilizzo del filtro\n"
								+ "Si posssono utilizzare questi campi:" + "\n1-Posti Abitativi\n2-Posti Letto");
						choice3 = this.ritornaDato(choice3);
						switch(choice3) {
						case 1: 
							int dato;
							int dato2;
							System.out.println("\nSara una compare >=primonumero <=secondonumero (scelto) \nPrimo numero:\t");
							dato = this.ritornaDato(primo);
							System.out.println("Secondo numero:\t");
							dato2 = this.ritornaDato(secondo);
							List<Appartamento> l = call.stream().filter(a -> a.getPosti_abitativi() >= dato && a.getPosti_abitativi()<=dato2).collect(Collectors.toList());// Use of stream and collections to create a filter of Appartamento list
							Iterator<Appartamento> it = l.iterator(); // Iterator creation to scroll the Appartamento list
							System.out.println("\nGli elementi trovati per questo filtro sono: \t" + l.size()); // print the size of created items
							this.ritornaFile(it,str);
							select3=true;
							break;
						case 2:
							int dato3;
							int dato4;
							System.out.println("\nSara una compare >=primonumero <=secondonumero (scelto) \nPrimo numero:\t");
							dato3 = this.ritornaDato(primo);
							System.out.println("Secondo numero:\t");
							dato4 = this.ritornaDato(secondo);
							List<Appartamento> l2 = call.stream().filter(a -> a.getPosti_letto() >= dato3 && a.getPosti_letto()<=dato4).collect(Collectors.toList());// Use of stream and collections to create a filter of Appartamento list
							Iterator<Appartamento> it2 = l2.iterator(); // Iterator creation to scroll the Appartamento list
							System.out.println("\nGli elementi trovati per questo filtro sono: \t" + l2.size()); // print the size of created items
							this.ritornaFile(it2,str);
							select3=true;
							break;
						}
					}while(!select3);
				select=true;
			}
			} while (!select);
			System.out.println("E' stato creato il file json con il filtro ");
	}
	
// return a String due the choice of the user
	public String scelta(int a) {
		String str = "";
		if (a == 1) {
			str = " Posti Letto";
		} else if (a == 2) {
			str = " Codice Via";
		} else if (a == 3) {
			str = " Municipio";
		} else if (a == 4) {
			str = " Posti Abitativi";
		}
		return str;
	}

	public void jsonDataSumAvgMinMaxCount() throws IOException {
		// initialized variables sum, count, choise to 0 //json file
		// initialized variables avg, max, min to null
		int sum = 0;
		OptionalDouble avg = null;
		OptionalInt max = null;
		OptionalInt min = null;
		long count = 0;
		int choice = 0;
		Scanner in = new Scanner(System.in);
		boolean validSelection = false;
		// let you choose between different filter fields
		do {
			System.out.println("Scegliere il campo di utilizzo del filto\n" + "Si posssono utilizzare questi campi:"
					+ "\n1-Posti letto\n2-Codice via\n3-Municipio\n4-Posti abitativi");
			choice = in.nextInt(); // let write your choice
			// based on the choice switch case of 'choice' starts with the 4 possible cases
			switch (choice) {
			case 1:
				sum = call.stream().filter(p -> p.getPosti_letto() != -1).mapToInt(Appartamento::getPosti_letto).sum();
				avg = call.stream().filter(p -> p.getPosti_letto() != -1).mapToInt(Appartamento::getPosti_letto)
						.average();
				max = call.stream().filter(p -> p.getPosti_letto() != -1).mapToInt(Appartamento::getPosti_letto).max();
				min = call.stream().filter(p -> p.getPosti_letto() != -1).mapToInt(Appartamento::getPosti_letto).min();
				validSelection = true;
				break;
			case 2:
				sum = call.stream().filter(p -> p.getCodice_via() != -1).mapToInt(Appartamento::getCodice_via).sum();
				avg = call.stream().filter(p -> p.getCodice_via() != -1).mapToInt(Appartamento::getCodice_via)
						.average();
				max = call.stream().filter(p -> p.getCodice_via() != -1).mapToInt(Appartamento::getCodice_via).max();
				min = call.stream().filter(p -> p.getCodice_via() != -1).mapToInt(Appartamento::getCodice_via).min();
				count = call.stream().filter(p -> p.getCodice_via() != -1).mapToInt(Appartamento::getCodice_via)
						.count();
				validSelection = true;
				break;
			case 3:
				sum = call.stream().filter(p -> p.getMunicipio() != -1).mapToInt(Appartamento::getMunicipio).sum();
				avg = call.stream().filter(p -> p.getMunicipio() != -1).mapToInt(Appartamento::getMunicipio).average();
				max = call.stream().filter(p -> p.getMunicipio() != -1).mapToInt(Appartamento::getMunicipio).max();
				min = call.stream().filter(p -> p.getMunicipio() != -1).mapToInt(Appartamento::getMunicipio).min();
				count = call.stream().filter(p -> p.getMunicipio() != -1).mapToInt(Appartamento::getMunicipio).count();
				validSelection = true;
				break;
			case 4:
				sum = call.stream().filter(p -> p.getPosti_abitativi() != -1).mapToInt(Appartamento::getPosti_abitativi).sum();
				avg = call.stream().filter(p -> p.getPosti_abitativi() != -1).mapToInt(Appartamento::getPosti_abitativi).average();
				max = call.stream().filter(p -> p.getPosti_abitativi() != -1).mapToInt(Appartamento::getPosti_abitativi).max();
				min = call.stream().filter(p -> p.getPosti_abitativi() != -1).mapToInt(Appartamento::getPosti_abitativi).min();
				count = call.stream().filter(p -> p.getPosti_abitativi() != -1).mapToInt(Appartamento::getPosti_abitativi).count();
				validSelection = true;
				break;
			}
		} while (validSelection != true);
		// in.close(); //close input stream
		// based on the choice prints the filtered data
		BufferedWriter w = new BufferedWriter(new FileWriter(JSON_FILE_NAME_FILTER_SUMMINMAXAVG+this.scelta(choice)+".json"));// open Buffer
		// to write on a
		w.write("{");
		w.newLine();
		w.write("\"Field\":" + this.scelta(choice));
		w.write("\n\"Sum\":" + sum);
		w.write("\n\"Avg\":" + avg);
		w.write("\n\"Max\":" + max);
		w.write("\n\"Min\":" + min);
		w.write("\n\"Count\":" + count);
		w.write("\n}");
		w.newLine();
		w.close();
		System.out.println("File " + JSON_FILE_NAME_FILTER_SUMMINMAXAVG+this.scelta(choice)+".json" + "creato");
	}

	// generate getter and setter of Serialization 's'
	public Serialization getS() {
		return s;
	}

	public void setS(Serialization s) {
		this.s = s;
	}

	public static String getJsonFileName() {
		return JSON_FILE_NAME;
	}


}