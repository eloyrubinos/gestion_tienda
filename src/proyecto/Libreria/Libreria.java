/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Libreria;

import Exceptions.RepeatException;
import Exceptions.RetryException;
import Exceptions.SetException;
import Interfaces.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import proyecto.Administracion.*;

/**
 *
 * @author eloy.rubinos
 */
public class Libreria implements Serializable, ILibreria{
    protected ArrayList<Cliente> bdclientes;
    protected ArrayList<Vendedor> bdvendedores;
    protected ArrayList<Libro> bdlibros;
    protected ArrayList<Revista> bdrevistas;
    protected ArrayList<Periodico> bdperiodicos;
    protected ArrayList<Fantasia> bdfantasia;
    protected ArrayList<CienciaFiccion> bdcienciaficcion;
    protected ArrayList<Actualidad> bdactualidad;
    protected ArrayList<Ciencia> bdciencia;
    protected ArrayList<Deportes> bddeportes;
    protected ArrayList<Local> bdlocales;
    protected ArrayList<String> bdsubcategoriasl;
    protected ArrayList<String> bdsubcategoriasr;
    protected ArrayList<String> bdsubcategoriasp;
    
    public Libreria(){
        bdclientes = new ArrayList();
        bdvendedores = new ArrayList();
        bdlibros = new ArrayList();
        bdrevistas = new ArrayList();
        bdperiodicos = new ArrayList();
        bdfantasia = new ArrayList();
        bdcienciaficcion = new ArrayList();
        bdactualidad = new ArrayList();
        bdciencia = new ArrayList();
        bddeportes = new ArrayList();
        bdlocales = new ArrayList();
        bdsubcategoriasl = new ArrayList();
        bdsubcategoriasr = new ArrayList();
        bdsubcategoriasp = new ArrayList();
    }
    public Libreria(ArrayList<Cliente> _clientes, ArrayList<Vendedor> _vendedores, ArrayList<Libro> _libros, ArrayList<Fantasia> _fantasia, ArrayList<CienciaFiccion> _cienciaficcion, ArrayList<Revista> _revistas, ArrayList<Actualidad> _actualidad, ArrayList<Ciencia> _ciencia, ArrayList<Periodico> _periodicos, ArrayList<Deportes> _deportes, ArrayList<Local> _locales, ArrayList<String> _subcategoriasl, ArrayList<String> _subcategoriasr, ArrayList<String> _subcategoriasp){
        bdclientes = new ArrayList(_clientes);
        bdvendedores = new ArrayList(_vendedores);
        bdlibros = new ArrayList(_libros);
        bdrevistas = new ArrayList(_revistas);
        bdperiodicos = new ArrayList(_periodicos);
        bdfantasia = new ArrayList(_fantasia);
        bdcienciaficcion = new ArrayList(_cienciaficcion);
        bdactualidad = new ArrayList(_actualidad);
        bdciencia = new ArrayList(_ciencia);
        bddeportes = new ArrayList(_deportes);
        bdlocales = new ArrayList(_locales);
        bdsubcategoriasl = new ArrayList(_subcategoriasl);
        bdsubcategoriasr = new ArrayList(_subcategoriasr);
        bdsubcategoriasp = new ArrayList(_subcategoriasp);
    }
    
