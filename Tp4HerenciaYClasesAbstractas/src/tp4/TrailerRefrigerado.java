package tp4;

public class TrailerRefrigerado extends Trailer {
	protected double alquilerTrailer;
	private int temperaturaMinima;
	
	public TrailerRefrigerado(int temMin) {
		this.alquilerTrailer = 250;
		this.temperaturaMinima = temMin;
	}

	public int getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public void setTemperaturaMinima(int temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}
}
