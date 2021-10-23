/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;

public class MiClase implements Serializable {

    //Esta variable es para identificar el archivo cuando lo vayamos a reconstruir del *.DAT
    private static final long serialVersionUID = 3;
    //Para gua                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      rdar el nombre de objeto de la clase
    private String Nombre_Objeto="";

    /* Constructor de la clase */
    public MiClase(String Nombre){
        this.Nombre_Objeto = Nombre;
    }

    public String getNombreObjeto()
    {
        return this.Nombre_Objeto;
    }
    //algunos metodos
    public int Suma(int a , int b)
    {
        return a + b;
    }

    public int Resta(int a , int b)
    {
        return a - b;
    }    
    int datos = 12;
    public int getCantidadDatos(){
        return datos;
    }
    public void setCantidadDatos(int datos){
        this.datos = datos;
    }
    public String Datos(){
        return "Balance de apertura/Servicio mensual/Balance Gestion/"
                + "Certificación RUPE/Certificación SIGEP/Certificación/"
                + "Trámites AFP/Trámites ROE/Trámites FUNDAEMPRESA/Trámites CNS";
    }
}