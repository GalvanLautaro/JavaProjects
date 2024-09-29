package paquete;

public class Taller {
	private final int mesasDeTrabajo;
    private int mesasOcupadas = 0;
    private boolean adornoImpreso = false;
    private int trabajosImpresores = 0;
    private int trabajosPintores = 0;

    public Taller(int mesas) {
        this.mesasDeTrabajo = mesas;
    }

    public synchronized void imprimir() throws InterruptedException {
        while (mesasOcupadas >= mesasDeTrabajo || adornoImpreso) {
            wait(); // Esperar si no hay mesas disponibles o el adorno ya está impreso
        }
        mesasOcupadas++;
        System.out.println("Impresor está usando la mesa");
        Thread.sleep(1000); // Simula el trabajo realizado
        System.out.println("Impresor terminó de usar la mesa");
        mesasOcupadas--;
        adornoImpreso = true; // Marcar que el adorno está impreso
        trabajosImpresores++; // Incrementar conteo de trabajos de impresores
        notifyAll(); // Notifica a los pintores que el adorno está listo
    }

    public synchronized void pintar() throws InterruptedException {
        while (mesasOcupadas >= mesasDeTrabajo || !adornoImpreso) {
            wait(); // Esperar si no hay mesas disponibles o el adorno no está impreso
        }
        mesasOcupadas++;
        System.out.println("Pintor está usando la mesa");
        Thread.sleep(1000); // Simula el trabajo realizado
        System.out.println("Pintor terminó de usar la mesa");
        mesasOcupadas--;
        adornoImpreso = false; // Restablecer el estado para el siguiente adorno
        trabajosPintores++; // Incrementar conteo de trabajos de pintores
        notifyAll(); // Notifica a los impresores que la mesa está disponible
    }

    // Métodos para obtener el número de trabajos realizados
    public int getTrabajosImpresores() {
        return trabajosImpresores;
    }

    public int getTrabajosPintores() {
        return trabajosPintores;
    }
}
