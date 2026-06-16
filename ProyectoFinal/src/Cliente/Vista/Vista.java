
package Cliente.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Vista extends javax.swing.JFrame {

    public DefaultListModel<String> modeloLista = new DefaultListModel<>();
    public HashMap<String, String> historialesMensajes = new HashMap<>();
    
    public Vista() {
        initComponents();
        
        javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                hora_actual_c.setText(hora);
            }
            
        });
        
        timer.start();
        
        lista_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
            
                String s = lista_usuarios.getSelectedValue();
                if(s != null) {
                    mostrarChat(s);
                }
            }
        });
        
        
        
        this.lista_usuarios.setModel(modeloLista);
        this.modeloLista.addElement("Grupo General");
        this.lista_usuarios.setSelectedIndex(0); 
    }
    
    public void agregarMensaje(String mensaje){
        this.areaChat.append(mensaje + "\n");
    }

    public JButton getBoton_enviar() {
        return boton_enviar;
    }

    public String getMensaje(){
        return txtMensaje.getText();
    }

    public void actualizarContador() {
        this.contador_conectados.setText(String.valueOf(modeloLista.size() -1));
    }
   
    
    
    public String getUsuarioSeleccionado() {
        return lista_usuarios.getSelectedValue();
    }
    
    
    public void limpiarMensaje() {
        txtMensaje.setText("");
    }
    
    
    public void mostrarChat(String contacto) {
        String historial = historialesMensajes.getOrDefault(contacto, "");
        areaChat.setText(historial);
    }

    public void agregarMensajeAChat(String contacto, String mensaje) {
        
        String historial = historialesMensajes.getOrDefault(contacto, "");
        historial += mensaje + "\n";
        
        historialesMensajes.put(contacto, historial);

        String seleccionado = lista_usuarios.getSelectedValue();
    
        
        if(seleccionado == null || seleccionado.equals(contacto)) {
            areaChat.setText(historial);
        }
    }
    
    
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_usuarios = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        txt_conectados = new javax.swing.JLabel();
        contador_conectados = new javax.swing.JTextField();
        txt_hora = new javax.swing.JLabel();
        hora_actual_c = new javax.swing.JTextField();
        txt_hora1 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaChat = new javax.swing.JTextArea();
        txtMensaje = new javax.swing.JTextField();
        boton_enviar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(204, 255, 204));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lista_usuarios.setBackground(new java.awt.Color(26, 115, 99));
        lista_usuarios.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 15)); // NOI18N
        lista_usuarios.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(lista_usuarios);

        fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 190, 420));

        jPanel1.setBackground(new java.awt.Color(26, 115, 99));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_conectados.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 12)); // NOI18N
        txt_conectados.setForeground(new java.awt.Color(255, 255, 255));
        txt_conectados.setText("Usuarios Conectados  :");
        jPanel1.add(txt_conectados, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 150, 20));

        contador_conectados.setBackground(new java.awt.Color(26, 115, 99));
        contador_conectados.setForeground(new java.awt.Color(255, 255, 255));
        contador_conectados.setDisabledTextColor(new java.awt.Color(26, 115, 99));
        contador_conectados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contador_conectadosActionPerformed(evt);
            }
        });
        jPanel1.add(contador_conectados, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 30, 20));

        txt_hora.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 12)); // NOI18N
        txt_hora.setForeground(new java.awt.Color(255, 255, 255));
        txt_hora.setText("Hora Actual             :");
        jPanel1.add(txt_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 150, 20));

        hora_actual_c.setBackground(new java.awt.Color(26, 115, 99));
        hora_actual_c.setForeground(new java.awt.Color(255, 255, 255));
        hora_actual_c.setDisabledTextColor(new java.awt.Color(26, 115, 99));
        hora_actual_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hora_actual_cActionPerformed(evt);
            }
        });
        jPanel1.add(hora_actual_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 120, 20));

        txt_hora1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 12)); // NOI18N
        txt_hora1.setForeground(new java.awt.Color(255, 255, 255));
        txt_hora1.setText("Usuario                   :");
        jPanel1.add(txt_hora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 150, 20));

        txtNombreUsuario.setBackground(new java.awt.Color(26, 115, 99));
        txtNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreUsuario.setDisabledTextColor(new java.awt.Color(26, 115, 99));
        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 120, 20));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lista de Usuarios");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 40));

        fondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 100));

        areaChat.setColumns(20);
        areaChat.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 15)); // NOI18N
        areaChat.setRows(5);
        areaChat.setDisabledTextColor(new java.awt.Color(26, 115, 99));
        jScrollPane2.setViewportView(areaChat);

        fondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 710, 370));

        txtMensaje.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 11)); // NOI18N
        txtMensaje.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensajeActionPerformed(evt);
            }
        });
        fondo.add(txtMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 410, 30));

        boton_enviar.setBackground(new java.awt.Color(26, 115, 99));
        boton_enviar.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 12)); // NOI18N
        boton_enviar.setForeground(new java.awt.Color(255, 255, 255));
        boton_enviar.setText("Enviar");
        boton_enviar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        boton_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_enviarActionPerformed(evt);
            }
        });
        fondo.add(boton_enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 480, 110, 30));

        jLabel2.setBackground(new java.awt.Color(153, 0, 204));
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 12)); // NOI18N
        jLabel2.setText("Mensaje: ");
        fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 70, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMensajeActionPerformed

    private void contador_conectadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contador_conectadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contador_conectadosActionPerformed

    private void boton_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_enviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_enviarActionPerformed

    private void hora_actual_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hora_actual_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hora_actual_cActionPerformed

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea areaChat;
    public javax.swing.JButton boton_enviar;
    public javax.swing.JTextField contador_conectados;
    private javax.swing.JPanel fondo;
    public javax.swing.JTextField hora_actual_c;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JList<String> lista_usuarios;
    public javax.swing.JTextField txtMensaje;
    public javax.swing.JTextField txtNombreUsuario;
    public javax.swing.JLabel txt_conectados;
    public javax.swing.JLabel txt_hora;
    public javax.swing.JLabel txt_hora1;
    // End of variables declaration//GEN-END:variables
}
