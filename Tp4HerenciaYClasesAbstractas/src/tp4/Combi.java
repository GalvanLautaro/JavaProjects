package tp4;

public class Combi extends VehiculoTransporte  {
	public Combi(String patente, int cantPlazas) {
		super(patente, cantPlazas);
	}
	
	@Override
	public double precioAlquiler(int cantDias) {
		double parcial = super.precioAlquiler(cantDias);
		return (1+(0.02 * cantPlazas)) * baseAlquiler + parcial;
	}
	
}
