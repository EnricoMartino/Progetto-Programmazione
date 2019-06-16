package com.example;
import java.io.*;



public class Appartamento implements Serializable {
	String codice;
	String ubicazione;
	String area_di_competenza;
	String descrizione_via;
	String civico;
	String codice_via;
	String posti_abitativi;
	String  posti_letto;
	String municipio;
	String longitudine;
	String latitudine;
	String location;
	
	
	
	//generate constructor of class "Appartamento" 
	public Appartamento(String codice, String ubicazione, String area_di_competenza, String descrizione_via, String civico,
			String codice_via, String posti_abitativi, String posti_letto, String municipio, String longitudine, String latitudine,
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
	
	public Appartamento( final String[] home)  {
		this(home[0],home[1],home[2],home[3],home[4],home[5],home[6],home[7],home[8],home[9],home[10],home[11]);
	}
	
	public Appartamento() {
		super();
	}

	@Override
	public String toString() {
		return "\"codice\": \"" + codice + "\",\n \"ubicazione\": \"" + ubicazione + "\",\n \"area_di_competenza\": \""
				+ area_di_competenza + "\",\n \"descrizione_via\": \"" + descrizione_via + "\",\n \"civico\": \"" + civico + "\",\n \"codice_via\": \""
				+ codice_via + "\",\n \"posti_abitativi\": \"" + posti_abitativi + "\"\n \"posti_letto\": \"" + posti_letto + "\",\n \" municipio\": \""
					+ municipio + "\",\n \"longitudine\": \"" + longitudine + "\",\n \"latitudine\": \"" + latitudine + "\",\n \"location\": \"" + location + "\"\n";
		}
	//generate getters and setters of class "Appartamento"
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

	public String getCodice_via() {
		return codice_via;
	}

	public void setCodice_via(String codice_via) {
		this.codice_via = codice_via;
	}
	public String getPosti_abitativi() {
		return posti_abitativi;
	}
	public void setPosti_abitativi(String posti_abitativi) {
		this.posti_abitativi = posti_abitativi;
	}
	public String getPosti_letto() {
		return posti_letto;
	}
	public void setPosti_letto(String posti_letto) {
		this.posti_letto = posti_letto;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
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
