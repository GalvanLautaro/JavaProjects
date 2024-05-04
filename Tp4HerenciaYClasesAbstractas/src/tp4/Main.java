package tp4;

public class Main {

	public static void main(String[] args) {
		Auto auto = new Auto("345 HA3", 4);
		Combi combi = new Combi("4A5 54G", 6);
		Camion camion = new Camion("5AS E34", 2.5);
		Camioneta camioneta = new Camioneta("455 DFD", 1.43);
		
		System.out.println("Precio alquiler auto: " + auto.precioAlquiler(15) + "\nPatente: " + auto.patente + "\nCantidad de plazas: " + auto.cantPlazas);
		System.out.println("Precio alquiler combi: " + combi.precioAlquiler(7) + "\nPatente: " + combi.patente + "\nCantidad de plazas: " + combi.cantPlazas);
		System.out.println("Precio alquiler camion: " + camion.precioAlquiler(16) + "\nPatente: " + camion.patente + "\nPMA: " + camion.PMA);
		System.out.println("Precio alquiler camioneta: " + camioneta.precioAlquiler(5) + "\nPatente: " + camioneta.patente + "\nPMA: " + camioneta.PMA);
		
	}

}
