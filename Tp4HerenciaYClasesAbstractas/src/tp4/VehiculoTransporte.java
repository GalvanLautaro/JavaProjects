package tp4;

public abstract class VehiculoTransporte extends Vehiculo {
	protected int cantPlazas;

	public VehiculoTransporte(String patente, int cantPlazas) {
		super(patente);
		this.cantPlazas = cantPlazas;
	}

	public VehiculoTransporte() {
	}

	public int getCantPlazas() {
		return cantPlazas;
	}

	public void setCantPlazas(int cantPlazas) {
		this.cantPlazas = cantPlazas;
	}

	@Override
	public double precioAlquiler(int cantDias) {
		return (cantDias * (1 + (0.015 * cantPlazas)) * baseAlquiler);
	}
}
