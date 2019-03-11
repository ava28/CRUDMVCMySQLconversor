package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dao {

    Conexion c;

    public dao() {
        c = new Conexion();
    }

    public boolean create(Moneda m) {
        try {
            String sql = "INSERT INTO coin(nombre,precio) VALUES(?,?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setDouble(2, m.getPrecio());
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("No se inserto registro");
            return false;
        }

    }

    public ArrayList<Moneda> read() {
        ArrayList<Moneda> lista = new ArrayList<Moneda>();
        try {
            String sql = "SELECT * FROM coin";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Moneda m = new Moneda();
                m.setId_c(rs.getInt("id_c"));
                m.setNombre(rs.getString("nombre"));
                m.setPrecio(rs.getDouble("precio"));
                lista.add(m);
            }
            ps.close();
            ps = null;
            c.desconectar();
        } catch (SQLException ex) {
            System.out.println("Fallo metodo read");
        }
        return lista;
    }
    

    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM coin WHERE id_c=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean update(Moneda m) {
        try {
            String sql = "UPDATE coin SET nombre=?,precio=? WHERE id_c=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setDouble(2, m.getPrecio());
            ps.setInt(3, m.getId_c());
            ps.execute();
            ps.close();
            ps=null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            return false;
        }        
    }
    public Moneda read(int id) {
       Moneda p=new Moneda();
        try {
            String sql = "SELECT * FROM coin WHERE id_c=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setId_c(rs.getInt("id_c"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
            }
            ps.close();
            ps = null;
            c.desconectar();
        } catch (SQLException ex) {
            System.out.println("Fallo metodo read prodcuto");
        }
        return p;
    }

}
