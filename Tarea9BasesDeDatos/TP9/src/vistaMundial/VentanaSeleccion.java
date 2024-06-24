package vistaMundial;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Mundial.Seleccion;
import persistencia.BDMundial;

public class VentanaSeleccion extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			VentanaSeleccion dialog = new VentanaSeleccion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VentanaSeleccion() {
		setTitle("Ingresar datos de Seleccion");
		setBounds(100, 100, 307, 271);
		getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel NombreLabel = new JLabel("Nombre:");
		NombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NombreLabel.setBounds(24, 29, 74, 21);
		contentPanel.add(NombreLabel);
		
		JLabel MedallasOroLabel = new JLabel("Medallas de Oro:");
		MedallasOroLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MedallasOroLabel.setBounds(24, 61, 108, 21);
		contentPanel.add(MedallasOroLabel);
		
		JLabel MedallasDePlataLabel = new JLabel("Medallas de Plata:");
		MedallasDePlataLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MedallasDePlataLabel.setBounds(24, 93, 108, 21);
		contentPanel.add(MedallasDePlataLabel);
		
		JLabel ParticipacionLabel = new JLabel("Can. Participaciones:");
		ParticipacionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ParticipacionLabel.setBounds(24, 125, 134, 21);
		contentPanel.add(ParticipacionLabel);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setBounds(94, 181, 89, 23);
		contentPanel.add(btnGuardar);
		
		JTextField nombreField = new JTextField();
		nombreField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nombreField.setBounds(94, 31, 165, 20);
		contentPanel.add(nombreField);
		nombreField.setColumns(10);
		
		JTextField medallasOroField = new JTextField();
		medallasOroField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		medallasOroField.setBounds(151, 63, 108, 20);
		contentPanel.add(medallasOroField);
		medallasOroField.setColumns(10);
		
		JTextField medallasPlataField = new JTextField();
		medallasPlataField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		medallasPlataField.setColumns(10);
		medallasPlataField.setBounds(151, 95, 108, 20);
		contentPanel.add(medallasPlataField);
		
		JTextField ParticipacionesField = new JTextField();
		ParticipacionesField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ParticipacionesField.setColumns(10);
		ParticipacionesField.setBounds(151, 127, 108, 20);
		contentPanel.add(ParticipacionesField);
	

		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				String nombre = nombreField.getText();
				int medallasOro = Integer.parseInt(medallasOroField.getText());
				int medallasPlata = Integer.parseInt(medallasPlataField.getText());
				int participaciones = Integer.parseInt(ParticipacionesField.getText());

				System.out.println("Datos ingresados:");
				System.out.println("Nombre: " + nombre);
				System.out.println("Medallas de Oro: " + medallasOro);
				System.out.println("Medallas de Plata: " + medallasPlata);
				System.out.println("Participaciones: " + participaciones);
            
				Seleccion seleccion = new Seleccion(0,nombre,medallasOro,medallasPlata,participaciones);
				try {
					BDMundial bd = new BDMundial();
					bd.conectar("jdbc:mysql://localhost:3306/Mundial", "root", "");
					bd.almacenarSeleccion(seleccion);
					bd.desconectar();
					JOptionPane.showMessageDialog(null, "Seleccion guardada con éxito");
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
            dispose();
        	}
		});
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
