/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Libreria;

import java.io.Serializable;

/**
 *
 * @author Eloy
 */
public final class Ciencia extends Revista implements Serializable{
    
    public Ciencia(){
        super();
    }
    public Ciencia(String _codigo, String _nombre, int _stock, double _precio, String _resumen, double _precio2){
        super(_codigo, _nombre, _stock, _precio, _resumen, _precio2);
    }
}
