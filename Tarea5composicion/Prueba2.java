package Tarea5composicion;

public class Prueba2 {
    public static void main(String[] args) {
        Equipo e = new Equipo("Patucos");

        e.agregarJugador(new Jugador("Lautaro", 20, "Defensa", 7.1));
        e.agregarJugador(new Jugador("Maximo", 19, "Delantero", 9.0));
        e.agregarJugador(new Jugador("Chaza", 15, "Portero", 5.0));
        System.out.println(e);
        System.out.println(e.getCantidadJugadores());
        System.out.println(e.promedioEdad());
        System.out.println(e.promedioMayoresEdad());
        System.out.println(e.promedioMenoresEdad());
    }
}
