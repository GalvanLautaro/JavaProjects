package SOIII.Repaso;

public class Prueba {
    public static void main(String[] args) {
        Persona p = new Persona("Lautaro", 17);
        Empleado e = new Empleado("Matias", 23, 250000);

        System.out.println(p.getName());
        System.out.println(p.getAge());

        System.out.println(e.getName());
        System.out.println(e.getAge());
        System.out.println(e.getSueldo());
    }
}
