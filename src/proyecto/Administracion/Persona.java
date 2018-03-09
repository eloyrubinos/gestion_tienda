/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Administracion;

import java.io.Serializable;

/**
 *
 * @author Eloy
 */
public abstract class Persona implements Serializable{
    protected String dni;
    protected String nombre;
    protected String postal;
    protected String email;
    
    public Persona(){
        dni = new String();
        nombre = new String();
        postal = new String();
        email = new String();
    }
    public Persona(String _dni, String _nombre, String _postal, String _email){
        setDni(_dni);
        setNombre(_nombre);
        setDireccion(_postal);
        setEmail(_email);
    }
    
    public final String getDni(){
        return dni;
    }
    public final String getNombre(){
        return nombre;
    }
    public final String getDireccion(){
        return postal;
    }
    public final String getEmail(){
        return email;
    }
    
    public final void setDni(String _dni){
        try{
        if(_dni.length()==9) dni = _dni;
        else System.out.println("Formato de DNI incorrecto.");
        }
        catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public final void setNombre(String _nombre){
        try{
        nombre = _nombre;
        }
        catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public final void setDireccion(String _direccion){
        try{
        postal = _direccion;
        }
        catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public final void setEmail(String _email){
        try{
        email = _email;
        }
        catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    
    public abstract String getUsuario();
    public abstract void setUsuario(String _usuario);
}
