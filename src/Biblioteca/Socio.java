package Biblioteca;
/**
 * Clase abtracta, donde se modela al socio.
 * Cada socio posee una lista de prestamos donde se asientan los prestamos en su poder.
 * 
 * @author (Pedro SV) 
 * @version (1)
 */
import java.util.*;

public abstract class Socio{
    
    private int dniSocio;
    private String nombre;
    private int diasPrestamo;
    private ArrayList<Prestamo> prestamos;

    /**
     * Constructor de la clase con tres parametros, dni y nombre del socio, los dias de prestamo.
     * se inicia con una lista vacia de prestamos.
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo){
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList<Prestamo>());
    }
    
     /**
     * Constructor de la clase con dos parametros, dni y los dias de prestamo.
     * Se inicia con una lista vacia de prestamos.
     */
    public Socio(int p_idSocio, int p_diasPrestamo){
        this.setDniSocio(p_idSocio);
        this.setNombre(" ");
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList<Prestamo>());
    }
    
        private void setDniSocio(int p_dniSocio){
            this.dniSocio = p_dniSocio;
        }
        
        /**
         * Obtener dni del socio.
         */
        public int getDniSocio(){
            return this.dniSocio;
        }
        
        private void setNombre(String p_nombre){
            this.nombre = p_nombre;
        }
        
        /**
         * obtener nombre del socio.
         */
        public String getNombre(){
            return this.nombre;
        }
        
        public void setDiasPrestamo(int p_dias){
            this.diasPrestamo = p_dias;
        }
        
        /**
         * obtener dias de prestamo
         */
        public int getDiasPrestamo(){
            return this.diasPrestamo;
        }
        
        private void setPrestamos(ArrayList<Prestamo> p_prestamos){
            this.prestamos = p_prestamos;
        }
        
        /**
         * Obtener la lista de prestamos.
         */
        public ArrayList<Prestamo> getPrestamos(){
            return this.prestamos;
        }
        
        /**
         * Agrega un prestamo a la lista.
         * @param un objeto de clase prestamo
         */
        public void addPrestamo(Prestamo p_prestamo){
            this.getPrestamos().add(p_prestamo);
        }
        
        /**
         * Quita un prestamo de la lista.
         * @param un objeto de clase prestamo
         */
        public void removePrestamo(Prestamo p_prestamo){
            this.getPrestamos().remove(p_prestamo);
        }
        
        /**
         * Devuelve la cantidad de libros prestados actualmente
         * (La cantidad de prestamos en la lista)
         */
        public int cantLibrosPrestados(){
            int prestados = 0;
            for (Prestamo aux: this.getPrestamos()){
            if (aux.getFechaDevolucion() == null){
                prestados++;
            }
        }
            return prestados;
    }
        
        /**
         * Clase abstracta
         * @return un string con el tipo de clase.
         */
        public abstract String soyDeLaClase();
        
        /**
         * Metodo que indica si el socio esta en condiciones de pedir otro libro
         * @return true si ninguno de los prestamos q ya tiene esta vencido.
         */
        public boolean puedePedir(){
        boolean puede = true;
        Calendar hoy = new GregorianCalendar();
        for (Prestamo aux: this.getPrestamos()){
            if (aux.vencido(hoy)) { // si alguno de los prestamos esta vencido (vencido() : true) se negara la condicion "puedePedir" (false)
                puede = false;
            }
        }
            return puede;
        }
    
        /**
         * metodo toSrtring, genera un String con los datos del socio.
         * @return String:  dni, nombre, clase, cantidad de libros prestados.  
         */
        public String toString(){
            return ("DNI: "+this.getDniSocio()+" || "+ this.getNombre() +" (" + this.soyDeLaClase()+") || Libros prestados: "+this.cantLibrosPrestados()); 
        }

}

    


