/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.util.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Servidor {
    
    private static Servidor inst;
    
    public static List<DataOutputStream> clientes = new ArrayList<>();
    public static List<String> nombresClientes = new ArrayList<>();
    
    private Servidor() {}
    
    //para obtener la unica instancia
    public static Servidor getInstancia() {
    
        if(inst == null) {
            
            inst = new Servidor();
        }
        return inst;
    }
    
  public void arrancar_server() {

        try {

            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println(" === Servidor iniciado === ");
            System.out.println("PUERTO 5000");

            while(true){

                Socket cliente = serverSocket.accept(); // se queda esperando un cliente

                System.out.println("Cliente conectado");

                ClienteHilo handler = new ClienteHilo(cliente,clientes);
                Thread hilo = new Thread(handler);

                hilo.start();
            }

        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
  
}
    

