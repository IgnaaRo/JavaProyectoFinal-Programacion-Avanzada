
package Cliente.Modelo;
// clase para funciones extras,autecnticaciones ,etc

public class Utils {
    
    public boolean Vacio(String nombre){
        
        if(nombre.isEmpty()){
            return true;
        }
        return false;
    }
    
    public boolean validarNombre(String nombre) {
        
        return nombre.matches("^[a-zA-Z0-9]{3,12}$");
    }
    
    public boolean validarCorreo(String correo) {
        
        return correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
    
}
