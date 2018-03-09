/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Eloy
 */
public class InputException extends InputMismatchException {
    String mensaje;
    
    public InputException(){
        mensaje = new String();
    }
    public InputException(String _mensaje){
        mensaje = _mensaje;
    }
    
    public void printError(){
        System.out.println(mensaje);
    }
    
    
}
