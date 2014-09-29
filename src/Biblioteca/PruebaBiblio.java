package Biblioteca;
import java.util.*;
public class PruebaBiblio{ 
    public static void main(String[] args){
        Biblioteca miBiblioteca = new Biblioteca("Aranduroga");
        //incorporar un nuevo docente
        Formu f= new Formu();
        f.setVisible(true);
        //miBiblioteca.addSocio(profe); esto pararia a ser el archivo socioDocente
        
        FormuEst fe= new FormuEst();
        fe.setVisible(true);
        
        FormLibro l=new FormLibro();
        l.setVisible(true);
       // miBiblioteca.prestarLibro(new GregorianCalendar(),alumno, miLibro);
        
        
        Calendar fRetiro = Calendar.getInstance();
        fRetiro.set(2012,11,12);
       
   
//        miBiblioteca.prestarLibro(fRetiro,alumno,miLibro);
//        miBiblioteca.devolverLibro(miLibro);
//        miBiblioteca.prestarLibro(fRetiro,profe,miLibro);
//        
//       
//        System.out.println("Cantidad de Socios Estudiantes: "+ miBiblioteca.cantidadSociosPorTipo("Estudiante"));
//        System.out.println(miBiblioteca.listaDeDocentesResponsables());
//        System.out.println(miBiblioteca.listaDeLibros());
//        System.out.println(miBiblioteca.listaDeSocios());
//        
//        //Libro miLibro=new Libro("Programar JAVA en 21 d�as", 5, "AZ",2005);
//        System.out.println(miBiblioteca.quienTieneElLibro(miLibro));
    }
}
