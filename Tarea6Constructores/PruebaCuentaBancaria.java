package Tarea6Constructores;

public class PruebaCuentaBancaria {
    public static void main(String[] args) {
        CuentaBancaria c = new CuentaBancaria("Lautaro Galvan", 10000);
		System.out.println(c.saldo);

		c.depositar(5000);
		System.out.println("Cantidad depositos: " + c.getCantidadDepositos());
		System.out.println(c.saldo);
		c.extraer(6000);
		System.out.println("Cantidad extracciones: " + c.getCantidadExtracciones());
		System.out.println(c.saldo);
    }
}
