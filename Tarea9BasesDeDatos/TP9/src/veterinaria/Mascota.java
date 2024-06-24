package veterinaria;

import java.util.Date;

public class Mascota {
    private int id;
    private String nombre;
    private String animal;
    private Date fechaNacimiento;
    private String historiaClinica;
    private int clienteId;
    public Mascota(int id,String nombre, String animal, Date fechaNacimiento, String historiaClinica, int clienteId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.animal = animal;
		this.fechaNacimiento = fechaNacimiento;
		this.historiaClinica = historiaClinica;
		this.clienteId = clienteId;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(String historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
}

