
package Cliente.Network;

import Cliente.Controlador.Controlador;

import Cliente.Modelo.Modelo;
import Cliente.Vista.Vista;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cliente {

    private Socket socket;
    private DataOutputStream salida;
    
    public void empezar(String nombre,Vista vista) {

        try {

            socket = new Socket("localhost",5000);
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());

            salida.writeUTF(nombre);

            ClienteR receptor = new ClienteR(entrada,vista);
            Thread hilo = new Thread(receptor);
            hilo.start();
            
            System.out.println("Conectado como :" + nombre);
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public void enviarMensaje(String mensaje){

        try {
            salida.writeUTF(mensaje);

        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
