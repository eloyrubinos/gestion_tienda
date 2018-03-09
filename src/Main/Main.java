/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import proyecto.Administracion.*;
import proyecto.Libreria.*;

/**
 *
 * @author eloy.rubinos
 */

public class Main {
    
    public static void escrituraObjeto(Object objeto) {
        try {
            FileOutputStream fos = new FileOutputStream("libreria.bin");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            if(objeto!=null) {
                out.writeObject(objeto);
            }
        } catch(IOException exception) {
            System.out.println("Error de escritura.");
        }
    }
    public static Object lecturaObjeto() {
        Object objeto= null;
        try {
            FileInputStream fis = new FileInputStream("libreria.bin");
            ObjectInputStream in = new ObjectInputStream(fis);
            objeto= in.readObject();
        } catch(IOException exception) {
            System.out.println("Error de lectura.");
        } catch(ClassNotFoundException exception) {
            System.out.println("Error de lectura. Clase no encontrada.");
        }
        return objeto;
    }

    
    public static void main(String[] args) {
        Libreria milib = (Libreria)lecturaObjeto();
        if(milib == null) {milib = new Libreria();}       
        
        /*
        //Datos para probar metodos
        
        //Cliente
        Cliente prueba = new Cliente("11111111Z", "ASD", "Rua Lolas", "cliente@", "asd", "asd", 1111111111111111L);
        milib.AltaCliente(prueba);        
        
        //Subcategorias
        milib.addCategoria("fantasia", "l"); milib.addCategoria("ciencia ficcion", "l");
        milib.addCategoria("actualidad", "r"); milib.addCategoria("ciencia", "r");
        milib.addCategoria("deportes", "p"); milib.addCategoria("local", "p");
        
        //Libros
        String resumen;
        
        resumen="Cuenta la historia de un niño que queda huerfano y gracias a su ingenio consigue sobrevivir en un mundo de magia";
        Libro l1 = new Libro("1234567891234", "El nombre del viento", 10, 25.5, resumen, "Patrick", "Debolsillo", "Fantasia", 2);
        
        resumen="La historia de un mundo realista si puediese percibirse a traves de las distintas eras en su conjunto";
        Libro l2 = new Libro("1234567891235", "La rueda del tiempo", 1, 30, resumen, "Robert Jordan", "Debolsillo", "Fantasia", 1);

        resumen="Un niño queda atrapado en un mundo desconocido y tendra que conseguir escapar";
        Libro l3 = new Libro("1234567891236", "La historia interminable", 5, 30.0, resumen, "Michael Ende", "BLALA", "Infantil", 2);
        
        resumen="Libro infantil que enseña sobre los acontecimientos historicos mas importantes de la historia";
        Libro l4 = new Libro("1234567891237", "Calvin viaja en el tiempo", 5, 30.0, resumen, "Michele Orson", "BLALA", "Infantil", 2);

        milib.addLibro(l1, "f"); milib.addLibro(l2, "cf"); milib.addLibro(l3, "f"); milib.addLibro(l4, "cf");
        
        //Revistas
        resumen="revista pseudocultural que trata temas de actualidad de forma satirica";
        Revista r1 = new Revista("1234-5678", "El jueves", 2, 2, resumen, 15.5);

        resumen="revista de informatica y en general tecnologia que trata temas de actualidad a nivel de usuario medio";
        Revista r2 = new Revista("1234-5679", "Computer hoy", 1, 4, resumen, 20);

        resumen="trata temas de la prensa rosa";
        Revista r3 = new Revista("1234-5677", "Asd", 20, 2, resumen, 10);

        resumen="temas muy variados sobre cultura y ciencia tanto actuales como revisiones del pasado";
        Revista r4 = new Revista("1234-5676", "e-Zine", 20, 2, resumen, 10);

        milib.addRevista(r1, "a"); milib.addRevista(r2, "c"); milib.addRevista(r3, "a"); milib.addRevista(r4, "c");
        
        //Periodicos
        GregorianCalendar fecha = new GregorianCalendar(2013, 10, 17);

        resumen="periodico conservador de ambito local";        
        Periodico p1 = new Periodico("4321-4321", "El progreso", 15, 2.5, resumen, fecha, 30);

        resumen="periodico progresista de ambito nacional";
        Periodico p2 = new Periodico("4321-4322", "El mundo", 1, 2.5, resumen, fecha, 30);

        resumen="periodico de actualidad deportiva a nivel nacional";
        Periodico p3 = new Periodico("4321-4323", "Marca", 10, 3, resumen, fecha, 50);

        resumen="periodico de actualidad deportiva a nivel local";
        Periodico p4 = new Periodico("4321-4324", "Lugo", 10, 3, resumen, fecha, 50);

        milib.addPeriodico(p1, "l"); milib.addPeriodico(p2, "l"); milib.addPeriodico(p3, "d"); milib.addPeriodico(p4, "d");
        
        //Vendedor
        Vendedor vendedor = new Vendedor("11111111Z", "vendedor", "Avn 123 lol", "vendedor@", "vendedor", "vendedor", 1111111111L, 666555444, 950.50);
        milib.AltaVendedor(vendedor);
        
        // Fin datos de prueba*/
        
        //System.out.println("Uso 'NullPointerException', 'InputMismatchException' y las 3 de mi jerarquia.\nLos dos nuevos métodos están en el menú inicial para que sean más fáciles de probar.");
        
        Menu menu = new Menu(milib);        
        menu.iniciarMenu();               
        
        escrituraObjeto(milib);
}
}