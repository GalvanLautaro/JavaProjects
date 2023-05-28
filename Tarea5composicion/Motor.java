package Tarea5composicion;

public class Motor {
    private String nSerie;
    private double cilindrada;
    private String tipoCombustible;

    public Motor(){}
    public Motor(String nS, double c, String tC) {
        this.nSerie = nS;
        this.cilindrada = c;
        this.tipoCombustible = tC;
    }
    public String getNSerie() {
        return this.nSerie;
    }
    public double getCilindrada() {
        return this.cilindrada;
    }
    public String getTipocombustible() {
        return this.tipoCombustible;
    }
    public String toString() {
        return "Motor [nSerie=" + nSerie + ", cilindrada=" + cilindrada + ", tipoCombustible=" + tipoCombustible + "]";
    }
}
