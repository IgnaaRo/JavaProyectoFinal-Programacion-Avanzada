/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import static Servidor.Servidor.clientes;
import static Servidor.Servidor.nombresClientes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClienteHilo implements Runnable {

    private Socket socket;
    private String nombreCliente;
    private List<DataOutputStream> clientes;

    
    public ClienteHilo(Socket socket,List<DataOutputStream> clientes) {
        
        this.socket = socket;
        this.clientes = clientes;
    }
    
    

    @Override
    public void run() {
        
        DataOutputStream salida = null;
        
        try {
            
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());
           
            
            nombreCliente = entrada.readUTF();
            String nombreBase = nombreCliente;
            
            int t = 2;
            while(nombresClientes.contains(nombreCliente)) {
                
                nombreCliente = nombreBase + t;
                t++;
            }
            
            
            System.out.println(nombreCliente + " se conecto");
            
            

            // Mandar al nuevo cliente la lista de los que ya estaban
            for(String u : nombresClientes) {
                salida.writeUTF("NUEVO_USUARIO:" + u);
            }

            // guardar el nombre anres de avisar a los demas
            nombresClientes.add(nombreCliente);

            // agregar a la lista de salidas
            clientes.add(salida);

            // avisar a todos los demas que llego uno nuevo
            for(DataOutputStream k : clientes) {
                if(k != salida) {
                    k.writeUTF("NUEVO_USUARIO:" + nombreCliente);
                }
                
            }

            
            while(true) {
                
                String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
                
                String mensaje = entrada.readUTF();
                System.out.println(nombreCliente + ": " + mensaje);
                
                if(mensaje.startsWith("PRIVADO:")) {
                    
                    // formato: PRIVADO:destinatario:texto
                    String[] partes = mensaje.split(":", 3);

                    String destinatario = partes[1];
                    String texto = partes[2];

                    // Buscar al destinatario y mandarle solo a él
                    int index = nombresClientes.indexOf(destinatario);

                    if(index != -1) {
                        clientes.get(index).writeUTF( "[" + hora + "] " + nombreCliente + " (privado): " + texto );
                    }

                } else {
                    // mensaje grupal, reenviar a todos
                    for(DataOutputStream k : clientes) {
                        
                        if(k != salida) {
                            k.writeUTF("[" + hora + "] " + nombreCliente + ": " + mensaje);
                        }
                        
                    }
                    
                }
                
            }
            
        } catch(Exception e) {
            
            System.out.println(nombreCliente + " se desconectó");
            
                clientes.remove(salida);
                nombresClientes.remove(nombreCliente);

                
            try {
                for(DataOutputStream k : clientes) {
                    k.writeUTF("USUARIO_DESCONECTADO:" + nombreCliente);
                }
            } catch (IOException ex) {
               ex.printStackTrace();
            }
               
        }
         
         
         
         
    }
}

