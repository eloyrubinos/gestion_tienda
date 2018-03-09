/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.ArrayList;
import proyecto.Administracion.*;

/**
 *
 * @author Eloy
 */
public interface Tienda {
    
    int menuInicial();
    int menuCliente(int estado);
    int menuVendedor(int estado);
    
    Cliente iniciarSesionCliente();
    Vendedor iniciarSesionVendedor();
    
    void crearCliente();
    void crearVendedor();
    
    ArrayList<Cliente> getClientes();
    void AltaCliente(Cliente c);
    void BajaCliente(String _dni);
    void BajaCliente(Cliente c);
    
    ArrayList<Vendedor> getVendedores();
    void AltaVendedor(Vendedor v);
    void BajaVendedor(String _dni);
    void BajaVendedor(Vendedor v);
    
    boolean isCliente(Cliente c);
    boolean isVendedor(Vendedor v);
    
    void controlStock();
    
    void imprimirClientes(ArrayList<Cliente> clientes, String tipo);
    void imprimirCliente(String tipo);
    void imprimirConsumidores();
    void imprimirInactivos();
    
    void imprimirProducto();
    void imprimirProductoPeriodo(String tipo);
    void imprimirBestsellers();
}
