
public class Posto extends Appartamento {
	int posti_abitativi;
	int posti_letto;
	int municipio;
	
	
//generate constructor of class "posto"
	public Posto(String codice, String ubicazione, String area_di_competenza, String descrizione_via, int civico,
			int codice_via, int posti_abitativi, int posti_letto, int municipio) {
		super(codice, ubicazione, area_di_competenza, descrizione_via, civico, codice_via);
		this.posti_abitativi = posti_abitativi;
		this.posti_letto = posti_letto;
		this.municipio = municipio;
	}

	
//generate getters and setters of class "posto"
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
	@Override
	public String toString() {
		return "posto [posti_abitativi=" + posti_abitativi + ", posti_letto=" + posti_letto + ", municipio=" + municipio
				+ "]";
	}
}
