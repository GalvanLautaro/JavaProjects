package Tarea5composicion;

public class Jugador {
    private String nombre;
    private int edad;
    private String posicion;
    private double efectividad;

    public Jugador(){}
    public Jugador(String n, int e, String p, double ef) {
        this.nombre = n;
        this.edad = e;
        this.posicion = p;
        this.efectividad = ef;
    }
    public String getNombre() {
        return this.nombre;
    }
    public int getEdad() {
        return this.edad;
    }
    public String getPosicion() {
        return this.posicion;
    }
    public double getEfectividad() {
        return this.efectividad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    public void setEfectividad(double efectividad) {
        this.efectividad = efectividad;
    }
    public String toString() {
        return "Jugador [nombre=" + nombre + ", edad=" + edad + ", posicion=" + posicion + ", efectividad=" + efectividad + "]";
    }
}
