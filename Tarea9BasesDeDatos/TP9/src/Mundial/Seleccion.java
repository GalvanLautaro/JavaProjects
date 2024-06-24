package Mundial;

public class Seleccion {
	private int id;
    private String nombre;
    private int palmaresOro;
    private int palmaresPlata;
    private int participaciones;
    public Seleccion() {}
	public Seleccion(int id,String nombre, int palmaresOro, int palmaresPlata, int participaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.palmaresOro = palmaresOro;
		this.palmaresPlata = palmaresPlata;
		this.participaciones = participaciones;
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
	public int getPalmaresOro() {
		return palmaresOro;
	}
	public void setPalmaresOro(int palmaresOro) {
		this.palmaresOro = palmaresOro;
	}
	public int getPalmaresPlata() {
		return palmaresPlata;
	}
	public void setPalmaresPlata(int palmaresPlata) {
		this.palmaresPlata = palmaresPlata;
	}
	public int getParticipaciones() {
		return participaciones;
	}
	public void setParticipaciones(int participaciones) {
		this.participaciones = participaciones;
	}	
}
