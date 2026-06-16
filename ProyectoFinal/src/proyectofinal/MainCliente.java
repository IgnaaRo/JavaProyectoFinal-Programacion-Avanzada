
package proyectofinal;

import Cliente.Controlador.Controlador;
import Cliente.Modelo.Modelo;
import Cliente.Network.Cliente;
import Cliente.Vista.Login;
import java.util.*;

public class MainCliente {
    
    public static void main(String[] args) {
        
        Cliente cliente = new Cliente();
        
        Modelo modelo = new Modelo();
        Login login = new Login();
        
        Controlador controlador = new Controlador(modelo,login,cliente);

        
        
     
    }
}
