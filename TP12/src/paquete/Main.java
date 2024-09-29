package paquete;

public class Main {

	public static void main(String[] args) {
		
		final int mesas = 3;

        Taller taller = new Taller(mesas);

        Thread pintor1 = new Thread(new RobotPintor(taller));
        Thread pintor2 = new Thread(new RobotPintor(taller));
        Thread impresor1 = new Thread(new RobotImpresor(taller));
        Thread impresor2 = new Thread(new RobotImpresor(taller));

        pintor1.start();
        pintor2.start();
        impresor1.start();
        impresor2.start();
	}
}
