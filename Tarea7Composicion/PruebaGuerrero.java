package Tarea7Composicion;

public class PruebaGuerrero {
    public static void main(String[] args) {
        Posicion posicionInicial = new Posicion(0.0, 0.0);
        Arma arma = new Arma("Espada",  150.0, 20.0);
        Arma arma2 = new Arma("Arco", 220.0, 80.0);
        Armadura armadura = new Armadura("Escudo", 100.0);
        Guerrero warrior = new Guerrero("Warrior", posicionInicial.getX(), posicionInicial.getY());

        warrior.equiparArma(arma);
        warrior.equiparArmadura(armadura);
        System.out.println(warrior);
        warrior.mueve(5.0, 3.0);
        System.out.println("Nueva posicion: (" + warrior.getX() + ", " + warrior.getY() + ")");
        warrior.recibirDmg(81);
        System.out.println("Vitalidad despues de recibir damage: " + warrior.getVitalidad() + "HP y " + warrior.getNivelDefensa()+ "Armor");
        warrior.equiparArma(arma2);
        warrior.setX(20);
        warrior.setY(-12);
        System.out.println(warrior);
        System.out.println("Nueva posicion: (" + warrior.getX() + ", " + warrior.getY() + ")");

    }
}