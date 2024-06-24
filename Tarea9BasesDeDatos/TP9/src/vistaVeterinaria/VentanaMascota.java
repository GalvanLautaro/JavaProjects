package vistaVeterinaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import persistencia.BDVeterinaria;
import veterinaria.Mascota;

public class VentanaMascota extends JDialog {

	private static final long serialVersionUID = 1L;

	public VentanaMascota() {
        setTitle("Ingresar Datos de Mascota");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setModal(true);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(10, 20, 80, 25);
        panel.add(nombreLabel);

        JTextField nombreField = new JTextField(20);
        nombreField.setBounds(100, 20, 200, 25);
        panel.add(nombreField);

        JLabel animalLabel = new JLabel("Animal:");
        animalLabel.setBounds(10, 60, 80, 25);
        panel.add(animalLabel);

        JTextField animalField = new JTextField(20);
        animalField.setBounds(100, 60, 200, 25);
        panel.add(animalField);

        JLabel fechaNacimientoLabel = new JLabel("Fecha Nacimiento:");
        fechaNacimientoLabel.setBounds(10, 100, 120, 25);
        panel.add(fechaNacimientoLabel);

        JDateChooser fechaNacimientoChooser = new JDateChooser();
        fechaNacimientoChooser.setBounds(150, 105, 150, 20);
        panel.add(fechaNacimientoChooser);
        
        JLabel historiaClinicaLabel = new JLabel("Historia Clínica:");
        historiaClinicaLabel.setBounds(10, 140, 120, 25);
        panel.add(historiaClinicaLabel);

        JTextField historiaClinicaField = new JTextField(20);
        historiaClinicaField.setBounds(150, 140, 150, 25);
        panel.add(historiaClinicaField);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.setBounds(150, 213, 100, 25);
        panel.add(guardarButton);
        
        JLabel IDClienteLabel = new JLabel("ID del Cliente");
        IDClienteLabel.setBounds(10, 177, 120, 25);
        panel.add(IDClienteLabel);
        
        JTextField IDClienteField = new JTextField(20);
        IDClienteField.setBounds(150, 177, 150, 25);
        panel.add(IDClienteField);
        
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String animal = animalField.getText();
                Date fechaNacimiento = fechaNacimientoChooser.getDate();
                String historiaClinica = historiaClinicaField.getText();
                int IDCliente = Integer.parseInt(IDClienteField.getText());

                System.out.println("Datos de la Mascota:");
                System.out.println("Nombre: " + nombre);
                System.out.println("Animal: " + animal);
                System.out.println("Fecha Nacimiento: " + fechaNacimiento);
                System.out.println("Historia Clínica: " + historiaClinica);
                System.out.println("ID del Cliente: " + IDCliente);
                
                try {
                    Mascota mascota = new Mascota(0,nombre, animal, fechaNacimiento, historiaClinica, IDCliente);
                    
                    BDVeterinaria bd = new BDVeterinaria();
                    bd.conectar("jdbc:mysql://localhost:3306/veterinaria", "root", "");
                    bd.almacenarMascota(mascota);
                    bd.desconectar();
                    JOptionPane.showMessageDialog(null, "Mascota guardada con éxito");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }

                dispose();
            }
        });
    }
}
