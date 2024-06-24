package vistaMundial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Mundial.Encuentro;
import Mundial.Jugador;
import Mundial.Seleccion;
import persistencia.BDMundial;

public class VentanaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public VentanaPrincipal() {
		initialize();
	}

	private void initialize() {
		setTitle("Gestión del Mundial");
        setSize(554, 171);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
		
		JButton btnCrearSeleccion = new JButton("Agregar Seleccion");
		btnCrearSeleccion.setBounds(10, 11, 162, 37);
		btnCrearSeleccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 VentanaSeleccion ventanaSeleccion = new VentanaSeleccion();
                 ventanaSeleccion.setVisible(true);
            }
        });
		getContentPane().add(btnCrearSeleccion);

		JButton btnCrearJugador = new JButton("Agregar Jugador");
		btnCrearJugador.setBounds(188, 11, 162, 37);
		btnCrearJugador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 VentanaJugador ventanaJugador = new VentanaJugador();
                 ventanaJugador.setVisible(true);
            }
        });
		getContentPane().add(btnCrearJugador);
		
		JButton btnOrganizarEncuentro = new JButton("Organizar Encuentro");
		btnOrganizarEncuentro.setBounds(360, 11, 168, 37);
		btnOrganizarEncuentro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 VentanaEncuentro ventanaEncuentro = new VentanaEncuentro();
                 ventanaEncuentro.setVisible(true);
            }
        });
		getContentPane().add(btnOrganizarEncuentro);

		JButton btnListarSeleccion = new JButton("Listar Selecciones");
		btnListarSeleccion.setBounds(10, 76, 162, 37);
		btnListarSeleccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    BDMundial bd = new BDMundial();
                    bd.conectar("jdbc:mysql://localhost:3306/mundial", "root", "");
                    Iterator<Seleccion> it = bd.recuperarSelecciones();
                    StringBuilder sb = new StringBuilder();
                    while (it.hasNext()) {
                        Seleccion s = it.next();
                        sb.append("Nombre: ").append(s.getNombre())
                          .append(", Medallas de Oro: ").append(s.getPalmaresOro())
                          .append(", Medallas de Plata: ").append(s.getPalmaresPlata())
                          .append(", Participaciones: ").append(s.getParticipaciones())
                          .append(", ID: ").append(s.getId())
                          .append("\n");
                    }
                    bd.desconectar();
                    JOptionPane.showMessageDialog(null, sb.toString());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
		getContentPane().add(btnListarSeleccion);
		
		JButton btnListarJugadores = new JButton("Listar Jugadores");
		btnListarJugadores.setBounds(188, 76, 162, 37);
		btnListarJugadores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    BDMundial bd = new BDMundial();
                    bd.conectar("jdbc:mysql://localhost:3306/mundial", "root", "");
                    Iterator<Jugador> it = bd.recuperarJugadores();
                    StringBuilder sb = new StringBuilder();
                    while (it.hasNext()) {
                        Jugador j = it.next();
                        sb.append("Nombre: ").append(j.getNombre())
                          .append(", Edad: ").append(j.getEdad())
                          .append(", Posicion: ").append(j.getPosicion())
                          .append(", Seleccion: ").append(j.getSeleccion())
                          .append(", Goles: ").append(j.getGoles())
                          .append(", Asistencias: ").append(j.getAsistencias())
                          .append(", Tarjetas Amarillas: ").append(j.getTarjetasAmarillas())
                          .append(", Tarjetas Rojas: ").append(j.getTarjetasRojas())
                          .append(", ID: ").append(j.getId())
                          .append("\n");
                    }
                    bd.desconectar();
                    JOptionPane.showMessageDialog(null, sb.toString());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
		getContentPane().add(btnListarJugadores);
		
		JButton btnListarEncuentros = new JButton("Listar Encuentros");
		btnListarEncuentros.setBounds(360, 76, 168, 37);
		btnListarEncuentros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    BDMundial bd = new BDMundial();
                    bd.conectar("jdbc:mysql://localhost:3306/mundial", "root", "");
                    Iterator<Encuentro> it = bd.recuperarEncuentros();
                    StringBuilder sb = new StringBuilder();
                    while (it.hasNext()) {
                        Encuentro en = it.next();
                        sb.append("Equipo Local: ").append(en.getEquipoLocal())
                          .append(", Equipo Visitante: ").append(en.getEquipoVisitante())
                          .append(", Fecha: ").append(en.getFecha())
                          .append(", Hora: ").append(en.getHora())
                          .append(", Lugar: ").append(en.getLugar())
                          .append(", Goles Eq. Local: ").append(en.getGolesLocal())
                          .append(", Goles Eq. Visitante: ").append(en.getGolesVisitante())
                          .append("\n");
                    }
                    bd.desconectar();
                    JOptionPane.showMessageDialog(null, sb.toString());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
		getContentPane().add(btnListarEncuentros);
		
	}
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
}
