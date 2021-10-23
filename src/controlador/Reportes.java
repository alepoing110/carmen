/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;

import java.util.Map;
import javax.swing.JOptionPane;
import modelo.Conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author USER
 */

public class Reportes {
    Conexion con =  new Conexion();
    public void imprimir(String archivo, Map datos) {
        
        try {
        File f = new File(archivo);
        JasperReport reporte = (JasperReport) JRLoader.loadObject(f);
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, datos , con.getConexion("root", ""));               
        JasperViewer.viewReport(jasperPrint,false);  
        System.err.println(jasperPrint.getName());
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Error al imprimir");
        }
    }
}
