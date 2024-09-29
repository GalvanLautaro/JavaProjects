<?php
// Conexión a la base de datos MySQL
$host = "localhost"; 
$dbname = "agenda";
$username = "root";
$password = "";

// Crear la conexión
$conn = new mysqli($host, $username, $password, $dbname);

// Comprobar conexión
if ($conn->connect_error) {
    die(json_encode(["status" => "error", "message" => "Conexión fallida: " . $conn->connect_error]));
}

// Manejar la inserción de personas
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nombre = $conn->real_escape_string($_POST['nombre']);
    $telefono = $conn->real_escape_string($_POST['telefono']);
    $fecha = $conn->real_escape_string($_POST['fecha']);

    // Realiza una consulta a la base de datos
    $query = "INSERT INTO contactos (nombre, telefono, fecha_nacimiento) VALUES ('$nombre', '$telefono', '$fecha')";
    if ($conn->query($query) === TRUE) {
        echo json_encode(["status" => "success"]);
    } else {
        echo json_encode(["status" => "error", "message" => "Error al insertar: " . $conn->error]);
    }
}

// Manejar la recuperación de personas 
if ($_SERVER["REQUEST_METHOD"] == "GET") {
    $query = "SELECT nombre, telefono, fecha_nacimiento FROM contactos";
    $resultado = $conn->query($query);
    $contactos = array();

    while ($row = $resultado->fetch_assoc()) {
        $contactos[] = $row;
    }

    header('Content-Type: application/json');
    echo json_encode($contactos);
}

$conn->close(); // Cerrar la conexión al final
?>