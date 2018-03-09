/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Libreria;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 *
 * @author Eloy
 */
public final class Deportes extends Periodico implements Serializable{
    
    public Deportes(){
        super();
    }
    public Deportes(String _codigo, String _nombre, int _stock, double _precio, String _resumen, GregorianCalendar _fecha, double _precio2){
        super(_codigo, _nombre, _stock, _precio, _resumen, _fecha, _precio2);
    }
}
