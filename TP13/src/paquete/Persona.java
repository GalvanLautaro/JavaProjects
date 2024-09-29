package paquete;

import java.util.GregorianCalendar;

public class Persona {
	private String nombre;
	private GregorianCalendar fecha;
	private String telefono;
	
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + telefono + ", Fecha de Nacimiento: " + 
               fecha.get(GregorianCalendar.DAY_OF_MONTH) + "/" + 
               (fecha.get(GregorianCalendar.MONTH) + 1) + "/" + 
               fecha.get(GregorianCalendar.YEAR);
    }
}
