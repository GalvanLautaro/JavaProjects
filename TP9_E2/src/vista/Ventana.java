package vista;

import javax.swing.*;

import paquete.BD;
import paquete.Encuentro;
import paquete.Jugador;
import paquete.Seleccion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;

public class Ventana extends JFrame {
    private JTextField seleccionNombreField, seleccionOroField, seleccionPlataField, seleccionParticipacionesField;
    private JTextField jugadorNombreField, jugadorEdadField, jugadorPosicionField, jugadorSeleccionField;
    private JTextField jugadorGolesField, jugadorAsistenciasField, jugadorRojasField, jugadorAmarillasField;
    private JTextField encuentroLocalField, encuentroVisitanteField, encuentroFechaField, encuentroHoraField;
    private JTextField encuentroLugarField, encuentroGolesLocalField, encuentroGolesVisitanteField;
    private JTextArea outputArea;

    private BD baseDatos;
	private static final long serialVersionUID = 1L;
    
    public Ventana() {
        try {
            baseDatos = new BD();
            baseDatos.conectar("jdbc:mysql://localhost:3306/mundial", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        setTitle("Mundial Qatar 2022");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Selecciones", crearPanelSeleccion());
        tabbedPane.addTab("Jugadores", crearPanelJugador());
        tabbedPane.addTab("Encuentros", crearPanelEncuentro());

        add(tabbedPane, BorderLayout.CENTER);

        outputArea = new JTextArea();
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel crearPanelSeleccion() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Nombre de Selección:"));
        seleccionNombreField = new JTextField();
        panel.add(seleccionNombreField);

        panel.add(new JLabel("Medallas de Oro:"));
        seleccionOroField = new JTextField();
        panel.add(seleccionOroField);

        panel.add(new JLabel("Medallas de Plata:"));
        seleccionPlataField = new JTextField();
        panel.add(seleccionPlataField);

        panel.add(new JLabel("Cantidad de Participaciones:"));
        seleccionParticipacionesField = new JTextField();
        panel.add(seleccionParticipacionesField);

        JButton insertButton = new JButton("Insertar Selección");
        insertButton.addActionListener(new InsertarSeleccionListener());
        panel.add(insertButton);

        JButton retrieveButton = new JButton("Recuperar Selecciones");
        retrieveButton.addActionListener(new RecuperarSeleccionesListener());
        panel.add(retrieveButton);

        return panel;
    }

    private JPanel crearPanelJugador() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));

        panel.add(new JLabel("Nombre de Jugador:"));
        jugadorNombreField = new JTextField();
        panel.add(jugadorNombreField);

        panel.add(new JLabel("Edad:"));
        jugadorEdadField = new JTextField();
        panel.add(jugadorEdadField);

        panel.add(new JLabel("Posición:"));
        jugadorPosicionField = new JTextField();
        panel.add(jugadorPosicionField);

        panel.add(new JLabel("Seleccion:"));
        jugadorSeleccionField = new JTextField();
        panel.add(jugadorSeleccionField);

        panel.add(new JLabel("Goles:"));
        jugadorGolesField = new JTextField();
        panel.add(jugadorGolesField);

        panel.add(new JLabel("Asistencias:"));
        jugadorAsistenciasField = new JTextField();
        panel.add(jugadorAsistenciasField);


        panel.add(new JLabel("Tarjetas Amarillas:"));
        jugadorAmarillasField = new JTextField();
        panel.add(jugadorAmarillasField);
        
        panel.add(new JLabel("Tarjetas Rojas:"));
        jugadorRojasField = new JTextField();
        panel.add(jugadorRojasField);


        JButton insertButton = new JButton("Insertar Jugador");
        insertButton.addActionListener(new InsertarJugadorListener());
        panel.add(insertButton);

        JButton retrieveButton = new JButton("Recuperar Jugadores");
        retrieveButton.addActionListener(new RecuperarJugadoresListener());
        panel.add(retrieveButton);

