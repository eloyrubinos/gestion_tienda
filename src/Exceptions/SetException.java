/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Eloy
 */
public class SetException extends InputException{
    
    public SetException(){
        super();
    }
    public SetException(String _mensaje){
        super(_mensaje);
    }
    
    public long numeroSet(){
        return 0L;
    }
    public double decimalSet(){
        return 0D;
    }
    public String cadenaSet(){
        System.out.println("Se ha usado un valor predefinido. Asegurese de modificarlo.");
        return "ERROR";
    }
}
