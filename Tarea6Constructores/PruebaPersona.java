package Tarea6Constructores;

public class PruebaPersona {
    public static void main(String[] args) {
		Persona p = new Persona("Lautaro", 17, "lautarogalvanTYT@gmail.com");

		System.out.println(p);

		p.setEdad(19);
		p.setEmail("lautigalvan300@gmail.com");
		System.out.println(p);
	}
}
