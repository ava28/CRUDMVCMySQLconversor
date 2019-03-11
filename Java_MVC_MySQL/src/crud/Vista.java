
package crud;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.*;

public class Vista extends JFrame{
    JLabel lblId,lblNombre,lblPrecio,lblIdproducto, lblCantidad;
    JTextField txtNombre, txtPrecio, txtCantidad;
    JSpinner spnCantidad;
    
    JScrollPane scroll;
    DefaultTableModel model;
    JTable tblDatos;
    JButton btnAgregar,btnEliminar,btnGuardar,btnLimpiar,btnRegresar, btnConvertir;
    public Vista(){
        this.setTitle("Gestor de Monedas");
        this.setSize(550, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new AbsoluteLayout());
        lblId=new JLabel("ID Moneda");
        this.getContentPane().add(lblId,new AbsoluteConstraints(120,10,100,40));
        lblNombre=new JLabel("Nombre");
        this.getContentPane().add(lblNombre,new AbsoluteConstraints(10,40,100,40));
        lblPrecio=new JLabel("Precio");
        this.getContentPane().add(lblPrecio,new AbsoluteConstraints(10,70,100,40));
        lblCantidad=new JLabel("Cantidad a Convertir");
        this.getContentPane().add(lblCantidad,new AbsoluteConstraints(10,100,100,40));
        
        lblIdproducto=new JLabel("ID ");
        this.getContentPane().add(lblIdproducto,new AbsoluteConstraints(10,10,100,20));
        
        txtNombre=new JTextField();
        this.getContentPane().add(txtNombre,new AbsoluteConstraints(120, 40,100, 20));
        
        txtPrecio=new  JTextField();
        this.getContentPane().add(txtPrecio,new AbsoluteConstraints(120, 70,100, 20));
        txtCantidad=new  JTextField();
        this.getContentPane().add(txtCantidad,new AbsoluteConstraints(120, 110,100, 20));
        
        btnAgregar=new JButton("Agregar");
        this.getContentPane().add(btnAgregar,new AbsoluteConstraints(300, 10,100, 20));
        btnEliminar=new JButton("Eliminar");
        this.getContentPane().add(btnEliminar,new AbsoluteConstraints(300, 40,100, 20));
        btnGuardar=new JButton("Guardar");
        this.getContentPane().add(btnGuardar,new AbsoluteConstraints(300, 70,100, 20));
        btnConvertir=new JButton("Convertir");
        this.getContentPane().add(btnConvertir,new AbsoluteConstraints(300, 100,100, 20));
        btnLimpiar=new JButton("Limpiar");
        this.getContentPane().add(btnLimpiar,new AbsoluteConstraints(300, 130,100, 20));
        btnRegresar=new JButton("Salir");
        this.getContentPane().add(btnRegresar,new AbsoluteConstraints(300, 160,100, 20));
        tblDatos=new JTable();
        scroll=new JScrollPane();
        model=new  DefaultTableModel();
        model.addColumn("Id Tabla");
        model.addColumn("Nombre");
        model.addColumn("Precio");

        tblDatos.setModel(model);
        scroll.setViewportView(tblDatos);
        this.getContentPane().add(scroll,new AbsoluteConstraints(10, 200,500, 300));
        this.setVisible(true);
        
    }
}
