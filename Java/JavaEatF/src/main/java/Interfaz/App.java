package Interfaz;

import JavaEatF.Cliente;
import JavaEatF.Empresa;
import JavaEatF.MetodosRestaurantes;
import JavaEatF.Particular;
import JavaEatF.Restaurante;
import JavaEatF.MetodosRestaurantes;
import JavaEatF.Restaurante;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tgarc
 */
public class App extends javax.swing.JFrame {

    private MenuInicial principal; 
    private ArrayList<Restaurante> restaurantes;
    private ArrayList<Restaurante> restaurantesFiltrados;
    private String buscar = "";
    private Particular particular;
    private Cliente cliente;
    
    
    
    /**
     * Creates new form AppParticulares
     * @param ventana
     * @param cliente
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public App(MenuInicial ventana, Cliente cliente) throws IOException, FileNotFoundException, ClassNotFoundException {
        principal = ventana;
        principal.setVisible(false);
        this.setVisible(true);
        initComponents();
        jLabel2.setText(cliente.getNombre() + ", " + cliente.getCodigoPostal());
        this.cliente = cliente;
        if (cliente instanceof Empresa) {
            catering.setVisible(true);
        }
        else {
            catering.setVisible(false);
        }
        
        restaurantes = MetodosRestaurantes.Leer();
        
        TablaCalificacion();
    }
    
    private void TablaCalificacion() throws IOException, FileNotFoundException, ClassNotFoundException  {
        
        restaurantesFiltrados = MetodosRestaurantes.OrdenarCalificacion(MetodosRestaurantes.obtenerRestaurantesCP(MetodosRestaurantes.Leer(), cliente.getCodigoPostal()));
        
        DefaultTableModel datosRestaurantes = (DefaultTableModel) jTable1.getModel(); 
        datosRestaurantes.setRowCount(0);
        
        for (Restaurante restaurante : restaurantesFiltrados) {
            Object[] fila = {  
                
                restaurante.getCodigoPostal(), restaurante.getNombre(), 
                restaurante.getEspecialidad(),restaurante.getTiempoEnvio(), 
                restaurante.getCatering(), restaurante.getValoracion()
    
            };
            
            datosRestaurantes.addRow(fila);
        }
        
    }
    
    public void TablaTiempoEnvio() throws IOException, FileNotFoundException, ClassNotFoundException {
        
        restaurantesFiltrados = MetodosRestaurantes.OrdenarTiempoEnvio(MetodosRestaurantes.obtenerRestaurantesCP(MetodosRestaurantes.Leer(), cliente.getCodigoPostal()));
        
        DefaultTableModel datosRestaurantes = (DefaultTableModel) jTable1.getModel();
        datosRestaurantes.setRowCount(0);
        
        for (Restaurante restaurante : restaurantesFiltrados) {
            Object[] fila = {  
                
                restaurante.getCodigoPostal(), restaurante.getNombre(), 
                restaurante.getEspecialidad(),restaurante.getTiempoEnvio(), 
                restaurante.getCatering(), restaurante.getValoracion()
    
            };
            
            datosRestaurantes.addRow(fila);
        }
    }
    
    public void TablaConCatering() throws IOException, FileNotFoundException, ClassNotFoundException {
        
        restaurantesFiltrados = MetodosRestaurantes.obtenerRestaurantesConCatering(MetodosRestaurantes.obtenerRestaurantesCP(MetodosRestaurantes.Leer(), cliente.getCodigoPostal()));
        
        DefaultTableModel datosRestaurantes = (DefaultTableModel) jTable1.getModel();
        datosRestaurantes.setRowCount(0);
        
        for (Restaurante restaurante : restaurantesFiltrados) {
            Object[] fila = {  
                
                restaurante.getCodigoPostal(), restaurante.getNombre(), 
                restaurante.getEspecialidad(),restaurante.getTiempoEnvio(), 
                restaurante.getCatering(), restaurante.getValoracion()
    
            };
            
            datosRestaurantes.addRow(fila);
        }
    }
    
    public void TablaSinCatering() throws IOException, FileNotFoundException, ClassNotFoundException {
        
        restaurantesFiltrados = MetodosRestaurantes.obtenerRestaurantesSinCatering(MetodosRestaurantes.obtenerRestaurantesCP(MetodosRestaurantes.Leer(), cliente.getCodigoPostal()));
        
        DefaultTableModel datosRestaurantes = (DefaultTableModel) jTable1.getModel();
        datosRestaurantes.setRowCount(0);
        
        for (Restaurante restaurante : restaurantesFiltrados) {
            Object[] fila = {  
                
                restaurante.getCodigoPostal(), restaurante.getNombre(), 
                restaurante.getEspecialidad(),restaurante.getTiempoEnvio(), 
                restaurante.getCatering(), restaurante.getValoracion()
    
            };
            
            datosRestaurantes.addRow(fila);
        }
    }
    
    private void actualizar() {
        
        cartaButton.setVisible(true);
        buscar = (String) jComboBox1.getSelectedItem();
        if (buscar.equals("TIEMPO DE ENVIO")) {
            try {
                TablaTiempoEnvio();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (buscar.equals("CON CATERING")) {
            try {
                TablaConCatering();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (buscar.equals("SIN CATERING")) {        
            try {
                TablaSinCatering();
            } catch (IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (buscar.equals("RELEVANCIA")) {
            
            try {
                TablaCalificacion();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
               
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSpinner1 = new javax.swing.JSpinner();
        valorar = new java.awt.Button();
        jComboBox1 = new javax.swing.JComboBox<>();
        cartaButton = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        catering = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CP", "Nombre", "Especialidad", "T. Envio", "Catering", "Valoracion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        valorar.setLabel("VALORAR");
        valorar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                valorarMouseClicked(evt);
            }
        });
        valorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RELEVANCIA", "TIEMPO DE ENVIO", "CON CATERING", "SIN CATERING" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        cartaButton.setLabel("CONSULTAR CARTA");
        cartaButton.setName(""); // NOI18N
        cartaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartaButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("juan");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("VER CUENTA");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("JavaEat");

        catering.setActionCommand("PEDIR CATERING");
        catering.setLabel("PEDIR CATERING");
        catering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cateringActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(valorar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 142, Short.MAX_VALUE)
                            .addComponent(cartaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(catering, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(catering, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(cartaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void valorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorarActionPerformed
        // TODO add your handling c 

    }//GEN-LAST:event_valorarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        //RELEVANCIA, TIEMPO DE ENVIO, CON CATERING, SIN CATERING
        actualizar();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void cartaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartaButtonActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();

        //si hay una fila seleccionada, abre la ventana para consultar la carta del restaurante seleccionado.
        if (fila != -1) {

            Restaurante resta = restaurantesFiltrados.get(fila);
            ConsultarCarta c = new ConsultarCarta(resta, cliente);

        }

    }//GEN-LAST:event_cartaButtonActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        DatosCuenta datosCuenta = new DatosCuenta(cliente, this);

    }//GEN-LAST:event_jLabel3MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
                principal.setVisible(true);

    }//GEN-LAST:event_formWindowClosed

    private void cateringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cateringActionPerformed
        // TODO add your handling code here:
        
        int fila = jTable1.getSelectedRow();
        Restaurante res = restaurantesFiltrados.get(fila);

        if ((res.getCatering() == true) && (fila != -1)) { 
            
            ConsultarCatering cc = new ConsultarCatering(res, cliente);
        }
    }//GEN-LAST:event_cateringActionPerformed

    private void valorarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_valorarMouseClicked
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        int valoracion = (int)jSpinner1.getValue();
        
        try {
            
            restaurantes = MetodosRestaurantes.Leer();
            
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Restaurante res = restaurantesFiltrados.get(fila);
        
        if (fila != -1) {
            
            res.agregarValoracion(valoracion);
            
                for (Restaurante restaurante : restaurantes) {
                    if (restaurante.getCif().equals(res.getCif())) {
                        
                        restaurante.agregarValoracion(valoracion);
                        MetodosRestaurantes.Registrar(restaurantes);
                        actualizar();
                    }
                }
        }
    }//GEN-LAST:event_valorarMouseClicked

    /**
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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button cartaButton;
    private java.awt.Button catering;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private java.awt.Button valorar;
    // End of variables declaration//GEN-END:variables
}
