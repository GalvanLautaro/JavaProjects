package Tarea5composicion;

public class Prueba1 {
    public static void main(String[] args) {
        Motor m1 = new Motor("SFE23432FREG24", 2500, "REMAX");
        Chasis c1 = new Chasis("FESF342354H44FD", 900);

        System.out.println("Automovil 1: ");
        Automovil a = new Automovil("Peugeot", 2010, m1, c1);
        a.setprecio(350000);
        System.out.println(a);
        double cilindrada = a.getCilindrada();
        System.out.println(cilindrada);

        Motor m2 = new Motor("ERW34234JH45F", 10000, "ULTRAX");
        Chasis c2 = new Chasis("F4334SAER34", 1300);

        System.out.println("Automovil 2: ");
        Automovil a2 = new Automovil("Ford", 2018, m2, c2);
        System.out.println(a2);
    }
}
