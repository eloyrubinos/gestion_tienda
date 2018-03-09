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
public final class Actualidad extends Revista implements Serializable{
    
    public Actualidad(){
        super();
    }
    public Actualidad(String _codigo, String _nombre, int _stock, double _precio, String _resumen, double _precio2){
        super(_codigo, _nombre, _stock, _precio, _resumen, _precio2);
    }
}
