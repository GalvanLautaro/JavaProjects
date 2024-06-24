package vistaVeterinaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import persistencia.BDVeterinaria;
import veterinaria.Cliente;

public class VentanaCliente extends JDialog {
	
	private static final long serialVersionUID = 1L;
    public VentanaCliente() {
        setTitle("Ingresar Datos del Cliente");
        setSize(358, 269);
        setLocationRelativeTo(null);
        setModal(true); 

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(21, 21, 80, 25);
        panel.add(nombreLabel);

        JTextField nombreField = new JTextField(20);
        nombreField.setBounds(111, 21, 200, 25);
        panel.add(nombreField);

        JLabel telefonoLabel = new JLabel("Teléfono:");
        telefonoLabel.setBounds(21, 61, 80, 25);
        panel.add(telefonoLabel);

        JTextField telefonoField = new JTextField(20);
        telefonoField.setBounds(111, 61, 200, 25);
        panel.add(telefonoField);

        JLabel direccionLabel = new JLabel("Dirección:");
        direccionLabel.setBounds(21, 101, 80, 25);
        panel.add(direccionLabel);

        JTextField direccionField = new JTextField(20);
        direccionField.setBounds(111, 101, 200, 25);
        panel.add(direccionField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(21, 141, 80, 25);
        panel.add(emailLabel);

        JTextField emailField = new JTextField(20);
        emailField.setBounds(111, 141, 200, 25);
        panel.add(emailField);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.setBounds(111, 194, 100, 25);
        panel.add(guardarButton);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String nombre = nombreField.getText();
                String telefono = telefonoField.getText();
                String direccion = direccionField.getText();
                String email = emailField.getText();

                System.out.println("Datos ingresados:");
                System.out.println("Nombre: " + nombre);
                System.out.println("Teléfono: " + telefono);
                System.out.println("Dirección: " + direccion);
                System.out.println("Email: " + email);
                
                Cliente cliente = new Cliente(0,nombre,telefono,direccion,email);
                try {
                    BDVeterinaria bd = new BDVeterinaria();
                    bd.conectar("jdbc:mysql://localhost:3306/veterinaria", "root", "");
                    bd.almacenarCliente(cliente);
                    bd.desconectar();
                    JOptionPane.showMessageDialog(null, "Cliente guardado con éxito");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
                dispose();
            }
        });
    }
}
