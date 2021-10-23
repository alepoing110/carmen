package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

    public class Conexion {
        Connection conexion;
    public Connection getConexion (String user, String pass){
        try {         
            //Class.forName("com.mysql.jdbc.Driver");
            //String servidor = "jdbc:mysql://localhost/carmen";           
            Class.forName("org.sqlite.JDBC");
            String servidor = "jdbc:sqlite:C:/Carmen/db/carmen.db";           
            conexion= DriverManager.getConnection(servidor,"","");       
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error con el DBMS" + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            return conexion;
        }       
    }    
}
