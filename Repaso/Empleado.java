package SOIII.Repaso;

public class Empleado extends Persona {

    private int sueldo;
    public Empleado(String name, int age, int sueldo) {
        super(name, age);
        this.sueldo = sueldo;
    }
    
    public int getSueldo() {
        return sueldo;
    }
    
}
