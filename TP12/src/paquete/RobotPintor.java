package paquete;

public class RobotPintor implements Runnable {
	private Taller taller;

    public RobotPintor(Taller taller) {
        this.taller = taller;
    }

    @Override
    public void run() {
        try {
            while (true) {
                taller.pintar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
