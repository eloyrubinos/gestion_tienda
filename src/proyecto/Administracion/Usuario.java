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
public abstract class Usuario extends Persona implements Serializable{
    protected String usuario;
    protected String contraseña;
    protected long tarjeta;
    
    public Usuario(){
        super();
        usuario = new String();
        contraseña = new String();
        tarjeta = 0L;
    }
    public Usuario(String _dni, String _nombre, String _postal, String _email, String _usuario, String _contraseña, long _tarjeta){
        super(_dni, _nombre, _postal, _email);
        setUsuario(_usuario);
        setContraseña(_contraseña);
        setTarjeta(_tarjeta);
    }
    
    @Override
    public final String getUsuario(){
        return usuario;
    }
    public final String getContraseña(){
        return contraseña;
    }
    
    @Override
    public final void setUsuario(String _usuario){
        try{
        usuario = _usuario;
        }
        catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    public final void setContraseña(String _contraseña){
        try{
        contraseña = _contraseña;
        }
        catch(NullPointerException exception){
            System.out.println("El input no puede ser null.");
        }
    }
    
    public long getTarjeta(){
        return tarjeta;
    }
    public void setTarjeta(long _tarjeta){
        tarjeta = _tarjeta;
    }
}
