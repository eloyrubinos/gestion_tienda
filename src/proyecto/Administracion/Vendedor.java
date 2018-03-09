/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Administracion;

import Exceptions.InputException;
import Exceptions.RetryException;
import java.io.Serializable;

/**
 *
 * @author eloy.rubinos
 */
public final class Vendedor extends Usuario implements Serializable{
    protected int contacto;
    protected double sueldo;
    
    public Vendedor(){
        super();
        contacto = 0;
        sueldo = 0D;
    }
    public Vendedor(String _dni, String _nombre, String _postal, String _email, String _usuario, String _contraseña, long _tarjeta, int _contacto, double _sueldo){
        super(_dni, _nombre, _postal, _email, _usuario, _contraseña, _tarjeta);
        setTelefono(_contacto);
        setSueldo(_sueldo);
    }
    
    @Override
    public long getTarjeta(){
        return super.getTarjeta();
    }
    public int getTelefono(){
        return contacto;
    }
    public double getSueldo(){
        return sueldo;
    }
    
    @Override
    public void setTarjeta(long _tarjeta){
        try{
        String t;
        t = Long.toString(_tarjeta);
        if(t.length()==10) super.setTarjeta(_tarjeta);
        else throw new RetryException("La tarjeta debe tener 10 dígitos");
        }catch(RetryException ex){  
          ex.printError();
          this.setTarjeta(ex.retryException());          
        }
    }
    public void setTelefono(int _telefono){
        try{
        String t;
        t = Integer.toString(_telefono);
        if(t.length()==9) contacto = _telefono;
        else throw new RetryException("El telefono debe tener 9 dígitos");
        }catch(RetryException ex){  
          ex.printError();
          this.setTelefono((int) ex.retryException());          
        }
    }
    public void setSueldo(double _sueldo){
        try{
        if(_sueldo>=0) sueldo = _sueldo;
        else throw new RetryException("No puede haber sueldos negativos.");
        }catch(RetryException ex){  
          ex.printError();
          this.setSueldo(ex.retrydException());          
        }
    }
}
