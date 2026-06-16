package Cliente.Controlador;

import Cliente.Modelo.Modelo;
import Cliente.Vista.Vista;
import Cliente.Vista.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Cliente.Modelo.Utils;
import Cliente.Network.Cliente;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import java.util.*;

public class Controlador implements ActionListener{
    
    public Modelo modelo;
    public Login login;
    public Cliente cliente;
    public Utils utils;
    public Vista vista; 

    public Controlador(Modelo modelo, Login login, Cliente cliente) {
        
        this.modelo = modelo;
        this.login = login;
        
        this.cliente = cliente;
        this.utils = new Utils();
        
        this.login.boton_conectarse.addActionListener(this);
        
        this.login.setLocationRelativeTo(null);
        this.login.setTitle("Login - Registrarse");
        this.login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.login.boton_conectarse) {
            
            String nombre = this.login.txtNombre.getText();
            String correo = this.login.txtCorreo.getText();
            
            
            
            if(!this.utils.Vacio(nombre) && this.utils.validarNombre(nombre)) {
                
                if(!this.utils.Vacio(correo) && !this.utils.validarCorreo(correo)) {
                    JOptionPane.showMessageDialog(login, "Ingrese un correo valido");
                    return;
                }
                
                this.modelo.setNombre(nombre);
                
                this.modelo.setCorreo(correo);
                
                this.vista = new Vista();
                this.cliente.empezar(this.modelo.getNombre(), this.vista);
                
                this.login.dispose();
                
                this.vista.setLocationRelativeTo(null);
                this.vista.setTitle("Chat Usuario : " + this.modelo.getNombre());
                
                this.vista.boton_enviar.addActionListener(this);
                this.vista.areaChat.setEditable(false);
                
                this.vista.hora_actual_c.setEditable(false);
                this.vista.txtNombreUsuario.setText(this.modelo.getNombre());
                this.vista.txtNombreUsuario.setEditable(false);
                
                this.vista.contador_conectados.setEditable(false);
                this.vista.actualizarContador();
                
                
                this.vista.setVisible(true);
            }
                    
        } else if(e.getSource() == this.vista.boton_enviar) {
            
            String mensaje = this.vista.getMensaje();
            String destinatario = this.vista.getUsuarioSeleccionado();
            
            String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
            
            if(!this.utils.Vacio(mensaje)) {
                
                if(destinatario == null || destinatario.equals("Grupo General")) {
                    
                    this.cliente.enviarMensaje(mensaje);
                    this.vista.agregarMensajeAChat("Grupo General", "[" + hora + "] Tú: " + mensaje);
                } else {

                    this.cliente.enviarMensaje("PRIVADO:" + destinatario + ":" + mensaje);
                    
                    this.vista.agregarMensajeAChat(destinatario, "[" + hora + "] Tú: " + mensaje);
                }
                
                this.vista.limpiarMensaje();
            }
        }  
    }
}
    

