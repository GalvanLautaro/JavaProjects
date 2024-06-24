package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Mundial.Encuentro;
import Mundial.Jugador;
import Mundial.Seleccion;

public class BDMundial {
	private Connection conexion = null;

    public BDMundial() throws SQLException {
        System.out.println("Iniciando programa.");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo cargar el puente JDBC-ODBC.");
            return;
        }
    }
    public void conectar(String direccion, String usuario, String contrasena) throws SQLException {
        this.conexion = DriverManager.getConnection(direccion, usuario, contrasena);
    }
    
    public void almacenarSeleccion(Seleccion seleccion) throws SQLException {
    	String sql = "INSERT INTO selecciones (id,nombre, medallasOro, medallasPlata, participaciones) VALUES (?,?, ?, ?, ?)";
    	try (PreparedStatement agregar = this.conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
    		agregar.setInt(1, seleccion.getId());
            agregar.setString(2, seleccion.getNombre());
            agregar.setInt(3, seleccion.getPalmaresOro());
            agregar.setInt(4, seleccion.getPalmaresPlata());
            agregar.setInt(5, seleccion.getParticipaciones());
            agregar.executeUpdate();

            try (ResultSet generatedKeys = agregar.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                	seleccion.setId(generatedKeys.getInt(1));
                }
            }
        }
    }
    public Iterator<Seleccion> recuperarSelecciones() throws SQLException { 
    	List<Seleccion> listadoSelecciones = new ArrayList<>();
    	
    	String sql = "SELECT * FROM selecciones ORDER BY nombre";
    	try (Statement sentencia = conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery(sql)) {
               while (resultado.next()) {
                   int id = resultado.getInt("id");
                   String nombre = resultado.getString("nombre");
                   int medallasOro = resultado.getInt("medallasOro");
                   int medallasPlata = resultado.getInt("medallasPlata");
                   int participaciones = resultado.getInt("participaciones");

                   Seleccion s = new Seleccion(id, nombre, medallasOro, medallasPlata, participaciones);
                   listadoSelecciones.add(s);
               }
           }
    	return listadoSelecciones.iterator();
    }
    public void almacenarJugador(Jugador jugador) throws SQLException {
    	String sql = "INSERT INTO jugadores (id, nombre, edad, posicion, seleccion, goles, asistencias, tarjetasAmarillas, tarjetasRojas" + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	try (PreparedStatement agregar = this.conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
    		agregar.setInt(1, jugador.getId());
    		agregar.setString(2, jugador.getNombre());
    		agregar.setInt(3, jugador.getEdad());
    		agregar.setString(4, jugador.getPosicion());
            agregar.setString(5, jugador.getSeleccion());
            agregar.setInt(6, jugador.getGoles());
            agregar.setInt(7, jugador.getAsistencias());
            agregar.setInt(8, jugador.getTarjetasAmarillas());
            agregar.setInt(9, jugador.getTarjetasRojas());

            agregar.executeUpdate();
        }
    }
    public Iterator<Jugador> recuperarJugadores() throws SQLException { 
    	List<Jugador> listadoJugadores = new ArrayList<>();
    	String sql = "SELECT * FROM jugadores ORDER BY nombre";
    	try (Statement sentencia = conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery(sql)) {
               while (resultado.next()) {
                   int id = resultado.getInt("id");
                   String nombre = resultado.getString("nombre");
                   int edad = resultado.getInt("edad");
                   String posicion= resultado.getString("posicion");
                   String seleccion = resultado.getString("seleccion");
                   int goles = Integer.parseInt(resultado.getString("goles"));
                   int asistencias = Integer.parseInt(resultado.getString("asistencias"));
                   int tarjetasAmarillas = Integer.parseInt(resultado.getString("tarjetasAmarillas"));
                   int tarjetasRojas = Integer.parseInt(resultado.getString("tarjetasRojas"));
                   

                   Jugador j = new Jugador(id, nombre, edad, posicion, seleccion, goles, asistencias, tarjetasAmarillas, tarjetasRojas);
                   listadoJugadores.add(j);
               }
           }
    	return listadoJugadores.iterator();
    }
    public void almacenarEncuentro(Encuentro encuentro) throws SQLException {
    	String sql = "INSERT INTO encuentros (id, equipoLocal, equipoVisitante, fecha, hora, lugar, golesLocal, golesVisitante) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    	try (PreparedStatement agregar = this.conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            agregar.setInt(1, encuentro.getId());
    		agregar.setString(2, encuentro.getEquipoLocal());
            agregar.setString(3, encuentro.getEquipoVisitante());
            long timestampFecha = encuentro.getFecha().getTime();
            Date fecha = new Date(timestampFecha);
            agregar.setDate(4, fecha);
            long timestampHora = encuentro.getHora().getTime();
            Time hora = new Time(timestampHora);
            agregar.setTime(5, hora);
            agregar.setString(6, encuentro.getLugar());
            agregar.setInt(7, encuentro.getGolesLocal());
            agregar.setInt(8, encuentro.getGolesVisitante());
            
            agregar.executeUpdate();

            try (ResultSet generatedKeys = agregar.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    encuentro.setId(generatedKeys.getInt(1));
                }
            }
        }
    }
    
    public Iterator<Encuentro> recuperarEncuentros() throws SQLException { 
    	List<Encuentro> listadoEncuentros = new ArrayList<>();
    	String sql = "SELECT * FROM encuentros ORDER BY lugar";
    	try (Statement sentencia = conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery(sql)) {
               while (resultado.next()) {
                   String equipoLocal = resultado.getString("equipoLocal");
                   String equipoVisitante = resultado.getString("equipoVisitante");
                   Date fecha = resultado.getDate("fecha");
                   Time hora = resultado.getTime("hora");
                   String lugar = resultado.getString("lugar");

                   Encuentro e = new Encuentro(0,equipoLocal, equipoVisitante, (java.sql.Date) fecha, (java.sql.Time) hora, lugar);
                   listadoEncuentros.add(e);
               }
           }
    	return listadoEncuentros.iterator();
    }
    public void desconectar() throws SQLException {
        if (this.conexion != null && !this.conexion.isClosed()) {
            this.conexion.close();
        }
    }
}
