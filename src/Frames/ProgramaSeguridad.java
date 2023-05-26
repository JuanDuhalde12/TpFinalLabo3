package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class ProgramaSeguridad extends JFrame implements ActionListener {
    private List<Usuario> usuarios;
    private List<Cliente> clientes;
    private JTextField nombreUsuarioTextField;
    private JPasswordField contraseñaPasswordField;
    private JButton ingresarButton;
    private JButton registrarButton;

    public ProgramaSeguridad() {
        usuarios = new ArrayList<>();
        clientes = new ArrayList<>();

        // Configuración del JFrame
        setTitle("Programa de Seguridad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(4, 1));

        // Panel de bienvenida
        JPanel bienvenidaPanel = new JPanel();
        bienvenidaPanel.setLayout(new FlowLayout());
        JLabel bienvenidaLabel = new JLabel("Bienvenido al Programa de Seguridad");
        bienvenidaPanel.add(bienvenidaLabel);

        // Panel de inicio de sesión
        JPanel inicioSesionPanel = new JPanel();
        inicioSesionPanel.setLayout(new GridLayout(2, 1));

        JLabel nombreUsuarioLabel = new JLabel("Nombre de usuario:");
        nombreUsuarioTextField = new JTextField();
        JLabel contraseñaLabel = new JLabel("Contraseña:");
        contraseñaPasswordField = new JPasswordField();

        inicioSesionPanel.add(nombreUsuarioLabel);
        inicioSesionPanel.add(nombreUsuarioTextField);
        inicioSesionPanel.add(contraseñaLabel);
        inicioSesionPanel.add(contraseñaPasswordField);

        // Panel de botones
        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new FlowLayout());

        ingresarButton = new JButton("Ingresar");
        ingresarButton.addActionListener(this);
        registrarButton = new JButton("Registrarse");
        registrarButton.addActionListener(this);

        botonesPanel.add(ingresarButton);
        botonesPanel.add(registrarButton);

        // Agregar los paneles al JFrame
        add(bienvenidaPanel);
        add(inicioSesionPanel);
        add(botonesPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ingresarButton) {
            String nombreUsuario = nombreUsuarioTextField.getText();
            String contraseña = new String(contraseñaPasswordField.getPassword());

            boolean usuarioEncontrado = false;
            for (Usuario usuario : usuarios) {
                if (usuario.getNombre().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                    usuarioEncontrado = true;
                    JOptionPane.showMessageDialog(this, "¡Bienvenido " + nombreUsuario + "!");
                    if (usuario.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
                        SwingUtilities.invokeLater(() -> {
                            CrearCliente crearClienteFrame = new CrearCliente(clientes);
                            crearClienteFrame.setVisible(true);
                        });
                    }
                    break;
                }
            }

            if (!usuarioEncontrado) {
                JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña incorrectos.");
            }
        } else if (e.getSource() == registrarButton) {
            if(usuarios.isEmpty()){
                String nombreUsuario = nombreUsuarioTextField.getText();
                String contraseña = new String(contraseñaPasswordField.getPassword());

                Usuario usuario = new Usuario(nombreUsuario, contraseña, TipoUsuario.ADMINISTRADOR);
                usuarios.add(usuario);

                JOptionPane.showMessageDialog(this, "¡Registro exitoso!");
            }else{
                String nombreUsuario = nombreUsuarioTextField.getText();
                String contraseña = new String(contraseñaPasswordField.getPassword());

                Usuario usuario = new Usuario(nombreUsuario, contraseña, TipoUsuario.USUARIO);
                usuarios.add(usuario);

                JOptionPane.showMessageDialog(this, "¡Registro exitoso!");
            }

        }
    }
}
