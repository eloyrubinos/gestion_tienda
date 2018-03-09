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
public final class CienciaFiccion extends Libro implements Serializable{
    
    public CienciaFiccion(){
        super();
    }
    public CienciaFiccion(String _codigo, String _nombre, int _stock, double _precio, String _resumen, String _autor, String _editorial, String _genero, int _edicion){
        super(_codigo, _nombre, _stock, _precio, _resumen, _autor, _editorial, _genero, _edicion);
    }

}
