package modulo;
import java.util.Scanner;

public class Matematica {
	/*public int promedio(int a, int b){
		return ((a+b)/2);
	}
	public int promedioDeTres(int a, int b, int c) {
		return (a+b+c)/2;
	}*/
	
	private float PI = 3.1416F;	
	public float getPI() {
		return this.PI;
	}
	public double area(int radio) {
		return this.PI * Math.pow(radio, 2);
	}
	public double diametro(int radio) {
		float PI;
		return 2*(Math.sqrt((area(radio) / PI)));
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		/*System.out.print("Ingrese a: ");
		int a = scanner.nextInt();
		System.out.print("Ingrese b: ");
		int b = scanner.nextInt();
		System.out.println("Ingrese c: ");
		int c = scanner.nextInt();*/
		System.out.println("Radio del circulo: ");
		int radio = scanner.nextInt();
		
		
		Matematica m = new Matematica();
		/*System.out.println("Valor a: " + a);
		System.out.println("Valor b: " + b);
		System.out.println("Valor c: " + c);
		System.out.println("El promedio es: " + m.promedioDeTres(a, b, c));
		System.out.println("Valor de PI: " + m.getPI());*/
		System.out.println("Valor del area: " + m.area(radio));
		System.out.println("Valor de diametro: " + m.diametro(radio));
	}
}
