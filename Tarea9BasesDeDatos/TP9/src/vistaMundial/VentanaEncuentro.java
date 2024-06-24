package vistaMundial;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Mundial.Encuentro;
import persistencia.BDMundial;

public class VentanaEncuentro extends JDialog {

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		try {
			VentanaEncuentro dialog = new VentanaEncuentro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public VentanaEncuentro() {
		setTitle("Organizar Encuentro");
		setBounds(100, 100, 256, 233);
		getContentPane().setLayout(null);
			
		JLabel equipoLocalLabel = new JLabel("Equipo Local: ");
		equipoLocalLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		equipoLocalLabel.setBounds(21, 26, 86, 14);
		getContentPane().add(equipoLocalLabel);
		
		JLabel equipoVisitanteLabel = new JLabel("Equipo Visitante: ");
		equipoVisitanteLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		equipoVisitanteLabel.setBounds(21, 51, 105, 14);
		getContentPane().add(equipoVisitanteLabel);
		
		JLabel fechalLabel = new JLabel("Fecha: ");
		fechalLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fechalLabel.setBounds(21, 76, 86, 14);
		getContentPane().add(fechalLabel);
		
		JLabel horaLabel = new JLabel("Hora:");
		horaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		horaLabel.setBounds(21, 101, 86, 14);
		getContentPane().add(horaLabel);

		JTextField equipoLocalField = new JTextField();
		equipoLocalField.setBounds(127, 24, 86, 22);
		getContentPane().add(equipoLocalField);
		
		JTextField equipoVisitanteField = new JTextField();
		equipoVisitanteField.setBounds(127, 49, 86, 22);
		getContentPane().add(equipoVisitanteField);
		
		JDateChooser fechaDChooser = new JDateChooser();
		fechaDChooser.setBounds(127, 76, 86, 20);
		getContentPane().add(fechaDChooser);
		
		JTextField horaField = new JTextField();
		horaField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		horaField.setColumns(10);
		horaField.setBounds(127, 100, 86, 20);
		getContentPane().add(horaField);
		
		JLabel lugarLabel = new JLabel("Lugar:");
		lugarLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lugarLabel.setBounds(21, 126, 86, 14);
		getContentPane().add(lugarLabel);
		
		JTextField lugarField = new JTextField();
		lugarField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lugarField.setBounds(127, 125, 86, 20);
		getContentPane().add(lugarField);
		lugarField.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(70, 156, 89, 23);
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				String equipoLocal = equipoLocalField.getText();
				String equipoVisitante = equipoVisitanteField.getText();
				Date fecha = fechaDChooser.getDate();
				SimpleDateFormat formato = new SimpleDateFormat("HH:mm");
				Time hora = null;
				try {
					hora = new Time(formato.parse(horaField.getText()).getTime());
				} catch (ParseException e2) {
					e2.printStackTrace();
				}
				String lugar = lugarField.getText();
				
				System.out.println("Datos ingresados:");
				System.out.println("Equipo local: " + equipoLocal);
				System.out.println("Equipo Visitante: " + equipoVisitante);
				System.out.println("Fecha: " + fecha);
				System.out.println("Hora: " + hora);
				System.out.println("Lugar: " + lugar);
            
				Encuentro encuentro = new Encuentro(0, equipoLocal, equipoVisitante, fecha, hora, lugar);
				String golesLocalStr = JOptionPane.showInputDialog("Ingrese la cantidad de goles del eq. Local:");
				String golesVisitanteStr = JOptionPane.showInputDialog("Ingrese la cantidad de goles del eq. Visitante:");
				int golesLocal = Integer.parseInt(golesLocalStr);
				int golesVisitante = Integer.parseInt(golesVisitanteStr);
				encuentro.setGolesLocal(golesLocal);
				encuentro.setGolesVisitante(golesVisitante);
				try {
					BDMundial bd = new BDMundial();
					bd.conectar("jdbc:mysql://localhost:3306/Mundial", "root", "");
					bd.almacenarEncuentro(encuentro);
					bd.desconectar();
					JOptionPane.showMessageDialog(null, "Encuentro organizado con éxito");
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
            dispose();
			}
		});
		getContentPane().add(btnGuardar);
	}
}
