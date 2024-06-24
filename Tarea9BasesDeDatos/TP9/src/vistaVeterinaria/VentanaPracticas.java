package vistaVeterinaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import persistencia.BDVeterinaria;
import veterinaria.Practica;
import com.toedter.calendar.JDateChooser;

public class VentanaPracticas extends JDialog {

	private static final long serialVersionUID = 1L;

    public VentanaPracticas() {
        setTitle("Ingresar Datos de la Practica");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setModal(true);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel descripcionLabel = new JLabel("Descripcion:");
        descripcionLabel.setBounds(10, 20, 80, 25);
        panel.add(descripcionLabel);

        JTextField descripcionField = new JTextField(20);
        descripcionField.setBounds(100, 20, 200, 25);
        panel.add(descripcionField);

        JLabel fechaLabel = new JLabel("Fecha:");
        fechaLabel.setBounds(10, 60, 80, 25);
        panel.add(fechaLabel);

        JDateChooser fechaChooser = new JDateChooser();
        fechaChooser.setBounds(100, 56, 200, 25);
        panel.add(fechaChooser);
        
        JLabel fechaVencimientoLabel = new JLabel("Fecha de Vencimiento:");
        fechaVencimientoLabel.setBounds(10, 100, 120, 25);
        panel.add(fechaVencimientoLabel);

        JDateChooser fechaVencimientoChooser = new JDateChooser();
        fechaVencimientoChooser.setBounds(150, 100, 150, 25);
        panel.add(fechaVencimientoChooser);

        JLabel comentariosLabel = new JLabel("Comentarios:");
        comentariosLabel.setBounds(10, 140, 120, 25);
        panel.add(comentariosLabel);

        JTextField comentariosField = new JTextField(20);
        comentariosField.setBounds(150, 140, 150, 25);
        panel.add(comentariosField);
        
        JLabel mascotaIdLabel = new JLabel("ID de mascota:");
        mascotaIdLabel.setBounds(10, 176, 120, 25);
        panel.add(mascotaIdLabel);
        
        JTextField mascotaIdField = new JTextField(20);
        mascotaIdField.setBounds(150, 176, 150, 25);
        panel.add(mascotaIdField);
        JButton guardarButton = new JButton("Agregar");
        guardarButton.setBounds(150, 225, 100, 25);
        panel.add(guardarButton);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descripcion = descripcionField.getText();
                Date fecha = fechaChooser.getDate();
                Date fechaVencimiento = fechaVencimientoChooser.getDate();
                String comentarios = comentariosField.getText();
                int mascotaId = Integer.parseInt(mascotaIdField.getText());

                System.out.println("Datos de la Practica:");
                System.out.println("Descripcion: " + descripcion);
                System.out.println("Fecha: " + fecha);
                System.out.println("Fecha Vencimiento: " + fechaVencimiento);
                System.out.println("Comentarios: " + comentarios);
                System.out.println("ID Mascota: " + mascotaId);

                try {
                    Practica practica = new Practica(descripcion, fecha, fechaVencimiento, comentarios, mascotaId);

                    BDVeterinaria bd = new BDVeterinaria();
                    bd.conectar("jdbc:mysql://localhost:3306/veterinaria", "root", "");
                    bd.almacenarPractica(practica);
                    bd.desconectar();
                    JOptionPane.showMessageDialog(null, "Práctica guardada con éxito");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
                
                dispose();
            }
        });
    }
}
