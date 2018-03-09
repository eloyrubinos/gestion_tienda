/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Libreria;

import Exceptions.RetryException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author eloy.rubinos
 */
public abstract class Categoria implements Serializable, Comparable<Categoria> {
    protected String codigo;
    protected String nombre;
    protected String resumen;
    protected int stock;
    protected double precio;
    protected int ventas;
    protected ArrayList<GregorianCalendar> fventas;
    protected GregorianCalendar creacion;
    
    public Categoria(){
        codigo = new String();
        nombre = new String();
        resumen = new String();
        stock = 0;
        precio = 0D;
        ventas = 0;
        fventas = new ArrayList();
        creacion = new GregorianCalendar();
    }
    public Categoria(String _codigo, String _nombre, int _stock, double _precio, String _resumen){
        setCodigo(_codigo);
        setNombre(_nombre);
        setStock(_stock);
        setPrecio(_precio);
        setResumen(_resumen);
        ventas = 0;
        fventas = new ArrayList();
        creacion = new GregorianCalendar();
    }
    
    public final String getCodigo(){
        return codigo;
    }
    public final String getNombre(){
        return nombre;
    }
    public final String getResumen(){
        return resumen;
    }
    public final int getStock(){
        return stock;
    }
    public final double getPrecio(){
        return precio;
    }
    public final int getVentas(){
        return ventas;
    }
    public final ArrayList<GregorianCalendar> getFechaVentas(){
        return fventas;
    }
    public final GregorianCalendar getCreacion(){
        return creacion;
    }
    
    public void setCodigo(String _codigo){
        codigo = _codigo;
    }
    public final void setNombre(String _nombre){
        nombre = _nombre;
    }
    public final void setResumen(String _resumen){
        resumen = _resumen;
    }
    public final void setStock(int _stock){
        try{
        if(_stock>=0) stock = _stock;
        else throw new RetryException("No puede haber stock negativo.");
        }catch(RetryException ex){  
          ex.printError();
          this.setStock((int) ex.retryException());          
        }
    }
    public final void setPrecio(double _precio){
        try{
        if(_precio>=0) precio = _precio;
        else throw new RetryException("No puede haber precios negativos.");
        }catch(RetryException ex){  
          ex.printError();
          this.setPrecio(ex.retrydException());          
        }
    }
    public final void setVentas(int _ventas){
        try{
        if(_ventas>=0) ventas = _ventas;
        else throw new RetryException("No puede haber ventas negativas.");
        }catch(RetryException ex){  
          ex.printError();
          this.setVentas((int) ex.retryException());          
        }
    }
    public final void setFechaVentas(ArrayList<GregorianCalendar> _fventas){
        try{
        int cont=0;
        GregorianCalendar g = new GregorianCalendar();
        for(int i=0;i<_fventas.size();i++){
            if(_fventas.get(i).after(g)) cont++;
        }
        if(cont==0) fventas = new ArrayList(_fventas);
        else System.out.println("El array de fechas contiene fechas invalidas");
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public final void setCreacion(GregorianCalendar _fecha){
        try{
        GregorianCalendar g = new GregorianCalendar();
        if(_fecha.after(g)) System.out.println("Esa fecha no es valida");
        else creacion = (GregorianCalendar) _fecha.clone();
        }catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    
    public final void Vender(){
        stock = stock-1;
        ventas++;
    }
    public final void Reembolsar(){
        stock = stock+1;
        ventas--;
    }
    public final void Venta(){
        GregorianCalendar g = new GregorianCalendar();
        fventas.add(g);
    }
    
    @Override
    public int compareTo(Categoria p) {
        return getNombre().compareTo(p.getNombre());
    }
}
