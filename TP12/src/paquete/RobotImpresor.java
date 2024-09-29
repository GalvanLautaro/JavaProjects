package paquete;

public class RobotImpresor implements Runnable {
	private Taller taller;

    public RobotImpresor(Taller taller) {
        this.taller = taller;
    }

    @Override
    public void run() {
        try {
            while (true) {
                taller.imprimir();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
