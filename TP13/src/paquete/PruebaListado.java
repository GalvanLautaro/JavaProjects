package paquete;

import java.sql.SQLException;
import java.util.Iterator;

public class PruebaListado {
	// Ejemplo de lectura de la BD 
	
		private static BD baseDatos;
		public static void main(String[] args) throws Exception{
		 try {
			 baseDatos = new BD();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		 
		 Iterator<Persona> it = null;
		 try{
			 baseDatos.conectar("jdbc:mysql://localhost:3306/agenda", "root", "");
			 it = (Iterator<Persona>) baseDatos.recuperarPersonas();
			 baseDatos.desconectar();
		} 
		 
		 catch (SQLException e)
		{
		// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		 while (it.hasNext())
		{
			Persona p = it.next();
			System.out.println(p);
		}
	  }
}
