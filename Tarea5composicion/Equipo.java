package Tarea5composicion;

import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

    public Equipo(){}
    public Equipo(String n) {
        this.nombre = n;
    }
    public void agregarJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }
    public void eliminarJugador(Jugador jugador) {
        this.jugadores.remove(jugador);
    }
    public int getCantidadJugadores() {
        return this.jugadores.size();
    }
    public String getNombre() {
        return this.nombre;
    }
    public double promedioEdad() {
        int sum = 0;
        double prom;

        for(int i = 0; i < this.jugadores.size(); i++) {
            Jugador j = this.jugadores.get(i);
            sum += j.getEdad();
        }

        prom = sum / this.jugadores.size();
        return prom;
    }
    public double promedioMayoresEdad() {
        int sum = 0;
        int mayores = 0;
        double prom;

        for(int i = 0; i < this.jugadores.size(); i++) {
            Jugador j = this.jugadores.get(i);
            if(j.getEdad() > 17) {
                mayores++;
                sum += j.getEdad();
            }
         }

        prom = sum / mayores;
        return prom;
    }
    public double promedioMenoresEdad() {
        int sum = 0;
        int menores = 0;
        double prom;

        for(int i = 0; i < this.jugadores.size(); i++) {
            Jugador j = this.jugadores.get(i);
            if(j.getEdad() < 18) {
                menores++;
                sum += j.getEdad();
            }
         }

        prom = sum / menores;
        return prom;
    }
    public double efectividadEquipo() {
        double sum = 0;

        for(int i = 0; i < this.jugadores.size(); i++) {
            Jugador j = this.jugadores.get(i);
            sum += j.getEfectividad();
        }

        return sum;
    }
    public String toString() {
        return "Equipo [nombre=" + nombre + ", jugadores=" + jugadores + "]";
    }
}
