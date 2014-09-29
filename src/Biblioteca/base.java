/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import BaseDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mariel
 */
public class base {
    public void guardarDocente(Docente d) {
          
         ConexionMySQL mysql= new ConexionMySQL();
            Connection cn= mysql.Conectar();
       //p_ indica q son parametros q utilizare, contendran los valores q se capten del formu
       
       String sql ="";
       String id= String.valueOf(d.getDniSocio());
       String nombre =d.getNombre();
       String area= d.getArea();
     
       sql= "insert into sociodocente(id, nombre , materia)"
               + "values(?,?,?)";
       String mensaje = "El nuevo Socio se ha cargado de manera Satisfactoria...";
       try {
       
        
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, nombre);
            pst.setString(3, area);
            int n = pst.executeUpdate();
            if(n> 0)
            {
                JOptionPane.showMessageDialog(null,mensaje);
            }
              
            
        } 
       catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
       
       // TODO add your handling code here:
    }
     public void guardarEstudiante(Estudiante d) {
          
         ConexionMySQL mysql= new ConexionMySQL();
            Connection cn= mysql.Conectar();
       //p_ indica q son parametros q utilizare, contendran los valores q se capten del formu
       
       String sql ="";
       String id= String.valueOf(d.getDniSocio());
       String nombre =d.getNombre();
       String area= d.getCarrera();
     
       sql= "insert into socioest(id, nombre , materia)"
               + "values(?,?,?)";
       String mensaje = "El nuevo Socio se ha cargado de manera Satisfactoria...";
       try {
       
        
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, nombre);
            pst.setString(3, area);
            int n = pst.executeUpdate();
            if(n> 0)
            {
                JOptionPane.showMessageDialog(null,mensaje);
            }
              
            
        } 
       catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
       
       // TODO add your handling code here:
    }
    public void guardarLibro(Libro d) {
          
         ConexionMySQL mysql= new ConexionMySQL();
            Connection cn= mysql.Conectar();
       
       String sql ="";
       String titulo= String.valueOf(d.getTitulo());
       String edic =String.valueOf(d.getEdicion());
       String edit= d.getEditorial();
       String año = String.valueOf(d.getAnio());
       
     
       sql= "insert into librojava(titulo, edicion ,editorial, año)"
               + "values(?,?,?,?)";
       String mensaje = "El nuevo libro se ha cargado de manera Satisfactoria...";
       try {
       
        
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, titulo);
            pst.setString(2, edic);
            pst.setString(3, edit);
            pst.setString(4,año);
            int n = pst.executeUpdate();
            if(n> 0)
            {
                JOptionPane.showMessageDialog(null,mensaje);
            }
              
            
        } 
       catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
       
       // TODO add your handling code here:
    }
    
}
