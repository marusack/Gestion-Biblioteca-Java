package Biblioteca;
import java.util.*;
/**
 * Write a description of class Libro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Libro{

    private String titulo;
    private int edicion;
    private String editorial;
    private int anio;
    private ArrayList<Prestamo> prestamos;

    //constructor
    public Libro(String p_titulo,int p_edicion,String p_editorial,int p_anio){
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(new ArrayList());

    }

    //setters  
    private void setTitulo(String p_titulo){
        this.titulo = p_titulo;
    }

    private void setEdicion(int p_edicion){
        this.edicion = p_edicion;
    }

    private void setEditorial(String p_editorial){
        this.editorial = p_editorial;
    }

    private void setAnio (int p_anio){
        this.anio = p_anio;
    }

    private void setPrestamos(ArrayList<Prestamo> p_prestamo){

        this.prestamos = p_prestamo;
    }
    //getters
    public ArrayList<Prestamo> getPrestamos(){
        return this.prestamos;
    }

    public Prestamo getPrestamo(){

            
        return this.getPrestamos().get(this.getPrestamos().size()-1);

    }

    public String getTitulo(){

        return this.titulo;
    }

    public int getEdicion(){

        return this.edicion;
    }

    public String getEditorial(){

        return this.editorial;
    }

    public int getAnio(){
        return this.anio;
    }

    public void addPrestamo(Prestamo p_prestamo){
        this.getPrestamos().add(p_prestamo);
    }

    public void removePrestamo(Prestamo p_prestamo){
        this.getPrestamos().remove(p_prestamo);
    }

    public boolean prestado(){
        for (Prestamo x: this.getPrestamos()){
            if ((this.getTitulo())==(x.getLibro().getTitulo())){
                return true;
            }
        }
            return false;
        }
    

    public String toString(){
        return "Titulo : "+this.getTitulo();
    }
}

            
        
        
          
      
        
    
    