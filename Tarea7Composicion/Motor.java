package Tarea7Composicion;

public class Motor {
    public String marcaMotor;
	public int numeroMotor;
	public int cilindrada;

	public Motor(String marcaMotor, int numeroMotor, int cilindrada) {
		this.marcaMotor = marcaMotor;
		this.numeroMotor = numeroMotor;
		this.cilindrada = cilindrada;
	}
	public String getMarcaMotor() {
		return marcaMotor;
	}
	public int getNumeroMotor() {
		return numeroMotor;
	}
	public int getCilindrada() {
		return cilindrada;
	}

	public String toString() {
		return "Motor [marcaMotor=" + marcaMotor + ", numeroMotor=" + numeroMotor + ", cilindrada=" + cilindrada + "]";
	}

}
