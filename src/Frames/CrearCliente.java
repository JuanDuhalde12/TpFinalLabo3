package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import models.*;

class CrearCliente extends JFrame implements ActionListener {
    private List<Cliente> clientes;
    private JTextField nombreTextField;
    private JTextField direccionTextField;
    private JTextField telefonoTextField;
    private JTextField emailTextField;
    private JTextField celularTextField;
    private JTextField cuitTextField;
    private JTextField ocupacionTextField;

    public CrearCliente(List<Cliente> clientes) {
        this.clientes = clientes;

        // Configuración del JFrame
        setTitle("Crear Cliente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLayout(new GridLayout(4, 2));

        // Panel de registro de cliente
        JPanel registroPanel = new JPanel();
        registroPanel.setLayout(new GridLayout(10, 10));

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreTextField = new JTextField();
        JLabel direccionLabel = new JLabel("Dirección:");
        direccionTextField = new JTextField();
        JLabel telefonoLabel = new JLabel("Teléfono:");
        telefonoTextField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailTextField = new JTextField();
        JLabel celularLabel = new JLabel("Celular:");
        celularTextField = new JTextField();
        JLabel cuitLabel = new JLabel("CUIT:");
        cuitTextField = new JTextField();
        JLabel ocupacionLabel = new JLabel("Ocupacion:");
        ocupacionTextField = new JTextField();


        JButton registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(this);

        registroPanel.add(nombreLabel);
        registroPanel.add(nombreTextField);
        registroPanel.add(direccionLabel);
        registroPanel.add(direccionTextField);
        registroPanel.add(telefonoLabel);
        registroPanel.add(telefonoTextField);
        registroPanel.add(emailLabel);
        registroPanel.add(emailTextField);
        registroPanel.add(celularLabel);
        registroPanel.add(celularTextField);
        registroPanel.add(cuitLabel);
        registroPanel.add(cuitTextField);
        registroPanel.add(ocupacionLabel);
        registroPanel.add(ocupacionTextField);
        registroPanel.add(new JLabel());
        registroPanel.add(registrarButton);

        // Agregar el panel al JFrame
        add(registroPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Registrar")) {
            String nombreCompleto = nombreTextField.getText();
            String direccion = direccionTextField.getText();
            String telefono = telefonoTextField.getText();
            String email = emailTextField.getText();
            String celular = celularTextField.getText();
            String cuit = cuitTextField.getText();
            String ocupacion = ocupacionTextField.getText();

            Cliente cliente = new Cliente(nombreCompleto,telefono,email,celular,direccion,cuit,ocupacion);
            clientes.add(cliente);

            JOptionPane.showMessageDialog(this, "Cliente registrado con éxito.");

            // Limpiar los campos de texto después del registro
            nombreTextField.setText("");
            direccionTextField.setText("");
            telefonoTextField.setText("");
            emailTextField.setText("");
            celularTextField.setText("");
            cuitTextField.setText("");
            ocupacionTextField.setText("");
        }
    }
}
