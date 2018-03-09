/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.ArrayList;
import proyecto.Administracion.*;
import proyecto.Libreria.*;

/**
 *
 * @author Eloy
 */
public interface ILibreria extends Tienda{
    double descuentol = 15D;
    double descuentor = 5D;
    double descuentop = 5D;
    
    ArrayList<Libro> getLibros();
    Libro getLibro(String _isbn);
    void addLibro(Libro libro, String tipo);
    
    ArrayList<Revista> getRevistas();
    Revista getRevista(String _issn);
    void addRevista(Revista revista, String tipo);
    
    ArrayList<Periodico> getPeriodicos();
    Periodico getPeriodico(String _issn);
    void addPeriodico(Periodico periodico, String tipo);
    
    ArrayList<String> getCategorias(String _tipo);
    void addCategoria(String nombre, String tipo);
    void removeCategoria(String _categoria, String tipo);
    void setCategorias(ArrayList<String> _categorias, String tipo);
    
    double getDescuento(String _tipo);
    
    ArrayList<Libro> ordenarLibros(ArrayList<Libro> libros);
    ArrayList<Libro> ordenarLibros(ArrayList<Libro> libros, Cliente c);
    ArrayList<Libro> ordenarLibros(ArrayList<Libro> libros, ArrayList<String> claves);
    ArrayList<Libro> ordenarNLibros(ArrayList<Libro> libros, Cliente c);
    
    ArrayList<Revista> ordenarRevistas(ArrayList<Revista> revistas);
    ArrayList<Revista> ordenarRevistas(ArrayList<Revista> revistas, Cliente c);
    ArrayList<Revista> ordenarRevistas(ArrayList<Revista> revistas, ArrayList<String> claves);
    ArrayList<Revista> ordenarNRevistas(ArrayList<Revista> revistas, Cliente c);
    
    ArrayList<Periodico> ordenarPeriodicos(ArrayList<Periodico> periodicos);
    ArrayList<Periodico> ordenarPeriodicos(ArrayList<Periodico> periodicos, Cliente c);
    ArrayList<Periodico> ordenarPeriodicos(ArrayList<Periodico> periodicos, ArrayList<String> claves);
    ArrayList<Periodico> ordenarNPeriodicos(ArrayList<Periodico> periodicos, Cliente c);
    
    void imprimirLibros(ArrayList<Libro> libros, String tipo);
    void imprimirRevistas(ArrayList<Revista> r, String tipo);
    void imprimirPeriodicos(ArrayList<Periodico> p, String tipo);
    void imprimirCategorias(Cliente c, String tipo);
    void imprimirCategorias(String tipo);
    
    void comprarLibroNombre(Cliente c);
    void comprarLibroGenero(Cliente c);
    void comprarLibroClave(Cliente c);
    void comprarLibroAutor(Cliente c);
    
    void comprarRevistaNombre(Cliente c);
    void comprarRevistaGenero(Cliente c);
    void comprarRevistaClave(Cliente c);
    
    void comprarPeriodicoNombre(Cliente c);
    void comprarPeriodicoGenero(Cliente c);
    void comprarPeriodicoClave(Cliente c);
    
    void carritoAObjeto(Cliente c, ArrayList<Libro> libros, ArrayList<Revista> revistas, ArrayList<Revista> revistass, ArrayList<Periodico> periodicos, ArrayList<Periodico> periodicoss);
    void carritoVer(Cliente c);
    void carritoEliminar(Cliente c);
    void carritoFinalizar(Cliente c);
    void carritoReset(Cliente c);
    
    void adminSaldo(Cliente c);
    void adminPremium(Cliente c, Boolean tipo);
    void adminCleanH(Cliente c);
    int adminBorrarCliente(Cliente c);
    
    void consultarLibroId();
    void consultarLibroC();
    
    void consultarRevistaId();
    void consultarRevistaC();
    
    void consultarPeriodicoId();
    void consultarPeriodicoC();
    
    void crearLibro();
    void crearRevista();
    void crearPeriodico();
    
    void modificarLibro();
    void modificarRevista();
    void modificarPeriodico();
    
    void eliminarLibro();
    void eliminarRevista();
    void eliminarPeriodico();   
    
    public void imprimirBestsellersCat();
    public void imprimirCatGanancias();
}
