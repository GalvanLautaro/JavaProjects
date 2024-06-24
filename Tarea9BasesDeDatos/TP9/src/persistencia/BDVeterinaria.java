package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import veterinaria.Cliente;
import veterinaria.Mascota;
import veterinaria.Practica;

public class BDVeterinaria {
    private Connection conexion;

    public BDVeterinaria() throws SQLException {
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

    public void almacenarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (nombre, telefono, direccion, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement agregar = this.conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            agregar.setString(1, cliente.getNombre());
            agregar.setString(2, cliente.getTelefono());
            agregar.setString(3, cliente.getDireccion());
            agregar.setString(4, cliente.getEmail());
            agregar.executeUpdate();

            try (ResultSet generatedKeys = agregar.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cliente.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public Iterator<Cliente> recuperarClientes() throws SQLException {
        List<Cliente> listadoClientes = new ArrayList<>();

        String sql = "SELECT * FROM Cliente ORDER BY nombre";
        try (Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(sql)) {
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String telefono = resultado.getString("telefono");
                String direccion = resultado.getString("direccion");
                String email = resultado.getString("email");

                Cliente c = new Cliente(id, nombre, telefono, direccion, email);
                listadoClientes.add(c);
            }
        }
        return listadoClientes.iterator();
    }

    public void almacenarMascota(Mascota mascota) throws SQLException {
        String sql = "INSERT INTO Mascota (nombre, animal, fechaNacimiento, historiaClinica, cliente_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement agregar = this.conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            agregar.setString(1, mascota.getNombre());
            agregar.setString(2, mascota.getAnimal());
            agregar.setDate(3, new java.sql.Date(mascota.getFechaNacimiento().getTime()));
            agregar.setString(4, mascota.getHistoriaClinica());
            agregar.setInt(5, mascota.getClienteId());
            agregar.executeUpdate();

            try (ResultSet generatedKeys = agregar.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    mascota.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public Iterator<Mascota> recuperarMascotas(int clienteId) throws SQLException {
        List<Mascota> listadoMascotas = new ArrayList<>();

        String sql = "SELECT * FROM Mascota WHERE cliente_id = ? ORDER BY nombre";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, clienteId);
            try (ResultSet resultado = stmt.executeQuery()) {
                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    String nombre = resultado.getString("nombre");
                    String animal = resultado.getString("animal");
                    Date fechaNacimiento = resultado.getDate("fechaNacimiento");
                    String historiaClinica = resultado.getString("historiaClinica");

                    Mascota m = new Mascota(id,nombre, animal, fechaNacimiento, historiaClinica, clienteId);
                    listadoMascotas.add(m);
                }
            }
        }
        return listadoMascotas.iterator();
    }

    public void almacenarPractica(Practica practica) throws SQLException {
        String sql = "INSERT INTO Practica (descripcion, fecha, fechaVencimiento, comentarios, mascota_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement agregar = this.conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        	agregar.setString(1, practica.getDescripcion());

            // Use LocalDateTime for date and time representation
        	long timestamp = practica.getFecha().getTime();
        	Date fecha = new Date(timestamp);
            agregar.setObject(2, fecha, Types.TIMESTAMP); // Use TIMESTAMP for combined date and time

            long timestampVencimiento = practica.getFechaVencimiento().getTime();
        	Date fechaVencimiento = new Date(timestampVencimiento);
            agregar.setObject(3, fechaVencimiento, Types.TIMESTAMP);

            agregar.setString(4, practica.getComentarios());
            agregar.setInt(5, practica.getMascotaId());

            agregar.executeUpdate();

            try (ResultSet generatedKeys = agregar.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    practica.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public Iterator<Practica> recuperarPracticas(int mascotaId) throws SQLException {
        List<Practica> listadoPracticas = new ArrayList<>();

        String sql = "SELECT * FROM Practica WHERE mascota_id = ? ORDER BY fecha";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, mascotaId);
            try (ResultSet resultado = stmt.executeQuery()) {
                while (resultado.next()) {
                    String descripcion = resultado.getString("descripcion");
                    Date fecha = resultado.getDate("fecha");
                    Date fechaVencimiento = resultado.getDate("fechaVencimiento");
                    String comentarios = resultado.getString("comentarios");

                    Practica p = new Practica(descripcion, fecha, fechaVencimiento, comentarios, mascotaId);
                    listadoPracticas.add(p);
                }
            }
        }
        return listadoPracticas.iterator();
    }

    public void desconectar() throws SQLException {
        if (this.conexion != null && !this.conexion.isClosed()) {
            this.conexion.close();
        }
    }
}

