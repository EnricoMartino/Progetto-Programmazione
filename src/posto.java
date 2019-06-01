
public class posto {
	int posti_abitativi;
	int posti_letto;
	int municipio;
	
	
//generate constructor of class "posto"
	public posto(int posti_abitativi, int posti_letto, int municipio) {
		super();
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
}
