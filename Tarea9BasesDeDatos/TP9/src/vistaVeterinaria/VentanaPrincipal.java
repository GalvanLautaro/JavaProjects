package vistaVeterinaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import persistencia.BDVeterinaria;
import veterinaria.Cliente;
import veterinaria.Mascota;
import veterinaria.Practica;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	public VentanaPrincipal() {
        setTitle("Gestión de Personas");
        setSize(565, 214);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JButton btnCliente = new JButton("Agregar Cliente");
        btnCliente.setBounds(10, 39, 170, 37);
        btnCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 VentanaCliente ventanaCliente = new VentanaCliente();
                 ventanaCliente.setVisible(true);
            }
        });
        getContentPane().add(btnCliente);

        JButton btnMascota = new JButton("Agregar Mascota");
        btnMascota.setBounds(190, 39, 170, 37);
        btnMascota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	VentanaMascota ventanaMascota = new VentanaMascota();
                ventanaMascota.setVisible(true);
                }
            });
        getContentPane().add(btnMascota);
        
        JButton btnPractica = new JButton("Realizar Practica");
        btnPractica.setBounds(370, 39, 170, 37);
        btnPractica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	VentanaPracticas ventanaPractica = new VentanaPracticas();
                ventanaPractica.setVisible(true);
                }
            });
        getContentPane().add(btnPractica);
        
       
        JButton btnListarMascotas = new JButton("Listar Mascotas");
        btnListarMascotas.setBounds(190, 98, 170, 34);
        btnListarMascotas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                String clienteIdStr = JOptionPane.showInputDialog("Ingrese el ID del cliente:");
                if (clienteIdStr != null && !clienteIdStr.isEmpty()) {
                    try {
                        int clienteId = Integer.parseInt(clienteIdStr);
                        BDVeterinaria bd = new BDVeterinaria();
                        bd.conectar("jdbc:mysql://localhost:3306/veterinaria", "root", "");
                        Iterator<Mascota> it = bd.recuperarMascotas(clienteId);
                        StringBuilder sb = new StringBuilder();
                        while (it.hasNext()) {
                            Mascota m = it.next();
                            sb.append("Nombre: ").append(m.getNombre())
                              .append(", Animal: ").append(m.getAnimal())
                              .append(", Fecha de nacimiento: ").append(m.getFechaNacimiento())
                              .append(", Historia Clinica: ").append(m.getHistoriaClinica())
                              .append(", ID Animal: ").append(m.getId())
                              .append("\n");
                        }
                        bd.desconectar();
                        JOptionPane.showMessageDialog(null, sb.toString());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID del cliente inválido.");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    }
                }
            }
        });
        getContentPane().add(btnListarMascotas);
        
        JButton btnListarClientes = new JButton("Listar Clientes");
        btnListarClientes.setBounds(10, 98, 170, 35);
        btnListarClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    BDVeterinaria bd = new BDVeterinaria();
                    bd.conectar("jdbc:mysql://localhost:3306/veterinaria", "root", "");
                    Iterator<Cliente> it = bd.recuperarClientes();
                    StringBuilder sb = new StringBuilder();
                    while (it.hasNext()) {
                        Cliente c = it.next();
                        sb.append("Nombre: ").append(c.getNombre())
                          .append(", Teléfono: ").append(c.getTelefono())
                          .append(", Direccion: ").append(c.getDireccion())
                          .append(", Email: ").append(c.getEmail())
                          .append(", ID: ").append(c.getId())
                          .append("\n");
                    }
                    bd.desconectar();
                    JOptionPane.showMessageDialog(null, sb.toString());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        getContentPane().add(btnListarClientes);
        
        JButton btnListarPracticas = new JButton("Listar Practicas");
        btnListarPracticas.setBounds(370, 98, 170, 34);
        btnListarPracticas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String mascotaIdStr = JOptionPane.showInputDialog("Ingrese el ID de la mascota:");
                if (mascotaIdStr != null && !mascotaIdStr.isEmpty()) {
                    try {
                        int mascotaId = Integer.parseInt(mascotaIdStr);
                        BDVeterinaria bd = new BDVeterinaria();
                        bd.conectar("jdbc:mysql://localhost:3306/veterinaria", "root", "");
                        Iterator<Practica> it = bd.recuperarPracticas(mascotaId);
                        StringBuilder sb = new StringBuilder();
                        while (it.hasNext()) {
                            Practica p = it.next();
                            sb.append("Descripcion: ").append(p.getDescripcion())
                              .append(", Fecha: ").append(p.getFecha())
                              .append(", Fecha de Vencimiento: ").append(p.getFechaVencimiento())
                              .append(", Comentarios: ").append(p.getComentarios())
                              .append("\n");
                        }
                        bd.desconectar();
                        JOptionPane.showMessageDialog(null, sb.toString());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID del cliente inválido.");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    }
                }
            }
        });
        getContentPane().add(btnListarPracticas);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
}
