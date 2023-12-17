package Interfaz;

import JavaEatF.Cliente;
import JavaEatF.Empresa;
import JavaEatF.Metodos;
import JavaEatF.MetodosRestaurantes;
import JavaEatF.Particular;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**Crea ventana del menu inicial
 *
 * @author Tatiana Garcia
 */
public class MenuInicial extends javax.swing.JFrame {

    private ArrayList<Cliente> clientes;

    /**Crea la ventana del menu inicial
     * Creates new form MenuInicial
     */
    public MenuInicial() throws IOException, FileNotFoundException, ClassNotFoundException  {
        this.setVisible(true);
        initComponents();
        MetodosRestaurantes.Registrar(MetodosRestaurantes.setRestaurantes());
        Metodos.RegistrarClientes(Metodos.setClientes());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        LabelUsuario = new javax.swing.JLabel();
        TextFieldUsuario = new javax.swing.JTextField();
        LabelContraseña = new javax.swing.JLabel();
        TextFieldContraseña = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        TextFieldEntrar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        TextFieldRegistrar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("INICIAR SESIÓN");

        LabelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelUsuario.setText("CORREO");

        TextFieldUsuario.setForeground(new java.awt.Color(153, 153, 153));
        TextFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldUsuarioActionPerformed(evt);
            }
        });

        LabelContraseña.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelContraseña.setText("CONTRASEÑA");

        TextFieldContraseña.setForeground(new java.awt.Color(153, 153, 153));

        jPanel3.setBackground(java.awt.SystemColor.activeCaption);

        TextFieldEntrar.setEditable(false);
        TextFieldEntrar.setBackground(new java.awt.Color(72, 192, 192));
        TextFieldEntrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TextFieldEntrar.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldEntrar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldEntrar.setText("ENTRAR");
        TextFieldEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TextFieldEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextFieldEntrarMouseClicked(evt);
            }
        });
        TextFieldEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextFieldEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextFieldEntrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(72, 192, 192));

        TextFieldRegistrar.setEditable(false);
        TextFieldRegistrar.setBackground(new java.awt.Color(72, 192, 192));
        TextFieldRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TextFieldRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldRegistrar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldRegistrar.setText("REGISTRARSE");
        TextFieldRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TextFieldRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextFieldRegistrarMouseClicked(evt);
            }
        });
        TextFieldRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextFieldRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextFieldRegistrar, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LabelContraseña, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextFieldContraseña, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(LabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(LabelContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TextFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldUsuarioActionPerformed

    private void TextFieldEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextFieldEntrarMouseClicked
        String correo = TextFieldUsuario.getText();
        String contraseña = TextFieldContraseña.getText();
        try {
            // TODO add your handling code here:
            clientes = Metodos.LeerClientes();
            
           
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Excepción al leer archivos.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuInicial.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (correo.isEmpty() || contraseña.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Rellena todos los campos.");
            } else if (correo.equals("admin@javaeat.com") && contraseña.equals("admin")) {
                JOptionPane.showMessageDialog(rootPane, "Has iniciado sesión como administrador.");
                try {
                    AppAdmin appAdmin = new AppAdmin(this);

                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(MenuInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {

                Cliente cliente = Metodos.consultaClientePorCorreo(correo, clientes);

                if (cliente !=null) {
                    if (cliente.getClave().equals(contraseña)) {

                        if (cliente instanceof Particular) {
                                JOptionPane.showMessageDialog(rootPane, "Has iniciado sesión como particular.");
                            }

                        else if (cliente instanceof Empresa) {
                                JOptionPane.showMessageDialog(rootPane, "Has iniciado sesión como empresa.");
                        }

                        try {
                            App app = new App(this, cliente); 
                        } catch (IOException ex) { 
                            Logger.getLogger(MenuInicial.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(MenuInicial.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Contraseña incorrecta. Por favor, intenta nuevamente.");
                        }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Cliente no registrado. Por favor, regístrate antes de iniciar sesión.");
                }
            }
    }//GEN-LAST:event_TextFieldEntrarMouseClicked

    private void TextFieldEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldEntrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldEntrarActionPerformed

    private void TextFieldRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextFieldRegistrarMouseClicked
        try {
            // TODO add your handling code here:
            MenuRegistrar menuRegistrar = new MenuRegistrar(this);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MenuInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TextFieldRegistrarMouseClicked

    private void TextFieldRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldRegistrarActionPerformed

    /**Argumentos a usar
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MenuInicial().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MenuInicial.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelContraseña;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JPasswordField TextFieldContraseña;
    private javax.swing.JTextField TextFieldEntrar;
    private javax.swing.JTextField TextFieldRegistrar;
    private javax.swing.JTextField TextFieldUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
