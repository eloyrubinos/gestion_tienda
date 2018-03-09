/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import java.util.Scanner;

/**
 *
 * @author Eloy
 */
public class RetryException extends InputException{
    
    public RetryException(){
        super();
    }
    public RetryException(String _mensaje){
        super(_mensaje);
    }
    
    public long retryException(){
        Scanner scani = new Scanner(System.in);
        long t;
        
        System.out.println("Introduzca un valor valido:");
        t = scani.nextLong();
        
        return t;
    } //con long
    public double retrydException(){
        Scanner scani = new Scanner(System.in);
        double t;
        
        System.out.println("Introduzca un valor valido:");
        t = scani.nextDouble();
        
        return t;
    } //con double
}
