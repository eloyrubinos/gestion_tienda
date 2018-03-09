package proyecto.Libreria;

import Exceptions.RetryException;
import java.io.Serializable;

/**
 *
 * @author eloy.rubinos
 */
public class Libro extends Categoria implements Serializable{
    protected String autor;
    protected String editorial;
    protected String genero;
    protected int edicion;  
    
    public Libro(){
        super();
        autor = new String();
        editorial = new String();
        genero = new String();
        edicion = 0;
    }
    public Libro(String _codigo, String _nombre, int _stock, double _precio, String _resumen, String _autor, String _editorial, String _genero, int _edicion){
        super(_codigo, _nombre, _stock, _precio, _resumen);
        setAutor(_autor);
        setEditorial(_editorial);
        setGenero(_genero);
        setEdicion(_edicion);
    }
    
    public final String getAutor(){
        return autor;
    }
    public final String getEditorial(){
        return editorial;
    }
    public final String getGenero(){
        return genero;
    }
    public final int getEdicion(){
        return edicion;
    }
    
    public final void setAutor(String _autor){
        autor = _autor;
    }
    public final void setEditorial(String _editorial){
        editorial = _editorial;
    }
    public final void setGenero(String _genero){
        genero = _genero;
    }
    public final void setEdicion(int _edicion){
        try{
        if(_edicion>=1) edicion = _edicion;
        else throw new RetryException("No puede haber ediciones anteriores a la 1ª.");
        }catch(RetryException ex){  
          ex.printError();
          this.setEdicion((int) ex.retrydException());          
        }
    }  
    
    @Override
    public final void setCodigo(String _codigo){
        if(_codigo.length()==13) super.setCodigo(_codigo);
        else System.out.println("Longitud incorrecta");

    }
}