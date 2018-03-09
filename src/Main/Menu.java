/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Interfaces.ILibreria;
import java.util.ArrayList;
import proyecto.Administracion.Cliente;
import proyecto.Administracion.Vendedor;
import proyecto.Libreria.Libro;
import proyecto.Libreria.Periodico;
import proyecto.Libreria.Revista;

/**
 *
 * @author Eloy
 */
public class Menu {
    protected ILibreria milib;
    
    Menu(ILibreria a){
        milib = (ILibreria) a;
    }
    
    public void iniciarMenu(){
        int opcion;
        
        do{opcion=milib.menuInicial();
        switch(opcion){
            case 1: //'paso atras'
                break;
            // 10-Inicios de sesion y subsecuentes || 01-Cliente, 02-Vendedor 
            case 11:
                Cliente c;
                if((c=milib.iniciarSesionCliente())==null) break;
                else{
                    int estado = 0;
                    do{opcion=milib.menuCliente(estado);
                    switch(opcion){
                        case 1:  //Caso de 'paso atrás'
                            estado = 0;
                            break;
                        case 2:
                            estado = 200;
                            break;
                    // 100-Catalogos || 001-Libros, 002-Revistas, 003-Periodicos
                        case 101:
                            ArrayList<Libro> l = milib.getLibros();
                            milib.imprimirLibros(milib.ordenarLibros(l, c), "n");
                            estado=100;
                            break;                            
                        case 102: 
                            ArrayList<Revista> r = milib.getRevistas();
                            milib.imprimirRevistas(milib.ordenarRevistas(r, c), "n");
                            estado=100;
                            break;                            
                        case 103:
                            ArrayList<Periodico> p = milib.getPeriodicos();
                            milib.imprimirPeriodicos(milib.ordenarPeriodicos(p, c), "n");
                            estado=100;
                            break;
                    // 200-Comprar || 010-Libros, 020-Revistas, 030-Periodicos || 001-Por nombre, 002-Por genero, 003-Por claves
                    // 240-Carrito || 001-Ver, 002-Quitar, 003-Finalizar, 004-Resetear        
                        case 211:
                            milib.comprarLibroNombre(c);
                            estado=210;
                            break;
                        case 212:
                            milib.comprarLibroGenero(c);
                            estado=210;
                            break;
                        case 213:
                            milib.comprarLibroAutor(c);
                            estado=210;
                            break;
                        case 214:
                            milib.comprarLibroClave(c);
                            estado=210;
                            break;
                            
                        case 221:
                            milib.comprarRevistaNombre(c);
                            estado=220;
                            break;
                        case 222:
                            milib.comprarRevistaGenero(c);
                            estado=220;
                            break;
                        case 223:
                            milib.comprarRevistaClave(c);
                            estado=220;
                            break;
                            
                        case 231:
                            milib.comprarPeriodicoNombre(c);
                            estado=230;
                            break;
                        case 232:
                            milib.comprarPeriodicoGenero(c);
                            estado=230;
                            break;
                        case 233:
                            milib.comprarPeriodicoClave(c);
                            estado=230;
                            break;
                            
                        case 241:
                            milib.carritoVer(c);
                            estado=240;
                            break;
                        case 242:
                            milib.carritoEliminar(c);
                            estado=240;
                            break;
                        case 243:
                            milib.carritoFinalizar(c);
                            estado=240;
                            break;
                        case 244:
                            milib.carritoReset(c);
                            estado=240;
                            break;
                    //300-Historiales de compras 
                        case 300:
                            System.out.println("Libros:\n----------------");
                            milib.imprimirLibros(c.getLibros(), "h");
                            System.out.println("Revistas:\n----------------");
                            milib.imprimirRevistas(c.getRevistas(), "h1");
                            System.out.println("Periodicos:\n----------------");
                            milib.imprimirPeriodicos(c.getPeriodicos(), "h1");
                            break;
                    //400-Administracion || 001-Añadir saldo, 002-Premium, 003-!Premium, 004-Borrar historiales, 005-Borrar cuenta        
                        case 401:
                            milib.adminSaldo(c);
                            estado=400;
                            break;
                        case 402:
//Los criterios para poder ser premium se implementaran con los vendedores, de momento no hay restriccion para serlo/dejar de serlo.
                            milib.adminPremium(c, true);
                            estado=400;
                            break;
                        case 403:
                            milib.adminPremium(c, false);
                            estado=400;
                            break;
                        case 404:
                            milib.adminCleanH(c);
                            estado=400;
                            break;
                        case 405:                            
                            opcion = milib.adminBorrarCliente(c);
                            estado=400;
                            break;
                    }
                    }while(opcion!=0);
                    opcion = 1;
                    }
                break; //Fin case 11
            case 12:
                Vendedor v;
                if((v=milib.iniciarSesionVendedor())==null) break;
                else{
                    ArrayList<Cliente> clientes = milib.getClientes();
                    milib.controlStock();
                    int estado = 0;
                    do{opcion=milib.menuVendedor(estado);
                    switch(opcion){
                        case 1:
                            estado = 0;
                            break;
                        case 2:
                            estado = 100;
                            break;
                        case 3:
                            estado = 200;
                            break;
                        case 4:
                            estado = 300;
                            break;
                     // 100-Catalogos || 010-Libros, 020-Revistas, 030-Periodicos || 001-Todos, 002-Por Id, 003-Por Creacion  
                        case 111:
                            ArrayList<Libro> l = milib.getLibros();
                            milib.imprimirLibros(milib.ordenarLibros(l), "v");
                            estado = 110;
                            break;
                        case 112:
                            milib.consultarLibroId();
                            estado = 110;
                            break;
                        case 113:
                            milib.consultarLibroC();
                            estado = 110;
                            break;
                        case 121:
                            ArrayList<Revista> r = milib.getRevistas();
                            milib.imprimirRevistas(milib.ordenarRevistas(r), "v");
                            estado = 120;
                            break;
                        case 122:
                            milib.consultarRevistaId();
                            estado = 120;
                            break;
                        case 123:
                            milib.consultarRevistaC();
                            estado = 120;
                            break;
                        case 131:
                            ArrayList<Periodico> p = milib.getPeriodicos();
                            milib.imprimirPeriodicos(milib.ordenarPeriodicos(p), "v");
                            estado = 130;
                            break;
                        case 132:
                            milib.consultarPeriodicoId();
                            estado = 130;
                            break;
                        case 133:
                            milib.consultarPeriodicoC();
                            estado = 130;
                            break;
                     // 200-Gestion de Productos || 010-Introducir, 020-Modificar, 030-Anular || 001-Libro, 002-Revista, 003-Periodico      
                        case 211:
                            milib.crearLibro();
                            estado = 210;
                            break;
                        case 212:
                            milib.crearRevista();
                            estado = 210;
                            break;
                        case 213:
                            milib.crearPeriodico();
                            estado = 210;
                            break;
                        case 221:
                            milib.modificarLibro();
                            estado = 220;
                            break;
                        case 222:
                            milib.modificarRevista();
                            estado = 220;
                            break;
                        case 223:
                            milib.modificarPeriodico();
                            estado = 220;
                            break;
                        case 231:
                            milib.eliminarLibro();
                            estado = 230;
                            break;
                        case 232:
                            milib.eliminarRevista();
                            estado = 230;
                            break;
                        case 233:
                            milib.eliminarPeriodico();
                            estado = 230;
                            break;
                     // 300-Gestion de Clientes || 010-Todos, 020-Por Nombre, 030-Consumidores, 040-Sin Compras || 001-Personal, 002-Comercial, 003-Todo   
                        case 311:                           
                            milib.imprimirClientes(clientes, "p");
                            estado = 310;
                            break;
                        case 312:
                            milib.imprimirClientes(clientes, "c");
                            estado = 310;
                            break;
                        case 313:
                            milib.imprimirClientes(clientes, "t");
                            estado = 310;
                            break;
                        case 321:
                            milib.imprimirCliente("p");
                            estado = 320;
                            break;
                        case 322:
                            milib.imprimirCliente("c");
                            estado = 320;
                            break;
                        case 323:
                            milib.imprimirCliente("t");
                            estado = 320;
                            break;
                        case 330:
                            milib.imprimirConsumidores();
                            estado = 300;
                            break;
                        case 340:
                            milib.imprimirInactivos();
                            estado = 300;
                            break;
                     // 400-Gestion de Ventas || 001-Por Codigo, 002-Por Periodo, 003-+Vendidos, 004-Inactivos     
                        case 401:
                            milib.imprimirProducto();
                            estado = 400;
                            break;
                        case 402:
                            milib.imprimirProductoPeriodo("si");
                            estado = 400;
                            break;
                        case 403:
                            milib.imprimirBestsellers();
                            estado = 400;
                            break;
                        case 404:
                            milib.imprimirProductoPeriodo("no");
                            estado = 400;
                            break;
                    }
                    }while(opcion!=0);
                    opcion = 1;
                }
                break; //Fin case 12
            // 20-Creacion de usuario || 01-Cliente, 02-Vendedor    
            case 21:
                milib.crearCliente();
                break;
            case 22:
                milib.crearVendedor();
                break;
            // 30-Catalogos no ordenados || 01-Libros, 02-Revistas, 03-Periodicos    
            case 31:
                milib.imprimirLibros(milib.ordenarLibros(milib.getLibros()), "n");
                break;
            case 32:
                milib.imprimirRevistas(milib.ordenarRevistas(milib.getRevistas()), "n");
                break;
            case 33:
                milib.imprimirPeriodicos(milib.ordenarPeriodicos(milib.getPeriodicos()), "n");
                break;
            // Métodos nuevos (de uso de clases)    
            case 40:
                milib.imprimirBestsellersCat();
                break;
            case 50:
                milib.imprimirCatGanancias();
                break;
                }
        }while(opcion!=0);
    }
}
