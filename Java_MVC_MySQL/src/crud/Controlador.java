package crud;




import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener, MouseListener {
    DefaultTableModel model;
    Vista v;
    Moneda m, m1;
    dao dao;
    int id = 0;
    ArrayList<Moneda> lista = null;
    Resultado r;
   

    public static void main(String[] args) {
        Controlador c = new Controlador();
    }

    public Controlador() {
    
        v = new Vista();
        dao = new dao();
        m1 = new Moneda();
        r=new Resultado();
        
        v.btnAgregar.addActionListener(this);
        v.btnEliminar.addActionListener(this);
        v.btnGuardar.addActionListener(this);
        v.btnLimpiar.addActionListener(this);
        v.tblDatos.addMouseListener(this);
        v.btnRegresar.addActionListener(this);
        v.btnConvertir.addActionListener(this);
        r.btnCerrar.addActionListener(this);
        refrescarTabla();  
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == v.btnAgregar) {//Aqui va el codigo para agregar registro
            try {
               
            m = new Moneda();
            m.setNombre(v.txtNombre.getText());
            m.setPrecio(Double.parseDouble(v.txtPrecio.getText()));
            if (!dao.create(m)) {
                JOptionPane.showMessageDialog(this.v, "No se inserto registro");
            }
            

            limpiarCampos();
             
            } catch (Exception T) {
                JOptionPane.showMessageDialog(this.v, "Favor de llenar todos los campos para registrar Moneda nueva");
            }
            }
        if (e.getSource() == v.btnEliminar) {//Aqui va el codigo para sliminar registro
            try {
            int x = JOptionPane.showConfirmDialog(this.v, "ESTAS SEGURO DE ELIMINAR ESTE RESGITRO?");
            if (x == 0 && id > 0) {
                if (!dao.delete(id)) {
                    JOptionPane.showMessageDialog(this.v, "No elimino registro");
                }
            }
                
            } catch (Exception a) {
                JOptionPane.showMessageDialog(this.v, "No se eligio Registro para eliminar");
            
            }
        }
        if (e.getSource() == v.btnGuardar) {//Aqui va el codigo para editar registro
            try {
                
            m1.setNombre(v.txtNombre.getText());
            m1.setPrecio(Double.parseDouble(v.txtPrecio.getText().toString()));
            if (!dao.update(m1)) {
                JOptionPane.showMessageDialog(this.v, "No se actualizo registro");
            }
            
            } catch (Exception l) {
                JOptionPane.showMessageDialog(this.v, "No hay registros que Actualizar");
            }
        }
        if (e.getSource() == v.btnLimpiar) {//Aqui va el codigo para limpiar campos
            limpiarCampos();
        }
       
        if (e.getSource() == v.btnRegresar) {//Aqui va el codigo para limpiar campos
            
            v.dispose();
        }
         if (e.getSource() == v.btnConvertir) {
             try {
            m1.setPrecio(Double.parseDouble(v.txtPrecio.getText()));
            m1.setCant(Double.parseDouble(v.txtCantidad.getText()));
            m1.conversor();
            r.setVisible(true);
            r.setLocationRelativeTo(null);
            r.lblNombre.setText(m1.getNombre());
            r.lblRes.setText(String.valueOf(m1.getRes()));
           } catch (Exception t) {
               JOptionPane.showMessageDialog(this.v, "No se eligio cantidad a comparar");
             }
               
                    
         }
     if (e.getSource() == r.btnCerrar) {
               r.dispose();
               limpiarCampos();
        }  
               
        refrescarTabla();
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == v.tblDatos) {//Aqui va el codigo para cuando de clic sobre la tabla
            int fila = v.tblDatos.getSelectedRow();
            id = Integer.parseInt(v.tblDatos.getValueAt(fila, 0).toString());
            m1 = dao.read(id);
            v.lblId.setText("" + m1.getId_c());
            v.txtNombre.setText(m1.getNombre());
            v.txtPrecio.setText(String.valueOf(m1.getPrecio()));
        }
        
    }

    public void refrescarTabla() {
      

        
        while (v.model.getRowCount() > 0) {
            v.model.removeRow(0);
        }
        lista = dao.read();
        for (Moneda m : lista) {
            Object item[] = new Object[3];
            item[0] = m.getId_c();
            item[1] = m.getNombre();
            item[2] = m.getPrecio();
            v.model.addRow(item);
        }
        v.tblDatos.setModel(v.model);
        
        
    }
 
    
    public void limpiarCampos() {
        v.txtNombre.setText("");
        v.txtPrecio.setText("");
        v.txtCantidad.setText("");
        v.lblId.setText("");
    }
    
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
