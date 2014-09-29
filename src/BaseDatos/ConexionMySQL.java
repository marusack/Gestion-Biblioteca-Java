/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * conexion para sistema de biblioitecas- Proyecto integrador de java
 * intercatedra Taller2 POO
  * @author mariel sack ceppi
 */
public class ConexionMySQL {
    
    public String db="biblioteca";//nombre de la base de datos
    public String url="jdbc:mysql://localhost/"+db;
    public String user="root";//nombre de ususario Wamp 
    public String pass="";//contraseña del usuario
 
        public ConexionMySQL(){}
        public Connection Conectar(){
            Connection link =null;//objeto del tipo conecction que me permite cargar un identificador de coneccion
            try
                {//cargamos el driver mysql
                Class.forName("org.gjt.mm.mysql.Driver");
                //creamos un enlace hacia la base de datos
                link = DriverManager.getConnection(this.url,this.user, this.pass);
                }
            catch (Exception e)
                { 
                    JOptionPane.showMessageDialog(null, e);// en caso de error muestra el mensaje
                    }
            return link;
        }


}
