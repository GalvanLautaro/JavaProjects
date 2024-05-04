package tp4;

public abstract class Vehiculo {
	protected String patente;
	protected static int baseAlquiler = 500;
	
	public Vehiculo(String patente) {
		this.patente = patente;
		baseAlquiler = 500;
	}
	public Vehiculo() {}

	public abstract double precioAlquiler(int cantDias);
	
	@Override 
	
	public String toString() {
		return "Vehiculo patente=" + patente;  
	}
	
}
