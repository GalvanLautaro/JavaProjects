package Tarea6Constructores;

public class PruebaGuerrero {
   public static void main(String[] args) {
    Guerrero guerrero1 = new Guerrero("Guerrero1");
    System.out.println("Nombre del guerrero: " + guerrero1.getNombre());
    System.out.println("Vitalidad: " + guerrero1.getVitalidad());
    System.out.println("Armadura: " + guerrero1.getArmadura());

    guerrero1.mover(10.2, 7.3);
    System.out.println("Posicion X: " + guerrero1.getX());
    System.out.println("Posicion Y: " + guerrero1.getY());

    guerrero1.recibirDanio(400);
    System.out.println("Vitalidad despues de recibir danio: " + guerrero1.getVitalidad());
    System.out.println("Armadura despues de recibir danio: " + guerrero1.getArmadura());

    Guerrero guerrero2 = new Guerrero("Guerrero2", 15.0, 20.0);
    System.out.println("Nombre del guerrero: " + guerrero2.getNombre());
    System.out.println("Vitalidad: " + guerrero2.getVitalidad());
    System.out.println("Armadura: " + guerrero2.getArmadura());
    System.out.println("Posición X: " + guerrero2.getX());
    System.out.println("Posición Y: " + guerrero2.getY());
   }
}
