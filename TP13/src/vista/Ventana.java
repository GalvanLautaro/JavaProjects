package vista;

import javax.swing.*;
import paquete.BD;
import paquete.Persona;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private BD baseDatos;
    private JFrame frame;
    private JTextField nombreField;
    private JTextField telefonoField;
    private JTextField diaField;
    private JTextField mesField;
    private JTextField anioField;
    private JTextArea contactosArea;
    
    public Ventana() throws SQLException {
        baseDatos = new BD();
        baseDatos.conectar("jdbc:mysql://localhost:3306/agenda", "root", "");

        frame = new JFrame("Registro de Contactos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        panel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        panel.add(telefonoField);

        panel.add(new JLabel("Día de Nacimiento:"));
        diaField = new JTextField();
        panel.add(diaField);

        panel.add(new JLabel("Mes de Nacimiento:"));
        mesField = new JTextField();
        panel.add(mesField);

        panel.add(new JLabel("Año de Nacimiento:"));
        anioField = new JTextField();
        panel.add(anioField);

        JButton agregarButton = new JButton("Agregar Contacto");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					agregarContacto();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        panel.add(agregarButton);

        JButton listarButton = new JButton("Listar Contactos");
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					listarContactos();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        panel.add(listarButton);

        contactosArea = new JTextArea();
        contactosArea.setEditable(false);

        frame.getContentPane().add(BorderLayout.CENTER, new JScrollPane(contactosArea));
        frame.getContentPane().add(BorderLayout.NORTH, panel);

        frame.setVisible(true);
    }

    private void agregarContacto() throws Exception {
        String nombre = nombreField.getText();
        String telefono = telefonoField.getText();
        int dia = Integer.parseInt(diaField.getText());
        int mes = Integer.parseInt(mesField.getText()) - 1; // Los meses en GregorianCalendar empiezan en 0
        int anio = Integer.parseInt(anioField.getText());
        
        Persona persona = new Persona(nombre);
        persona.setTelefono(telefono);
        persona.setFecha(new GregorianCalendar(anio, mes, dia));
        
        try {
            baseDatos.almacenarPersona(persona);
            JOptionPane.showMessageDialog(frame, "Contacto agregado con éxito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Error al agregar el contacto: " + e.getMessage());
        }
    }

    private void listarContactos() throws Exception {
        contactosArea.setText("");
        try {
            Iterator<Persona> it = (Iterator<Persona>) baseDatos.recuperarPersonas();
            while (it.hasNext()) {
                Persona p = it.next();
                contactosArea.append(p.toString() + "\n");
            }
        } catch (SQLException e) {
            contactosArea.setText("Error al recuperar contactos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            new Ventana();
        } catch (SQLException e) {
            System.out.println("Error al iniciar la aplicación: " + e.getMessage());
        }
    }
}
