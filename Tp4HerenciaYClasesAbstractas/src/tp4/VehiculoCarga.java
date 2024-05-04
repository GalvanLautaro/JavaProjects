package tp4;

public abstract class VehiculoCarga extends Vehiculo {
	protected double PMA;
	
	public VehiculoCarga(String patente, double PMA) {
		super(patente);
		this.PMA = PMA;
	}
	public VehiculoCarga() {}
	
	public double getPMA() {
		return PMA;
	}
	public void setPMA(double PMA) {
		this.PMA = PMA;
	}
	
	@Override
	public double precioAlquiler(int cantDias) {
		return baseAlquiler * cantDias * (1+(0.20 * PMA));
	}

}
