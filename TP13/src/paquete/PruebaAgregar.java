package paquete;

import java.sql.SQLException;
import java.util.GregorianCalendar;

public class PruebaAgregar {

    // Ejemplo para agregar una nueva persona 
    private static BD baseDatos;

    public static void main(String[] args) throws Exception {
        
        try {
            baseDatos = new BD();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // Agrega una persona
        Persona p1 = new Persona("Carolina Montes");
        p1.setTelefono("155-237698");
        p1.setFecha(new GregorianCalendar(1989, 5, 4));
        
        try {
            baseDatos.almacenarPersona(p1);
            System.out.println("Se guardó con éxito la persona: " + p1);
        } catch (SQLException e) {
            System.out.println("Error al guardar la persona: " + e.getMessage());
        }

        // Agrega otra persona 
        Persona p2 = new Persona("Pepito Lopez");
        p2.setTelefono("123-456789");
        p2.setFecha(new GregorianCalendar(1992, 7, 15)); // Agosto es el mes 7

        try {
            baseDatos.almacenarPersona(p2);
            System.out.println("Se guardó con éxito la persona: " + p2);
        } catch (SQLException e) {
            System.out.println("Error al guardar la persona: " + e.getMessage());
        }
    }
}