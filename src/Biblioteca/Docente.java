package Biblioteca;
import java.util.*;
public class Docente extends Socio{
    private String area;
    
    public Docente(int p_idSocio, String p_nombre, String p_area){
        super(p_idSocio, p_nombre, 5);
        this.setArea(p_area);
    }
    public Docente(int p_idSocio, String p_area){
        super(p_idSocio, 5);
        this.setArea(p_area);
    }
    
    private void setArea(String p_area){
        this.area = p_area;
    }
    public String getArea(){
        return this.area;
    }
       
    public boolean esResponsable(){
        if(this.puedePedir()){
            return true;
        } else {
            return false;
        }
    }
    public void agregarDiasDePrestamo(int p_dias){
        if(this.esResponsable()){
        this.setDiasPrestamo(p_dias);
       }
    }
    public String soyDeLaClase(){
        return "Docente";
    }
}