    public ArrayList<Cliente> getClientes(){
        return bdclientes;
    }
    public void AltaCliente(Cliente c){
        try{
        bdclientes.add(c);
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void BajaCliente(String _dni){
        try{
        int i;
        for(i=0;i<bdclientes.size();i++){
            if(bdclientes.get(i).getDni().equals(_dni)){
                bdclientes.remove(i);
            }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void BajaCliente(Cliente c){
        try{
        int i;
        for(i=0;i<bdclientes.size();i++){
            if(bdclientes.get(i).getDni().equals(c.getDni())){
                bdclientes.remove(i);
            }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    
    public ArrayList<Vendedor> getVendedores(){
        Libro c = new Libro();
        return bdvendedores;
    }
    public void AltaVendedor(Vendedor v){
        try{
        bdvendedores.add(v);
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void BajaVendedor(String _dni){
        try{
        int i;
        for(i=0;i<bdvendedores.size();i++){
            if(bdvendedores.get(i).getDni().equals(_dni)){
                bdvendedores.remove(i);
            }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void BajaVendedor(Vendedor v){
        try{
        int i;
        for(i=0;i<bdvendedores.size();i++){
            if(bdvendedores.get(i).getDni().equals(v.getDni())){
                bdvendedores.remove(i);
            }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
        
    public ArrayList<Libro> getLibros(){
        return bdlibros;
    } 
    public Libro getLibro(String _isbn){
        Libro l = null;
        for(int i=0;i<bdlibros.size();i++){
            if(bdlibros.get(i).codigo.equals(_isbn)) l = bdlibros.get(i);
        }
        return l;
    }
    public void addLibro(Libro libro, String tipo){
        try{
        int cont = 0;
        for(int i=0;i<bdlibros.size();i++){
            if(bdlibros.get(i).codigo.equals(libro.codigo)) cont++;
        }
        if(cont!=0) System.out.println("Ese libro ya existe en la base de datos");
        else{
            bdlibros.add(libro);
            switch(tipo){
                case "f":
                    Fantasia f1 = new Fantasia(libro.codigo, libro.nombre, libro.stock, libro.precio, libro.resumen, libro.autor, libro.editorial, libro.genero, libro.edicion);
                    bdfantasia.add(f1);
                    break;
                case "cf":
                    CienciaFiccion cf1 = new CienciaFiccion(libro.codigo, libro.nombre, libro.stock, libro.precio, libro.resumen, libro.autor, libro.editorial, libro.genero, libro.edicion);
                    bdcienciaficcion.add(cf1);
                    break;
            }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    
    public ArrayList<Revista> getRevistas(){
        return bdrevistas;
    }
    public Revista getRevista(String _issn){
        Revista r = null;
        if(_issn.charAt(_issn.length()-1)=='s') _issn = _issn.substring(0, (_issn.length()-1));
        for(int i=0;i<bdrevistas.size();i++){
            if(bdrevistas.get(i).codigo.equals(_issn)) r = bdrevistas.get(i);
        }
        return r;
    }
    public void addRevista(Revista revista, String tipo){
        try{
        int cont = 0;
        for(int i=0;i<bdrevistas.size();i++){
            if(bdrevistas.get(i).codigo.equals(revista.codigo)) cont++;
        }
        if(cont!=0) System.out.println("Esa revista ya existe en la base de datos");
        else{
            bdrevistas.add(revista);
            switch(tipo){
                case "a":
                    Actualidad a1 = new Actualidad(revista.codigo, revista.nombre, revista.stock, revista.precio, revista.resumen, revista.precioSubscripcion);
                    bdactualidad.add(a1);
                    break;
                case "c":
                    Ciencia c1 = new Ciencia(revista.codigo, revista.nombre, revista.stock, revista.precio, revista.resumen, revista.precioSubscripcion);
                    bdciencia.add(c1);
                    break;
            }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    
    public ArrayList<Periodico> getPeriodicos(){
        return bdperiodicos;
    }  
    public Periodico getPeriodico(String _issn){
        Periodico p = null;
        if(_issn.charAt(_issn.length()-1)=='s') _issn = _issn.substring(0, (_issn.length()-1));
        for(int i=0;i<bdperiodicos.size();i++){
            if(bdperiodicos.get(i).codigo.equals(_issn)) p = bdperiodicos.get(i);
        }
        return p;
    }
    public void addPeriodico(Periodico periodico, String tipo){
        try{
        int cont = 0;
        for(int i=0;i<bdperiodicos.size();i++){
            if(bdperiodicos.get(i).codigo.equals(periodico.codigo)) cont++;
        }
        if(cont!=0) System.out.println("Ese periodico ya existe en la base de datos");
        else{
            bdperiodicos.add(periodico);
            switch(tipo){
                case "d":
                    Deportes d1 = new Deportes(periodico.codigo, periodico.nombre, periodico.stock, periodico.precio, periodico.resumen, periodico.fecha, periodico.precioSubscripcion);
                    bddeportes.add(d1);
                    break;
                case "l":
                    Local l1 = new Local(periodico.codigo, periodico.nombre, periodico.stock, periodico.precio, periodico.resumen, periodico.fecha, periodico.precioSubscripcion);
                    bdlocales.add(l1);
                    break;
            }
        } 
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    
    public ArrayList<String> getCategorias(String _tipo){
        ArrayList<String> aux = new ArrayList<>();
        aux.clear();
        switch(_tipo){
            case "l":
                aux.addAll(bdsubcategoriasl);
                break;
            case "r":
                aux.addAll(bdsubcategoriasr);
                break;
            case "p":
                aux.addAll(bdsubcategoriasp);
                break;            
    }
        return aux;
    }
    public void addCategoria(String nombre, String tipo){
        try{
        int cont=0;
        switch(tipo){
            case "l":
                for(int i=0;i<bdsubcategoriasl.size();i++){
                    if(bdsubcategoriasl.get(i).equalsIgnoreCase(nombre)) cont++;
                }
                if(cont==0) bdsubcategoriasl.add(nombre);
                else throw new RepeatException("Problema con las subcategorias de Libro");
                break;
            case "r":
                for(int i=0;i<bdsubcategoriasr.size();i++){
                    if(bdsubcategoriasr.get(i).equalsIgnoreCase(nombre)) cont++;
                }
                if(cont==0) bdsubcategoriasr.add(nombre);
                else throw new RepeatException("Problema con las subcategorias de Revista");
                break;
            case "p":
                for(int i=0;i<bdsubcategoriasp.size();i++){
                    if(bdsubcategoriasp.get(i).equalsIgnoreCase(nombre)) cont++;
                }
                if(cont==0) bdsubcategoriasp.add(nombre);
                else throw new RepeatException("Problema con las subcategorias de Periodico");
                break;
        }
        }catch(RepeatException ex){
            ex.printError();
            ex.printException();
        }
    }
    public void removeCategoria(String _categoria, String tipo){
        switch(tipo){
            case "l":
                for(int i=0;i<bdsubcategoriasl.size();i++){
                    if(bdsubcategoriasl.get(i).equalsIgnoreCase(_categoria)) bdsubcategoriasl.remove(i);
                }
                break;
            case "r":
                for(int i=0;i<bdsubcategoriasr.size();i++){
                    if(bdsubcategoriasr.get(i).equalsIgnoreCase(_categoria)) bdsubcategoriasr.remove(i);
                }
                break;
            case "p":
                for(int i=0;i<bdsubcategoriasp.size();i++){
                    if(bdsubcategoriasp.get(i).equalsIgnoreCase(_categoria)) bdsubcategoriasp.remove(i);
                }
                break;
        }
    }
    public void setCategorias(ArrayList<String> _categorias, String tipo){
        try{
        int cont=0;
        
        for(int i=0;i<_categorias.size();i++){
            for(int j=1;j<_categorias.size();j++){
                if(_categorias.get(i).equalsIgnoreCase(_categorias.get(j)) && i!=j) cont++;
            }
        }
        if(cont>0) System.out.println("No puede haber categorias repetidas");
        else{
        switch(tipo){
            case "l":
                bdsubcategoriasl.clear();
                bdsubcategoriasl.addAll(_categorias);
                break;
            case "r":
                bdsubcategoriasr.clear();
                bdsubcategoriasr.addAll(_categorias);
                break;
            case "p":
                bdsubcategoriasp.clear();
                bdsubcategoriasp.addAll(_categorias);
                break;
        }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    
    public double getDescuento(String _tipo){
        switch (_tipo) {
            case "l":
                return descuentol;
            case "r":
                return descuentor;
            case "p":
                return descuentop;
            default:
                System.out.println("Ha sucedido un error con el descuento.");
                return 0;
        }
    }
    
    public boolean isCliente(Cliente c){
        try{
        for(int i=0;i<bdclientes.size();i++){
            if(bdclientes.get(i).getUsuario().equals(c.getUsuario())) return true;
        }
        return false;
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
            return false;
        }
    }    
    public boolean isVendedor(Vendedor v){
        try{
        for(int i=0;i<bdvendedores.size();i++){
            if(bdvendedores.get(i).getUsuario().equals(v.getUsuario())) return true;
        }
        return false;
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
            return false;
        }
    }
    
    // Metodos para el main
    
    public int menuInicial(){
        Scanner scani = new Scanner(System.in);
        int opcion;
        System.out.println("-----------------MENU-----------------");
        System.out.println("1)Iniciar Sesion\n2)Crear Usuario\n3)Consultar libreria\n4)Consultar categorias mas vendidas\n5)Consultar categorias con mayor ganancia");
        System.out.println("0)Salir");
        opcion = scani.nextInt()*10;
        switch(opcion){
            case 10:
                System.out.println("-----------------MENU-----------------");
                System.out.println("1)Cliente\n2)Vendedor");
                System.out.println("0)Atras");
                if((opcion += scani.nextInt())==10) opcion=1;
                break;
            case 20:
                System.out.println("-----------------MENU-----------------");
                System.out.println("1)Cliente\n2)Vendedor");
                System.out.println("0)Atras");
                if((opcion += scani.nextInt())==20) opcion=1;
                break;
            case 30:
                System.out.println("-----------------MENU-----------------");
                System.out.println("1)Libros\n2)Revistas\n3)Periodicos");
                System.out.println("0)Atras");
                if((opcion += scani.nextInt())==30) opcion=1;
                break;
            case 40:
                break;
            case 50:
                break;
            case 0:
                opcion=0;
                break;
            case 1:
                opcion=1;
                break;
            default:
                System.out.println("Indice incorrecto");
                opcion=1;
                break;
        }
        return opcion;
    }
    public int menuCliente(int estado){
        Scanner scani = new Scanner(System.in);
        int opcion, aux=0;
        if(estado==0){
        System.out.println("-----------------MENU-----------------");
        System.out.println("1)Catalogos\n2)Compras\n3)Historiales\n4)Administrar cuenta");
        System.out.println("0)Desconectar");
        opcion = scani.nextInt()*100;
        }
        else {
            opcion = estado; //210
            aux = ((opcion/10)%10)*10; //aux=10
            opcion = opcion - aux; //opcion=200
            if(aux!=0) aux = opcion + aux; //aux=210
        }
        switch(opcion){
            case 100:
                System.out.println("-----------------MENU-----------------");
                System.out.println("1)Libros\n2)Revistas\n3)Periodicos");
                System.out.println("0)Atras");
                if((opcion += scani.nextInt())==100) opcion=1;
                break; //100
            case 200:
                if(estado!=0 && aux!=0) opcion = aux;
                else {
                System.out.println("-----------------MENU-----------------");
                System.out.println("1)Libros\n2)Revistas\n3)Periodicos\n4)Carrito");
                System.out.println("0)Atras");                 
                if((opcion += scani.nextInt()*10)==200) {opcion=1; break;} }
                switch(opcion){
                    case 210:
                        System.out.println("-----------------MENU-----------------");
                        System.out.println("1)Por Nombre\n2)Por Genero\n3)Por Autor\n4)Por Palabras Clave");
                        System.out.println("0)Atras");
                        if((opcion += scani.nextInt())==210) opcion=2; 
                        break;    
                    case 220:
                        System.out.println("-----------------MENU-----------------");
                        System.out.println("1)Por Nombre\n2)Por Genero\n3)Por Palabras Clave");
                        System.out.println("0)Atras");
                        if((opcion += scani.nextInt())==220) opcion=2; 
                        break;
                    case 230:
                        System.out.println("-----------------MENU-----------------");
                        System.out.println("1)Por Nombre\n2)Por Genero\n3)Por Palabras Clave");
                        System.out.println("0)Atras");
                        if((opcion += scani.nextInt())==230) opcion=2; 
                        break;
                    case 240:
                        System.out.println("-----------------MENU-----------------");
                        System.out.println("1)Ver elementos en el carrito\n2)Quitar elementos del carrito\n3)Finalizar compra\n4)Resetear carrito");
                        System.out.println("0)Atras");
                        if((opcion += scani.nextInt())==240) opcion=2; 
                        break;
                    case 1:
                        opcion = 1;
                        break;
                    default:
                        System.out.println("Indice incorrecto."); opcion=1;
                        break;
                }
                break; //200
            case 300:                
                break;
            case 400:
                System.out.println("-----------------MENU-----------------");
                System.out.println("1)Añadir saldo\n2)Hacerse premium\n3)Dejar de ser premium\n4)Borrar historiales\n5)Borrar cuenta");
                System.out.println("0)Atras");
                if((opcion += scani.nextInt())==400) opcion=1;
                break; //400
            case 0:
                opcion = 0;
                break;
            case 1:
                opcion = 1;
                break;
            default:
                System.out.println("Indice incorrecto."); opcion=1;
                break;
        }        
        return opcion;
    }
    public int menuVendedor(int estado){
        Scanner scani = new Scanner(System.in);
        int opcion, aux=0;
        if(estado==0){
        System.out.println("-----------------MENU-----------------");
        System.out.println("1)Catalogo de Productos\n2)Gestion de Productos\n3)Gestion de Clientes\n4)Gestion de Ventas");
        System.out.println("0)Desconectar");
        opcion = scani.nextInt()*100;
        }
        else {
            opcion = estado; //210
            aux = ((opcion/10)%10)*10; //aux=10
            opcion = opcion - aux; //opcion=200
            if(aux!=0) aux = opcion + aux; //aux=210
        }
        switch(opcion){
            case 100:
                if(estado!=0 && aux!=0) opcion = aux;
                else {
                System.out.println("-----------------MENU-----------------");
                System.out.println("1)Libros\n2)Revistas\n3)Periodicos");
                System.out.println("0)Atras");
                if((opcion += scani.nextInt()*10)==100) {opcion=1; break;} }
                switch(opcion){
                    case 110:
                        System.out.println("-----------------MENU-----------------");
                        System.out.println("1)Todos\n2)Por ISBN\n3)Por Fecha Creacion");
                        System.out.println("0)Atras");
                        if((opcion += scani.nextInt())==110) opcion=2; 
                        break;    
                    case 120:
                        System.out.println("-----------------MENU-----------------");
                        System.out.println("1)Todos\n2)Por ISSN\n3)Por Fecha Creacion");
                        System.out.println("0)Atras");
                        if((opcion += scani.nextInt())==120) opcion=2; 
                        break;
                    case 130:
                        System.out.println("-----------------MENU-----------------");
                        System.out.println("1)Todos\n2)Por ISSN\n3)Por Fecha Creacion");
                        System.out.println("0)Atras");
                        if((opcion += scani.nextInt())==130) opcion=2; 
                        break;
                    case 1:
                        opcion = 1;
                        break;
                    default:
                        System.out.println("Indice incorrecto."); opcion=1;
                        break;
                }
                break; //100
            case 200:
                if(estado!=0 && aux!=0) opcion = aux;
                else {
                System.out.println("-----------------MENU-----------------");
                System.out.println("1)Introducir Producto\n2)Modificar Producto\n3)Anular Producto");
                System.out.println("0)Atras");                 
                if((opcion += scani.nextInt()*10)==200) {opcion=1; break;} }
                switch(opcion){
                    case 210:
                        System.out.println("-----------------MENU-----------------");
                        System.out.println("1)Libro\n2)Revista\n3)Periodico");
                        System.out.println("0)Atras");
                        if((opcion += scani.nextInt())==210) opcion=3; 
                        break;    
                    case 220:
                        System.out.println("-----------------MENU-----------------");
                        System.out.println("1)Libro\n2)Revista\n3)Periodico");
                        System.out.println("0)Atras");
                        if((opcion += scani.nextInt())==220) opcion=3; 
                        break;
                    case 230:
                        System.out.println("-----------------MENU-----------------");
                        System.out.println("1)Libro\n2)Revista\n3)Periodico");
                        System.out.println("0)Atras");
                        if((opcion += scani.nextInt())==230) opcion=3; 
                        break; 
                    case 1:
                        opcion = 1;
                        break;
                    default:
                        System.out.println("Indice incorrecto."); opcion=1;
                        break;
                }
                break; //200
            case 300:    
                if(estado!=0 && aux!=0) opcion = aux;
                else {
                System.out.println("-----------------MENU-----------------");
                System.out.println("1)Ver Todos\n2)Consulta por Nombre\n3)Mas Consumidores\n4)Inactivos");
                System.out.println("0)Atras");                 
                if((opcion += scani.nextInt()*10)==300) {opcion=1; break;} }
                switch(opcion){
                    case 310:
                        System.out.println("-----------------MENU-----------------");
                        System.out.println("1)Informacion Personal\n2)Informacion comercial\n3)Todo");
                        System.out.println("0)Atras");
                        if((opcion += scani.nextInt())==310) opcion=4; 
                        break;   
                    case 320:
                        System.out.println("-----------------MENU-----------------");
                        System.out.println("1)Informacion Personal\n2)Informacion comercial\n3)Todo");
                        System.out.println("0)Atras");
                        if((opcion += scani.nextInt())==320) opcion=4; 
                        break;
                    case 330:
                        break;
                    case 340: 
                        break;
                    case 1:
                        opcion = 1;
                        break;
                    default:
                        System.out.println("Indice incorrecto."); opcion=1;
                        break;
                }
                break;
            case 400:
                System.out.println("-----------------MENU-----------------");
                System.out.println("1)Ventas y Stock\n2)Ventas por Periodo\n3)Mas Vendidos\n4)No Vendidos(por periodo)");
                System.out.println("0)Atras");
                if((opcion += scani.nextInt())==400) opcion=1;
                break; //400
            case 0:
                opcion = 0;
                break;
            case 1:
                opcion = 1;
                break;
            default:
                System.out.println("Indice incorrecto."); opcion=1;
                break;
        }        
        return opcion;
    }
    
    public Cliente iniciarSesionCliente(){
        Scanner scant = new Scanner(System.in);
        ArrayList<Cliente> a = new ArrayList(getClientes());
        Cliente c;
        String _usuario, _contraseña;
        
        System.out.println("Introducir usuario:");
        _usuario = scant.nextLine();
                
        for(int i=0;i<a.size();i++){
            if(a.get(i).getUsuario().equals(_usuario)){
                c = a.get(i);
                System.out.println("Introducir contraseña");
                _contraseña = scant.nextLine();
                if(!c.getContraseña().equals(_contraseña)) {System.out.println("Contraseña incorrecta"); return null;}
                else {c.Acceder(); return c;}
            }
                }
        
        System.out.println("El usuario no existe.");
        return null;
    }
    public Vendedor iniciarSesionVendedor(){
        Scanner scant = new Scanner(System.in);
        ArrayList<Vendedor> b = new ArrayList(getVendedores());
        Vendedor v;
        String _usuario, _contraseña;
        
        System.out.println("Introducir usuario:");
        _usuario = scant.nextLine();
                
        for(int i=0;i<b.size();i++){
            if(b.get(i).getUsuario().equals(_usuario)){
                v = b.get(i);
                System.out.println("Introducir contraseña");
                _contraseña = scant.nextLine();
                if(!v.getContraseña().equals(_contraseña)) {System.out.println("Contraseña incorrecta"); return null;}
                else return v;
            }
                }
        System.out.println("El usuario no existe.");
        return null;
    }
    
    // Metodos para el cliente
    
    public ArrayList<Libro> ordenarLibros(ArrayList<Libro> libros){
        ArrayList<Libro> orden1 = new ArrayList();
        orden1.addAll(libros);
        Collections.sort(orden1);
        return orden1;
    } //alfabeticamente
    public ArrayList<Libro> ordenarLibros(ArrayList<Libro> libros, Cliente c){
        ArrayList<String> ca = new ArrayList(c.getCategorias());        
        ArrayList<Libro> orden2 = new ArrayList();
        ArrayList<Libro> aux = new ArrayList(libros);
        for(int h=0;h<ca.size();h++){
            ArrayList<Libro> orden1 = new ArrayList();
            Libro l;
            if(ca.get(h).equalsIgnoreCase("fantasia") && !bdfantasia.isEmpty()){
                for(int j=0;j<bdfantasia.size();j++){
                    for( int i=0;i<aux.size();i++){
                        if(aux.get(i).codigo.equals(bdfantasia.get(j).codigo)){
                            l = (Libro) bdfantasia.get(j);
                            orden1.add(l);
                        }
                    }                   
                }
            }
            else if((ca.get(h).equalsIgnoreCase("CienciaFiccion") || ca.get(h).equalsIgnoreCase("Ciencia Ficcion"))&& !bdcienciaficcion.isEmpty()){
                for(int j=0;j<bdcienciaficcion.size();j++){
                    for( int i=0;i<aux.size();i++){
                        if(aux.get(i).codigo.equals(bdcienciaficcion.get(j).codigo)){
                            l = (Libro) bdcienciaficcion.get(j);
                            orden1.add(l);
                        }
                    }
                }
            }
            Collections.sort(orden1);
            orden2.addAll(orden1);
        }
        aux.removeAll(orden2);
        Collections.sort(aux);
        orden2.addAll(aux);
        return orden2;
    } //segun preferencias + alfb
    public ArrayList<Libro> ordenarLibros(ArrayList<Libro> libros, ArrayList<String> claves){
        ArrayList<Libro> orden1 = new ArrayList();
        int[] prioridad = new int[libros.size()]; 
        
        for(int i=0;i<libros.size();i++){
            prioridad[i]=0;
        }
        
        for(int i=0;i<claves.size();i++){
            for(int j=0;j<libros.size();j++){
                int index=0, cont=0;
                while((index=libros.get(j).resumen.indexOf(claves.get(i), index))!=-1){
                    cont++;
                    index++;
                }
                prioridad[j]+=cont;
            }
        }

        int i = 0;
        while(i<libros.size()){
            int aux = 0;
            for(int j=1;j<libros.size();j++){
                if(prioridad[j]>prioridad[j-1]) aux=j;            
            }
            prioridad[aux]=0;
            orden1.add(libros.get(aux));
            i++;
        }
        return orden1;
    } //segun palabras clave + alfb *funciona algo raro*
    public ArrayList<Libro> ordenarNLibros(ArrayList<Libro> libros, Cliente c){
        ArrayList<String> ca = new ArrayList(c.getCategorias());        
        ArrayList<Libro> orden2 = new ArrayList();
        ArrayList<Libro> aux = new ArrayList(libros);
        for(int h=ca.size()-1;h==0;h--){
            ArrayList<Libro> orden1 = new ArrayList();
            Libro l;
            if(ca.get(h).equalsIgnoreCase("fantasia") && !bdfantasia.isEmpty()){
                for(int j=0;j<bdfantasia.size();j++){
                    for( int i=0;i<aux.size();i++){
                        if(aux.get(i).codigo.equals(bdfantasia.get(j).codigo)){
                            l = (Libro) bdfantasia.get(j);
                            orden1.add(l);
                        }
                    }                   
                }
            }
            else if((ca.get(h).equalsIgnoreCase("CienciaFiccion") || ca.get(h).equalsIgnoreCase("Ciencia Ficcion"))&& !bdcienciaficcion.isEmpty()){
                for(int j=0;j<bdcienciaficcion.size();j++){
                    for( int i=0;i<aux.size();i++){
                        if(aux.get(i).codigo.equals(bdcienciaficcion.get(j).codigo)){
                            l = (Libro) bdcienciaficcion.get(j);
                            orden1.add(l);
                        }
                    }
                }
            }
            Collections.sort(orden1);
            orden2.addAll(orden1);
        }
        aux.removeAll(orden2);
        Collections.sort(aux);
        orden2.addAll(0, aux);
        return orden2;
    } //segun preferencias (al reves) + alfb
    public ArrayList<Revista> ordenarRevistas(ArrayList<Revista> revistas){
        ArrayList<Revista> orden1 = new ArrayList();
        orden1.addAll(revistas);
        Collections.sort(orden1);
        return orden1;
    }
    public ArrayList<Revista> ordenarRevistas(ArrayList<Revista> revistas, Cliente c){
        ArrayList<String> ca = new ArrayList(c.getCategorias());        
        ArrayList<Revista> orden2 = new ArrayList();
        ArrayList<Revista> aux = new ArrayList(revistas);
        for(int h=0;h<ca.size();h++){
            ArrayList<Revista> orden1 = new ArrayList();
            Revista l;
            if(ca.get(h).equalsIgnoreCase("actualidad") && !bdactualidad.isEmpty()){
                for(int j=0;j<bdactualidad.size();j++){
                    for( int i=0;i<aux.size();i++){
                        if(aux.get(i).codigo.equals(bdactualidad.get(j).codigo)){
                            l = (Revista) bdactualidad.get(j);
                            orden1.add(l);
                        }
                    }                   
                }
            }
            else if(ca.get(h).equalsIgnoreCase("ciencia") && !bdciencia.isEmpty()){
                for(int j=0;j<bdciencia.size();j++){
                    for( int i=0;i<aux.size();i++){
                        if(aux.get(i).codigo.equals(bdciencia.get(j).codigo)){
                            l = (Revista) bdciencia.get(j);
                            orden1.add(l);
                        }
                    }
                }
            }
            Collections.sort(orden1);
            orden2.addAll(orden1);
        }
        aux.removeAll(orden2);
        Collections.sort(aux);
        orden2.addAll(aux);
        return orden2;
    }
    public ArrayList<Revista> ordenarRevistas(ArrayList<Revista> revistas, ArrayList<String> claves){
        ArrayList<Revista> orden1 = new ArrayList();
        int[] prioridad = new int[revistas.size()]; 
        
        for(int i=0;i<prioridad.length;i++){
            prioridad[i]=0;
        }
        
        for(int i=0;i<claves.size();i++){
            for(int j=0;j<revistas.size();j++){
                int index=0, cont=0;
                while((index=revistas.get(j).resumen.indexOf(claves.get(i), index))!=-1){
                    cont++;
                }
                prioridad[j]+=cont;
            }
        }
        
        int i = 0;
        while(i<revistas.size()){
            int aux = 0;
            for(int j=1;j<prioridad.length;j++){
                if(prioridad[j]>prioridad[j-1]) aux=j;            
            }
            prioridad[aux]=0;
            orden1.add(revistas.get(aux));
            i++;
        }
        
        return orden1;
    }
    public ArrayList<Revista> ordenarNRevistas(ArrayList<Revista> revistas, Cliente c){
        ArrayList<String> ca = new ArrayList(c.getCategorias());        
        ArrayList<Revista> orden2 = new ArrayList();
        ArrayList<Revista> aux = new ArrayList(revistas);
        for(int h=ca.size()-1;h==0;h--){
            ArrayList<Revista> orden1 = new ArrayList();
            Revista l;
            if(ca.get(h).equalsIgnoreCase("actualidad") && !bdactualidad.isEmpty()){
                for(int j=0;j<bdactualidad.size();j++){
                    for( int i=0;i<aux.size();i++){
                        if(aux.get(i).codigo.equals(bdactualidad.get(j).codigo)){
                            l = (Revista) bdactualidad.get(j);
                            orden1.add(l);
                        }
                    }                   
                }
            }
            else if(ca.get(h).equalsIgnoreCase("ciencia") && !bdciencia.isEmpty()){
                for(int j=0;j<bdciencia.size();j++){
                    for( int i=0;i<aux.size();i++){
                        if(aux.get(i).codigo.equals(bdciencia.get(j).codigo)){
                            l = (Revista) bdciencia.get(j);
                            orden1.add(l);
                        }
                    }
                }
            }
            Collections.sort(orden1);
            orden2.addAll(orden1);
        }
        aux.removeAll(orden2);
        Collections.sort(aux);
        orden2.addAll(0, aux);
        return orden2;
    }
    public ArrayList<Periodico> ordenarPeriodicos(ArrayList<Periodico> periodicos){
        ArrayList<Periodico> orden1 = new ArrayList();
        orden1.addAll(periodicos);
        Collections.sort(orden1);
        return orden1;
    }
    public ArrayList<Periodico> ordenarPeriodicos(ArrayList<Periodico> periodicos, Cliente c){
        ArrayList<String> ca = new ArrayList(c.getCategorias());        
        ArrayList<Periodico> orden2 = new ArrayList();
        ArrayList<Periodico> aux = new ArrayList(periodicos);
        for(int h=0;h<ca.size();h++){
            ArrayList<Periodico> orden1 = new ArrayList();
            Periodico l;
            if(ca.get(h).equalsIgnoreCase("deportes") && !bddeportes.isEmpty()){
                for(int j=0;j<bddeportes.size();j++){
                    for( int i=0;i<aux.size();i++){
                        if(aux.get(i).codigo.equals(bddeportes.get(j).codigo)){
                            l = (Periodico) bddeportes.get(j);
                            orden1.add(l);
                        }
                    }                   
                }
            }
            else if(ca.get(h).equalsIgnoreCase("local") && !bdlocales.isEmpty()){
                for(int j=0;j<bdlocales.size();j++){
                    for( int i=0;i<aux.size();i++){
                        if(aux.get(i).codigo.equals(bdlocales.get(j).codigo)){
                            l = (Periodico) bdlocales.get(j);
                            orden1.add(l);
                        }
                    }
                }
            }
            Collections.sort(orden1);
            orden2.addAll(orden1);
        }
        aux.removeAll(orden2);
        Collections.sort(aux);
        orden2.addAll(aux);
        return orden2;
    }
    public ArrayList<Periodico> ordenarPeriodicos(ArrayList<Periodico> periodicos, ArrayList<String> claves){
        ArrayList<Periodico> orden1 = new ArrayList();
        int[] prioridad = new int[periodicos.size()]; 
        
        for(int i=0;i<prioridad.length;i++){
            prioridad[i]=0;
        }
        
        for(int i=0;i<claves.size();i++){
            for(int j=0;j<periodicos.size();j++){
                int index=0, cont=0;
                while((index=periodicos.get(j).resumen.indexOf(claves.get(i), index))!=-1){
                    cont++;
                }
                prioridad[j]+=cont;
            }
        }
        
        int i = 0;
        while(i<periodicos.size()){
            int aux = 0;
            for(int j=1;j<prioridad.length;j++){
                if(prioridad[j]>prioridad[j-1]) aux=j;            
            }
            prioridad[aux]=0;
            orden1.add(periodicos.get(aux));
            i++;
        }
        
        return orden1;
    }
    public ArrayList<Periodico> ordenarNPeriodicos(ArrayList<Periodico> periodicos, Cliente c){
        ArrayList<String> ca = new ArrayList(c.getCategorias());        
        ArrayList<Periodico> orden2 = new ArrayList();
        ArrayList<Periodico> aux = new ArrayList(periodicos);
        for(int h=ca.size()-1;h==0;h--){
            ArrayList<Periodico> orden1 = new ArrayList();
            Periodico l;
            if(ca.get(h).equalsIgnoreCase("deportes") && !bddeportes.isEmpty()){
                for(int j=0;j<bddeportes.size();j++){
                    for( int i=0;i<aux.size();i++){
                        if(aux.get(i).codigo.equals(bddeportes.get(j).codigo)){
                            l = (Periodico) bddeportes.get(j);
                            orden1.add(l);
                        }
                    }                   
                }
            }
            else if(ca.get(h).equalsIgnoreCase("local") && !bdlocales.isEmpty()){
                for(int j=0;j<bdlocales.size();j++){
                    for( int i=0;i<aux.size();i++){
                        if(aux.get(i).codigo.equals(bdlocales.get(j).codigo)){
                            l = (Periodico) bdlocales.get(j);
                            orden1.add(l);
                        }
                    }
                }
            }
            Collections.sort(orden1);
            orden2.addAll(orden1);
        }
        aux.removeAll(orden2);
        Collections.sort(aux);
        orden2.addAll(0, aux);
        return orden2;
    }
    
    public void imprimirLibros(ArrayList<Libro> libros, String tipo){
        try{
        switch(tipo){
            case "n":
                for(int i=0;i<libros.size();i++){
                    System.out.println("ISBN: "+libros.get(i).getCodigo()+"\nNombre: "+libros.get(i).getNombre()+"  Autor: "+libros.get(i).getAutor()+"\nGenero: "+libros.get(i).getGenero()+"  Editorial: "+libros.get(i).getEditorial()+"\nEdicion: "+libros.get(i).getEdicion()+"  Unidades: "+libros.get(i).getStock()+"  Precio: "+libros.get(i).getPrecio()+"\n");
                }
                break;
            case "h":
                for(int i=0;i<libros.size();i++){
                    System.out.println("ISBN: "+libros.get(i).getCodigo()+"\nNombre: "+libros.get(i).getNombre()+"  Autor: "+libros.get(i).getAutor()+"\nGenero: "+libros.get(i).getGenero()+"  Editorial: "+libros.get(i).getEditorial()+"\nEdicion: "+libros.get(i).getEdicion()+"  Precio: "+libros.get(i).getPrecio()+"\n");
                }
                break;
            case "v":
                for(int i=0;i<libros.size();i++){
                    System.out.println("ISBN: "+libros.get(i).getCodigo()+"\nNombre: "+libros.get(i).getNombre()+"  Autor: "+libros.get(i).getAutor()+"\nGenero: "+libros.get(i).getGenero()+"  Editorial: "+libros.get(i).getEditorial()+"\nEdicion: "+libros.get(i).getEdicion()+"  Unidades: "+libros.get(i).getStock()+"  Precio: "+libros.get(i).getPrecio()+"  Ventas Totales: "+libros.get(i).ventas+"  Fecha de Creacion: "+libros.get(i).creacion.get(Calendar.DAY_OF_MONTH)+"/"+(libros.get(i).creacion.get(Calendar.MONTH)+1)+"/"+libros.get(i).creacion.get(Calendar.YEAR)+"\nResumen: "+libros.get(i).resumen+"\n");
                }
                break;
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }        
    }
    public void imprimirRevistas(ArrayList<Revista> r, String tipo){
        try{
        switch(tipo){
            case "n":
                for(int i=0;i<r.size();i++){
                    System.out.println("ISSN: "+r.get(i).codigo+"\nNombre: "+r.get(i).getNombre()+"  Unidades: "+r.get(i).getStock()+"\nPrecio: "+r.get(i).getPrecio()+"  Subscripcion: "+r.get(i).getPrecioSubscripcion()+"\n");
                }
                break;
            case "s":
                for(int i=0;i<r.size();i++){
                    System.out.println("Subscripcion->ISSN: "+r.get(i).codigo+"\nNombre: "+r.get(i).getNombre()+"  Unidades: "+r.get(i).getStock()+"\nPrecio: "+r.get(i).getPrecioSubscripcion()+"\n");
                }
                break;
            case "e":
                for(int i=0;i<r.size();i++){
                    System.out.println("ISSN: "+r.get(i).codigo+"\nNombre: "+r.get(i).getNombre()+"  Unidades: "+r.get(i).getStock()+"\nPrecio: "+r.get(i).getPrecio()+"\n");
                }
                break;
            case "h1":
                for(int i=0;i<r.size();i++){
                    System.out.println("ISSN: "+r.get(i).codigo+"\nNombre: "+r.get(i).getNombre()+"  Precio: "+r.get(i).getPrecio()+"\n");
                }
                break;
            case "h2":
                for(int i=0;i<r.size();i++){
                    System.out.println("Subscripcion->ISSN: "+r.get(i).codigo+"\nNombre: "+r.get(i).getNombre()+"  Precio: "+r.get(i).getPrecioSubscripcion()+"\n");
                }
                break;
            case "v":
                for(int i=0;i<r.size();i++){
                    System.out.println("ISSN: "+r.get(i).codigo+"\nNombre: "+r.get(i).getNombre()+"  Unidades: "+r.get(i).getStock()+"\nPrecio: "+r.get(i).getPrecio()+"  Subscripcion: "+r.get(i).getPrecioSubscripcion()+"  Ventas Totales: "+r.get(i).ventas+"  Fecha Creacion: "+r.get(i).creacion.get(Calendar.DAY_OF_MONTH)+"/"+(r.get(i).creacion.get(Calendar.MONTH)+1)+"/"+r.get(i).creacion.get(Calendar.YEAR)+"\nResumen: "+r.get(i).resumen+"\n");
                }
                break;
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void imprimirPeriodicos(ArrayList<Periodico> p, String tipo){
        try{
        switch(tipo){
            case "n":
                for(int i=0;i<p.size();i++){
                    System.out.println("ISSN: "+p.get(i).codigo+"\nNombre: "+p.get(i).getNombre()+"  Fecha: "+p.get(i).getFecha().get(Calendar.YEAR)+"-"+(p.get(i).getFecha().get(Calendar.MONTH)+1)+"-"+p.get(i).getFecha().get(Calendar.DAY_OF_MONTH)+"\nUnidades: "+p.get(i).getStock()+"  Precio: "+p.get(i).getPrecio()+"  Subscripcion: "+p.get(i).getPrecioSubscripcion()+"\n");
                }
                break;
            case "s":
                for(int i=0;i<p.size();i++){
                    System.out.println("Subscripcion->ISSN: "+p.get(i).codigo+"\nNombre: "+p.get(i).getNombre()+"  Fecha: "+p.get(i).getFecha().get(Calendar.YEAR)+"-"+(p.get(i).getFecha().get(Calendar.MONTH)+1)+"-"+p.get(i).getFecha().get(Calendar.DAY_OF_MONTH)+"\nUnidades: "+p.get(i).getStock()+"  Precio: "+p.get(i).getPrecioSubscripcion()+"\n");
                }
                break;
            case "e":
                for(int i=0;i<p.size();i++){
                    System.out.println("ISSN: "+p.get(i).codigo+"\nNombre: "+p.get(i).getNombre()+"  Fecha: "+p.get(i).getFecha().get(Calendar.YEAR)+"-"+(p.get(i).getFecha().get(Calendar.MONTH)+1)+"-"+p.get(i).getFecha().get(Calendar.DAY_OF_MONTH)+"\nUnidades: "+p.get(i).getStock()+"  Precio: "+p.get(i).getPrecio()+"\n");
                }
                break;
            case "h1":
                for(int i=0;i<p.size();i++){
                    System.out.println("ISSN: "+p.get(i).codigo+"\nNombre: "+p.get(i).getNombre()+"  Fecha: "+p.get(i).getFecha().get(Calendar.YEAR)+"-"+(p.get(i).getFecha().get(Calendar.MONTH)+1)+"-"+p.get(i).getFecha().get(Calendar.DAY_OF_MONTH)+"  Precio: "+p.get(i).getPrecio()+"\n");
                }
                break;
            case "h2":
                for(int i=0;i<p.size();i++){
                    System.out.println("Subscripcion->ISSN: "+p.get(i).codigo+"\nNombre: "+p.get(i).getNombre()+"  Fecha: "+p.get(i).getFecha().get(Calendar.YEAR)+"-"+(p.get(i).getFecha().get(Calendar.MONTH)+1)+"-"+p.get(i).getFecha().get(Calendar.DAY_OF_MONTH)+"  Precio: "+p.get(i).getPrecioSubscripcion()+"\n");
                }
                break;
            case "v":
                for(int i=0;i<p.size();i++){
                    System.out.println("ISSN: "+p.get(i).codigo+"\nNombre: "+p.get(i).getNombre()+"  Fecha: "+p.get(i).getFecha().get(Calendar.YEAR)+"-"+(p.get(i).getFecha().get(Calendar.MONTH)+1)+"-"+p.get(i).getFecha().get(Calendar.DAY_OF_MONTH)+"\nUnidades: "+p.get(i).getStock()+"  Precio: "+p.get(i).getPrecio()+"  Subscripcion: "+p.get(i).getPrecioSubscripcion()+"  Ventas Totales: "+p.get(i).ventas+"  Fecha Creacion:"+p.get(i).creacion.get(Calendar.YEAR)+"/"+(p.get(i).creacion.get(Calendar.MONTH)+1)+"/"+p.get(i).creacion.get(Calendar.DAY_OF_MONTH)+"\nResumen: "+p.get(i).resumen+"\n");
                }
                break;
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void imprimirCategorias(Cliente c, String tipo){
        try{
        ArrayList<String> cat = c.getCategorias();
        switch(tipo){
            case "l":
                for(int i=0;i<cat.size();i++){
                    for(int j=0;j<bdsubcategoriasl.size();j++){
                        if(cat.get(i).equalsIgnoreCase(bdsubcategoriasl.get(j))) System.out.println(cat.get(i));
                    }
                }
                break;
            case "r":
                for(int i=0;i<cat.size();i++){
                    for(int j=0;j<bdsubcategoriasr.size();j++){
                        if(cat.get(i).equalsIgnoreCase(bdsubcategoriasr.get(j))) System.out.println(cat.get(i));
                    }
                }
                break;
            case "p":
                for(int i=0;i<cat.size();i++){
                    for(int j=0;j<bdsubcategoriasp.size();j++){
                        if(cat.get(i).equalsIgnoreCase(bdsubcategoriasp.get(j))) System.out.println(cat.get(i));
                    }
                }
                break;
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void imprimirCategorias(String tipo){
        switch(tipo){
            case "l":
                ArrayList<String> cat = getCategorias(tipo);
                for(int i=0;i<cat.size();i++){
                    System.out.println(cat.get(i));
                }
                break;
            case "r":
                cat = getCategorias(tipo);
                for(int i=0;i<cat.size();i++){
                    System.out.println(cat.get(i));
                }
                break;
            case "p":
                cat = getCategorias(tipo);
                for(int i=0;i<cat.size();i++){
                    System.out.println(cat.get(i));
                }
                break;
        }
    }
    
    public void comprarLibroNombre(Cliente c){
        try{
        Scanner scant = new Scanner(System.in);
        ArrayList<Libro> l = new ArrayList();
        String codigo;
        int cont=0;
        
        System.out.println("Introducir nombre del libro que desea comprar");
        codigo = scant.nextLine();
        
        for(int i=0;i<bdlibros.size();i++){
            if(bdlibros.get(i).nombre.equalsIgnoreCase(codigo) && bdlibros.get(i).stock>0) {l.add(bdlibros.get(i)); cont++;}
        }
        if(cont==0) System.out.println("No se hayaron coincidencias o no hay stock del libro deseado"); 
        else{
            Scanner scani = new Scanner(System.in);
            System.out.println("Se mostrarán las coincidencias de los libros en stock:");
            imprimirLibros(ordenarLibros(l, c), "n");
            System.out.println("Introduzca el ISBN del libro deseado");
            codigo = scant.nextLine();
            if(getLibro(codigo)==null) System.out.println("ISBN incorrecto");
            else{
            System.out.println("Introduzca el numero de ejemplares que desea comprar");
            int num = scani.nextInt();
            if(getLibro(codigo).stock<num) System.out.println("No hay suficiente stock");
            else{
                System.out.println("Se ha añadido su compra al carrito.");
                for(int i=0;i<num;i++){
                    c.addCarrito(codigo);
                    getLibro(codigo).Vender();
                }                
            }
          }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void comprarLibroGenero(Cliente c){
        try{
        Scanner scant = new Scanner(System.in);
        ArrayList<Libro> l = new ArrayList();
        String codigo;
        int cont=0;
        
        System.out.println("Introducir genero del libro que desea comprar");
        codigo = scant.nextLine();
        
        for(int i=0;i<bdsubcategoriasl.size();i++){
            if(bdsubcategoriasl.get(i).equalsIgnoreCase(codigo)){
                switch(bdsubcategoriasl.get(i)){
                    case "fantasia":
                        for(int j=0;j<bdfantasia.size();j++){
                            if(bdfantasia.get(j).stock>0) l.add(bdfantasia.get(j)); cont++;
                        }
                        break;
                    case "cienciaficcion":
                        for(int j=0;j<bdcienciaficcion.size();j++){
                            if(bdcienciaficcion.get(j).stock>0) l.add(bdcienciaficcion.get(j)); cont++;
                        }
                        break;
                }
            }
        }
        if(cont==0) System.out.println("No hay libros de ese genero o no quedan en stock."); 
        else{
            Scanner scani = new Scanner(System.in);
            System.out.println("Se mostrarán las coincidencias de los libros en stock:");
            imprimirLibros(ordenarLibros(l, c), "n");
            System.out.println("Introduzca el ISBN del libro deseado");
            codigo = scant.nextLine();
            if(getLibro(codigo)==null) System.out.println("ISBN incorrecto");
            else{
            System.out.println("Introduzca el numero de ejemplares que desea comprar");
            int num = scani.nextInt();
            if(getLibro(codigo).stock<num) System.out.println("No hay suficiente stock");
            else{
                for(int i=0;i<num;i++){
                    c.addCarrito(codigo);
                    getLibro(codigo).Vender();
                }                
            }
          }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void comprarLibroClave(Cliente c){
        try{
        Scanner scant = new Scanner(System.in);
        ArrayList<Libro> l = new ArrayList();
        ArrayList<String> s = new ArrayList();
        String codigo;
        int cont=0;
        
        System.out.println("Introducir palabras clave separadas por espacios");
        codigo = scant.nextLine();
        codigo = codigo+' ';
        for(int i=0;i<codigo.length();i++){
            if(codigo.charAt(i)==' '){
                s.add(codigo.substring(cont, i));
                cont = i+1;
            }
        }
        if(cont==0) s.add(codigo);

        cont = 0;
        for(int i=0;i<bdlibros.size();i++){
            for(int j=0;j<s.size();j++){
                if(bdlibros.get(i).resumen.contains(s.get(j)) && bdlibros.get(i).stock>0) {                    
                    l.add(bdlibros.get(i)); cont++; break;
                }
            }
        }                
        if(cont==0) System.out.println("No se hayaron coincidencias o no hay stock del libro deseado"); 
        else{            
            Scanner scani = new Scanner(System.in);
            System.out.println("Se mostrarán las coincidencias de los libros en stock por orden de prioridad:");
            imprimirLibros(ordenarLibros(l, s), "n"); //Revisar el otro metodo de ordenar
            System.out.println("Introduzca el ISBN del libro deseado");
            codigo = scant.nextLine();
            if(getLibro(codigo)==null) System.out.println("ISBN incorrecto");
            else{
            System.out.println("Introduzca el numero de ejemplares que desea comprar");
            int num = scani.nextInt();
            if(getLibro(codigo).stock<num) System.out.println("No hay suficiente stock");
            else{
                for(int i=0;i<num;i++){
                    c.addCarrito(codigo);
                    getLibro(codigo).Vender();
                }                
            }
          }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void comprarLibroAutor(Cliente c){
        try{
        Scanner scant = new Scanner(System.in);
        ArrayList<Libro> l = new ArrayList();
        String codigo;
        int cont=0;
        
        System.out.println("Introducir nombre del autor cuyo libro desea comprar");
        codigo = scant.nextLine();
        
        for(int i=0;i<bdlibros.size();i++){
            if(bdlibros.get(i).autor.equalsIgnoreCase(codigo) && bdlibros.get(i).stock>0) {l.add(bdlibros.get(i)); cont++;}
        }
        if(cont==0) System.out.println("No se hayaron coincidencias o no hay stock del libro deseado"); 
        else{
            Scanner scani = new Scanner(System.in);
            System.out.println("Se mostrarán las coincidencias de los libros en stock:");
            imprimirLibros(ordenarLibros(l, c), "n");
            System.out.println("Introduzca el ISBN del libro deseado");
            codigo = scant.nextLine();
            if(getLibro(codigo)==null) System.out.println("ISBN incorrecto");
            else{
            System.out.println("Introduzca el numero de ejemplares que desea comprar");
            int num = scani.nextInt();
            if(getLibro(codigo).stock<num) System.out.println("No hay suficiente stock");
            else{
                System.out.println("Se ha añadido su compra al carrito.");
                for(int i=0;i<num;i++){
                    c.addCarrito(codigo);
                    getLibro(codigo).Vender();
                }                
            }
          }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    
    public void comprarRevistaNombre(Cliente c){
        try{
        Scanner scant = new Scanner(System.in);
        ArrayList<Revista> r = new ArrayList();
        String codigo;
        int cont=0;
        
        System.out.println("Introducir nombre de la revista que desea comprar");
        codigo = scant.nextLine();
        
        for(int i=0;i<bdrevistas.size();i++){
            if(bdrevistas.get(i).nombre.equalsIgnoreCase(codigo) && bdrevistas.get(i).stock>0) {r.add(bdrevistas.get(i)); cont++;}
        }
        if(cont==0) System.out.println("No se hayaron coincidencias o no hay stock de la revista deseada"); 
        else{            
            System.out.println("Se mostrarán las coincidencias de las revistas en stock:");
            imprimirRevistas(ordenarRevistas(r, c), "n");
            System.out.println("Introduzca el ISSN de la revista deseada");
            codigo = scant.nextLine();
            if(getRevista(codigo)==null) System.out.println("ISSN incorrecto");
            else{
                Scanner scani = new Scanner(System.in);    
                System.out.println("1)Ejemplar\n2)Subscripcion");
                cont = scani.nextInt();
                if(cont==2) {getRevista(codigo).Vender(); codigo = codigo+"s"; c.addCarrito(codigo);}
                else if(cont==1){
                    System.out.println("Introduzca el numero de ejemplares que desea comprar");
                    int num = scani.nextInt();
                    if(getRevista(codigo).stock<num) System.out.println("No hay suficiente stock");
                    else{
                        for(int i=0;i<num;i++){
                            c.addCarrito(codigo);
                            getRevista(codigo).Vender();
                        }                
                    }
                }
                else System.out.println("Indice incorrecto");                
          }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void comprarRevistaGenero(Cliente c){
        try{
        Scanner scant = new Scanner(System.in);
        ArrayList<Revista> r = new ArrayList();
        String codigo;
        int cont=0;
        
        System.out.println("Introducir genero de la revista que desea comprar");
        codigo = scant.nextLine();
        
        for(int i=0;i<bdsubcategoriasr.size();i++){
            if(bdsubcategoriasr.get(i).equalsIgnoreCase(codigo)){
                switch(bdsubcategoriasr.get(i)){
                    case "actualidad":
                        for(int j=0;j<bdactualidad.size();j++){
                            if(bdactualidad.get(j).stock>0) r.add(bdactualidad.get(j)); cont++;
                        }
                        break;
                    case "ciencia":
                        for(int j=0;j<bdciencia.size();j++){
                            if(bdciencia.get(j).stock>0) r.add(bdciencia.get(j)); cont++;
                        }
                        break;
                }
            }
        }
        if(cont==0) System.out.println("No hay revistas de ese genero o no quedan en stock."); 
        else{
            System.out.println("Se mostrarán las coincidencias de las revistas en stock:");
            imprimirRevistas(ordenarRevistas(r, c), "n");
            System.out.println("Introduzca el ISSN de la revista deseada");
            codigo = scant.nextLine();
            if(getRevista(codigo)==null) System.out.println("ISSN incorrecto");
            else{
                Scanner scani = new Scanner(System.in);    
                System.out.println("1)Ejemplar\n2)Subscripcion");
                cont = scani.nextInt();
                if(cont==2) {getRevista(codigo).Vender(); codigo = codigo+"s"; c.addCarrito(codigo);}
                else if(cont==1){
                    System.out.println("Introduzca el numero de ejemplares que desea comprar");
                    int num = scani.nextInt();
                    if(getRevista(codigo).stock<num) System.out.println("No hay suficiente stock");
                    else{
                        for(int i=0;i<num;i++){
                            c.addCarrito(codigo);
                            getRevista(codigo).Vender();
                        }                
                    }
                }
                else System.out.println("Indice incorrecto");
          }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void comprarRevistaClave(Cliente c){
        try{
        Scanner scant = new Scanner(System.in);
        ArrayList<Revista> r = new ArrayList();
        ArrayList<String> s = new ArrayList();
        String codigo;
        int cont=0;
        
        System.out.println("Introducir palabras clave separadas por espacios");
        codigo = scant.nextLine();
        codigo = codigo+' ';
        for(int i=0;i<codigo.length();i++){
            if(codigo.charAt(i)==' '){
                s.add(codigo.substring(cont, i));
                cont = i+1;
            }
        }
        if(cont==0) s.add(codigo);
        
        cont = 0;
        for(int i=0;i<bdrevistas.size();i++){
            for(int j=0;j<s.size();j++){
                if(bdrevistas.get(i).resumen.contains(s.get(j)) && bdrevistas.get(i).stock>0) {                    
                    r.add(bdrevistas.get(i)); cont++; break;
                }
            }
        }                
        if(cont==0) System.out.println("No se hayaron coincidencias o no hay stock de la revista deseada"); 
        else{            
            System.out.println("Se mostrarán las coincidencias de las revistas en stock:");
            imprimirRevistas(ordenarRevistas(r, s), "n");
            System.out.println("Introduzca el ISSN de la revista deseada");
            codigo = scant.nextLine();
            if(getRevista(codigo)==null) System.out.println("ISSN incorrecto");
            else{
                Scanner scani = new Scanner(System.in);    
                System.out.println("1)Ejemplar\n2)Subscripcion");
                cont = scani.nextInt();
                if(cont==2) {getRevista(codigo).Vender(); codigo = codigo+"s"; c.addCarrito(codigo);}
                else if(cont==1){
                    System.out.println("Introduzca el numero de ejemplares que desea comprar");
                    int num = scani.nextInt();
                    if(getRevista(codigo).stock<num) System.out.println("No hay suficiente stock");
                    else{
                        for(int i=0;i<num;i++){
                            c.addCarrito(codigo);
                            getRevista(codigo).Vender();
                        }                
                    }
                }
                else System.out.println("Indice incorrecto");
          }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    
    public void comprarPeriodicoNombre(Cliente c){
        try{
        Scanner scant = new Scanner(System.in);
        ArrayList<Periodico> p = new ArrayList();
        String codigo;
        int cont=0;
        
        System.out.println("Introducir nombre del periodico que desea comprar");
        codigo = scant.nextLine();
        
        for(int i=0;i<bdperiodicos.size();i++){
            if(bdperiodicos.get(i).nombre.equalsIgnoreCase(codigo) && bdperiodicos.get(i).stock>0) {p.add(bdperiodicos.get(i)); cont++;}
        }
        if(cont==0) System.out.println("No se hayaron coincidencias o no hay stock del periodico deseado"); 
        else{            
            System.out.println("Se mostrarán las coincidencias de las revistas en stock:");
            imprimirPeriodicos(ordenarPeriodicos(p, c), "n");
            System.out.println("Introduzca el ISSN del periodico deseado");
            codigo = scant.nextLine();
            if(getPeriodico(codigo)==null) System.out.println("ISSN incorrecto");
            else{
                Scanner scani = new Scanner(System.in);    
                System.out.println("1)Ejemplar\n2)Subscripcion");
                cont = scani.nextInt();
                if(cont==2) {getPeriodico(codigo).Vender(); codigo = codigo+"s"; c.addCarrito(codigo);}
                else if(cont==1){
                    System.out.println("Introduzca el numero de ejemplares que desea comprar");
                    int num = scani.nextInt();
                    if(getPeriodico(codigo).stock<num) System.out.println("No hay suficiente stock");
                    else{
                        for(int i=0;i<num;i++){
                            c.addCarrito(codigo);
                            getPeriodico(codigo).Vender();
                        }                
                    }
                }
                else System.out.println("Indice incorrecto");                
          }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void comprarPeriodicoGenero(Cliente c){
        try{
        Scanner scant = new Scanner(System.in);
        ArrayList<Periodico> p = new ArrayList();
        String codigo;
        int cont=0;
        
        System.out.println("Introducir genero del periodico que desea comprar");
        codigo = scant.nextLine();
        
        for(int i=0;i<bdsubcategoriasp.size();i++){
            if(bdsubcategoriasp.get(i).equalsIgnoreCase(codigo)){
                switch(bdsubcategoriasp.get(i)){
                    case "deportes":
                        for(int j=0;j<bddeportes.size();j++){
                            if(bddeportes.get(j).stock>0) p.add(bddeportes.get(j)); cont++;
                        }
                        break;
                    case "local":
                        for(int j=0;j<bdlocales.size();j++){
                            if(bdlocales.get(j).stock>0) p.add(bdlocales.get(j)); cont++;
                        }
                        break;
                }
            }
        }
        if(cont==0) System.out.println("No hay periodicos de ese genero o no quedan en stock."); 
        else{
            System.out.println("Se mostrarán las coincidencias de los periodicos en stock:");
            imprimirPeriodicos(ordenarPeriodicos(p, c), "n");
            System.out.println("Introduzca el ISSN del periodico deseado");
            codigo = scant.nextLine();
            if(getPeriodico(codigo)==null) System.out.println("ISSN incorrecto");
            else{
                Scanner scani = new Scanner(System.in);    
                System.out.println("1)Ejemplar\n2)Subscripcion");
                cont = scani.nextInt();
                if(cont==2) {getPeriodico(codigo).Vender(); codigo = codigo+"s"; c.addCarrito(codigo);}
                else if(cont==1){
                    System.out.println("Introduzca el numero de ejemplares que desea comprar");
                    int num = scani.nextInt();
                    if(getPeriodico(codigo).stock<num) System.out.println("No hay suficiente stock");
                    else{
                        for(int i=0;i<num;i++){
                            c.addCarrito(codigo);
                            getPeriodico(codigo).Vender();
                        }                
                    }
                }
                else System.out.println("Indice incorrecto");
          }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void comprarPeriodicoClave(Cliente c){
        try{
        Scanner scant = new Scanner(System.in);
        ArrayList<Periodico> p = new ArrayList();
        ArrayList<String> s = new ArrayList();
        String codigo;
        int cont=0;
        
        System.out.println("Introducir palabras clave separadas por espacios");
        codigo = scant.nextLine();
        codigo = codigo+' ';
        for(int i=0;i<codigo.length();i++){
            if(codigo.charAt(i)==' '){
                s.add(codigo.substring(cont, i));
                cont = i+1;
            }
        }
        if(cont==0) s.add(codigo);
        
        cont = 0;
        for(int i=0;i<bdperiodicos.size();i++){
            for(int j=0;j<s.size();j++){
                if(bdperiodicos.get(i).resumen.contains(s.get(j)) && bdperiodicos.get(i).stock>0) {                    
                    p.add(bdperiodicos.get(i)); cont++; break;
                }
            }
        }                
        if(cont==0) System.out.println("No se hayaron coincidencias o no hay stock del periodico deseado"); 
        else{            
            System.out.println("Se mostrarán las coincidencias de los periodicos en stock:");
            imprimirPeriodicos(ordenarPeriodicos(p, s), "n");
            System.out.println("Introduzca el ISSN del periodico deseado");
            codigo = scant.nextLine();
            if(getPeriodico(codigo)==null) System.out.println("ISSN incorrecto");
            else{
                Scanner scani = new Scanner(System.in);    
                System.out.println("1)Ejemplar\n2)Subscripcion");
                cont = scani.nextInt();
                if(cont==2) {getPeriodico(codigo).Vender(); codigo = codigo+"s"; c.addCarrito(codigo);}
                else if(cont==1){
                    System.out.println("Introduzca el numero de ejemplares que desea comprar");
                    int num = scani.nextInt();
                    if(getPeriodico(codigo).stock<num) System.out.println("No hay suficiente stock");
                    else{
                        for(int i=0;i<num;i++){
                            c.addCarrito(codigo);
                            getPeriodico(codigo).Vender();
                        }                
                    }
                }
                else System.out.println("Indice incorrecto");
          }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    
    public void carritoAObjeto(Cliente c, ArrayList<Libro> libros, ArrayList<Revista> revistas, ArrayList<Revista> revistass, ArrayList<Periodico> periodicos, ArrayList<Periodico> periodicoss){
        try{
        for(int i=0;i<c.getCarrito().size();i++){
                for(int j=0;j<bdlibros.size();j++){
                    if(c.getCarrito().get(i).equals(bdlibros.get(j).codigo)) {libros.add(bdlibros.get(j));}
                }
            }        
        for(int i=0;i<c.getCarrito().size();i++){
            for(int j=0;j<bdrevistas.size();j++){
                if(c.getCarrito().get(i).equals(bdrevistas.get(j).codigo)) {revistas.add(bdrevistas.get(j));}
            }
        }
        for(int i=0;i<c.getCarrito().size();i++){
            for(int j=0;j<bdrevistas.size();j++){
                if(c.getCarrito().get(i).equals(bdrevistas.get(j).codigo+'s')) {revistass.add(bdrevistas.get(j));}
            }
        }
        for(int i=0;i<c.getCarrito().size();i++){
            for(int j=0;j<bdperiodicos.size();j++){
                if(c.getCarrito().get(i).equals(bdperiodicos.get(j).codigo)) {periodicos.add(bdperiodicos.get(j));}
            }
        }
        for(int i=0;i<c.getCarrito().size();i++){
            for(int j=0;j<bdperiodicos.size();j++){
                if(c.getCarrito().get(i).equals(bdperiodicos.get(j).codigo+'s')) {periodicoss.add(bdperiodicos.get(j));}
            }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void carritoVer(Cliente c){   
        try{
        if(c.getCarrito().isEmpty()) {System.out.println("El carrito esta vacio");}
        else{
            ArrayList<Libro> libros = new ArrayList();
            ArrayList<Revista> revistas = new ArrayList();
            ArrayList<Periodico> periodicos = new ArrayList();
            ArrayList<Revista> revistass = new ArrayList();
            ArrayList<Periodico> periodicoss = new ArrayList();
            
            carritoAObjeto(c, libros, revistas, revistass, periodicos, periodicoss);
                        
            if(!libros.isEmpty()) {System.out.println("Libros\n-------------------"); imprimirLibros(ordenarLibros(libros, c), "h");}            
            if(!revistas.isEmpty()) {System.out.println("Revistas\n-------------------"); imprimirRevistas(ordenarRevistas(revistas, c), "h1");}
            if(!revistass.isEmpty()) {System.out.println("Revistas-Subscripcion\n-------------------"); imprimirRevistas(ordenarRevistas(revistass, c), "h2");}            
            if(!periodicos.isEmpty()) {System.out.println("Periodicos\n-------------------"); imprimirPeriodicos(ordenarPeriodicos(periodicos, c), "h1");}
            if(!periodicoss.isEmpty()) {System.out.println("Periodicos-Subscripcion\n-------------------"); imprimirPeriodicos(ordenarPeriodicos(periodicoss, c), "h2");}
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void carritoEliminar(Cliente c){
        try{
        Scanner scant = new Scanner(System.in);
        String codigo;
        ArrayList<Libro> libros = new ArrayList();
        ArrayList<Revista> revistas = new ArrayList();
        ArrayList<Periodico> periodicos = new ArrayList();
        ArrayList<Revista> revistass = new ArrayList();
        ArrayList<Periodico> periodicoss = new ArrayList();

        carritoAObjeto(c, libros, revistas, revistass, periodicos, periodicoss);
        
        System.out.println("Se recomienda eliminar uno de los siguientes productos(con su ISBN o ISSN)");
        if(!libros.isEmpty()) {
            System.out.println("Libros\n-------------------"); libros=ordenarNLibros(libros, c);
            for(int i=0;i<2;i++){
                int cont;
                System.out.println("ISBN: "+libros.get(i).getCodigo()+"\nNombre: "+libros.get(i).getNombre()+"  Autor: "+libros.get(i).getAutor()+"\nGenero: "+libros.get(i).getGenero()+"  Editorial: "+libros.get(i).getEditorial()+"\nEdicion: "+libros.get(i).getEdicion()+"  Precio: "+libros.get(i).getPrecio()+"\n");
                if((cont=i+1)==libros.size()) break;
            }
        }            
        if(!revistas.isEmpty()) {            
            System.out.println("Revistas\n-------------------"); revistas=ordenarNRevistas(revistas, c);
            for(int i=0;i<2;i++){
                int cont;
                System.out.println("ISSN: "+revistas.get(i).codigo+"\nNombre: "+revistas.get(i).getNombre()+"  Precio: "+revistas.get(i).getPrecio()+"\n");
                if((cont=i+1)==revistas.size()) break;
            }
        }
        if(!revistass.isEmpty()) {
            System.out.println("Revistas-Subscripcion\n-------------------"); revistass=ordenarNRevistas(revistass, c);
            for(int i=0;i<2;i++){
                int cont;
                System.out.println("Subscripcion->ISSN: "+revistass.get(i).codigo+"\nNombre: "+revistass.get(i).getNombre()+"  Precio: "+revistass.get(i).getPrecioSubscripcion()+"\n");
                if((cont=i+1)==revistass.size()) break;
            }
        }            
        if(!periodicos.isEmpty()) {
            System.out.println("Periodicos\n-------------------"); periodicos=ordenarNPeriodicos(periodicos, c);
            for(int i=0;i<2;i++){
                int cont;
                System.out.println("ISSN: "+periodicos.get(i).codigo+"\nNombre: "+periodicos.get(i).getNombre()+"  Fecha: "+periodicos.get(i).getFecha().get(Calendar.YEAR)+"-"+(periodicos.get(i).getFecha().get(Calendar.MONTH)+1)+"-"+periodicos.get(i).getFecha().get(Calendar.DAY_OF_MONTH)+"  Precio: "+periodicos.get(i).getPrecio()+"\n");
                if((cont=i+1)==periodicos.size()) break;
            }
        }
        if(!periodicoss.isEmpty()) {
            System.out.println("Periodicos-Subscripcion\n-------------------"); periodicoss=ordenarNPeriodicos(periodicoss, c);
            for(int i=0;i<2;i++){
                int cont;
                System.out.println("ISSN: "+periodicoss.get(i).codigo+"\nNombre: "+periodicoss.get(i).getNombre()+"  Fecha: "+periodicoss.get(i).getFecha().get(Calendar.YEAR)+"-"+(periodicoss.get(i).getFecha().get(Calendar.MONTH)+1)+"-"+periodicoss.get(i).getFecha().get(Calendar.DAY_OF_MONTH)+"  Precio: "+periodicoss.get(i).getPrecio()+"\n");
                if((cont=i+1)==periodicoss.size()) break;
            }
        }        
        
        System.out.println("Introducir:");
        codigo = scant.nextLine();
        if(getLibro(codigo)!=null) {getLibro(codigo).Reembolsar(); c.removeCarrito(codigo);}
        else if(getRevista(codigo)!=null) {getRevista(codigo).Reembolsar(); c.removeCarrito(codigo);}
        else if(getPeriodico(codigo)!=null) {getPeriodico(codigo).Reembolsar(); c.removeCarrito(codigo);}
        else System.out.println("No se han eliminado elementos");
        
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void carritoFinalizar(Cliente c){
        try{
        ArrayList<String> carrito = new ArrayList(c.getCarrito());
        
        if(carrito.isEmpty()) System.out.println("El carrito esta vacio");
        else{
            double precioFinal = 0;
            ArrayList<String> aux = new ArrayList();
            ArrayList<Libro> auxl = new ArrayList();
            ArrayList<Revista> auxr = new ArrayList();
            ArrayList<Revista> auxrs = new ArrayList();
            ArrayList<Periodico> auxp = new ArrayList();
            ArrayList<Periodico> auxps = new ArrayList();
            
            for(int i=0;i<carrito.size();i++){
                for(int j=0;j<bdlibros.size();j++){
                    if(carrito.get(i).equals(bdlibros.get(j).codigo)){
                        double precio;
                        if(c.isPremium()) {precio = bdlibros.get(j).getPrecio()*getDescuento("l")/100;
                                           precio = bdlibros.get(j).getPrecio()-precio;}
                        else {precio = bdlibros.get(j).getPrecio();}
                        precioFinal += precio;
                        aux.add(carrito.get(i));
                        auxl.add(bdlibros.get(j));
                    }
                }
            }
            carrito.removeAll(aux);
            aux.clear();
            for(int i=0;i<carrito.size();i++){
                for(int j=0;j<bdrevistas.size();j++){
                    if(carrito.get(i).equals(bdrevistas.get(j).codigo)){
                        double precio;
                        if(c.isPremium()) {precio = bdrevistas.get(j).getPrecio()*getDescuento("r")/100;
                                           precio = bdrevistas.get(j).getPrecio()-precio;}
                        else {precio = bdrevistas.get(j).getPrecio();}
                        precioFinal += precio;
                        aux.add(carrito.get(i));
                        auxr.add(bdrevistas.get(j));
                    }
                }
            }
            carrito.removeAll(aux);
            aux.clear();
            for(int i=0;i<carrito.size();i++){
                for(int j=0;j<bdrevistas.size();j++){
                    if(carrito.get(i).equals(bdrevistas.get(j).codigo+'s')){
                        double precio;
                        if(c.isPremium()) {precio = bdrevistas.get(j).getPrecioSubscripcion()*getDescuento("r")/100;
                                           precio = bdrevistas.get(j).getPrecioSubscripcion()-precio;}
                        else {precio = bdrevistas.get(j).getPrecioSubscripcion();}
                        precioFinal += precio;
                        aux.add(carrito.get(i));
                        auxrs.add(bdrevistas.get(j));
                    }
                }
            }
            carrito.removeAll(aux);
            aux.clear();
            for(int i=0;i<carrito.size();i++){
                for(int j=0;j<bdperiodicos.size();j++){
                    if(carrito.get(i).equals(bdperiodicos.get(j).codigo)){
                        double precio;
                        if(c.isPremium()) {precio = bdperiodicos.get(j).getPrecio()*getDescuento("p")/100;
                                           precio = bdperiodicos.get(j).getPrecio()-precio;}
                        else {precio = bdperiodicos.get(j).getPrecio();}
                        precioFinal += precio;
                        aux.add(carrito.get(i));
                        auxp.add(bdperiodicos.get(j));
                    }
                }
            }
            carrito.removeAll(aux);
            aux.clear();
            for(int i=0;i<carrito.size();i++){
                for(int j=0;j<bdperiodicos.size();j++){
                    if(carrito.get(i).equals(bdperiodicos.get(j).codigo+'s')){
                        double precio;
                        if(c.isPremium()) {precio = bdperiodicos.get(j).getPrecioSubscripcion()*getDescuento("p")/100;
                                           precio = bdperiodicos.get(j).getPrecioSubscripcion()-precio;}
                        else {precio = bdperiodicos.get(j).getPrecioSubscripcion();}
                        precioFinal += precio;
                        aux.add(carrito.get(i));
                        auxps.add(bdperiodicos.get(j));
                    }
                }
            }
            if(precioFinal>c.getSaldo()) System.out.println("No hay suficiente saldo\nEl precio del carrito es "+precioFinal+"€, y su cuenta dispone de "+c.getSaldo()+"€ de saldo\nAñada saldo y vuelva a intentarlo");
            else{
                String opcion;
                Scanner scant = new Scanner(System.in);
                System.out.println("El precio del carrito es "+precioFinal+"€. Su saldo actual es "+c.getSaldo()+"€");
                System.out.println("Efectuar? (s/n)");
                opcion = scant.nextLine();
                switch(opcion){
                    case "n":
                        System.out.println("Operacion cancelada");
                        break;
                    case "s":
                        c.setSaldo(c.getSaldo()-precioFinal);
                        c.Gastar(precioFinal);                  
                        for(int i=0;i<auxl.size();i++){
                            for(int j=0;j<bdlibros.size();j++){
                                if(auxl.get(i).codigo.equals(bdlibros.get(j).codigo)) {c.addHistorial(bdlibros.get(j)); bdlibros.get(j).Venta(); break;}
                            }
                        }
                        for(int i=0;i<auxr.size();i++){
                            for(int j=0;j<bdrevistas.size();j++){
                                if(auxr.get(i).codigo.equals(bdrevistas.get(j).codigo)) {c.addHistorial(bdrevistas.get(j)); bdrevistas.get(j).Venta(); break;}
                            }
                        }
                        for(int i=0;i<auxrs.size();i++){
                            for(int j=0;j<bdrevistas.size();j++){
                                if(auxrs.get(i).codigo.equals(bdrevistas.get(j).codigo)) {c.addHistorial(bdrevistas.get(j)); bdrevistas.get(j).subscribir(c); bdrevistas.get(j).Venta(); break;}
                            }
                        }
                        for(int i=0;i<auxp.size();i++){
                            for(int j=0;j<bdperiodicos.size();j++){
                                if(auxp.get(i).codigo.equals(bdperiodicos.get(j).codigo)) {c.addHistorial(bdperiodicos.get(j)); bdperiodicos.get(j).Venta(); break;}
                            }
                        }
                        for(int i=0;i<auxps.size();i++){
                            for(int j=0;j<bdperiodicos.size();j++){
                                if(auxps.get(i).codigo.equals(bdperiodicos.get(j).codigo)) {c.addHistorial(bdperiodicos.get(j)); bdperiodicos.get(j).subscribir(c); bdperiodicos.get(j).Venta(); break;}
                            }
                        }
                        c.resetCarrito();
                        System.out.println("Tramite finalizado");
                        break;
                    default:
                        System.out.println("Indice incorrecto");
                        break;
                }
            }
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void carritoReset(Cliente c){
        try{
        if(!c.getCarrito().isEmpty()){
            for(int i=0;i<c.getCarrito().size();i++){
                if(getLibro(c.getCarrito().get(i))!=null) getLibro(c.getCarrito().get(i)).Reembolsar();
                if(getRevista(c.getCarrito().get(i))!=null) getRevista(c.getCarrito().get(i)).Reembolsar();
                if(getPeriodico(c.getCarrito().get(i))!=null) getPeriodico(c.getCarrito().get(i)).Reembolsar();
            }
            c.resetCarrito();
        }  
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    
    public void adminSaldo(Cliente c){
        Scanner scani = new Scanner(System.in);
        double saldo;
        
        System.out.println("Ingresar cantidad a añadir:");
        saldo = scani.nextDouble();
        saldo += c.getSaldo();
        c.setSaldo(saldo);
        System.out.println("Saldo actualizado. Ahora dispone de "+c.getSaldo()+"€ en su cuenta.");
    }
    public void adminPremium(Cliente c, Boolean tipo){
        if(tipo) c.setPremium(1);
        else c.setPremium(0);
    }
    public void adminCleanH(Cliente c){
        c.getLibros().clear();
        c.getRevistas().clear();
        c.getPeriodicos().clear();
    }
    public int adminBorrarCliente(Cliente c){
        Scanner scant = new Scanner(System.in);
        String opcion;
        
        System.out.println("Esta seguro de que desea borrar su cuenta definitivamente? (s/n)");
        opcion = scant.nextLine();
        if(opcion.equals("s")) {bdclientes.remove(c); return 0;}
        else if(opcion.equals("n")) return 1;
        else System.out.println("Indice erroneo. Ninguna accion se llevara a cabo."); return 1;
    }
    
    public void crearCliente(){
        Scanner scant = new Scanner(System.in);
        ArrayList<Cliente> clientes = getClientes();
        ArrayList<Vendedor> vendedores = getVendedores();        
        String usuario;
        int cont=0;
        
        System.out.println("Introducir nuevo usuario:");
        usuario = scant.nextLine();

        for(int i=0;i<clientes.size();i++){
            if(clientes.get(i).getUsuario().equals(usuario)){System.out.println("Ese usuario ya existe."); cont++; break;}
        }
        for(int i=0;i<vendedores.size();i++){
            if(vendedores.get(i).getUsuario().equals(usuario)){System.out.println("Ese usuario ya existe."); cont++; break;}
        }
        if(cont==0){
            String dni;
            
            System.out.println("Introducir DNI");
            dni = scant.nextLine();
            for(int i=0;i<clientes.size();i++){
                if(clientes.get(i).getDni().equals(dni)){System.out.println("Este DNI ya está registrado como cliente."); cont++; break;}
            }
            if(cont==0){
                Scanner scani = new Scanner(System.in);
                String contraseña, nombre, postal, email, cat;
                long tarjeta;
                
                System.out.println("Introduce contraseña:");
                contraseña = scant.nextLine();
                System.out.println("Introduce tu nombre completo:");
                nombre = scant.nextLine();
                System.out.println("Introduce tu direccion postal:");
                postal = scant.nextLine();
                System.out.println("Introduce tu email:");
                email = scant.nextLine();
                System.out.println("Introduce una tarjeta de credito:");
                tarjeta = scani.nextLong();
                
                Cliente c = new Cliente(dni, nombre, postal, email, usuario, contraseña, tarjeta);
                ArrayList<String> catl = c.getCategorias();
                
                System.out.println("Elije 3 de las siguientes categorias de libros por orden de prioridad:");
                imprimirCategorias("l");
                cat = scant.nextLine();
                for(int i=0;i<bdsubcategoriasl.size();i++){
                    if(bdsubcategoriasl.get(i).equalsIgnoreCase(cat)) catl.add(bdsubcategoriasl.get(i));
                }
                cat = scant.nextLine();
                for(int i=0;i<bdsubcategoriasl.size();i++){
                    if(bdsubcategoriasl.get(i).equalsIgnoreCase(cat)) catl.add(bdsubcategoriasl.get(i));
                }
                cat = scant.nextLine();
                for(int i=0;i<bdsubcategoriasl.size();i++){
                    if(bdsubcategoriasl.get(i).equalsIgnoreCase(cat)) catl.add(bdsubcategoriasl.get(i));
                }
                System.out.println("Elije 3 de las siguientes categorias de revistas por orden de prioridad:");
                imprimirCategorias("r");
                cat = scant.nextLine();
                for(int i=0;i<bdsubcategoriasr.size();i++){
                    if(bdsubcategoriasr.get(i).equalsIgnoreCase(cat)) catl.add(bdsubcategoriasr.get(i));
                }
                cat = scant.nextLine();
                for(int i=0;i<bdsubcategoriasr.size();i++){
                    if(bdsubcategoriasr.get(i).equalsIgnoreCase(cat)) catl.add(bdsubcategoriasr.get(i));
                }
                cat = scant.nextLine();
                for(int i=0;i<bdsubcategoriasr.size();i++){
                    if(bdsubcategoriasr.get(i).equalsIgnoreCase(cat)) catl.add(bdsubcategoriasr.get(i));
                }
                System.out.println("Elije 3 de las siguientes categorias de periodicos por orden de prioridad:");
                imprimirCategorias("p");
                cat = scant.nextLine();
                for(int i=0;i<bdsubcategoriasp.size();i++){
                    if(bdsubcategoriasp.get(i).equalsIgnoreCase(cat)) catl.add(bdsubcategoriasp.get(i));
                }
                cat = scant.nextLine();
                for(int i=0;i<bdsubcategoriasp.size();i++){
                    if(bdsubcategoriasp.get(i).equalsIgnoreCase(cat)) catl.add(bdsubcategoriasp.get(i));
                }
                cat = scant.nextLine();
                for(int i=0;i<bdsubcategoriasp.size();i++){
                    if(bdsubcategoriasp.get(i).equalsIgnoreCase(cat)) catl.add(bdsubcategoriasp.get(i));
                }
                
                bdclientes.add(c);
            }
        }   
    }
    public void crearVendedor(){
        Scanner scant = new Scanner(System.in);
        ArrayList<Cliente> clientes = getClientes();
        ArrayList<Vendedor> vendedores = getVendedores();        
        String usuario;
        int cont=0;
        
        System.out.println("Introducir nuevo usuario:");
        usuario = scant.nextLine();
        
        for(int i=0;i<clientes.size();i++){
            if(clientes.get(i).getUsuario().equals(usuario)){System.out.println("Ese usuario ya existe."); cont++; break;}
        }
        for(int i=0;i<vendedores.size();i++){
            if(vendedores.get(i).getUsuario().equals(usuario)){System.out.println("Ese usuario ya existe."); cont++; break;}
        }
        if(cont==0){
            String dni;
            
            System.out.println("Introducir DNI");
            dni = scant.nextLine();
            for(int i=0;i<vendedores.size();i++){
                if(vendedores.get(i).getDni().equals(dni)){System.out.println("Este DNI ya está registrado como vendedor."); cont++; break;}
            }
            if(cont==0){
                Scanner scani = new Scanner(System.in);
                String contraseña, nombre, direccion, email;
                int telefono;
                long tarjeta;
                double sueldo;
                
                System.out.println("Introduce contraseña:");
                contraseña = scant.nextLine();
                System.out.println("Introduce tu nombre completo:");
                nombre = scant.nextLine();
                System.out.println("Introduce tu direccion:");
                direccion = scant.nextLine();
                System.out.println("Introduce tu telefono de contacto:");
                telefono = scani.nextInt();
                System.out.println("Introduce tu email:");
                email = scant.nextLine();
                System.out.println("Introduce tu nº de tarjeta:");
                tarjeta = scani.nextLong();
                System.out.println("Introduce tu sueldo:");
                sueldo = scani.nextDouble();
                
                Vendedor v = new Vendedor(dni, nombre, direccion, email, usuario, contraseña, tarjeta, telefono, sueldo);                                
                bdvendedores.add(v);
            }
        }
    }
    
    //Metodos de vendedor
    public void controlStock(){
        ArrayList<Libro> l = new ArrayList();
        ArrayList<Revista> r = new ArrayList();
        ArrayList<Periodico> p = new ArrayList();
        
        for(int i=0;i<bdlibros.size();i++){
            if(bdlibros.get(i).stock<5) l.add(bdlibros.get(i));
        }
        for(int i=0;i<bdrevistas.size();i++){
            if(bdrevistas.get(i).stock<5) r.add(bdrevistas.get(i));
        }
        for(int i=0;i<bdperiodicos.size();i++){
            if(bdperiodicos.get(i).stock<5) p.add(bdperiodicos.get(i));
        }
        
        if(!l.isEmpty()){
            System.out.println("Los siguientes libros se estan quedando sin stock\n----------------------------------");
            imprimirLibros(ordenarLibros(l), "n");
        }
        if(!r.isEmpty()){
            System.out.println("Las siguientes revistas se estan quedando sin stock\n----------------------------------");
            imprimirRevistas(ordenarRevistas(r), "n");
        }
        if(!p.isEmpty()){
            System.out.println("Los siguientes periodicos se estan quedando sin stock\n----------------------------------");
            imprimirPeriodicos(ordenarPeriodicos(p), "n");
        }
        
        if(!l.isEmpty() || !r.isEmpty() || !p.isEmpty()){
            System.out.println("Pulsar una tecla para continuar");
            try {
                System.in.read();
            } catch (IOException ex) {
                System.out.println("Error al recibir el input");
            }
        }
    }
    
    public void consultarLibroId(){
        Scanner scant = new Scanner(System.in);
        String codigo;
        int cont=0;
        
        System.out.println("Introducir el ISBN del libro a consultar");
        codigo = scant.nextLine();
        
        for(int i=0;i<bdlibros.size();i++){
            if(bdlibros.get(i).codigo.equals(codigo)){
                System.out.println("ISBN: "+bdlibros.get(i).getCodigo()+"\nNombre: "+bdlibros.get(i).getNombre()+"  Autor: "+bdlibros.get(i).getAutor()+"\nGenero: "+bdlibros.get(i).getGenero()+"  Editorial: "+bdlibros.get(i).getEditorial()+"\nEdicion: "+bdlibros.get(i).getEdicion()+"  Unidades: "+bdlibros.get(i).getStock()+"  Precio: "+bdlibros.get(i).getPrecio()+"  Ventas Totales: "+bdlibros.get(i).ventas+"  Fecha de Creacion: "+bdlibros.get(i).creacion.get(Calendar.DAY_OF_MONTH)+"/"+(bdlibros.get(i).creacion.get(Calendar.MONTH)+1)+"/"+bdlibros.get(i).creacion.get(Calendar.YEAR)+"\nResumen: "+bdlibros.get(i).resumen+"\n");
                cont++;
            }
        }
        if(cont==0) System.out.println("No se hayaron coincidencias"); 

    }
    public void consultarLibroC(){
        Scanner scant = new Scanner(System.in);
        ArrayList<Libro> l = new ArrayList();
        GregorianCalendar fecha;
        int dia, mes, año;
        
        System.out.println("Se consultaran los libros de creacion posterior a la fecha indicada\nIntroducir fecha en formato dd mm aaaa (respetando los espacios)");
        dia = scant.nextInt();
        mes = scant.nextInt()-1;
        año = scant.nextInt();
        
        fecha = new GregorianCalendar(año, mes, dia);
        
        for(int i=0;i<bdlibros.size();i++){
            if(bdlibros.get(i).creacion.after(fecha)) l.add(bdlibros.get(i));
        }
        
        if(l.isEmpty()) System.out.println("No se hayaron productos que cumplan el criterio");
        else {
            for(int i=0;i<l.size();i++){
                System.out.println("ISBN: "+l.get(i).getCodigo()+"\nNombre: "+l.get(i).getNombre()+"  Autor: "+l.get(i).getAutor()+"\nGenero: "+l.get(i).getGenero()+"  Editorial: "+l.get(i).getEditorial()+"\nEdicion: "+l.get(i).getEdicion()+"  Unidades: "+l.get(i).getStock()+"  Precio: "+l.get(i).getPrecio()+"  Ventas Totales: "+l.get(i).ventas+"  Fecha de Creacion: "+l.get(i).creacion.get(Calendar.DAY_OF_MONTH)+"/"+(l.get(i).creacion.get(Calendar.MONTH)+1)+"/"+l.get(i).creacion.get(Calendar.YEAR)+"\nResumen: "+l.get(i).resumen+"\n");
        }
        }
    }
    
    public void consultarRevistaId(){
        Scanner scant = new Scanner(System.in);
        String codigo;
        int cont=0;
        
        System.out.println("Introducir el ISSN de la revista a consultar");
        codigo = scant.nextLine();
        
        for(int i=0;i<bdrevistas.size();i++){
            if(bdrevistas.get(i).codigo.equals(codigo)){
                System.out.println("ISSN: "+bdrevistas.get(i).codigo+"\nNombre: "+bdrevistas.get(i).getNombre()+"  Unidades: "+bdrevistas.get(i).getStock()+"\nPrecio: "+bdrevistas.get(i).getPrecio()+"  Subscripcion: "+bdrevistas.get(i).getPrecioSubscripcion()+"  Ventas Totales: "+bdrevistas.get(i).ventas+"  Fecha Creacion: "+bdrevistas.get(i).creacion.get(Calendar.DAY_OF_MONTH)+"/"+(bdrevistas.get(i).creacion.get(Calendar.MONTH)+1)+"/"+bdrevistas.get(i).creacion.get(Calendar.YEAR)+"\nResumen: "+bdrevistas.get(i).resumen+"\n");
                cont++;
            }
        }
        if(cont==0) System.out.println("No se hayaron coincidencias"); 
    }
    public void consultarRevistaC(){
        Scanner scant = new Scanner(System.in);
        ArrayList<Revista> r = new ArrayList();
        GregorianCalendar fecha;
        int dia, mes, año;
        
        System.out.println("Se consultaran las revistas de creacion posterior a la fecha indicada\nIntroducir fecha en formato dd mm aaaa (respetando los espacios)");
        dia = scant.nextInt();
        mes = scant.nextInt()-1;
        año = scant.nextInt();
        
        fecha = new GregorianCalendar(año, mes, dia);
        
        for(int i=0;i<bdrevistas.size();i++){
            if(bdrevistas.get(i).creacion.after(fecha)) r.add(bdrevistas.get(i));
        }
        
        if(r.isEmpty()) System.out.println("No se hayaron productos que cumplan el criterio");
        else{
            for(int i=0;i<r.size();i++){
                System.out.println("ISSN: "+r.get(i).codigo+"\nNombre: "+r.get(i).getNombre()+"  Unidades: "+r.get(i).getStock()+"\nPrecio: "+r.get(i).getPrecio()+"  Subscripcion: "+r.get(i).getPrecioSubscripcion()+"  Ventas Totales: "+r.get(i).ventas+"  Fecha Creacion: "+r.get(i).creacion.get(Calendar.DAY_OF_MONTH)+"/"+(r.get(i).creacion.get(Calendar.MONTH)+1)+"/"+r.get(i).creacion.get(Calendar.YEAR)+"\nResumen: "+r.get(i).resumen+"\n");
        }
        }
    }
    
    public void consultarPeriodicoId(){
        Scanner scant = new Scanner(System.in);
        String codigo;
        int cont=0;
        
        System.out.println("Introducir el ISSN del periodico a consultar");
        codigo = scant.nextLine();
        
        for(int i=0;i<bdperiodicos.size();i++){
            if(bdperiodicos.get(i).codigo.equals(codigo)){
                System.out.println("ISSN: "+bdperiodicos.get(i).codigo+"\nNombre: "+bdperiodicos.get(i).getNombre()+"  Fecha: "+bdperiodicos.get(i).getFecha().get(Calendar.YEAR)+"-"+(bdperiodicos.get(i).getFecha().get(Calendar.MONTH)+1)+"-"+bdperiodicos.get(i).getFecha().get(Calendar.DAY_OF_MONTH)+"\nUnidades: "+bdperiodicos.get(i).getStock()+"  Precio: "+bdperiodicos.get(i).getPrecio()+"  Subscripcion: "+bdperiodicos.get(i).getPrecioSubscripcion()+"  Ventas Totales: "+bdperiodicos.get(i).ventas+"  Fecha Creacion:"+bdperiodicos.get(i).creacion.get(Calendar.YEAR)+"/"+(bdperiodicos.get(i).creacion.get(Calendar.MONTH)+1)+"/"+bdperiodicos.get(i).creacion.get(Calendar.DAY_OF_MONTH)+"\nResumen: "+bdperiodicos.get(i).resumen+"\n");
                cont++;
            }
        }
        if(cont==0) System.out.println("No se hayaron coincidencias"); 
    }
    public void consultarPeriodicoC(){
        Scanner scant = new Scanner(System.in);
        ArrayList<Periodico> p = new ArrayList();
        GregorianCalendar fecha;
        int dia, mes, año;
        
        System.out.println("Se consultaran los periodicos de creacion posterior a la fecha indicada\nIntroducir fecha en formato dd mm aaaa (respetando los espacios)");
        dia = scant.nextInt();
        mes = scant.nextInt()-1;
        año = scant.nextInt();
        
        fecha = new GregorianCalendar(año, mes, dia);
        
        for(int i=0;i<bdperiodicos.size();i++){
            if(bdperiodicos.get(i).creacion.after(fecha)) p.add(bdperiodicos.get(i));
        }
        
        if(p.isEmpty()) System.out.println("No se hayaron productos que cumplan el criterio");
        else{
            for(int i=0;i<p.size();i++){
                System.out.println("ISSN: "+p.get(i).codigo+"\nNombre: "+p.get(i).getNombre()+"  Fecha: "+p.get(i).getFecha().get(Calendar.YEAR)+"-"+(p.get(i).getFecha().get(Calendar.MONTH)+1)+"-"+p.get(i).getFecha().get(Calendar.DAY_OF_MONTH)+"\nUnidades: "+p.get(i).getStock()+"  Precio: "+p.get(i).getPrecio()+"  Subscripcion: "+p.get(i).getPrecioSubscripcion()+"  Ventas Totales: "+p.get(i).ventas+"  Fecha Creacion:"+p.get(i).creacion.get(Calendar.YEAR)+"/"+(p.get(i).creacion.get(Calendar.MONTH)+1)+"/"+p.get(i).creacion.get(Calendar.DAY_OF_MONTH)+"\nResumen: "+p.get(i).resumen+"\n");
        }
        }
    }
    
    public void crearLibro(){
        Scanner scant = new Scanner(System.in);       
        String isbn;
        int cont=0;
        
        System.out.println("Introducir ISBN del producto a crear:");
        isbn = scant.nextLine();
        
        for(int i=0;i<bdlibros.size();i++){
            if(bdlibros.get(i).codigo.equals(isbn)) cont++;
        }
        
        if(cont>0) System.out.println("Ese producto ya existe en la libreria");
        else{
            Scanner scani = new Scanner(System.in);
            String nombre, autor, editorial, genero, resumen, codigo;
            int edicion, stock;
            double precio;
            
            System.out.println("Introducir nombre:");
            nombre = scant.nextLine();
            System.out.println("Introducir autor:");
            autor = scant.nextLine();
            System.out.println("Introducir editorial:");
            editorial = scant.nextLine();
            System.out.println("Introducir genero:");
            genero = scant.nextLine();
            System.out.println("Introducir edicion (entero):");
            edicion = scani.nextInt();
            System.out.println("Introducir stock inicial:");
            stock = scani.nextInt();
            System.out.println("Introducir precio (formato 0,0:");
            precio = scani.nextDouble();
            System.out.println("Introducir resumen del producto:");
            resumen = scant.nextLine();
            System.out.println("A continuacion se muestran las subcategorias disponibles para libros. Elegir una.");
            imprimirCategorias("l");
            codigo = scant.nextLine();
            
            cont=0;
            for(int i=0;i<bdsubcategoriasl.size();i++){
                if(bdsubcategoriasl.get(i).equalsIgnoreCase(codigo)) cont++;
            }
            
            if(cont==0) System.out.println("La subcategoria indicada no es valida");
            else{
                Libro l;
                switch(codigo){
                    case "fantasia":
                        Fantasia f = new Fantasia(isbn, nombre, stock, precio, resumen, autor, editorial, genero, edicion);
                        bdfantasia.add(f);
                        l = (Libro) f;
                        bdlibros.add(l);
                        break;
                    case "ciencia ficcion":
                        CienciaFiccion cf = new CienciaFiccion(isbn, nombre, stock, precio, resumen, autor, editorial, genero, edicion);
                        bdcienciaficcion.add(cf);
                        l = (Libro) cf;
                        bdlibros.add(l);
                        break;
                }            
            System.out.println("Libro creado");
            }
        }
        
    }
    public void crearRevista(){
        Scanner scant = new Scanner(System.in);       
        String issn;
        int cont=0;
        
        System.out.println("Introducir ISSN del producto a crear:");
        issn = scant.nextLine();
        
        for(int i=0;i<bdrevistas.size();i++){
            if(bdrevistas.get(i).codigo.equals(issn)) cont++;
        }
        
        if(cont>0) System.out.println("Ese producto ya existe en la libreria");
        else{
            Scanner scani = new Scanner(System.in);
            String nombre, resumen, codigo;
            int stock;
            double precio, precio2;
            ArrayList<String> s = new ArrayList();
            
            System.out.println("Introducir nombre:");
            nombre = scant.nextLine();
            System.out.println("Introducir stock inicial:");
            stock = scani.nextInt();
            System.out.println("Introducir precio (formato 0,0:");
            precio = scani.nextDouble();
            System.out.println("Introducir precio de subscripcion (formato 0,0:");
            precio2 = scani.nextDouble();
            System.out.println("Introducir resumen del producto:");
            resumen = scant.nextLine();
            System.out.println("A continuacion se muestran las categorias disponibles para revistas. Elegir todas las deseadas separadas por espacios.");
            imprimirCategorias("r");
            codigo = scant.nextLine();
            
            cont=0;
            for(int i=0;i<bdsubcategoriasr.size();i++){
                if(bdsubcategoriasr.get(i).equalsIgnoreCase(codigo)) cont++;
            }
            
            if(cont==0) System.out.println("La subcategoria indicada no es valida");
            else{
                Revista l;
                switch(codigo){
                    case "actualidad":
                        Actualidad a = new Actualidad(issn, nombre, stock, precio, resumen, precio2);
                        bdactualidad.add(a);
                        l = (Revista) a;
                        bdrevistas.add(l);
                        break;
                    case "ciencia":
                        Ciencia c = new Ciencia(issn, nombre, stock, precio, resumen, precio2);
                        bdciencia.add(c);
                        l = (Revista) c;
                        bdrevistas.add(l);
                        break;
                }            
            System.out.println("Revista creada");
            }
        }
        
    }
    public void crearPeriodico(){
        Scanner scant = new Scanner(System.in);       
        String issn;
        int cont=0;
        
        System.out.println("Introducir ISSN del producto a crear:");
        issn = scant.nextLine();
        
        for(int i=0;i<bdperiodicos.size();i++){
            if(bdperiodicos.get(i).codigo.equals(issn)) cont++;
        }
        
        if(cont>0) System.out.println("Ese producto ya existe en la libreria");
        else{
            Scanner scani = new Scanner(System.in);
            String nombre, resumen, codigo;
            int stock, dia, mes, año;
            double precio, precio2;
            GregorianCalendar fecha;
            ArrayList<String> s = new ArrayList();
            
            System.out.println("Introducir nombre:");
            nombre = scant.nextLine();
            System.out.println("Introducir fecha (formato dd mm aaaa):");
            dia = scant.nextInt();
            mes = scant.nextInt()-1;
            año = scant.nextInt();
            
            fecha = new GregorianCalendar(año, mes, dia);
        
            System.out.println("Introducir stock inicial:");
            stock = scani.nextInt();
            System.out.println("Introducir precio (formato 0,0:");
            precio = scani.nextDouble();
            System.out.println("Introducir precio de subscripcion (formato 0,0:");
            precio2 = scani.nextDouble();
            System.out.println("Introducir resumen del producto:");
            resumen = scant.nextLine();
            System.out.println("A continuacion se muestran las categorias disponibles para libros. Elegir todas las deseadas separadas por espacios.");
            imprimirCategorias("l");
            codigo = scant.nextLine();
            
            cont=0;
            for(int i=0;i<bdsubcategoriasp.size();i++){
                if(bdsubcategoriasp.get(i).equalsIgnoreCase(codigo)) cont++;
            }
            
            if(cont==0) System.out.println("La subcategoria indicada no es valida");
            else{
                Periodico l;
                switch(codigo){
                    case "deportes":
                        Deportes d = new Deportes(issn, nombre, stock, precio, resumen, fecha, precio2);
                        bddeportes.add(d);
                        l = (Periodico) d;
                        bdperiodicos.add(l);
                        break;
                    case "local":
                        Local lo = new Local(issn, nombre, stock, precio, resumen, fecha, precio2);
                        bdlocales.add(lo);
                        l = (Periodico) lo;
                        bdperiodicos.add(l);
                        break;
                }            
            System.out.println("Periodico creado");
            }
        }
        
    }
    
    public void modificarLibro(){
        Scanner scant = new Scanner(System.in);
        Libro l = null;
        String isbn;
        int cont=0;
        
        try{
        System.out.println("Introducir ISBN del producto a modificar:");
        isbn = scant.nextLine();
        }catch(InputMismatchException ex){
            System.out.println("El tipo de dato esperado no concuerda con el recibido");
            try{
                throw new SetException();
            }catch(SetException ex2){
                isbn = ex2.cadenaSet();
            }
        }
        
        for(int i=0;i<bdlibros.size();i++){
            if(bdlibros.get(i).codigo.equals(isbn)) l = bdlibros.get(i); cont++;
        }
        if(cont==0) System.out.println("No se hayaron coincidencias");
        else{
            int opcion=0;
            Scanner scani = new Scanner(System.in);
            System.out.println("Elija qué atributo desea modificar:");
            
            do{System.out.println("1-Nombre    7-Precio\n2-Autor    8-Resumen\n3-Editorial    9-Subcategorias\n4-Genero    10-Ventas\n5-Edicion    11-Fecha de Creacion\n6-Stock    0-Atras");
                opcion = scani.nextInt();
                switch(opcion){
                    case 1:
                        String nombre;
                        try{
                        System.out.println("El nombre actual es: "+l.nombre);
                        System.out.println("Introducir nuevo nombre:");
                        nombre = scant.nextLine();
                        }catch(InputMismatchException ex){
                            System.out.println("El tipo de dato esperado no concuerda con el recibido");
                            try{
                                throw new SetException();
                            }catch(SetException ex2){
                                nombre = ex2.cadenaSet();
                            }
                        }
                        l.setNombre(nombre);
                        break;
                    case 2:
                        String autor;
                        try{
                        System.out.println("El autor actual es: "+l.autor);
                        System.out.println("Introducir nuevo autor:");
                        autor = scant.nextLine();
                        }catch(InputMismatchException ex){
                            System.out.println("El tipo de dato esperado no concuerda con el recibido");
                            try{
                                throw new SetException();
                            }catch(SetException ex2){
                                autor = ex2.cadenaSet();
                            }
                        }
                        l.setAutor(autor);
                        break;
                    case 3:
                        String editorial;
                        try{
                        System.out.println("La editorial actual es: "+l.editorial);
                        System.out.println("Introducir nueva editorial:");
                        editorial = scant.nextLine();
                        }catch(InputMismatchException ex){
                            System.out.println("El tipo de dato esperado no concuerda con el recibido");
                            try{
                                throw new SetException();
                            }catch(SetException ex2){
                                editorial = ex2.cadenaSet();
                            }
                        }
                        l.setEditorial(editorial);
                        break;
                    case 4:
                        String genero;
                        try{
                        System.out.println("El genero actual es: "+l.genero);
                        System.out.println("Introducir nuevo genero:");
                        genero = scant.nextLine();
                        }catch(InputMismatchException ex){
                            System.out.println("El tipo de dato esperado no concuerda con el recibido");
                            try{
                                throw new SetException();
                            }catch(SetException ex2){
                                genero = ex2.cadenaSet();
                            }
                        }
                        l.setGenero(genero);
                        break;
                    case 5:
                        int edicion;
                        try{
                        System.out.println("La edicion actual es: "+l.edicion);
                        System.out.println("Introducir nueva edicion:");
                        edicion = scani.nextInt();
                        }catch(InputMismatchException ex){
                            System.out.println("El tipo de dato esperado no concuerda con el recibido");
                            try{
                                throw new SetException();
                            }catch(SetException ex2){
                                edicion = (int) ex2.numeroSet();
                            }
                        }
                        l.setEdicion(edicion);
                        break;
                    case 6:
                        int stock;
                        try{
                        System.out.println("El stock actual es: "+l.stock);
                        System.out.println("Introducir nuevo stock:");
                        stock = scani.nextInt();
                        }catch(InputMismatchException ex){
                            System.out.println("El tipo de dato esperado no concuerda con el recibido");
                            try{
                                throw new SetException();
                            }catch(SetException ex2){
                                stock = (int) ex2.numeroSet();
                            }
                        }
                        l.setStock(stock);
                        break;
                    case 7:
                        double precio;
                        try{
                        System.out.println("El precio actual es: "+l.precio);
                        System.out.println("Introducir nuevo precio (formato 0,0):");
                        precio = scani.nextDouble();
                        }catch(InputMismatchException ex){
                            System.out.println("El tipo de dato esperado no concuerda con el recibido");
                            try{
                                throw new SetException();
                            }catch(SetException ex2){
                                precio = ex2.decimalSet();
                            }
                        }
                        l.setPrecio(precio);
                        break;
                    case 8:
                        System.out.println("El resumen actual es: "+l.resumen);
                        System.out.println("Introducir nuevo resumen:");
                        l.setResumen(scant.nextLine());
                        break;
                    case 9:
                        String codigo, sc=null;                                             
                        cont=0;
                        
                        System.out.print("Este libro pertenece a esta subcategoria: ");
                        for(int i=0;i<bdfantasia.size();i++){
                            if(l.codigo.equals(bdfantasia.get(i).codigo)) {sc = bdfantasia.get(i).getClass().getName(); System.out.println(sc);}
                        }
                        for(int i=0;i<bdcienciaficcion.size();i++){
                            if(l.codigo.equals(bdcienciaficcion.get(i).codigo)) {sc = bdcienciaficcion.get(i).getClass().getName(); System.out.println(sc);}
                        }
                        
                        System.out.println("Las subcategorias disponibles para libros son las siguientes:");
                        imprimirCategorias("l");
                        System.out.println("\n1)Cambiar de subcategoria\n0)Atras");
                        opcion = scani.nextInt();
                        
                        switch(opcion){
                            case 1:
                                codigo = scant.nextLine();
                                if(codigo.equalsIgnoreCase(sc)) System.out.println("Ha seleccionado la misma subcategoria a la que el articulo ya pertenece.");
                                else{
                                if(codigo.equalsIgnoreCase("fantasia")){
                                    cont++;
                                    
                                    Fantasia f = new Fantasia(l.codigo, l.nombre, l.stock, l.precio, l.resumen, l.autor, l.editorial, l.genero, l.edicion);
                                    bdfantasia.add(f);
                                    
                                    if(sc.equalsIgnoreCase("ciencia ficcion") || sc.equalsIgnoreCase("cienciaficcion")){
                                        CienciaFiccion cf = (CienciaFiccion) l;
                                        for(int i=0;i<bdcienciaficcion.size();i++){
                                            if(bdcienciaficcion.get(i).codigo.equals(cf.codigo)) bdcienciaficcion.remove(i);
                                        }
                                    }
                                }
                                if(codigo.equalsIgnoreCase("ciencia ficcion") || codigo.equalsIgnoreCase("cienciaficcion")){
                                    cont++;
                                    
                                    CienciaFiccion cf = new CienciaFiccion(l.codigo, l.nombre, l.stock, l.precio, l.resumen, l.autor, l.editorial, l.genero, l.edicion);
                                    bdcienciaficcion.add(cf);
                                    
                                    if(sc.equalsIgnoreCase("fantasia")){
                                        Fantasia f = (Fantasia) l;
                                        for(int i=0;i<bdfantasia.size();i++){
                                            if(bdfantasia.get(i).codigo.equals(f.codigo)) bdfantasia.remove(i);
                                        }
                                    }
                                }
                                }
                                if(cont==0) System.out.println("No se ha introducido una subcategoria valida.");
                                else System.out.println("Operacion realizada con exito.");
                                break;
                                
                            case 0:
                                break;
                            default:
                                System.out.println("Opcion invalida");
                                break;
                        }                        
                        break;
                    case 10:
                        int ventas;
                        try{
                        System.out.println("El numero de ventas actual es: "+l.ventas);
                        System.out.println("Introducir nuevo numero de ventas:");
                        ventas = scani.nextInt();
                        }catch(InputMismatchException ex){
                            System.out.println("El tipo de dato esperado no concuerda con el recibido");
                            try{
                                throw new SetException();
                            }catch(SetException ex2){
                                ventas = (int) ex2.numeroSet();
                            }
                        }
                        l.setVentas(ventas);
                        break;
                    case 11:
                        int dia, mes, año;
                        
                        System.out.println("La fecha de creacion es: "+l.creacion.get(Calendar.DAY_OF_MONTH)+"-"+(l.creacion.get(Calendar.MONTH)+1)+"-"+l.creacion.get(Calendar.YEAR));
                        System.out.println("Introducir nueva fecha de creacion (dd mm aaaa):");
                        dia = scant.nextInt();
                        mes = scant.nextInt()-1;
                        año = scant.nextInt();

                        l.creacion.clear();
                        l.creacion.set(año, mes, dia);
                        break;
                }
                
            }while(opcion!=0);
        }
    }
    public void modificarRevista(){
        Scanner scant = new Scanner(System.in);
        Revista r = null;
        String issn;
        int cont=0;
        
        System.out.println("Introducir ISSN del producto a modificar:");
        issn = scant.nextLine();
        
        for(int i=0;i<bdrevistas.size();i++){
            if(bdrevistas.get(i).codigo.equals(issn)) r = bdrevistas.get(i); cont++;
        }
        if(cont==0) System.out.println("No se hayaron coincidencias");
        else{
            int opcion=0;
            Scanner scani = new Scanner(System.in);
            System.out.println("Elija qué atributo desea modificar:");
            
            do{System.out.println("1-Nombre    6-Subcategorias\n2-Stock    7-Ventas\n3-Precio    8-Fecha de Creacion\n4-Precio Subscripcion    0-Atras\n5-Resumen");
                opcion = scani.nextInt();
                switch(opcion){
                    case 1:
                        System.out.println("El nombre actual es: "+r.nombre);
                        System.out.println("Introducir nuevo nombre:");
                        r.setNombre(scant.nextLine());
                        break;
                    case 2:
                        int stock;
                        try{
                        System.out.println("El stock actual es: "+r.stock);
                        System.out.println("Introducir nuevo stock:");
                        stock = scani.nextInt();
                        }catch(InputMismatchException ex){
                            System.out.println("El tipo de dato esperado no concuerda con el recibido");
                            try{
                                throw new SetException();
                            }catch(SetException ex2){
                                stock = (int) ex2.numeroSet();
                            }
                        }
                        r.setStock(stock);
                        break;
                    case 3:
                        double precio;
                        try{
                        System.out.println("El precio actual es: "+r.precio);
                        System.out.println("Introducir nuevo precio (formato 0,0):");
                        precio = scani.nextDouble();
                        }catch(InputMismatchException ex){
                            System.out.println("El tipo de dato esperado no concuerda con el recibido");
                            try{
                                throw new SetException();
                            }catch(SetException ex2){
                                precio = ex2.numeroSet();
                            }
                        }
                        r.setPrecio(precio);
                        break;
                    case 4:
                        try{
                        System.out.println("El precio de subscripcion actual es: "+r.precioSubscripcion);
                        System.out.println("Introducir nuevo precio (formato 0,0):");
                        precio = scani.nextDouble();
                        }catch(InputMismatchException ex){
                            System.out.println("El tipo de dato esperado no concuerda con el recibido");
                            try{
                                throw new SetException();
                            }catch(SetException ex2){
                                precio = ex2.numeroSet();
                            }
                        }
                        r.setPrecioSubscripcion(precio);
                        break;
                    case 5:
                        System.out.println("El resumen actual es: "+r.resumen);
                        System.out.println("Introducir nuevo resumen:");
                        r.setResumen(scant.nextLine());
                        break;
                    case 6:
                        String codigo, sc=null;                                             
                        cont=0;
                        
                        System.out.print("Esta revista pertenece a esta subcategoria: ");
                        for(int i=0;i<bdactualidad.size();i++){
                            if(r.codigo.equals(bdactualidad.get(i).codigo)) {sc = bdactualidad.get(i).getClass().getName(); System.out.println(sc);}
                        }
                        for(int i=0;i<bdciencia.size();i++){
                            if(r.codigo.equals(bdciencia.get(i).codigo)) {sc = bdciencia.get(i).getClass().getName(); System.out.println(sc);}
                        }
                        
                        System.out.println("Las subcategorias disponibles para revistas son las siguientes:");
                        imprimirCategorias("r");
                        System.out.println("\n1)Cambiar de subcategoria\n0)Atras");
                        opcion = scani.nextInt();
                        
                        switch(opcion){
                            case 1:
                                codigo = scant.nextLine();
                                if(codigo.equalsIgnoreCase(sc)) System.out.println("Ha seleccionado la misma subcategoria a la que el articulo ya pertenece.");
                                else{
                                if(codigo.equalsIgnoreCase("actualidad")){
                                    cont++;
                                    
                                    Actualidad a = new Actualidad(r.codigo, r.nombre, r.stock, r.precio, r.resumen, r.precioSubscripcion);
                                    bdactualidad.add(a);
                                    
                                    if(sc.equalsIgnoreCase("ciencia")){
                                        Ciencia c = (Ciencia) r;
                                        for(int i=0;i<bdciencia.size();i++){
                                            if(bdciencia.get(i).codigo.equals(c.codigo)) bdciencia.remove(i);
                                        }
                                    }
                                }
                                if(codigo.equalsIgnoreCase("ciencia")){
                                    cont++;
                                    
                                    Ciencia c = new Ciencia(r.codigo, r.nombre, r.stock, r.precio, r.resumen, r.precioSubscripcion);
                                    bdciencia.add(c);
                                    
                                    if(sc.equalsIgnoreCase("actualidad")){
                                        Actualidad a = (Actualidad) r;
                                        for(int i=0;i<bdactualidad.size();i++){
                                            if(bdactualidad.get(i).codigo.equals(a.codigo)) bdactualidad.remove(i);
                                        }
                                    }
                                }
                                }
                                if(cont==0) System.out.println("No se ha introducido una subcategoria valida.");
                                else System.out.println("Operacion realizada con exito.");
                                break;
                                
                            case 0:
                                break;
                            default:
                                System.out.println("Opcion invalida");
                                break;
                        }                        
                        break;
                    case 7:
                        int ventas;
                        try{
                        System.out.println("El numero de ventas actual es: "+r.ventas);
                        System.out.println("Introducir nuevo numero de ventas:");
                        ventas = scani.nextInt();
                        }catch(InputMismatchException ex){
                            System.out.println("El tipo de dato esperado no concuerda con el recibido");
                            try{
                                throw new SetException();
                            }catch(SetException ex2){
                                ventas = (int) ex2.numeroSet();
                            }
                        }
                        r.setVentas(ventas);
                        break;
                    case 8:
                        int dia, mes, año;
                        
                        System.out.println("La fecha de creacion es: "+r.creacion.get(Calendar.DAY_OF_MONTH)+"-"+(r.creacion.get(Calendar.MONTH)+1)+"-"+r.creacion.get(Calendar.YEAR));
                        System.out.println("Introducir nueva fecha de creacion (dd mm aaaa):");
                        dia = scant.nextInt();
                        mes = scant.nextInt()-1;
                        año = scant.nextInt();

                        r.creacion.clear();
                        r.creacion.set(año, mes, dia);
                        break;
                }
                
            }while(opcion!=0);
        }
    }
    public void modificarPeriodico(){
        Scanner scant = new Scanner(System.in);
        Periodico p = null;
        String issn;
        int cont=0;
        
        System.out.println("Introducir ISSN del producto a modificar:");
        issn = scant.nextLine();
        
        for(int i=0;i<bdperiodicos.size();i++){
            if(bdperiodicos.get(i).codigo.equals(issn)) p = bdperiodicos.get(i); cont++;
        }
        if(cont==0) System.out.println("No se hayaron coincidencias");
        else{
            int opcion=0;
            Scanner scani = new Scanner(System.in);
            System.out.println("Elija qué atributo desea modificar:");
            
            do{System.out.println("1-Nombre    6-Subcategorias\n2-Stock    7-Ventas\n3-Precio    8-Fecha de Creacion\n4-Precio Subscripcion    9-Fecha\n5-Resumen    0-Atras");
                opcion = scani.nextInt();
                switch(opcion){
                    case 1:
                        System.out.println("El nombre actual es: "+p.nombre);
                        System.out.println("Introducir nuevo nombre:");
                        p.setNombre(scant.nextLine());
                        break;
                    case 2:
                        int stock;
                        try{
                        System.out.println("El stock actual es: "+p.stock);
                        System.out.println("Introducir nuevo stock:");
                        stock = scani.nextInt();
                        }catch(InputMismatchException ex){
                            System.out.println("El tipo de dato esperado no concuerda con el recibido");
                            try{
                                throw new SetException();
                            }catch(SetException ex2){
                                stock = (int) ex2.numeroSet();
                            }
                        }
                        p.setStock(stock);
                        break;
                    case 3:
                        double precio;
                        try{
                        System.out.println("El precio actual es: "+p.precio);
                        System.out.println("Introducir nuevo precio (formato 0,0):");
                        precio = scani.nextDouble();
                        }catch(InputMismatchException ex){
                            System.out.println("El tipo de dato esperado no concuerda con el recibido");
                            try{
                                throw new SetException();
                            }catch(SetException ex2){
                                precio = ex2.numeroSet();
                            }
                        }
                        p.setPrecio(precio);
                        break;
                    case 4:
                        try{
                        System.out.println("El precio de subscripcion actual es: "+p.precioSubscripcion);
                        System.out.println("Introducir nuevo precio (formato 0,0):");
                        precio = scani.nextDouble();
                        }catch(InputMismatchException ex){
                            System.out.println("El tipo de dato esperado no concuerda con el recibido");
                            try{
                                throw new SetException();
                            }catch(SetException ex2){
                                precio = ex2.numeroSet();
                            }
                        }
                        p.setPrecioSubscripcion(precio);
                        break;
                    case 5:
                        System.out.println("El resumen actual es: "+p.resumen);
                        System.out.println("Introducir nuevo resumen:");
                        p.setResumen(scant.nextLine());
                        break;
                    case 6:
                        String codigo, sc=null;                                             
                        cont=0;
                        
                        System.out.print("Este periodico pertenece a esta subcategoria: ");
                        for(int i=0;i<bddeportes.size();i++){
                            if(p.codigo.equals(bddeportes.get(i).codigo)) {sc = bddeportes.get(i).getClass().getName(); System.out.println(sc);}
                        }
                        for(int i=0;i<bdlocales.size();i++){
                            if(p.codigo.equals(bdlocales.get(i).codigo)) {sc = bdlocales.get(i).getClass().getName(); System.out.println(sc);}
                        }
                        
                        System.out.println("Las subcategorias disponibles para periodicos son las siguientes:");
                        imprimirCategorias("p");
                        System.out.println("\n1)Cambiar de subcategoria\n0)Atras");
                        opcion = scani.nextInt();
                        
                        switch(opcion){
                            case 1:
                                codigo = scant.nextLine();
                                if(codigo.equalsIgnoreCase(sc)) System.out.println("Ha seleccionado la misma subcategoria a la que el articulo ya pertenece.");
                                else{
                                if(codigo.equalsIgnoreCase("deportes")){
                                    cont++;
                                    
                                    Deportes d = new Deportes(p.codigo, p.nombre, p.stock, p.precio, p.resumen, p.fecha, p.precioSubscripcion);
                                    bddeportes.add(d);
                                    
                                    if(sc.equalsIgnoreCase("local")){
                                        Local l = (Local) p;
                                        for(int i=0;i<bdlocales.size();i++){
                                            if(bdlocales.get(i).codigo.equals(l.codigo)) bdlocales.remove(i);
                                        }
                                    }
                                }
                                if(codigo.equalsIgnoreCase("local")){
                                    cont++;
                                    
                                    Local l = new Local(p.codigo, p.nombre, p.stock, p.precio, p.resumen, p.fecha, p.precioSubscripcion);
                                    bdlocales.add(l);
                                    
                                    if(sc.equalsIgnoreCase("deportes")){
                                        Deportes d = (Deportes) p;
                                        for(int i=0;i<bddeportes.size();i++){
                                            if(bddeportes.get(i).codigo.equals(d.codigo)) bddeportes.remove(i);
                                        }
                                    }
                                }
                                }
                                if(cont==0) System.out.println("No se ha introducido una subcategoria valida.");
                                else System.out.println("Operacion realizada con exito.");
                                break;
                                
                            case 0:
                                break;
                            default:
                                System.out.println("Opcion invalida");
                                break;
                        }                        
                        break;
                    case 7:
                        int ventas;
                        try{
                        System.out.println("El numero de ventas actual es: "+p.ventas);
                        System.out.println("Introducir nuevo numero de ventas:");
                        ventas = scani.nextInt();
                        }catch(InputMismatchException ex){
                            System.out.println("El tipo de dato esperado no concuerda con el recibido");
                            try{
                                throw new SetException();
                            }catch(SetException ex2){
                                ventas = (int) ex2.numeroSet();
                            }
                        }
                        p.setVentas(ventas);
                        break;
                    case 8:
                       {int dia, mes, año;
                        
                        System.out.println("La fecha de creacion es: "+p.creacion.get(Calendar.DAY_OF_MONTH)+"-"+(p.creacion.get(Calendar.MONTH)+1)+"-"+p.creacion.get(Calendar.YEAR));
                        System.out.println("Introducir nueva fecha de creacion (dd mm aaaa):");
                        dia = scant.nextInt();
                        mes = scant.nextInt()-1;
                        año = scant.nextInt();

                        p.creacion.clear();
                        p.creacion.set(año, mes, dia);
                        break;}
                    case 9:
                       {int dia, mes, año;
                        
                        System.out.println("La fecha actual es: "+p.fecha.get(Calendar.DAY_OF_MONTH)+"-"+(p.fecha.get(Calendar.MONTH)+1)+"-"+p.fecha.get(Calendar.YEAR));
                        System.out.println("Introducir nueva (dd mm aaaa):");
                        dia = scant.nextInt();
                        mes = scant.nextInt()-1;
                        año = scant.nextInt();

                        p.fecha.clear();
                        p.fecha.set(año, mes, dia);
                        break;}
                }                
            }while(opcion!=0);
        }
    }
    
    public void eliminarLibro(){
        Scanner scant = new Scanner(System.in);       
        String isbn;
        int cont=0;
        
        System.out.println("Introducir ISBN del producto a dar de baja (poner stock a 0):");
        isbn = scant.nextLine();
        
        for(int i=0;i<bdlibros.size();i++){
            if(bdlibros.get(i).codigo.equals(isbn)) bdlibros.get(i).stock=0; cont++;
        }
        if(cont>0) System.out.println("Se ha dado de baja correctamente");
        else System.out.println("No se hayaron coincidencias");
    }
    public void eliminarRevista(){
        Scanner scant = new Scanner(System.in);       
        String issn;
        int cont=0;
        
        System.out.println("Introducir ISSN del producto a dar de baja (poner stock a 0):");
        issn = scant.nextLine();
        
        for(int i=0;i<bdrevistas.size();i++){
            if(bdrevistas.get(i).codigo.equals(issn)) bdrevistas.get(i).stock=0; cont++;
        }
        if(cont>0) System.out.println("Se ha dado de baja correctamente");
        else System.out.println("No se hayaron coincidencias");
    }
    public void eliminarPeriodico(){
        Scanner scant = new Scanner(System.in);       
        String issn;
        int cont=0;
        
        System.out.println("Introducir ISSN del producto a dar de baja (poner stock a 0):");
        issn = scant.nextLine();
        
        for(int i=0;i<bdperiodicos.size();i++){
            if(bdperiodicos.get(i).codigo.equals(issn)) bdperiodicos.get(i).stock=0; cont++;
        }
        if(cont>0) System.out.println("Se ha dado de baja correctamente");
        else System.out.println("No se hayaron coincidencias");
    }
    
    public void imprimirClientes(ArrayList<Cliente> clientes, String tipo){  
        try{
        switch(tipo){
            case "t":
                for(int i=0;i<clientes.size();i++){
                    System.out.println("DNI: "+clientes.get(i).getDni()+"  Nombre: "+clientes.get(i).getNombre()+"  Direccion Postal: "+clientes.get(i).getDireccion()+"\nEmail: "+clientes.get(i).getEmail()+"  Tarjeta: "+clientes.get(i).getTarjeta()+"  Saldo: "+clientes.get(i).getSaldo()+"\nUsuario: "+clientes.get(i).getUsuario()+"  Accesos: "+clientes.get(i).getAccesos()+"  Gasto Total: "+clientes.get(i).getGastoTotal());
                    if(!clientes.get(i).getLibros().isEmpty()){
                        System.out.println("Historial de compra de libros:");
                        imprimirLibros(ordenarLibros(clientes.get(i).getLibros()), "h");
                    }
                    if(!clientes.get(i).getRevistas().isEmpty()){
                        System.out.println("Historial de compra de revistas:");
                        imprimirRevistas(ordenarRevistas(clientes.get(i).getRevistas()), "h1");
                    }
                    if(!clientes.get(i).getPeriodicos().isEmpty()){
                        System.out.println("Historial de compra de periodicos:");
                        imprimirPeriodicos(ordenarPeriodicos(clientes.get(i).getPeriodicos()), "h1");
                    }
                    if(!clientes.get(i).getCategorias().isEmpty()){
                        System.out.println("Subcategorias de libros preferidas:");
                        imprimirCategorias(clientes.get(i), "l");
                        System.out.println("Subcategorias de revistas preferidas:");
                        imprimirCategorias(clientes.get(i), "r");
                        System.out.println("Subcategorias de periodicos preferidas:");
                        imprimirCategorias(clientes.get(i), "p");
                    }                   
                    System.out.println("");
                }
                break;
            case "p":
                for(int i=0;i<clientes.size();i++){
                    System.out.println("DNI: "+clientes.get(i).getDni()+"  Nombre: "+clientes.get(i).getNombre()+"  Direccion Postal: "+clientes.get(i).getDireccion()+"\nEmail: "+clientes.get(i).getEmail()+"  Tarjeta: "+clientes.get(i).getTarjeta()+"  Usuario: "+clientes.get(i).getUsuario());
                    System.out.println("");
                }
                break;
            case "c":
                for(int i=0;i<clientes.size();i++){
                    System.out.println("Nombre: "+clientes.get(i).getNombre()+"  Usuario: "+clientes.get(i).getUsuario()+"  Tarjeta: "+clientes.get(i).getTarjeta()+"  Saldo: "+clientes.get(i).getSaldo()+"  Accesos: "+clientes.get(i).getAccesos()+"  Gasto Total: "+clientes.get(i).getGastoTotal());
                    if(!clientes.get(i).getLibros().isEmpty()){
                        System.out.println("Historial de compra de libros:");
                        imprimirLibros(ordenarLibros(clientes.get(i).getLibros()), "h");
                    }
                    if(!clientes.get(i).getRevistas().isEmpty()){
                        System.out.println("Historial de compra de revistas:");
                        imprimirRevistas(ordenarRevistas(clientes.get(i).getRevistas()), "h1");
                    }
                    if(!clientes.get(i).getPeriodicos().isEmpty()){
                        System.out.println("Historial de compra de periodicos:");
                        imprimirPeriodicos(ordenarPeriodicos(clientes.get(i).getPeriodicos()), "h1");
                    }
                    if(!clientes.get(i).getCategorias().isEmpty()){
                        System.out.println("Subcategorias de libros preferidas:");
                        imprimirCategorias(clientes.get(i), "l");
                        System.out.println("Subcategorias de revistas preferidas:");
                        imprimirCategorias(clientes.get(i), "r");
                        System.out.println("Subcategorias de periodicos preferidas:");
                        imprimirCategorias(clientes.get(i), "p");
                    }
                    System.out.println("");
                }
                break;
            case "c2":
                for(int i=0;i<clientes.size();i++){
                    System.out.println("Nombre: "+clientes.get(i).getNombre()+"  Usuario: "+clientes.get(i).getUsuario()+"  Tarjeta: "+clientes.get(i).getTarjeta()+"  Saldo: "+clientes.get(i).getSaldo()+"  Accesos: "+clientes.get(i).getAccesos()+"  Gasto Total: "+clientes.get(i).getGastoTotal());
                    System.out.println("");
                }
                break;
        }
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void imprimirCliente(String tipo){
        Scanner scant = new Scanner(System.in);
        String nombre;
        ArrayList<Cliente> clientes = new ArrayList();        
        int cont=0;
        
        System.out.println("Nombre del cliente a consultar:");
        nombre = scant.nextLine();
        
        for(int i=0;i<bdclientes.size();i++){
            if(bdclientes.get(i).getNombre().equalsIgnoreCase(nombre)) clientes.add(bdclientes.get(i)); cont++;
        }
        
        if(cont==0) System.out.println("No se hayaron coincidencias");
        else if(cont>1){
            System.out.println("Se ha hayado mas de una coincidencia:");
            imprimirClientes(clientes, "p");
            
            if(!tipo.equals("p")){
                ArrayList<Cliente> clientes2 = new ArrayList();
                System.out.println("Introducir DNI del cliente a consultar:");
                nombre = scant.nextLine();
                
                for(int i=0;i<clientes.size();i++){
                    if(clientes.get(i).getDni().equals(nombre)) clientes2.add(clientes.get(i)); imprimirClientes(clientes2, tipo);
                }
            } 
        }
        else if(cont==1){
            imprimirClientes(clientes, tipo);
        }
        else System.out.println("Ha ocurrido un error");
    }
    public void imprimirConsumidores(){
        ArrayList<Cliente> clientes = new ArrayList(bdclientes);
        ArrayList<Cliente> clientes2 = new ArrayList();
        Cliente c;
        
        if(clientes.size()>1){
            c = clientes.get(0);
            for(int i=1;i<clientes.size();i++){
                if(clientes.get(i).getGastoTotal()>c.getGastoTotal()) c = clientes.get(i);
            }
            clientes2.add(c);
            for(int i=0;i<clientes.size();i++){
                if(clientes.get(i).getGastoTotal()==c.getGastoTotal() && !clientes.get(i).getDni().equals(c.getDni())) clientes2.add(clientes.get(i));
            }
        }
        else clientes2.add(clientes.get(0));
        
        imprimirClientes(clientes2, "c2");
    }
    public void imprimirInactivos(){
        Scanner scant = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList(bdclientes);
        ArrayList<Cliente> clientes2 = new ArrayList();
        String input;
        int dia, mes, año, cont, dia2, mes2, año2;
        GregorianCalendar fechaa, fechad;
        
        System.out.println("Introducir periodo de tiempo (dd mm aaaa dd mm aaaa)(la fecha menor primero)(respetar espacios): ");
        dia = scant.nextInt();
        mes = scant.nextInt()-1;
        año = scant.nextInt(); 
        dia2 = scant.nextInt();
        mes2 = scant.nextInt()-1;
        año2 = scant.nextInt(); 
        
        fechaa = new GregorianCalendar(año, mes, dia);
        fechad = new GregorianCalendar(año2, mes2, dia2);
        
        for(int i=0;i<clientes.size();i++){
            cont = 0;
            for(int j=0;j<clientes.get(i).getFcompras().size();j++){
                if((clientes.get(i).getFcompras().get(j).equals(fechaa) || clientes.get(i).getFcompras().get(j).after(fechaa)) && (clientes.get(i).getFcompras().get(j).equals(fechad) || clientes.get(i).getFcompras().get(j).before(fechad))) cont++;       
            }
            if(cont==0) clientes2.add(clientes.get(i));
        }        
        
        if(clientes2.isEmpty()) System.out.println("No hay clientes inactivos en el periodo especificado");
        else imprimirClientes(clientes2, "c2");
    }
    
    public void imprimirProducto(){
        Scanner scant = new Scanner(System.in);
        String codigo;
        int cont=0;
        
        System.out.println("Introducir ISBN/ISSN del producto a consultar:");
        codigo = scant.nextLine();
        
        for(int i=0;i<bdlibros.size();i++){
            if(bdlibros.get(i).codigo.equals(codigo)) System.out.println("Nombre: "+bdlibros.get(i).nombre+"\nStock: "+bdlibros.get(i).stock+"  Ventas Totales: "+bdlibros.get(i).ventas); cont++;
        }
        for(int i=0;i<bdrevistas.size();i++){
            if(bdrevistas.get(i).codigo.equals(codigo)) System.out.println("Nombre: "+bdrevistas.get(i).nombre+"\nStock: "+bdrevistas.get(i).stock+"  Ventas Totales: "+bdrevistas.get(i).ventas); cont++;
        }
        for(int i=0;i<bdperiodicos.size();i++){
            if(bdperiodicos.get(i).codigo.equals(codigo)) System.out.println("Nombre: "+bdperiodicos.get(i).nombre+"\nStock: "+bdperiodicos.get(i).stock+"  Ventas Totales: "+bdperiodicos.get(i).ventas); cont++;
        }
        
        if(cont==0) System.out.println("Ese producto no existe");
    }
    public void imprimirProductoPeriodo(String tipo){
        Scanner scant = new Scanner(System.in);
        ArrayList<Libro> alibros = new ArrayList();
        ArrayList<Revista> arevistas = new ArrayList();
        ArrayList<Periodico> aperiodicos = new ArrayList();       
        int dia, mes, año, cont, dia2, mes2, año2;
        GregorianCalendar fechaa, fechad;
        
        System.out.println("Introducir periodo de tiempo (dd mm aaaa dd mm aaaa)(la fecha menor primero)(respetar espacios): ");
        dia = scant.nextInt();
        mes = scant.nextInt()-1;
        año = scant.nextInt(); 
        dia2 = scant.nextInt();
        mes2 = scant.nextInt()-1;
        año2 = scant.nextInt(); 
        
        fechaa = new GregorianCalendar(año, mes, dia);
        fechad = new GregorianCalendar(año2, mes2, dia2);
        
        switch(tipo){
            case "si":
                HashMap<Libro, Integer> libros = new HashMap();
                HashMap<Revista, Integer> revistas = new HashMap();
                HashMap<Periodico, Integer> periodicos = new HashMap();
        
                for(int i=0;i<bdlibros.size();i++){
                    cont = 0;
                    for(int j=0;j<bdlibros.get(i).fventas.size();j++){
                        if((bdlibros.get(i).fventas.get(j).equals(fechaa) || bdlibros.get(i).fventas.get(j).after(fechaa)) && (bdlibros.get(i).fventas.get(j).equals(fechad) || bdlibros.get(i).fventas.get(j).before(fechad))) cont++;       
                    }
                    if(cont>0){
                      Integer contI = new Integer(cont);
                      alibros.add(bdlibros.get(i));
                      libros.put(bdlibros.get(i), contI);
                    }
                } 
                for(int i=0;i<bdrevistas.size();i++){
                    cont = 0;
                    for(int j=0;j<bdrevistas.get(i).fventas.size();j++){
                        if((bdrevistas.get(i).fventas.get(j).equals(fechaa) || bdrevistas.get(i).fventas.get(j).after(fechaa)) && (bdrevistas.get(i).fventas.get(j).equals(fechad) || bdrevistas.get(i).fventas.get(j).before(fechad))) cont++;       
                    }
                    if(cont>0){
                      Integer contI = new Integer(cont);
                      arevistas.add(bdrevistas.get(i));
                      revistas.put(bdrevistas.get(i), contI);
                    }
                } 
                for(int i=0;i<bdperiodicos.size();i++){
                    cont = 0;
                    for(int j=0;j<bdperiodicos.get(i).fventas.size();j++){
                        if((bdperiodicos.get(i).fventas.get(j).equals(fechaa) || bdperiodicos.get(i).fventas.get(j).after(fechaa)) && (bdperiodicos.get(i).fventas.get(j).equals(fechad) || bdperiodicos.get(i).fventas.get(j).before(fechad))) cont++;       
                    }
                    if(cont>0){
                      Integer contI = new Integer(cont);
                      aperiodicos.add(bdperiodicos.get(i));
                      periodicos.put(bdperiodicos.get(i), contI);
                    }
                }
                
                if(!alibros.isEmpty()){
                    System.out.println("Libros vendidos en el periodo especificado:");
                    for(int i=0;i<alibros.size();i++){
                        System.out.println("ISBN: "+alibros.get(i).codigo+"\nNombre: "+alibros.get(i).nombre+"  Ventas en el periodo: "+libros.get(alibros.get(i)));
                    }
                }
                if(!arevistas.isEmpty()){
                    System.out.println("Revistas vendidas en el periodo especificado:");
                    for(int i=0;i<arevistas.size();i++){
                        System.out.println("ISSN: "+arevistas.get(i).codigo+"\nNombre: "+arevistas.get(i).nombre+"  Ventas en el periodo: "+revistas.get(arevistas.get(i)));
                    }
                }
                if(!aperiodicos.isEmpty()){
                    System.out.println("Periodicos vendidos en el periodo especificado:");
                    for(int i=0;i<aperiodicos.size();i++){
                        System.out.println("ISSN: "+aperiodicos.get(i).codigo+"\nNombre: "+aperiodicos.get(i).nombre+"  Ventas en el periodo: "+periodicos.get(aperiodicos.get(i)));
                    }
                }
                if(alibros.isEmpty() && arevistas.isEmpty() && aperiodicos.isEmpty()) System.out.println("No se han hecho ventas en el periodo especificado");
                break;
            case "no":
                for(int i=0;i<bdlibros.size();i++){
                    cont = 0;
                    for(int j=0;j<bdlibros.get(i).fventas.size();j++){
                        if((bdlibros.get(i).fventas.get(j).equals(fechaa) || bdlibros.get(i).fventas.get(j).after(fechaa)) && (bdlibros.get(i).fventas.get(j).equals(fechad) || bdlibros.get(i).fventas.get(j).before(fechad))) cont++;       
                    }
                    if(cont==0) alibros.add(bdlibros.get(i));                    
                } 
                for(int i=0;i<bdrevistas.size();i++){
                    cont = 0;
                    for(int j=0;j<bdrevistas.get(i).fventas.size();j++){
                        if((bdrevistas.get(i).fventas.get(j).equals(fechaa) || bdrevistas.get(i).fventas.get(j).after(fechaa)) && (bdrevistas.get(i).fventas.get(j).equals(fechad) || bdrevistas.get(i).fventas.get(j).before(fechad))) cont++;       
                    }
                    if(cont==0) arevistas.add(bdrevistas.get(i));
                } 
                for(int i=0;i<bdperiodicos.size();i++){
                    cont = 0;
                    for(int j=0;j<bdperiodicos.get(i).fventas.size();j++){
                        if((bdperiodicos.get(i).fventas.get(j).equals(fechaa) || bdperiodicos.get(i).fventas.get(j).after(fechaa)) && (bdperiodicos.get(i).fventas.get(j).equals(fechad) || bdperiodicos.get(i).fventas.get(j).before(fechad))) cont++;       
                    }
                    if(cont>0) aperiodicos.add(bdperiodicos.get(i));
                }
                
                if(!alibros.isEmpty()){
                    System.out.println("Libros no vendidos en el periodo especificado:");
                    for(int i=0;i<alibros.size();i++){
                        System.out.println("ISBN: "+alibros.get(i).codigo+"\nNombre: "+alibros.get(i).nombre);
                    }
                }
                if(!arevistas.isEmpty()){
                    System.out.println("Revistas no vendidas en el periodo especificado:");
                    for(int i=0;i<arevistas.size();i++){
                        System.out.println("ISSN: "+arevistas.get(i).codigo+"\nNombre: "+arevistas.get(i).nombre);
                    }
                }
                if(!aperiodicos.isEmpty()){
                    System.out.println("Periodicos no vendidos en el periodo especificado:");
                    for(int i=0;i<aperiodicos.size();i++){
                        System.out.println("ISSN: "+aperiodicos.get(i).codigo+"\nNombre: "+aperiodicos.get(i).nombre);
                    }
                }
                if(alibros.isEmpty() && arevistas.isEmpty() && aperiodicos.isEmpty()) System.out.println("No hay productos no vendidos en el periodo especificado.");
                break;
        }
               
        
        
    }
    public void imprimirBestsellers(){
        ArrayList<Libro> libros = new ArrayList();
        Libro libro;
        ArrayList<Revista> revistas = new ArrayList();
        Revista revista;
        ArrayList<Periodico> periodicos = new ArrayList();
        Periodico periodico;
        
        if(bdlibros.size()>1){
            libro = bdlibros.get(0);
            for(int i=1;i<bdlibros.size();i++){
                if(bdlibros.get(i).ventas>libro.ventas) libro = bdlibros.get(i);
            }
            libros.add(libro);
            for(int i=0;i<bdlibros.size();i++){
                if(bdlibros.get(i).ventas==libro.ventas && !bdlibros.get(i).codigo.equals(libro.codigo)) libros.add(bdlibros.get(i));
            }
        }
        else libros.add(bdlibros.get(0));
        if(bdrevistas.size()>1){
            revista = bdrevistas.get(0);
            for(int i=1;i<bdrevistas.size();i++){
                if(bdrevistas.get(i).ventas>revista.ventas) revista = bdrevistas.get(i);
            }
            revistas.add(revista);
            for(int i=0;i<bdrevistas.size();i++){
                if(bdrevistas.get(i).ventas==revista.ventas && !bdrevistas.get(i).codigo.equals(revista.codigo)) revistas.add(bdrevistas.get(i));
            }
        }
        else revistas.add(bdrevistas.get(0));
        if(bdperiodicos.size()>1){
            periodico = bdperiodicos.get(0);
            for(int i=1;i<bdperiodicos.size();i++){
                if(bdperiodicos.get(i).ventas>periodico.ventas) periodico = bdperiodicos.get(i);
            }
            periodicos.add(periodico);
            for(int i=0;i<bdperiodicos.size();i++){
                if(bdperiodicos.get(i).ventas==periodico.ventas && !bdperiodicos.get(i).codigo.equals(periodico.codigo)) periodicos.add(bdperiodicos.get(i));
            }
        }
        else periodicos.add(bdperiodicos.get(0));
        
        if(!libros.isEmpty()){
            System.out.println("Libro/s mas vendido/s:");
            for(int i=0;i<libros.size();i++){
                System.out.println("ISBN: "+libros.get(i).getCodigo()+"\nNombre: "+libros.get(i).getNombre()+"  Autor: "+libros.get(i).getAutor()+"\nGenero: "+libros.get(i).getGenero()+"  Editorial: "+libros.get(i).getEditorial()+"\nEdicion: "+libros.get(i).getEdicion()+"  Unidades: "+libros.get(i).getStock()+"  Precio: "+libros.get(i).getPrecio()+"  Ventas Totales: "+libros.get(i).ventas+"  Fecha de Creacion: "+libros.get(i).creacion.get(Calendar.DAY_OF_MONTH)+"/"+(libros.get(i).creacion.get(Calendar.MONTH)+1)+"/"+libros.get(i).creacion.get(Calendar.YEAR)+"\nResumen: "+libros.get(i).resumen+"\n");
            }
        }
        if(!revistas.isEmpty()){
            System.out.println("Revista/s mas vendida/s:");
            for(int i=0;i<revistas.size();i++){
                System.out.println("ISSN: "+revistas.get(i).codigo+"\nNombre: "+revistas.get(i).getNombre()+"  Unidades: "+revistas.get(i).getStock()+"\nPrecio: "+revistas.get(i).getPrecio()+"  Subscripcion: "+revistas.get(i).getPrecioSubscripcion()+"  Ventas Totales: "+revistas.get(i).ventas+"  Fecha Creacion: "+revistas.get(i).creacion.get(Calendar.DAY_OF_MONTH)+"/"+(revistas.get(i).creacion.get(Calendar.MONTH)+1)+"/"+revistas.get(i).creacion.get(Calendar.YEAR)+"\nResumen: "+revistas.get(i).resumen+"\n");
            }
        }
        if(!periodicos.isEmpty()){
            System.out.println("Periodico/s mas vendido/s:");
            for(int i=0;i<periodicos.size();i++){
                System.out.println("ISSN: "+periodicos.get(i).codigo+"\nNombre: "+periodicos.get(i).getNombre()+"  Fecha: "+periodicos.get(i).getFecha().get(Calendar.YEAR)+"-"+(periodicos.get(i).getFecha().get(Calendar.MONTH)+1)+"-"+periodicos.get(i).getFecha().get(Calendar.DAY_OF_MONTH)+"\nUnidades: "+periodicos.get(i).getStock()+"  Precio: "+periodicos.get(i).getPrecio()+"  Subscripcion: "+periodicos.get(i).getPrecioSubscripcion()+"  Ventas Totales: "+periodicos.get(i).ventas+"  Fecha Creacion:"+periodicos.get(i).creacion.get(Calendar.YEAR)+"/"+(periodicos.get(i).creacion.get(Calendar.MONTH)+1)+"/"+periodicos.get(i).creacion.get(Calendar.DAY_OF_MONTH)+"\nResumen: "+periodicos.get(i).resumen+"\n");
            }
        }
    }
    
    //Métodos de la última entrega
    
    public void imprimirBestsellersCat(){
        int actualidad=0, ciencia=0, cienciaficcion=0, deportes=0, fantasia=0, local=0;
        
        for(int i=0;i<bdlibros.size();i++){
            for(int j=0;j<bdfantasia.size();j++){
                if(bdlibros.get(i).codigo.equals(bdfantasia.get(j).codigo)) fantasia = fantasia + bdlibros.get(i).ventas;
            }
        }
        for(int i=0;i<bdlibros.size();i++){
            for(int j=0;j<bdcienciaficcion.size();j++){
                if(bdlibros.get(i).codigo.equals(bdcienciaficcion.get(j).codigo)) cienciaficcion = cienciaficcion + bdlibros.get(i).ventas;
            }
        }
        for(int i=0;i<bdrevistas.size();i++){
            for(int j=0;j<bdactualidad.size();j++){
                if(bdlibros.get(i).codigo.equals(bdactualidad.get(j).codigo)) actualidad = actualidad + bdrevistas.get(i).ventas;
            }
        }
        for(int i=0;i<bdrevistas.size();i++){
            for(int j=0;j<bdciencia.size();j++){
                if(bdrevistas.get(i).codigo.equals(bdciencia.get(j).codigo)) ciencia = ciencia + bdrevistas.get(i).ventas;
            }
        }
        for(int i=0;i<bdperiodicos.size();i++){
            for(int j=0;j<bddeportes.size();j++){
                if(bdperiodicos.get(i).codigo.equals(bddeportes.get(j).codigo)) deportes = deportes + bdperiodicos.get(i).ventas;
            }
        }
        for(int i=0;i<bdperiodicos.size();i++){
            for(int j=0;j<bdlocales.size();j++){
                if(bdperiodicos.get(i).codigo.equals(bdlocales.get(j).codigo)) local = local + bdperiodicos.get(i).ventas;
            }
        }
        
            
        System.out.println("Subcategoria/s de Libro mas vendida/s:");
        if(fantasia>cienciaficcion) System.out.println("Fantasia con "+fantasia+" ventas");
        else if(fantasia<cienciaficcion) System.out.println("CienciaFiccion con "+cienciaficcion+" ventas");
        else if(fantasia==cienciaficcion) System.out.println("Fantasia con "+fantasia+" ventas\nCienciaFiccion con "+cienciaficcion+" ventas");
        System.out.println();
        System.out.println("Subcategoria/s de Revista mas vendida/s:");
        if(actualidad>ciencia) System.out.println("Actualidad con "+actualidad+" ventas");
        else if(actualidad<ciencia) System.out.println("Ciencia con "+ciencia+" ventas");
        else if(actualidad==ciencia) System.out.println("Actualidad con "+actualidad+" ventas\nCiencia con "+ciencia+" ventas");
        System.out.println();
        System.out.println("Subcategoria/s de Periodico mas vendida/s:");
        if(deportes>local) System.out.println("Deportes con "+deportes+" ventas");
        else if(deportes<local) System.out.println("Local con "+local+" ventas");
        else if(deportes==local) System.out.println("Deportes con "+deportes+" ventas\nLocal con "+local+" ventas");
    }
    public void imprimirCatGanancias(){
        double actualidad=0D, ciencia=0D, cienciaficcion=0D, deportes=0D, fantasia=0D, local=0D;
        
        for(int i=0;i<bdlibros.size();i++){
            for(int j=0;j<bdfantasia.size();j++){
                if(bdlibros.get(i).codigo.equals(bdfantasia.get(j).codigo)) fantasia = fantasia + (bdlibros.get(i).ventas*bdlibros.get(i).precio);
            }
        }
        for(int i=0;i<bdlibros.size();i++){
            for(int j=0;j<bdcienciaficcion.size();j++){
                if(bdlibros.get(i).codigo.equals(bdcienciaficcion.get(j).codigo)) cienciaficcion = cienciaficcion + (bdlibros.get(i).ventas*bdlibros.get(i).precio);
            }
        }
        for(int i=0;i<bdrevistas.size();i++){
            for(int j=0;j<bdactualidad.size();j++){
                if(bdlibros.get(i).codigo.equals(bdactualidad.get(j).codigo)) actualidad = actualidad + (bdrevistas.get(i).ventas*bdrevistas.get(i).precio);
            }
        }
        for(int i=0;i<bdrevistas.size();i++){
            for(int j=0;j<bdciencia.size();j++){
                if(bdrevistas.get(i).codigo.equals(bdciencia.get(j).codigo)) ciencia = ciencia + (bdrevistas.get(i).ventas*bdrevistas.get(i).precio);
            }
        }
        for(int i=0;i<bdperiodicos.size();i++){
            for(int j=0;j<bddeportes.size();j++){
                if(bdperiodicos.get(i).codigo.equals(bddeportes.get(j).codigo)) deportes = deportes + (bdperiodicos.get(i).ventas*bdperiodicos.get(i).precio);
            }
        }
        for(int i=0;i<bdperiodicos.size();i++){
            for(int j=0;j<bdlocales.size();j++){
                if(bdperiodicos.get(i).codigo.equals(bdlocales.get(j).codigo)) local = local + (bdperiodicos.get(i).ventas*bdperiodicos.get(i).precio);
            }
        }
        
            
        System.out.println("Subcategoria/s de Libro con mayores ganancias:");
        if(fantasia>cienciaficcion) System.out.println("Fantasia con "+fantasia+"€ de ganancias");
        else if(fantasia<cienciaficcion) System.out.println("CienciaFiccion con "+cienciaficcion+"€ de ganancias");
        else if(fantasia==cienciaficcion) System.out.println("Fantasia con "+fantasia+"€ de ganancias\nCienciaFiccion con "+cienciaficcion+"€ de ganancias");
        System.out.println();
        System.out.println("Subcategoria/s de Revista con mayores ganancias:");
        if(actualidad>ciencia) System.out.println("Actualidad con "+actualidad+"€ de ganancias");
        else if(actualidad<ciencia) System.out.println("Ciencia con "+ciencia+"€ de ganancias");
        else if(actualidad==ciencia) System.out.println("Actualidad con "+actualidad+"€ de ganancias\nCiencia con "+ciencia+"€ de ganancias");
        System.out.println();
        System.out.println("Subcategoria/s de Periodico con mayores ganancias:");
        if(deportes>local) System.out.println("Deportes con "+deportes+"€ de ganancias");
        else if(deportes<local) System.out.println("Local con "+local+"€ de ganancias");
        else if(deportes==local) System.out.println("Deportes con "+deportes+"€ de ganancias\nLocal con "+local+"€ de ganancias");
    }
}
