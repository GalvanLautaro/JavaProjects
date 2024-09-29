package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import paquete.BD;
import paquete.Cliente;
import paquete.Mascota;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private BD bd;
	    
		// Constructor
		public Ventana() {
        super("Veterinaria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        try {
            bd = new BD();
            bd.conectar("jdbc:mysql://localhost:3306/veterinaria", "root", ""); // Modifica la URL, usuario y contraseña según tu BD
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error conectando a la base de datos: " + e.getMessage());
            System.exit(1);
        }

        // Panel para gestionar clientes
        JPanel panelClientes = new JPanel();
        panelClientes.setLayout(new GridLayout(0, 2));

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblTelefono = new JLabel("Teléfono:");
        JTextField txtTelefono = new JTextField();
        JLabel lblDireccion = new JLabel("Dirección:");
        JTextField txtDireccion = new JTextField();
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();
        JButton btnGuardarCliente = new JButton("Guardar Cliente");

        panelClientes.add(lblNombre);
        panelClientes.add(txtNombre);
        panelClientes.add(lblTelefono);
        panelClientes.add(txtTelefono);
        panelClientes.add(lblDireccion);
        panelClientes.add(txtDireccion);
        panelClientes.add(lblEmail);
        panelClientes.add(txtEmail);
        panelClientes.add(new JLabel()); // Empty cell
        panelClientes.add(btnGuardarCliente);

        // Panel para gestionar mascotas
        JPanel panelMascotas = new JPanel();
        panelMascotas.setLayout(new GridLayout(0, 2));

        JLabel lblMascotaNombre = new JLabel("Nombre Mascota:");
        JTextField txtMascotaNombre = new JTextField();
        JLabel lblAnimal = new JLabel("Animal:");
        JTextField txtAnimal = new JTextField();
        JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
        JTextField txtFechaNacimiento = new JTextField();
        JLabel lblHistoriaClinica = new JLabel("Historia Clínica:");
        JTextField txtHistoriaClinica = new JTextField();
        JLabel lblClienteId = new JLabel("ID Cliente:");
        JTextField txtClienteId = new JTextField();
        JButton btnGuardarMascota = new JButton("Guardar Mascota");

        panelMascotas.add(lblMascotaNombre);
        panelMascotas.add(txtMascotaNombre);
        panelMascotas.add(lblAnimal);
        panelMascotas.add(txtAnimal);
        panelMascotas.add(lblFechaNacimiento);
        panelMascotas.add(txtFechaNacimiento);
        panelMascotas.add(lblHistoriaClinica);
        panelMascotas.add(txtHistoriaClinica);
        panelMascotas.add(lblClienteId);
        panelMascotas.add(txtClienteId);
        panelMascotas.add(new JLabel()); // Empty cell
        panelMascotas.add(btnGuardarMascota);

        // Agregar los paneles a la ventana principal
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Clientes", panelClientes);
        tabbedPane.add("Mascotas", panelMascotas);

        add(tabbedPane, BorderLayout.CENTER);

        // Action listeners
        btnGuardarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cliente cliente = new Cliente(0, txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText(), txtEmail.getText());
                    bd.almacenarCliente(cliente);
                    JOptionPane.showMessageDialog(Ventana.this, "Cliente guardado con éxito.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(Ventana.this, "Error guardando cliente: " + ex.getMessage());
                }
            }
        });

        btnGuardarMascota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Mascota mascota = new Mascota(0, txtMascotaNombre.getText(), txtAnimal.getText(), java.sql.Date.valueOf(txtFechaNacimiento.getText()), txtHistoriaClinica.getText(), Integer.parseInt(txtClienteId.getText()));
                    bd.almacenarMascota(mascota);
                    JOptionPane.showMessageDialog(Ventana.this, "Mascota guardada con éxito.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(Ventana.this, "Error guardando mascota: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
	    
}
