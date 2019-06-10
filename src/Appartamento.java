import java.io.*;

public class Appartamento implements Serializable {
	String codice;
	String ubicazione;
	String area_di_competenza;
	String descrizione_via;
	int civico;
	int codice_via;
	int posti_abitativi;
	int posti_letto;
	int municipio;
	double longitudine;
	double latitudine;
	double location;
	
	
	
	//generate constructor of class "Appartamento" 
	public Appartamento(String codice, String ubicazione, String area_di_competenza, String descrizione_via, int civico,
			int codice_via, int posti_abitativi, int posti_letto, int municipio, double longitudine, double latitudine,
			double location) {
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
	
	public Appartamento()  {
		//Constructor
	}
	@Override
	public String toString() {
		return "Appartamento [codice=" + codice + ", ubicazione=" + ubicazione + ", area_di_competenza="
				+ area_di_competenza + ", descrizione_via=" + descrizione_via + ", civico=" + civico + ", codice_via="
				+ codice_via + ", posti_abitativi=" + posti_abitativi + ", posti_letto=" + posti_letto + ", municipio="
				+ municipio + ", longitudine=" + longitudine + ", latitudine=" + latitudine + ", location=" + location
				+ "]";
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

	public int getCivico() {
		return civico;
	}

	public void setCivico(int civico) {
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
	public double getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(double longitudine) {
		this.longitudine = longitudine;
	}
	public double getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(double latitudine) {
		this.latitudine = latitudine;
	}
	public double getLocation() {
		return location;
	}
	public void setLocation(double location) {
		this.location = location;
	}

}
