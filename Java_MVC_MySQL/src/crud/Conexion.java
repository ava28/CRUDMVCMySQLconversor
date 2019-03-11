
package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    Connection cx;
    String bd="moneda";
    String url="jdbc:mysql://localhost:3306/"+bd;
    String user="root";
    String pass="";
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");        
            cx=(Connection)DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException|SQLException ex) {
        }
        return cx;
    }
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
        }
        
    }
}
