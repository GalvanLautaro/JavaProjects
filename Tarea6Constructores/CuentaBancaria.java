package Tarea6Constructores;

public class CuentaBancaria {
    public String titularr;
	public double saldo;
	public int cantidadDepositos;
	public int cantidadExtracciones;

	public CuentaBancaria(String titular, double saldo) {
		this.titularr = titular;
		this.saldo = saldo;
	}

	public String getTitular() {
		return titularr;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getCantidadDepositos() {
		return cantidadDepositos;
	}

	public int getCantidadExtracciones() {
		return cantidadExtracciones;
	}

	public void depositar(double cantidad) {
		this.saldo += cantidad;
		this.cantidadDepositos++;
	}

	public boolean extraer(double cantidad) {
		boolean flag = false;
		if(cantidad <= this.saldo) {
			this.saldo-=cantidad;
			this.cantidadExtracciones++;
			flag = true;
			}

		return flag;
	}

	public String toString() {
		return "CuentaBancaria [Titular=" + titularr + ", saldo=" + saldo + ", cantidadDepositos=" + cantidadDepositos
				+ ", cantidadExtracciones=" + cantidadExtracciones + "]";
	}


}
