package vista;

import javax.swing.JFrame;
import paquete.RobotImpresor;
import paquete.RobotPintor;
import paquete.Taller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
    private JTextField mesasField;
    private JButton iniciarButton;
    private JButton finalizarButton;
    private JTextArea resultadosArea;
    private Taller taller;
    private Thread[] robots;
    private boolean simulacionActiva = false;

    public Ventana() {
        setTitle("Simulación de Taller");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel mesasLabel = new JLabel("Número de mesas:");
        mesasLabel.setBounds(10, 10, 150, 25);
        add(mesasLabel);

        mesasField = new JTextField("3");
        mesasField.setBounds(160, 10, 100, 25);
        add(mesasField);

        iniciarButton = new JButton("Iniciar Simulación");
        iniciarButton.setBounds(10, 50, 150, 25);
        add(iniciarButton);

        finalizarButton = new JButton("Finalizar Simulación");
        finalizarButton.setBounds(170, 50, 150, 25);
        add(finalizarButton);

        resultadosArea = new JTextArea();
        resultadosArea.setBounds(10, 90, 360, 150);
        resultadosArea.setEditable(false);
        add(resultadosArea);

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!simulacionActiva) {
                    iniciarSimulacion();
                }
            }
        });

        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (simulacionActiva) {
                    finalizarSimulacion();
                }
            }
        });
    }

    private void iniciarSimulacion() {
        int mesas = Integer.parseInt(mesasField.getText());
        taller = new Taller(mesas);

        robots = new Thread[]{
            new Thread(new RobotPintor(taller)),
            new Thread(new RobotPintor(taller)),
            new Thread(new RobotImpresor(taller)),
            new Thread(new RobotImpresor(taller))
        };

        for (Thread robot : robots) {
            robot.start();
        }

        simulacionActiva = true;
        resultadosArea.setText("Simulación iniciada...\n");
    }

    private void finalizarSimulacion() {
        for (Thread robot : robots) {
            robot.interrupt();
        }
        simulacionActiva = false;

        // Esperar a que todos los hilos terminen
        try {
            for (Thread robot : robots) {
                robot.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Mostrar resultados 
        resultadosArea.append("Simulación finalizada.\n");
        resultadosArea.append("Trabajos de impresores: " + taller.getTrabajosImpresores() + "\n");
        resultadosArea.append("Trabajos de pintores: " + taller.getTrabajosPintores() + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ventana ventana = new Ventana();
            ventana.setVisible(true);
        });
    }
}
