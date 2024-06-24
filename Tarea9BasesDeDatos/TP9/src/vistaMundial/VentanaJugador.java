package vistaMundial;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Mundial.Jugador;
import persistencia.BDMundial;

public class VentanaJugador extends JDialog {

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		try {
			VentanaJugador dialog = new VentanaJugador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public VentanaJugador() {
		setTitle("Ingresar Datos Jugador");
		setBounds(100, 100, 224, 321);
		getContentPane().setLayout(null);
			JLabel nombreLabel = new JLabel("Nombre:");
			nombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			nombreLabel.setBounds(22, 24, 62, 17);
			getContentPane().add(nombreLabel);
		
			JLabel edadLabel = new JLabel("Edad:");
			edadLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			edadLabel.setBounds(22, 51, 46, 14);
			getContentPane().add(edadLabel);
		
			JLabel posicionLabel = new JLabel("Posicion:");
			posicionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			posicionLabel.setBounds(22, 77, 62, 14);
			getContentPane().add(posicionLabel);
		
			JLabel seleccionLabel = new JLabel("Seleccion:");
			seleccionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			seleccionLabel.setBounds(22, 102, 62, 14);
			getContentPane().add(seleccionLabel);
		
			JTextField nombreField = new JTextField();
			nombreField.setBounds(104, 24, 86, 20);
			getContentPane().add(nombreField);
			nombreField.setColumns(10);
			
			JTextField edadField = new JTextField();
			edadField.setBounds(104, 50, 86, 20);
			getContentPane().add(edadField);
		
			JTextField posicionField = new JTextField();
			posicionField.setBounds(104, 76, 86, 20);
			getContentPane().add(posicionField);
			posicionField.setColumns(10);
		
			JTextField seleccionField = new JTextField();
			seleccionField.setBounds(104, 101, 86, 20);
			getContentPane().add(seleccionField);
			seleccionField.setColumns(10);
		
			JLabel golesLabel = new JLabel("Goles:");
			golesLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			golesLabel.setBounds(22, 126, 62, 14);
			getContentPane().add(golesLabel);
			
			JLabel asistenciasLabel = new JLabel("Asistencias:");
			asistenciasLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			asistenciasLabel.setBounds(22, 151, 75, 14);
			getContentPane().add(asistenciasLabel);
			
			JLabel tarjetasAmarillasLabel = new JLabel("Tarjetas Amarillas");
			tarjetasAmarillasLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tarjetasAmarillasLabel.setBounds(22, 176, 112, 14);
			getContentPane().add(tarjetasAmarillasLabel);
			
			JLabel tarjetasRojasLabel = new JLabel("Tarjetas Rojas: ");
			tarjetasRojasLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tarjetasRojasLabel.setBounds(22, 201, 96, 14);
			getContentPane().add(tarjetasRojasLabel);
			
			JTextField golesField = new JTextField();
			golesField.setColumns(10);
			golesField.setBounds(104, 125, 86, 20);
			getContentPane().add(golesField);
			
			JTextField asistenciasField = new JTextField();
			asistenciasField.setColumns(10);
			asistenciasField.setBounds(104, 150, 86, 20);
			getContentPane().add(asistenciasField);
			
			JTextField tarjetasAmarillasField = new JTextField();
			tarjetasAmarillasField.setColumns(10);
			tarjetasAmarillasField.setBounds(134, 175, 56, 20);
			getContentPane().add(tarjetasAmarillasField);
			
			JTextField tarjetasRojasField = new JTextField();
			tarjetasRojasField.setColumns(10);
			tarjetasRojasField.setBounds(134, 201, 56, 20);
			getContentPane().add(tarjetasRojasField);
			
			JButton btnGuardar = new JButton("Guardar");
			btnGuardar.setBounds(59, 229, 89, 23);
			btnGuardar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e){
	                String nombre = nombreField.getText();
	                int edad = Integer.parseInt(edadField.getText());
	                String posicion = posicionField.getText();
	                String seleccion = seleccionField.getText();
	                int goles = Integer.parseInt(golesField.getText());
	                int asistencias = Integer.parseInt(asistenciasField.getText());
	                int tarjetasAmarillas = Integer.parseInt(tarjetasAmarillasField.getText());
	                int tarjetasRojas = Integer.parseInt(tarjetasRojasField.getText());
	                
	                System.out.println("Datos ingresados:");
	                System.out.println("Nombre: " + nombre);
	                System.out.println("Edad: " + edad);
	                System.out.println("Posicion: " + posicion);
	                System.out.println("Seleccion: " + seleccion);
	                System.out.println("Goles: " + goles);
	                System.out.println("Asistencias: " + asistencias);
	                System.out.println("Tarjetas Amarillas: " + tarjetasAmarillas);
	                System.out.println("Tarjetas Rojas: " + tarjetasRojas);

	                Jugador jugador = new Jugador(0, nombre, edad, posicion, seleccion, goles, asistencias, tarjetasAmarillas, tarjetasRojas);
	                try {
	                    BDMundial bd = new BDMundial();
	                    bd.conectar("jdbc:mysql://localhost:3306/Mundial", "root", "");
	                    bd.almacenarJugador(jugador);
	                    bd.desconectar();
	                    JOptionPane.showMessageDialog(null, "Jugador guardado con éxito");
	                } catch (SQLException ex) {
	                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	                }
	                dispose();
	            }
	        });
			getContentPane().add(btnGuardar);
			
	}
}