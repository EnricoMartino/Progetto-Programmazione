package com.example;
import java.io.*;
import java.util.List;

//class "Appartamento" 

public class Appartamento implements Serializable {
	String codice;
	String ubicazione;
	String area_di_competenza;
	String descrizione_via;
	String civico;  //String because "civico" can include letters
	int codice_via;
	int posti_abitativi;
	int  posti_letto;
	int municipio;
	String longitudine;
	String latitudine;
	String location;
	

	//Generate constructors of class "Appartamento" 
	public Appartamento(String codice, String ubicazione, String area_di_competenza, String descrizione_via, String civico,
			int codice_via, int posti_abitativi, int posti_letto, int municipio, String longitudine, String latitudine,
			String location) {
		this.codice = codice;
		this.ubicazione = ubicazione;
		this.area_di_competenza = area_di_competenza;
		this.descrizione_via = descrizione_via;
		this.civico = civico;
		this.codice_via = codice_via;
		this.posti_abitativi = posti_abitativi;
		this.posti_letto = posti_letto;
		this.municipio = municipio;
		this.longitudine = longitudine;
		this.latitudine = latitudine;
		this.location = location;
	}
	//created list "home" with features of class "appartamento"
	public Appartamento( final List<String> home)  {
		this(home.get(0),home.get(1),home.get(2),home.get(3),home.get(4),Integer.parseInt(home.get(5)),Integer.parseInt(home.get(6)),
				Integer.parseInt(home.get(7)),Integer.parseInt(home.get(8)),home.get(9),home.get(10),home.get(11));
	}
	
	public Appartamento() {
		super();
	}
	//Override of "appartamento"
	@Override
	public String toString() {
		return "\"codice\": \"" + codice + "\",\n \"ubicazione\": \"" + ubicazione + "\",\n \"area_di_competenza\": \""
				+ area_di_competenza + "\",\n \"descrizione_via\": \"" + descrizione_via + "\",\n \"civico\": \"" + civico + "\",\n \"codice_via\": \""
				+ codice_via + "\",\n \"posti_abitativi\": \"" + posti_abitativi + "\"\n \"posti_letto\": \"" + posti_letto + "\",\n \" municipio\": \""
					+ municipio + "\",\n \"longitudine\": \"" + longitudine + "\",\n \"latitudine\": \"" + latitudine + "\",\n \"location\": \"" + location + "\"\n";
		}
	
	
	/*
	 * public String toString() { return "Appartamento [codice=" + codice +
	 * ", ubicazione=" + ubicazione + ", area_di_competenza=" + area_di_competenza +
	 * ", descrizione_via=" + descrizione_via + ", civico=" + civico +
	 * ", codice_via=" + codice_via + ", posti_abitativi=" + posti_abitativi +
	 * ", posti_letto=" + posti_letto + ", municipio=" + municipio +
	 * ", longitudine=" + longitudine + ", latitudine=" + latitudine + ", location="
	 * + location + "]"; }
	 */
	
	
	//Generate getters and setters of class "Appartamento"
	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getUbicazione() {
		return ubicazione;
	}

	public void setUbicazione(String ubicazione) {
		this.ubicazione = ubicazione;
	}

	public String getArea_di_competenza() {
		return area_di_competenza;
	}

	public void setArea_di_competenza(String area_di_competenza) {
		this.area_di_competenza = area_di_competenza;
	}

	public String getDescrizione_via() {
		return descrizione_via;
	}

	public void setDescrizione_via(String descrizione_via) {
		this.descrizione_via = descrizione_via;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public int getCodice_via() {
		return codice_via;
	}

	public void setCodice_via(int codice_via) {
		this.codice_via = codice_via;
	}
	public int getPosti_abitativi() {
		return posti_abitativi;
	}
	public void setPosti_abitativi(int posti_abitativi) {
		this.posti_abitativi = posti_abitativi;
	}
	public int getPosti_letto() {
		return posti_letto;
	}
	public void setPosti_letto(int posti_letto) {
		this.posti_letto = posti_letto;
	}
	public int getMunicipio() {
		return municipio;
	}
	public void setMunicipio(int municipio) {
		this.municipio = municipio;
	}
	public String getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(String longitudine) {
		this.longitudine = longitudine;
	}
	public String getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(String latitudine) {
		this.latitudine = latitudine;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
