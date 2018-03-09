/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Administracion;

import Exceptions.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import proyecto.Libreria.*;

/**
 *
 * @author eloy.rubinos
 */
public final class Cliente extends Usuario implements Serializable{
    protected ArrayList<String> carrito;
    protected Boolean premium;
    protected double saldo;
    protected ArrayList<Libro> historiall; //Historiales de compra
    protected ArrayList<Revista> historialr;
    protected ArrayList<Periodico> historialp;
    protected ArrayList<String> categorias; //Categorias preferidas por el cliente
    protected ArrayList<GregorianCalendar> fcompras;
    protected int accesos;
    protected double gastoTotal;
    
    public Cliente(){
        super();
        tarjeta = 0L;
        carrito = new ArrayList<>();
        premium = false;
        saldo = 0D;
        historiall = new ArrayList<>();
        historialr = new ArrayList<>();
        historialp = new ArrayList<>();
        categorias = new ArrayList<>();
        fcompras = new ArrayList();
        accesos = 0;
        gastoTotal = 0D;
    }
    public Cliente(String _dni, String _nombre, String _postal, String _email, String _usuario, String _contraseña, long _tarjeta){
        super(_dni, _nombre, _postal, _email, _usuario, _contraseña, _tarjeta);
        carrito = new ArrayList<>();
        premium = false;
        saldo = 0D;
        historiall = new ArrayList<>();
        historialr = new ArrayList<>();
        historialp = new ArrayList<>();
        categorias = new ArrayList<>();
        fcompras = new ArrayList();
        accesos = 0;
        gastoTotal = 0D;
    }
         
    public ArrayList<String> getCarrito(){
        return carrito;
    }
    
    @Override
    public long getTarjeta(){
        return super.getTarjeta();
    }
    public Boolean isPremium(){
        return premium;
    }
    public double getSaldo(){
        return saldo;
    }
    public ArrayList<Libro> getLibros(){
        return historiall;
    }
    public ArrayList<Revista> getRevistas(){
        return historialr;
    }
    public ArrayList<Periodico> getPeriodicos(){
        return historialp;
    }
    public ArrayList<String> getCategorias(){
        return categorias;
    }
    public ArrayList<GregorianCalendar> getFcompras(){
        return fcompras;
    }
    public int getAccesos(){
        return accesos;
    }
    public double getGastoTotal(){
        return gastoTotal;
    }
    
    public void setCarrito(ArrayList<String> _carrito){
        try{
        if(carrito.isEmpty()){
            carrito.addAll(_carrito);
        }
        else{
            System.out.println("El carrito contiene elementos. Termina la compra o resetealo antes de sobreescribirlo.");
        }
        }
        catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    @Override
    public void setTarjeta(long _tarjeta){
        try{
        String t;
        t = Long.toString(_tarjeta);
        if(t.length()==16) super.setTarjeta(_tarjeta);
        else throw new RetryException("La tarjeta debe tener 16 dígitos");
        }
        catch(RetryException ex){  
          ex.printError();
          this.setTarjeta(ex.retryException());          
        }
    }
    public void setPremium(int _premium){
        if(_premium==0) premium = false;
        else if(_premium==1) premium = true;
        else System.out.println("Valor no válido.");
    }
    public void setSaldo(double _saldo){
        try{
        if(_saldo>=0) saldo = _saldo;
        else throw new RetryException("No puede haber saldos negativos.");
        }catch(RetryException ex){  
          ex.printError();
          this.setSaldo(ex.retrydException());          
        }
    }
    public void setCategorias(ArrayList<String> _categorias){
        try{
        int i,j,cont=0;
        for(i=0;i<_categorias.size();i++){
            for(j=0;j<_categorias.size();j++){                
                if(_categorias.get(i).equalsIgnoreCase(_categorias.get(j)) && i!=j) cont++;
            }
        }
        if(cont!=0) System.out.println("No puede haber categorias repetidas");
        else categorias.clear(); categorias.addAll(_categorias);
        }
        catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void setFcompras(ArrayList<GregorianCalendar> _fcompras){
        try{
        GregorianCalendar g = new GregorianCalendar();
        int cont=0;
        
        for(int i=0;i<_fcompras.size();i++){
            if(_fcompras.get(i).after(g)) cont++;
        }
        
        if(cont>0) System.out.println("Hay fechas invalidas en el array");
        else fcompras.clear(); fcompras.addAll(_fcompras);
        }
        catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void setAccesos(int _accesos){
        try{
        if(_accesos>=0) accesos = _accesos;
        else throw new RetryException("No puede haber accesos negativos.");
        }catch(RetryException ex){  
          ex.printError();
          this.setAccesos((int) ex.retryException());          
        }
    }
    public void setGastoTotal(double gt){
        try{
        if(gt>=0) gastoTotal = gt;
        else throw new RetryException("No puede haber gasto total negativo.");
        }catch(RetryException ex){  
          ex.printError();
          this.setGastoTotal(ex.retrydException());          
        }
    }
    
    public void addCarrito(String _codigo){
        try{
        carrito.add(_codigo);
        }
        catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void resetCarrito(){
        carrito.clear();
    }
    public final void removeCarrito(String _codigo){
        try{
        carrito.remove(_codigo);
        _codigo = _codigo+"s";
        carrito.remove(_codigo);
        }
        catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    
    public void addHistorial(Libro l){
        try{
        historiall.add(l);
        }
        catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void addHistorial(Revista r){
        try{
        historialr.add(r);
        }
        catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public void addHistorial(Periodico p){
        try{
        historialp.add(p);
        }
        catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    
    public void Gastar(double precio){
        gastoTotal += precio;
        
        GregorianCalendar g = new GregorianCalendar();
        fcompras.add(g);
    }
    
    public void Acceder(){
        accesos++;
    }
}
