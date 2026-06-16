/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.Network;

import Cliente.Vista.Vista;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClienteR implements Runnable {
    
    private DataInputStream entrada;
    private Vista vista;
    
    public ClienteR(DataInputStream entrada,Vista vista) {
        this.entrada = entrada;
        this.vista = vista;
    }
    
    @Override
    public void run() {
        try {
            while(true) {
                
                String mensaje = entrada.readUTF();

                if(mensaje.startsWith("NUEVO_USUARIO:")) {
                    
                    String nombre = mensaje.split(":")[1];
                    
                    this.vista.modeloLista.addElement(nombre);
                    this.vista.actualizarContador();

                } else if(mensaje.startsWith("USUARIO_DESCONECTADO:")) {
                    String nombre = mensaje.split(":")[1];
                    
                    this.vista.modeloLista.removeElement(nombre);
                    this.vista.actualizarContador();

                } else if(mensaje.contains("(privado):")) {
                    
                    String remitente = mensaje.split(" ")[1];
                    
                    this.vista.agregarMensajeAChat(remitente, mensaje);

                } else {
                    // mensaje grupal va al grupo
                    this.vista.agregarMensajeAChat("Grupo General", mensaje);
                }
                
            }
            
        } catch(Exception e) {
            System.out.println("Se perdió la conexión");
        }
    }

    
    
}
