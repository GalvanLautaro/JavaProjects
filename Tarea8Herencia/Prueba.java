package Tarea8Herencia;

public class Prueba {
    public static void main(String[] args) {
        Arquero a = new Arquero("Esqueleto", new Posicion(10,4));
		Guerrero g = new Guerrero("Señor ceniza", new Posicion(12,5));
		Caballero c = new Caballero("Golem", new Posicion(15,3));

		System.out.println(a);
		System.out.println(g);
		System.out.println(c);

		a.ataca(c);
		c.ataca(g);
		g.ataca(a);
		a.moverse(new Posicion(15,7));

		System.out.println("-----------");

		System.out.println(a);
		System.out.println(g);
		System.out.println(c);

		a.recuperarFlechas();

		System.out.println("-----------");

		System.out.println(a);
		System.out.println(g);
		System.out.println(c);
    }
}
