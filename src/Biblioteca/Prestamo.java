package Biblioteca;
/**
 * Clase prestamo.
 * 
 * @author (Pedro SV) 
 * @version (1)
 */

import java.util.*;

public class Prestamo{
    private Calendar fechaRetiro;
    private Calendar fechaDevolucion; 
    private Socio socio;
    private  Libro libro;
    
    /**
     * Contructor de la clase con tres parametros, la fecha en q se retira el libro, el socio q retira, y el libro.
     */
    public Prestamo(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro){
        this.setFechaRetiro(p_fechaRetiro);
        this.setFechaDevolucion(null);
        this.setSocio(p_socio);
        this.setLibro(p_libro);
    }
    
    /**
     * Contructor de la clase con dos parametros, el socio q retira, y el libro.
     */
    public Prestamo(Socio p_socio, Libro p_libro){
        this.setFechaRetiro(new GregorianCalendar());
        this.setFechaDevolucion(null);
        this.setSocio(p_socio);
        this.setLibro(p_libro);
    }
    
            private void setFechaRetiro(Calendar p_fecha){
                this.fechaRetiro = p_fecha ;
            }
            
                public void setFechaDevolucion(Calendar p_fecha){
                this.fechaDevolucion = p_fecha ;
            }
            
                private void setSocio(Socio p_socio){
                this.socio = p_socio ;
            }
            
                private void setLibro(Libro p_libro){
                this.libro = p_libro ;
            }
    
            /**
             * obtener la fecha en q se retiro el libro
             */
            public Calendar getFechaRetiro(){
                return this.fechaRetiro;
            }
            
            /**
             * obtener la fecha en q se devolvio el libro
             */
            public Calendar getFechaDevolucion(){
                return this.fechaDevolucion;
            }
            
            /**
             * obtner el socio con el q se trata
             */
            public Socio getSocio(){
                return this.socio;
            }
            
            /**
             * obtener el libro q se retiro
             */
            public Libro getLibro(){
                return this.libro;
            }
         
            /**
             * Devuelve true si ya pasaron mas de 20 dias de la fecha de retiro.
             */
     public boolean vencido(Calendar p_fecha){
        Calendar fechaLimite = this.getFechaRetiro();
        fechaLimite.add(Calendar.DATE, this.getSocio().getDiasPrestamo());
         if (p_fecha.after(fechaLimite)) {
             return true;}
         else{ return false;}
   }
            
   /**
    * Genera y devuelve un string q contiene los siguientes datos: Fecha de retiro, fecha de devolucion, titulo del libro
    * nombre del socio.
    */
   public String toString(){
       return ("Retiro: "+this.getFechaRetiro()+" - Devolucion: "+this.getFechaDevolucion()
       +"\n Libro: "+this.getLibro().getTitulo()+
       "\n Socio: "+this.getSocio().getNombre());
    }
}
         
    
   

