package Tarea5composicion;

public class Chasis {
    private String nChasis;
    private double peso;

    public Chasis(){}
    public Chasis(String nC, double p) {
        this.nChasis = nC;
        this.peso = p;
    }
    public String getChasis() {
        return this.nChasis;
    }
    public double getPeso() {
        return this.peso;
    }
    public String toString() {
        return "Chasis [nChasis=" + nChasis + ", peso=" + peso + "]";
    }
}

