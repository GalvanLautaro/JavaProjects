package veterinaria;

import java.util.Date;

public class Practica {
    private int id;
    private String descripcion;
    private Date fecha;
    private Date fechaVencimiento;
    private String comentarios;
    private int mascotaId;
    public Practica(String descripcion, Date fecha, Date fechaVencimiento, String comentarios, int mascotaId) {
		super();
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.fechaVencimiento = fechaVencimiento;
		this.comentarios = comentarios;
		this.mascotaId = mascotaId;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(int mascotaId) {
        this.mascotaId = mascotaId;
    }
}