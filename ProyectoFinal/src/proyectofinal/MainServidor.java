
package proyectofinal;

import Servidor.Servidor;


public class MainServidor {
    
    public static void main(String[] args) {
        
        
        
        Servidor servidor = Servidor.getInstancia();
        servidor.arrancar_server();
    }
}
