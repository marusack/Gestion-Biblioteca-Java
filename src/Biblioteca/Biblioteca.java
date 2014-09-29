package Biblioteca;
import java.util.*;
public class Biblioteca{
  private ArrayList<Socio> socios;
  private ArrayList<Libro> libros;
  public String nombre;
  
    public Biblioteca(String p_nombre){
        this.setNombre(p_nombre);
        this.setSocios (new ArrayList <Socio>());
        this.setLibros (new ArrayList<Libro>());
    } 
    private void setSocios (ArrayList<Socio> p_socio){
       this.socios=p_socio;
    }
    private void setLibros (ArrayList<Libro> p_libro){
       this.libros=p_libro;
    }
    public ArrayList <Socio> getSocios (){
      return this.socios;
    }
    public ArrayList <Libro> getLibros (){
      return this.libros;
    }
    private void setNombre (String p_nombre){
        this.nombre = p_nombre;
    }
    public String getNombre (){
        return this.nombre;
    }
    public void addSocio (Socio p_socio){
        this.getSocios().add(p_socio);
    }
    public void removeSocio(Socio p_socio){
            this.getSocios().remove(p_socio);
        }
    public void addLibro(Libro p_libro){
        this.getLibros().add(p_libro);
        }
    public void removeLibro(Libro p_libro){
        this.getLibros().remove(p_libro);
        } 
    public void nuevoLibro(String p_titulo, int p_edicion, String p_editorial,int p_anio){
       Libro libro = new Libro(p_titulo,p_edicion,p_editorial,p_anio);
       this.addLibro(libro);
    }
    public void nuevoSocioEstudiante(int p_idSocio,String p_nombre,String p_carrera){
        Estudiante estudiante = new Estudiante(p_idSocio, p_nombre, p_carrera);
        this.addSocio(estudiante);
    }
    public  void nuevoSocioDocente(int p_idSocio,String p_nombre,String p_area){
        Docente docente = new Docente(p_idSocio, p_nombre, p_area);
        this.addSocio(docente);
    }
    public int cantidadSociosPorTipo(String p_objeto){
       
        int cont=0;
        for (int i=0 ;i < this.getSocios().size();i++){ 
            if (this.getSocios().get(i).soyDeLaClase()==p_objeto){
                cont = cont + 1;
                
                 }
                    }
                    return cont;
    }
    public boolean prestarLibro (Calendar p_fechaRetiro, Socio p_socio, Libro p_libro){
        if ((p_libro.prestado()) == false){
          if ((p_socio.puedePedir()) == true){
              Prestamo prestamo = new Prestamo (p_fechaRetiro, p_socio, p_libro);
              p_libro.addPrestamo(prestamo);
              p_socio.addPrestamo(prestamo);
              return true;
          }
      }
      return false;
            }
     public void devolverLibro (Libro p_libro){
      Calendar fechaHoy = new GregorianCalendar();        
      Prestamo prestamo = p_libro.getPrestamo();
      prestamo.setFechaDevolucion(fechaHoy);
      prestamo.getSocio().removePrestamo(prestamo);
    }
    /**
    * Retorna una colecci�n con los pr�stamos vencidos al d�a de la fecha de la clase Biblioteca.
    * @return Un valor del tipo ArrayList.
    */
    public ArrayList <Prestamo> prestamosVencidos (){
       Calendar fechadehoy = new GregorianCalendar();
      ArrayList <Prestamo> presVencidos = new ArrayList<Prestamo>();
      for(int i=0;i<this.getSocios().size();i++){
          Socio socio = this.getSocios().get(i);
          String nombre = socio.soyDeLaClase();
         for (int j=0;j<socio.getPrestamos().size();j++){
                      Prestamo pre = ((Prestamo)socio.getPrestamos().get(j));
                      if (pre.vencido(fechadehoy)){
                          presVencidos.add(pre);
                      }
                  }
                }
      return presVencidos;
    }
     /**
    * Retorna una colecci�n con los docentes responsables de la clase Biblioteca.
    * @return Un valor del tipo ArrayList.
    */
     public ArrayList <Docente> docentesResponsables (){
      ArrayList <Docente> docRes = new ArrayList <Docente> ();
      for (int i=0;i<this.getSocios().size();i++){
          Socio socio = this.getSocios().get(i);
          String nombre = socio.soyDeLaClase();
          if (nombre.equals("Docente")){
              Docente docente = (Docente)this.getSocios().get(i);
              if (docente.esResponsable()){
                  docRes.add(docente);
              }
          }
      }
      return docRes;
    }
     /**
 * Retorna el nombre del Socio que tiene el libro con el t�tulo ingresado como parametro de la clase Biblioteca.
 * @param Libro p_libro.
 * @return Un valor del tipo String.
 */
  public String quienTieneElLibro (Libro p_libro){
      if (p_libro.prestado()){
          return (p_libro.getPrestamo().getSocio().getNombre()+" tiene el libro "+p_libro.getTitulo());
      }
      else{
          return ("El libro "+p_libro.getTitulo()+" se encuentra en la biblioteca");
      } 
  }
    
 /**
 * Retorna una lista de socios de la clase Biblioteca.
 * @return Un valor del tipo String.
 */
  public String listaDeSocios (){
      String encabezado = "Lista de Socios: \n\n";
      String impresion = "";
      for (int i=0;i<this.getSocios().size();i++){
          Socio socio = (Socio)this.getSocios().get(i);
          impresion = impresion+(i+1)+")"+socio.toString();
      }
      return (encabezado+impresion); 
  }
    
 /**
 * Retorna una lista de libros de la clase Biblioteca.
 * @return Un valor del tipo String.
 */
  public String listaDeLibros (){
      String encabezado = "Lista de Libros: \n\n";
      String impresion = "";
      String cond="";
      for(int i=0;i<this.getLibros().size();i++){
          Libro libro = (Libro)this.getLibros().get(i);
          if (libro.prestado() == true){
              cond = "(Si)";
          }
          else{
              cond = "(No)";
          }
          impresion=impresion+(i+1)+")"+libro.toString()+" || Prestado: "+cond+"\n";
      }
      return (encabezado+impresion);
  }
 /**
 * Retorna el socio que tiene el dni pasado como par�metro, o null si no lo encuentra de la clase Biblioteca.
 * @param int p_dni.
 * @return Un valor del tipo Socio.
 */
  public Socio buscarSocio (int dni){
      int aux = -1;
      for (int i=0;i<this.getSocios().size();i++){
          Socio socio = (Socio)this.getSocios().get(i);
          if (dni == socio.getDniSocio()){
              aux = i;
          }
      }
      return this.getSocios().get(aux);
  } 
   /**
 * Retorna una lista de los docentes responsables de la clase Biblioteca.
 * @return Un valor del tipo String.
 */
  public String listaDeDocentesResponsables (){
      String encabezado = "Lista de Docentes Responsables: \n\n";
      String impresion = " ";
      for (int i=0;i<this.docentesResponsables().size();i++){
          Docente docente = (Docente)this.docentesResponsables().get(i);
          impresion = impresion+"* D.N.I.: "+docente.getDniSocio()+" || Nombre y Apellido: "+docente.getNombre()+" || Libros Prestados: "+docente.cantLibrosPrestados()+"\n";
      }
      return (encabezado+impresion);
  }
} 