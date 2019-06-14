package com.example;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Data {
	
	private BufferedReader br;
	
	private List<Appartamento> appList = new ArrayList<>();
	
	public Data(String str) {
		super();
		try {
			this.br = new BufferedReader(new FileReader(str));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gnegne() {
		Appartamento app = new Appartamento("", "", "", "", "", "", "", "", "", "", "", "");
		System.out.println(app.getCivico().getClass().toString());
		appList.stream().filter(e -> e.getCivico().equals("3")).collect(Collectors.toList());
		
		System.out.println(appList);
		
	}
	

}
