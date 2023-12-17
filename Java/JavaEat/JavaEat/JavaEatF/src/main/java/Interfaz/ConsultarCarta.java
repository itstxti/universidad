package Interfaz;

import JavaEatF.Cliente;
import JavaEatF.Comida;
import JavaEatF.IconCellRenderer;
import JavaEatF.Metodos;
import JavaEatF.Particular;
import JavaEatF.Restaurante;
import JavaEatF.Venta;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**Consulta de carta
 *
 * @author tgarc
 */
public class ConsultarCarta extends javax.swing.JFrame {

    private ArrayList<Comida> comidas;
    private ArrayList<Comida> listaComidaComprada;
    private ArrayList<Integer> listaCantidadCadaComidaComprada;
    private Restaurante restaurante;
    private Particular particular;
    private Cliente cliente;
    private ArrayList<Venta> ventas;
    
    /**Crea la carta
     * 
     * @param restaurante emplea objetos restaurante
     * @param cliente emplea objetos cliente
     */
    public ConsultarCarta(Restaurante restaurante, Cliente cliente) {
        this.restaurante = restaurante;
        this.cliente = cliente;
        this.setVisible(true);
        initComponents();
        comidas = restaurante.getComidas();
        ConsularCarta();
        listaComidaComprada = new ArrayList<>();
        listaCantidadCadaComidaComprada = new ArrayList<>();
    }


    private void ConsularCarta() {
        
        DefaultTableModel datosComidas = (DefaultTableModel) jTable4.getModel();
        jTable4.setDefaultRenderer(Object.class, new IconCellRenderer());
        
        for (Comida comida : comidas) {
                
                Object[] filaComida = {
                    Metodos.StringToHtml(comida.getTituloComida()), Metodos.StringToHtml(comida.getIngredientesComida()), comida.getPrecioComida(), 
                    new JLabel (new ImageIcon(comida.getImagenComida()))
                };
                
                datosComidas.addRow(filaComida);
            }
        
        
    }
    
    /**Registra la comida comprada
     * 
     * @param comida objeto guardado
     */
    public void comprarComida(Comida comida) {
        int index = listaComidaComprada.indexOf(comida);

        if (index != -1) {
            int cantidad = listaCantidadCadaComidaComprada.get(index);
            listaCantidadCadaComidaComprada.set(index, cantidad + 1);
        } else {
            listaComidaComprada.add(comida);
            listaCantidadCadaComidaComprada.add(1);
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
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Ingredientes", "Precio", "Imagen"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setRowHeight(100);
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setResizable(false);
            jTable4.getColumnModel().getColumn(1).setResizable(false);
            jTable4.getColumnModel().getColumn(1).setPreferredWidth(270);
            jTable4.getColumnModel().getColumn(2).setResizable(false);
            jTable4.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTable4.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Carta");

        button1.setLabel("AÑADIR AL CARRO");
        button1.setName(""); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setLabel("COMPRAR");
        button2.setName(""); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        int fila = jTable4.getSelectedRow();
        if (fila != -1) {
            Comida comidaComprada = comidas.get(fila);
            comprarComida(comidaComprada);
            JOptionPane.showMessageDialog(rootPane, "Has añadido " + comidaComprada.getTituloComida().toLowerCase() + " a tu carro de la compra.");
        }
        
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
         if (listaComidaComprada.isEmpty()) {
            
            JOptionPane.showMessageDialog(rootPane, "El carro de la compra está vacio. Añade al menos una comida.");
        }
        
        else {
        
            try {
                // TODO add your handling code here:
                Metodos.generarFactura(listaComidaComprada, listaCantidadCadaComidaComprada, restaurante, cliente);
                } catch (IOException ex) {
                Logger.getLogger(ConsultarCarta.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(rootPane, "Gracias, " + cliente.getNombre() + ", por comprar. Revisa tu factura.");
                LocalDate hoy = LocalDate.now();
                Venta venta = new Venta(cliente, restaurante, listaComidaComprada, listaCantidadCadaComidaComprada, hoy);

                //ArrayList<Venta> ventas = new ArrayList<>();

                try {

                    ventas = Metodos.LeerVenta();

                } catch (IOException ex) {
                    Logger.getLogger(ConsultarCarta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ConsultarCarta.class.getName()).log(Level.SEVERE, null, ex);
                }

                ventas.add(venta);

                try {

                    Metodos.GuardarVenta(ventas);

                } catch (IOException ex) {
                    Logger.getLogger(ConsultarCarta.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                listaComidaComprada.clear(); 
                listaCantidadCadaComidaComprada.clear(); 
            }
    }//GEN-LAST:event_button2ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables
}
