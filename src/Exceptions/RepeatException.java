/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Eloy
 */
public class RepeatException extends InputException{
    String output = "No puede haber elementos repetidos";
    
    public RepeatException(){
        super();
    }
    public RepeatException(String _mensaje){
        super(_mensaje);
    }
    
    public void printException(){
        System.out.println(output);
    }
}
