package mvc.unomaxs.crud.controller;


import mvc.unomaxs.crud.model.ConsultasProducto;
import mvc.unomaxs.crud.model.Producto;
import mvc.unomaxs.crud.view.frmProducto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CtrlProducto implements ActionListener {

    private final Producto modelo;
    private final ConsultasProducto consultas;
    private final frmProducto vista;

    public CtrlProducto(Producto modelo, ConsultasProducto consultas, frmProducto vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Productos");
        vista.setLocationRelativeTo(null);
        vista.txtId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnGuardar) {
            modelo.setCodigo(vista.txtCodigo.getText());
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
            modelo.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));

            try {
                if (consultas.registrar(modelo)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                    limpiar();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == vista.btnModificar) {
            modelo.setId(Integer.parseInt(vista.txtId.getText()));
            modelo.setCodigo(vista.txtCodigo.getText());
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
            modelo.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));

            try {
                if (consultas.modificar(modelo)) {
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar");
                    limpiar();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == vista.btnEliminar) {
            modelo.setId(Integer.parseInt(vista.txtId.getText()));

            try {
                if (consultas.eliminar(modelo)) {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar");
                    limpiar();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == vista.btnBuscar) {
            modelo.setCodigo(vista.txtCodigo.getText());

            try {
                if (consultas.buscar(modelo)) {
                    vista.txtId.setText(String.valueOf(modelo.getId()));
                    vista.txtCodigo.setText(modelo.getCodigo());
                    vista.txtNombre.setText(modelo.getNombre());
                    vista.txtPrecio.setText(String.valueOf(modelo.getPrecio()));
                    vista.txtCantidad.setText(String.valueOf(modelo.getCantidad()));

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro registro");
                    limpiar();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == vista.btnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        vista.txtId.setText(null);
        vista.txtCodigo.setText(null);
        vista.txtNombre.setText(null);
        vista.txtPrecio.setText(null);
        vista.txtCantidad.setText(null);
    }
}