        return panel;
    }

    private JPanel crearPanelEncuentro() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));

        panel.add(new JLabel("Equipo Local:"));
        encuentroLocalField = new JTextField();
        panel.add(encuentroLocalField);

        panel.add(new JLabel("Equipo Visitante:"));
        encuentroVisitanteField = new JTextField();
        panel.add(encuentroVisitanteField);

        panel.add(new JLabel("Fecha (YYYY-MM-DD):"));
        encuentroFechaField = new JTextField();
        panel.add(encuentroFechaField);

        panel.add(new JLabel("Hora (HH:MM:SS):"));
        encuentroHoraField = new JTextField();
        panel.add(encuentroHoraField);

        panel.add(new JLabel("Lugar:"));
        encuentroLugarField = new JTextField();
        panel.add(encuentroLugarField);

        panel.add(new JLabel("Goles Local:"));
        encuentroGolesLocalField = new JTextField();
        panel.add(encuentroGolesLocalField);

        panel.add(new JLabel("Goles Visitante:"));
        encuentroGolesVisitanteField = new JTextField();
        panel.add(encuentroGolesVisitanteField);

        JButton insertButton = new JButton("Insertar Encuentro");
        insertButton.addActionListener(new InsertarEncuentroListener());
        panel.add(insertButton);

        JButton retrieveButton = new JButton("Recuperar Encuentros");
        retrieveButton.addActionListener(new RecuperarEncuentrosListener());
        panel.add(retrieveButton);

        return panel;
    }

    private class InsertarSeleccionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = seleccionNombreField.getText();
            int oro = Integer.parseInt(seleccionOroField.getText());
            int plata = Integer.parseInt(seleccionPlataField.getText());
            int participaciones = Integer.parseInt(seleccionParticipacionesField.getText());

            Seleccion seleccion = new Seleccion(0, nombre, oro, plata, participaciones);

            try {
                baseDatos.almacenarSeleccion(seleccion);
                outputArea.append("Selección insertada: " + nombre + "\n");
            } catch (SQLException ex) {
                outputArea.append("Error al insertar selección: " + ex.getMessage() + "\n");
            }
        }
    }

    private class InsertarJugadorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = jugadorNombreField.getText();
            int edad = Integer.parseInt(jugadorEdadField.getText());
            String posicion = jugadorPosicionField.getText();
            String seleccion = jugadorSeleccionField.getText();
            int goles = Integer.parseInt(jugadorGolesField.getText());
            int asistencias = Integer.parseInt(jugadorAsistenciasField.getText());
            int rojas = Integer.parseInt(jugadorRojasField.getText());
            int amarillas = Integer.parseInt(jugadorAmarillasField.getText());

            Jugador jugador = new Jugador(0, nombre, edad, posicion, seleccion, goles, asistencias, rojas, amarillas);

            try {
                baseDatos.almacenarJugador(jugador);
                outputArea.append("Jugador insertado: " + nombre + "\n");
            } catch (SQLException ex) {
                outputArea.append("Error al insertar jugador: " + ex.getMessage() + "\n");
            }
        }
    }

    private class InsertarEncuentroListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String equipoLocal = encuentroLocalField.getText();
            String equipoVisitante = encuentroVisitanteField.getText();
            java.sql.Date fecha = java.sql.Date.valueOf(encuentroFechaField.getText());
            java.sql.Time hora = java.sql.Time.valueOf(encuentroHoraField.getText());
            String lugar = encuentroLugarField.getText();

            Encuentro encuentro = new Encuentro(0, equipoLocal, equipoVisitante, fecha, hora, lugar);

            try {
                baseDatos.almacenarEncuentro(encuentro);
                outputArea.append("Encuentro insertado: " + equipoLocal + " vs " + equipoVisitante + "\n");
            } catch (SQLException ex) {
                outputArea.append("Error al insertar encuentro: " + ex.getMessage() + "\n");
            }
        }
    }

    private class RecuperarSeleccionesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Iterator<Seleccion> selecciones = baseDatos.recuperarSelecciones();
                while (selecciones.hasNext()) {
                    Seleccion seleccion = selecciones.next();
                    outputArea.append("Selección: " + seleccion.getNombre() + ", Oro: " + seleccion.getPalmaresOro() + ", Plata: " + seleccion.getPalmaresPlata() + ", Participaciones: " + seleccion.getParticipaciones() + "\n");
                }
            } catch (SQLException ex) {
                outputArea.append("Error al recuperar selecciones: " + ex.getMessage() + "\n");
            }
        }
    }

    private class RecuperarJugadoresListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Iterator<Jugador> jugadores = baseDatos.recuperarJugadores();
                while (jugadores.hasNext()) {
                    Jugador jugador = jugadores.next();
                    outputArea.append("Jugador: " + jugador.getNombre() + ", Edad: " + jugador.getEdad() + ", Posición: " + jugador.getPosicion() + ", Selección: " + jugador.getSeleccion() + "\n");
                }
            } catch (SQLException ex) {
                outputArea.append("Error al recuperar jugadores: " + ex.getMessage() + "\n");
            }
        }
    }

    private class RecuperarEncuentrosListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Iterator<Encuentro> encuentros = baseDatos.recuperarEncuentros();
                while (encuentros.hasNext()) {
                    Encuentro encuentro = encuentros.next();
                    outputArea.append("Encuentro: " + encuentro.getEquipoLocal() + " vs " + encuentro.getEquipoVisitante() + ", Fecha: " + encuentro.getFecha() + ", Hora: " + encuentro.getHora() + ", Lugar: " + encuentro.getLugar() + "\n");
                }
            } catch (SQLException ex) {
                outputArea.append("Error al recuperar encuentros: " + ex.getMessage() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ventana());
    }
}