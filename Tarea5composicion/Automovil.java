package Tarea5composicion;

public class Automovil {
    private String marca;
    private int modelo;
    private Motor motor;
    private Chasis chasis;
    private double precio;

    public Automovil(){}
    public Automovil(String m, int mo, Motor mot, Chasis c, double p){
        this.marca = m;
        this.modelo = mo;
        this.motor = mot;
        this.chasis = c;
        this.precio = p;
    }
    public String getMarca() {
        return this.marca;
    }
    public double getModelo() {
        return this.modelo;
    }
    public Motor getMotor() {
        return this.motor;
    }
    public Chasis getChasis() {
        return this.chasis;
    }
    public double getPrecio() {
        return this.precio;
    }
    public void setprecio(double precio) {
        this.precio = precio;
    }
    public String getTipoCombustible() {
        return this.motor.getTipocombustible();
    }
    public double getCilindrada() {
        return this.motor.getCilindrada();
    }
    public String toString() {
        return "Automovil [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + ", chasis=" + chasis + ", precio=" + precio + "]";
    }
}
