
package controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class Bits {

    private String ruta_archivo = "archivo.dat";

    public Bits(String ruta_archivo){
    
    }
    public Bits(){}
    public void escribir()
    {
        try {
            //Objeto a guardar en archivo *.DAT
            MiClase clase = new MiClase("CREACI\tON DE OBJETOS");
            //Se crea un Stream para guardar archivo
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream( this.ruta_archivo ));
            //Se escribe el objeto en archivo
            file.writeObject(clase);
            //se cierra archivo
            file.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error al guardar", JOptionPane.ERROR);
        }
    }

    public String leer()
    {
        try {
            //Stream para leer archivo
            ObjectInputStream file = new ObjectInputStream(new FileInputStream( this.ruta_archivo ));
            //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
            MiClase clase = (MiClase) file.readObject();
            //se cierra archivo
            file.close();
            
            return String.valueOf(clase.Datos()) ;
            
            
        } catch (ClassNotFoundException ex) {
             return null;
        } catch (IOException ex) {
             return null;
       }
    }

}