
public class Appartamento {
	String codice;
	String ubicazione;
	String area_di_competenza;
	String descrizione_via;
	int civico;
	int codice_via;
	
	
	//generate constructor of class "Appartamento" 
	public Appartamento(String codice, String ubicazione, String area_di_competenza, String descrizione_via, int civico,
			int codice_via) {
		this.codice = codice;
		this.ubicazione = ubicazione;
		this.area_di_competenza = area_di_competenza;
		this.descrizione_via = descrizione_via;
		this.civico = civico;
		this.codice_via = codice_via;
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

}
