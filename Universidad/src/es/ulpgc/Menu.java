package es.ulpgc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu {
    private GestionUsuarios gestion;
    private JFrame frame;
    private JTextArea textArea;

    public Menu() {
        gestion = new GestionUsuarios();
        createUI();
    }
 
    private void createUI() {
        // Configuración de la ventana
        frame = new JFrame("Gestión de Usuarios");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());
      

        // Panel de botones
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));


        // Botones
        JButton addButton = new JButton("Agregar");
        JButton deleteButton = new JButton("Eliminar");
        JButton listButton = new JButton("Listar");
        JButton exitButton = new JButton("Salir");
        
        exitButton.setBackground(Color.red);
        addButton.setBackground(Color.GREEN);
        deleteButton.setBackground(Color.red);
        listButton.setBackground(Color.ORANGE);
        
       
        exitButton.setFont(new Font("Arial",Font.ITALIC,14));
        addButton.setFont(new Font("Arial",Font.ITALIC,14));
        deleteButton.setFont(new Font("Arial",Font.ITALIC, 14));
        listButton.setFont(new Font("Arial",Font.ITALIC, 14));
         
         
        
        // Área de texto
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setBackground(Color.WHITE);
        
        
        // Agregar componentes
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);
        buttonPanel.add(exitButton);
        
        

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
      
        
        // Acciones de los botones
        addButton.addActionListener(e -> agregarUsuario());
        deleteButton.addActionListener(e -> eliminarUsuario());
        listButton.addActionListener(e -> listarUsuarios());
        exitButton.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }

    private void agregarUsuario() {
        String nombre = JOptionPane.showInputDialog(frame, "Nombre del usuario:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            gestion.agregarUSER(new Usuario(nombre));
            textArea.append("Usuario agregado: " + nombre + "\n");
        }
    }

    private void eliminarUsuario() {
        String nombre = JOptionPane.showInputDialog(frame, "Nombre del usuario a eliminar:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            gestion.eliminarUSER(nombre);
            textArea.append("Usuario eliminado: " + nombre + "\n");
        }
    }

    private void listarUsuarios() {
    	int id = 0;
        textArea.setText("=== Lista de Usuarios ===\n");
        for (Usuario usuario : gestion.getUsuarios()) {
            textArea.append(+ id++ +".-" + usuario.getNombre() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu());
    }
}
