
public class locazione {

	double longitudine;
	double latitudine;
	double location;
	
	
//generate constructor of class "locazione"
	public locazione(double longitudine, double latitudine, double location) {
		super();
		this.longitudine = longitudine;
		this.latitudine = latitudine;
		this.location = location;
	}
	//generate getters and setters of class "locazione"
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
	
	@Override
	public String toString() {
		return "locazione [longitudine=" + longitudine + ", latitudine=" + latitudine + ", location=" + location + "]";
	}

}
