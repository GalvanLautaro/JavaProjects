package paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class BD {
    private Connection conexion;

    public BD() throws SQLException {
        System.out.println("Iniciando programa.");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo cargar el driver JDBC.");
            throw new SQLException(e);
        }
    }

    // Conectar a la base de datos
    public void conectar(String direccion, String usuario, String contrasena) throws SQLException {
        this.conexion = DriverManager.getConnection(direccion, usuario, contrasena);
    }

    // Almacenar una persona usando HTTP POST
    public void almacenarPersona(Persona persona) throws Exception {
        String url = "http://localhost/tp13/agenda.php"; // URL del archivo PHP
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setDoOutput(true);

        // Formato de los parámetros
        String postParams = String.format("nombre=%s&telefono=%s&fecha=%s",
            persona.getNombre(),
            persona.getTelefono(),
            String.format("%04d-%02d-%02d", 
                persona.getFecha().get(GregorianCalendar.YEAR), 
                persona.getFecha().get(GregorianCalendar.MONTH) + 1, 
                persona.getFecha().get(GregorianCalendar.DAY_OF_MONTH))
        );

        // Enviar los datos
        try (OutputStream os = con.getOutputStream()) {
            os.write(postParams.getBytes("UTF-8"));
            os.flush();
        }

        // Comprobar la respuesta
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("Persona almacenada con éxito");
        } else {
            System.out.println("Error al almacenar la persona. Código de respuesta: " + responseCode);
        }
    }

    // Recuperar la lista de personas usando HTTP GET
    public ArrayList<Persona> recuperarPersonas() throws Exception {
        String url = "http://localhost/tp13/agenda.php";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Parsear la respuesta manualmente
        return parsearPersonas(response.toString());
    }

    private ArrayList<Persona> parsearPersonas(String json) {
        ArrayList<Persona> personas = new ArrayList<>();
        
        // Limpiar la respuesta JSON manualmente
        json = json.replace("[", "").replace("]", "");
        String[] registros = json.split("},");
        
        for (String registro : registros) {
            registro = registro.replace("{", "").replace("}", "");
            String[] campos = registro.split(",");
            String nombre = "";
            String telefono = "";
            GregorianCalendar fecha = null;

            for (String campo : campos) {
                String[] par = campo.split(":");
                String clave = par[0].trim().replace("\"", "");
                String valor = par[1].trim().replace("\"", "");

                switch (clave) {
                    case "nombre":
                        nombre = valor;
                        break;
                    case "telefono":
                        telefono = valor;
                        break;
                    case "fecha_nacimiento":
                        String[] fechaParts = valor.split("-");
                        fecha = new GregorianCalendar(
                            Integer.parseInt(fechaParts[0]),
                            Integer.parseInt(fechaParts[1]) - 1,
                            Integer.parseInt(fechaParts[2])
                        );
                        break;
                }
            }

            Persona p = new Persona(nombre);
            p.setTelefono(telefono);
            p.setFecha(fecha);
            personas.add(p);
        }

        return personas;
    }

    // Cerrar la conexión
    public void desconectar() throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
    }
}
