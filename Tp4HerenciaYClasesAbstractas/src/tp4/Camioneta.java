package tp4;

public class Camioneta extends VehiculoCarga {
	public Camioneta(String patente, double PMA) {
		super(patente, PMA);
	}
	
	@Override
	public double precioAlquiler(int cantDias) {
		double parcial = super.precioAlquiler(cantDias);
		
		return(baseAlquiler * (1+(0.40 * PMA)) + parcial);
	}
}
