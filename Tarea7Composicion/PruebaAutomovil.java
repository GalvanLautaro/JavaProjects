package Tarea7Composicion;

public class PruebaAutomovil {
    public static void main(String[] args) {
        Motor m1 = new Motor("Toyota", 23354255, 2001);
		Automovil a1 = new Automovil("BMW",2015, m1, "fe3 34d", 5000000);

		System.out.println(a1);
    }
}
