package mvc.unomaxs.crud.view;

import javax.swing.*;
import java.awt.*;

public class frmProducto extends JFrame {

    // Declaración de los componentes de la interfaz
    public JTextField txtCodigo;
    public JTextField txtNombre;
    public JTextField txtPrecio;
    public JTextField txtCantidad;
    public JTextField txtId;
    public JButton btnBuscar;
    public JButton btnGuardar;
    public JButton btnModificar;
    public JButton btnEliminar;
    public JButton btnLimpiar;

    // Constructor del JFrame
    public frmProducto() {

        // Configuración del JFrame
        setTitle("Productos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Creación del layout para los componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta y campo de texto para Código
        JLabel lblCodigo = new JLabel("Código:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblCodigo, gbc);

        txtCodigo = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtCodigo, gbc);

        btnBuscar = new JButton("Buscar");
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(btnBuscar, gbc);

        // Etiqueta y campo de texto para Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblNombre, gbc);


        txtNombre = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtNombre, gbc);

        // Etiqueta y campo de texto para Precio
        JLabel lblPrecio = new JLabel("Precio:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblPrecio, gbc);

        txtPrecio = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(txtPrecio, gbc);

        // Etiqueta y campo de texto para Cantidad
        JLabel lblCantidad = new JLabel("Cantidad:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblCantidad, gbc);

        txtCantidad = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(txtCantidad, gbc);

        // Campo de texto para ID (asegúrate de añadirlo aquí)
        txtId = new JTextField(15); // Inicializa txtId
        txtId.setVisible(false); // Hacerlo invisible si no quieres que el usuario lo vea
        gbc.gridx = 1;
        gbc.gridy = 6; // Ajusta la posición según sea necesario
        add(txtId, gbc); // Agrega el campo de texto al formulario


        // Botón Guardar
        btnGuardar = new JButton("Guardar");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(btnGuardar, gbc);

        // Botón Modificar
        btnModificar = new JButton("Modificar");
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(btnModificar, gbc);

        // Botón Eliminar
        btnEliminar = new JButton("Eliminar");
        gbc.gridx = 2;
        gbc.gridy = 4;
        add(btnEliminar, gbc);

        // Botón Limpiar
        btnLimpiar = new JButton("Limpiar");
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(btnLimpiar, gbc);
    }

    // Método principal para ejecutar la vista
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frmProducto frame = new frmProducto();
            frame.setVisible(true);
        });
    }

}
