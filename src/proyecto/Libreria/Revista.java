/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Libreria;

import Exceptions.RetryException;
import java.io.Serializable;
import java.util.ArrayList;
import proyecto.Administracion.Cliente;

/**
 *
 * @author eloy.rubinos
 */
public class Revista extends Categoria implements Serializable{
    protected ArrayList<Cliente> subscriptores;
    protected double precioSubscripcion;
    
    public Revista(){
        super();
        precioSubscripcion = 0D;
        subscriptores = new ArrayList<>();
    }
    public Revista(String _codigo, String _nombre, int _stock, double _precio, String _resumen, double _precio2){
        super(_codigo, _nombre, _stock, _precio, _resumen);
        setPrecioSubscripcion(_precio2);
        subscriptores = new ArrayList();
    }
    
    public final ArrayList<Cliente> getSubscriptores(){
        return subscriptores;
    }
    public final double getPrecioSubscripcion(){
        return precioSubscripcion;
    }
    
    public final void setSubscriptores(ArrayList<Cliente> _subscriptores){
        try{
        int i, j, equivalencias=0;
        for(i=0;i<_subscriptores.size();i++){
            for(j=0;j<_subscriptores.size();j++){                
                if(_subscriptores.get(i).getDni().equals(_subscriptores.get(j).getDni()) && i!=j) equivalencias++;
            }
        }
        if(equivalencias==0) {subscriptores.clear(); subscriptores.addAll(_subscriptores);}
        else System.out.println("No puede haber subscriptores repetidos.");    
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public final void setPrecioSubscripcion(double _precio){
        try{
        if(_precio>=0) precioSubscripcion = _precio;
        else throw new RetryException("No puede haber precios negativos.");
        }catch(RetryException ex){  
          ex.printError();
          this.setPrecioSubscripcion(ex.retrydException());          
        }
    }
    
    public final void subscribir(Cliente c){
        try{
        int i, cont=0;
        for(i=0;i<subscriptores.size();i++){
            if(subscriptores.get(i).getDni().equals(c.getDni())) cont++;
        }
        if(cont!=0) System.out.println("Este cliente ya está subscrito");
        else subscriptores.add(c);
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public final void cancelar(Cliente c){
        subscriptores.remove(c);
    }
    
    @Override
    public final void setCodigo(String _codigo){
        if(_codigo.length()==9) super.setCodigo(_codigo);
        else System.out.println("Longitud incorrecta");

    }
}
