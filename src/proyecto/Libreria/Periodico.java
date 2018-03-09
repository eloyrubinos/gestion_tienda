/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Libreria;

import Exceptions.RetryException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import proyecto.Administracion.Cliente;

/**
 *
 * @author eloy.rubinos
 */
public class Periodico extends Categoria implements Serializable{
    protected ArrayList<Cliente> subscriptores;
    protected GregorianCalendar fecha;
    protected double precioSubscripcion;
    
    public Periodico(){
        super();
        subscriptores = new ArrayList<>();
        fecha = null;
        precioSubscripcion = 0D;
    }
    public Periodico(String _codigo, String _nombre, int _stock, double _precio, String _resumen, GregorianCalendar _fecha, double _precio2){
        super(_codigo, _nombre, _stock, _precio, _resumen);
        subscriptores = new ArrayList<>();
        setFecha(_fecha);
        setPrecioSubscripcion(_precio2);
    }
        
    public final ArrayList<Cliente> getSubscriptores(){
        return subscriptores;
    }
    public final GregorianCalendar getFecha(){
        return fecha;
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
    public final void setFecha(GregorianCalendar _fecha){
        try{
        GregorianCalendar c1 = new GregorianCalendar();
        if(_fecha.after(c1)) System.out.println("La fecha es incorrecta.");
        else fecha = new GregorianCalendar(_fecha.get(Calendar.YEAR), _fecha.get(Calendar.MONTH), _fecha.get(Calendar.DAY_OF_MONTH));
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
