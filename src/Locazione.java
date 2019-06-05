
public class Locazione extends Appartamento {

	double longitudine;
	double latitudine;
	double location;
	
	
//generate constructor of class "locazione"
	
	//generate getters and setters of class "locazione"
	public double getLongitudine() {
		return longitudine;
	}
	public Locazione(String codice, String ubicazione, String area_di_competenza, String descrizione_via, int civico,
		int codice_via, double longitudine, double latitudine, double location) {
	super(codice, ubicazione, area_di_competenza, descrizione_via, civico, codice_via);
	this.longitudine = longitudine;
	this.latitudine = latitudine;
	this.location = location;
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
	
	@Override
	public String toString() {
		return "locazione [longitudine=" + longitudine + ", latitudine=" + latitudine + ", location=" + location + "]";
	}

}
