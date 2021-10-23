package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import modelo.Conexion;

public class Consultas {
    
    public void addInsert(Map<String,Object> datos,String tabla){
        Connection con = new Conexion().getConexion("root", "");
        String col = "(";
        String val = "VALUES(";
        for (Map.Entry<String, Object> entry : datos.entrySet()) {
            col = col + entry.getKey()+",";
        }        
        col = col.substring(0, col.length()-1)+") ";                
        for(int i=0;i<datos.size()-1;i++)
            val = val + "?,";
        val = val + "?) ";        
        try {           
            PreparedStatement ps=con.prepareStatement("INSERT INTO "+ tabla 
                    +  col + val);
            int fila=1;
            /*System.out.println("INSERT INTO "+ tabla 
                    +  col + val);*/
            for (Map.Entry<String, Object> entry : datos.entrySet()) {
                ps.setObject(fila, entry.getValue());
                fila++;
        }
        ps.execute();  
        //JOptionPane.showConfirmDialog(null, "Datos ingresados correctamente", "Confirmación", JOptionPane.CLOSED_OPTION);
        ps.close();
        con.close();
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error"+ex.toString(), "Error InserInto", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public Map<String,Object[][]> getSelect(Map<String,String> datos, int n_col){
       
        String col = datos.get("columnas");
        String tablas = datos.get("tablas");
        String condicion = datos.get("condicion");

        Map <String,Object[][]> res = new HashMap<String,Object[][]>();
        Object[][] cant = {{0}};
        Object[][] cont = null;                
        try {           
            Connection con = new Conexion().getConexion("root", "");  

            PreparedStatement ps = con.prepareStatement("SELECT count(*) "
            +" FROM "+ tablas
            +" WHERE " + condicion);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cont = new Object[rs.getInt(1)][n_col];
                //Cantidad de datos almacenados en la consulta
                cant[0][0] = rs.getInt(1);
            }
            //En caso de que no existna datos en la consulta

            ps = con.prepareStatement("SELECT "+col
            +" FROM "+ tablas
            +" WHERE " + condicion);         
            rs = ps.executeQuery();
            int i = 0;
            while(rs.next()&&i<=((int)cant[0][0])){                
                for(int k=0;k<n_col;k++)
                    cont[i][k] = rs.getString(k+1);
                i++;
            }
         
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error"+ex.toString(), "Error en la consulta select", JOptionPane.ERROR_MESSAGE);
        }
        res.put("cant", cant);
        res.put("cont", cont);
        return res;
    }

    public void setUpdate(Map<String,String> datos){
        Object col = datos.get("columnas");
        Object tabla = datos.get("tabla");
        Object condicion = datos.get("condicion");
        try {
            Connection con = new Conexion().getConexion("root", "");   
            PreparedStatement ps = con.prepareStatement("UPDATE "+ tabla
                    + " SET " + col
                    + " WHERE " + condicion );
            ps.execute();
            //JOptionPane.showMessageDialog(null, "Actualizado");
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizado" + e);
        }                
    }

    public void delete(String condicion, String tabla){
        try {
            Connection con = new Conexion().getConexion("root", "");
            PreparedStatement ps = con.prepareStatement("DELETE FROM "+ tabla
                    + " WHERE "+ condicion);
            ps.execute();
            JOptionPane.showConfirmDialog(null, "Elimando");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
        
    }
            
}
