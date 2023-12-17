package Interfaz;

import JavaEatF.Cliente;
import JavaEatF.Comida;
import JavaEatF.Empresa;
import JavaEatF.Metodos;
import static JavaEatF.Metodos.buenaFecha;
import JavaEatF.MetodosRestaurantes;
import JavaEatF.Particular;
import JavaEatF.Restaurante;
import JavaEatF.Venta;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

/**App de consulta del administrador
 *
 * @author tgarc
 */
public class AppAdmin extends javax.swing.JFrame {

    
    private MenuInicial principal;    
    public ArrayList<Restaurante> restaurantes; // Lista de objetos Restaurante que representa los restaurantes disponibles
    private ArrayList<Cliente> clientes;
    private ArrayList<Venta> ventas;
    
    /**Medio de uso
     * Creates new form AppAdmin
     * @param ventana medio en el que se va a generar
     * @throws java.io.IOException excepcion en entrada/salida de datos
     * @throws java.io.FileNotFoundException excepcion al no encontrar archivo
     * @throws java.lang.ClassNotFoundException excepcion al no encontrar la clase
     */
    public AppAdmin(MenuInicial ventana) throws IOException, FileNotFoundException, ClassNotFoundException {
        principal = ventana;
        principal.setVisible(false);
        this.setVisible(true);
        initComponents();
        button1.setVisible(false);
        TextFieldFecha.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
        button5.setVisible(false);
        button6.setVisible(false);
        llenarTablaParticular();
        RestaurateT();
        llenarTablaEmpresas();
        llenarTablaVentas();
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
        TextFieldFecha = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        button5 = new java.awt.Button();
        button6 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(215, 236, 246));

        TextFieldFecha.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar a partir de esta fecha"));
        try {
            TextFieldFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TextFieldFecha.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        TextFieldFecha.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                TextFieldFechaInputMethodTextChanged(evt);
            }
        });
        TextFieldFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldFechaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("JavaEat: Administrador");

        jTabbedPane1.setName(""); // NOI18N
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "Correo", "Clave", "Calle", "Nº Calle", "Codigo Postal", "Ciudad", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setShowGrid(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Particulares", jScrollPane1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CIF", "Nombre", "Correo", "Clave", "Calle", "Nº Calle", "Código Postal", "Ciudad", "Telefono", "Web"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane1.addTab("Empresas", jScrollPane2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CIF", "Nombre", "Calle", "Nº Calle", "Código Postal", "Ciudad", "Especialidad", "Gastos de envio", "Tiempo de entrega", "Catering", "Valoración"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
            jTable3.getColumnModel().getColumn(1).setResizable(false);
            jTable3.getColumnModel().getColumn(2).setResizable(false);
            jTable3.getColumnModel().getColumn(3).setResizable(false);
            jTable3.getColumnModel().getColumn(4).setResizable(false);
            jTable3.getColumnModel().getColumn(5).setResizable(false);
            jTable3.getColumnModel().getColumn(6).setResizable(false);
            jTable3.getColumnModel().getColumn(7).setResizable(false);
            jTable3.getColumnModel().getColumn(8).setResizable(false);
            jTable3.getColumnModel().getColumn(9).setResizable(false);
            jTable3.getColumnModel().getColumn(10).setResizable(false);
        }

        jTabbedPane1.addTab("Restaurantes", jScrollPane3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Restaurante", "Comida comprada", "Cantidad", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setResizable(false);
            jTable4.getColumnModel().getColumn(1).setResizable(false);
            jTable4.getColumnModel().getColumn(2).setResizable(false);
            jTable4.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTable4.getColumnModel().getColumn(4).setResizable(false);
        }

        jTabbedPane1.addTab("Ventas", jScrollPane4);

        button1.setLabel("CONSULTAR CARTA");
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button1MouseClicked(evt);
            }
        });
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setLabel("MOSTRAR TODAS");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setLabel("DAR DE BAJA A RESTAURANTE");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setLabel("DETALLES CATERING");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button5.setLabel("DAR DE ALTA UN RESTAURANTE");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        button6.setActionCommand("Actualizar");
        button6.setLabel("ACTUALIZAR");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextFieldFecha, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("jTabbedPane1");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

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

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        principal.setVisible(true);
        
    }//GEN-LAST:event_formWindowClosed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

    }//GEN-LAST:event_button1ActionPerformed

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
        
            try {
                restaurantes = MetodosRestaurantes.Leer();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(AppAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }

            //guarda la fila seleccionada
            int fila = jTable3.getSelectedRow();

            //si hay una fila seleccionada, abre la ventana para consultar la carta del restaurante seleccionado.
            if (fila != -1) {

                Restaurante res = restaurantes.get(fila);
                ConsultarCartaAdmin c = new ConsultarCartaAdmin(res);

            }
        
    }//GEN-LAST:event_button1MouseClicked

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        JTabbedPane tabbedPane = jTabbedPane1;
        int selectedTabIndex = tabbedPane.getSelectedIndex();

        switch (selectedTabIndex) {
            case 2:
            button1.setVisible(true);
            button3.setVisible(true);
            TextFieldFecha.setVisible(false);
            button2.setVisible(false);
            button4.setVisible(true);
            button5.setVisible(true);
            button6.setVisible(true);



            break;
            case 3:
            button1.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            button5.setVisible(false);
            button6.setVisible(false);

            TextFieldFecha.setVisible(true);
            button2.setVisible(true);

            break;
            default:
            button1.setVisible(false);
            button4.setVisible(false);
            TextFieldFecha.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button5.setVisible(false);
            button6.setVisible(false);

            break;
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void TextFieldFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldFechaActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            llenarTablaVentasFiltrada();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AppAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TextFieldFechaActionPerformed

    private void TextFieldFechaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TextFieldFechaInputMethodTextChanged

    }//GEN-LAST:event_TextFieldFechaInputMethodTextChanged

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        try {
            // TODO add your handling code here:
            TextFieldFecha.setText("");
            llenarTablaVentas();
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AppAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        try {
                restaurantes = MetodosRestaurantes.Leer();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(AppAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }

            //guarda la fila seleccionada
            int fila = jTable3.getSelectedRow();

            //si hay una fila seleccionada, abre la ventana para consultar la carta del restaurante seleccionado.
            if (fila != -1) {

                Restaurante res = restaurantes.get(fila);
                restaurantes.remove(res);
                MetodosRestaurantes.Registrar(restaurantes);
                try {
                    RestaurateT();
                } catch (IOException ex) {
                    Logger.getLogger(AppAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        int fila = jTable3.getSelectedRow();
        Restaurante res = restaurantes.get(fila);

        if ((res.getCatering() == true) && (fila != -1)) { 
            
            ConsultarCateringAdmin cc = new ConsultarCateringAdmin(res);
        }   
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        // TODO add your handling code here:
        DatosRestaurante dr = new DatosRestaurante();
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        try {
            // TODO add your handling code here:
            RestaurateT();
        } catch (IOException ex) {
            Logger.getLogger(AppAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button6ActionPerformed

    /**Excepciones a recibir
     * 
     * @throws java.io.IOException excepcion en entrada/salida de datos
     * @throws java.io.FileNotFoundException excepcion al no encontrar archivo
     * @throws java.lang.ClassNotFoundException excepcion al no encontrar la clase
     */
    private void llenarTablaParticular() throws IOException, FileNotFoundException, ClassNotFoundException  {
        
        clientes = Metodos.LeerClientes();
        ArrayList<Particular> particulares = new ArrayList<>();
        
        for (Cliente cliente : clientes) {
            if (cliente instanceof Particular particular) {
                particulares.add(particular);
            }
            
        }
        
        

        DefaultTableModel datosParticulares = (DefaultTableModel) jTable1.getModel();
        
        for (Particular particular : particulares) {
            
            Object[] fila = {
                particular.getDni(),particular.getNombre(), particular.getCorreo(),
                particular.getClave(), particular.getCalle(), particular.getNumeroCalle(), particular.getCodigoPostal(),
                particular.getCiudad(), particular.getTelefono() 
            };
            
            datosParticulares.addRow(fila);
        }
      
    }
    
    /**Excepciones recibidas
     * 
     * @throws java.io.IOException excepcion en entrada/salida de datos
     * @throws java.io.FileNotFoundException excepcion al no encontrar archivo
     * @throws java.lang.ClassNotFoundException excepcion al no encontrar la clase
     */
    private void llenarTablaEmpresas() throws IOException, FileNotFoundException, ClassNotFoundException  {
        
        clientes = Metodos.LeerClientes();
        ArrayList<Empresa> empresas = new ArrayList<>();
        
        for (Cliente cliente : clientes) {
            if (cliente instanceof Empresa empresa) {
                empresas.add(empresa);
            }
            
        }

        DefaultTableModel datosEmpresas = (DefaultTableModel) jTable2.getModel();
        
        for (Empresa empresa : empresas) {
            
            Object[] fila = {
                empresa.getCif(),empresa.getNombre(), empresa.getCorreo(),
                empresa.getClave(),  empresa.getCalle(), empresa.getNumeroCalle(), empresa.getCodigoPostal(),
                empresa.getCiudad(),empresa.getTelefono(), empresa.getWeb()
            };
            datosEmpresas.addRow(fila);
            
        }
      
    }
    
    /**Excepcion recibida
     * 
     * @throws java.io.IOException excepcion en entrada/salida de datos
     */
    private void RestaurateT() throws IOException {
        
        try {
            restaurantes = MetodosRestaurantes.Leer();
            //System.out.println(restaurantesP);
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(AppAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultTableModel datosRestaurantes = (DefaultTableModel) jTable3.getModel();
        datosRestaurantes.setRowCount(0);
        for (Restaurante restaurante : restaurantes) {
            Object[] fila = {  
                
                restaurante.getCif(), restaurante.getNombre(), restaurante.getCalle(), restaurante.getNumeroCalle(),
                restaurante.getCodigoPostal(), restaurante.getCiudad(), 
                restaurante.getEspecialidad(),restaurante.getGastosEnvio(),restaurante.getTiempoEnvio(), 
                restaurante.getCatering(), restaurante.getValoracion()
    
            };
            
            datosRestaurantes.addRow(fila);
        }
    }
    
    
    /**Excepciones recibidas
     * 
     * @throws java.io.IOException excepcion en entrada/salida de datos
     * @throws java.io.FileNotFoundException excepcion al no encontrar archivo
     * @throws java.lang.ClassNotFoundException excepcion al no encontrar la clase
     */
    private void llenarTablaVentasFiltrada() throws IOException, FileNotFoundException, ClassNotFoundException {
        String fechaTxt = (String) TextFieldFecha.getValue();
        String[] partes = fechaTxt.split("/");
        int d1 = Integer.parseInt(partes[0]);
        int m1 = Integer.parseInt(partes[1]);
        int a1 = Integer.parseInt(partes[2]);
        
        if (!buenaFecha(d1, m1, a1)) {
                JOptionPane.showMessageDialog(rootPane, "Introduce una fecha válida.");
                llenarTablaVentas();
                TextFieldFecha.setText("");
            } else {
                    LocalDate fecha = LocalDate.of(a1, m1, d1);

                    ventas = Metodos.filtrarVentaFecha(Metodos.LeerVenta(), fecha); 

                    DefaultTableModel datosVentas = (DefaultTableModel) jTable4.getModel();
                    datosVentas.setRowCount(0); // Limpiar la tabla antes de agregar los datos

                    for (Venta venta : ventas) {
                        for (int i = 0; i < venta.getListaComidaComprada().size(); i++) {
                            Comida comida = venta.getListaComidaComprada().get(i);
                            int cantidad = venta.getListaCantidadCadaComidaComprada().get(i);

                            Object[] fila = {
                                venta.getCliente().getNombre(),
                                venta.getRestaurante().getNombre(),
                                comida.getTituloComida(),
                                cantidad,
                                venta.getFechaCompra()
                            };

                            datosVentas.addRow(fila);
                        }
                    }    
        }
    }

    /**Excepciones recibidas
     * 
     * @throws java.io.IOException excepcion en entrada/salida de datos
     * @throws java.io.FileNotFoundException excepcion al no encontrar archivo
     * @throws java.lang.ClassNotFoundException excepcion al no encontrar la clase
     */
    
    private void llenarTablaVentas() throws IOException, FileNotFoundException, ClassNotFoundException {
       

        ventas = Metodos.LeerVenta(); 

        DefaultTableModel datosVentas = (DefaultTableModel) jTable4.getModel();
        datosVentas.setRowCount(0); // Limpiar la tabla antes de agregar los datos

        for (Venta venta : ventas) {
            for (int i = 0; i < venta.getListaComidaComprada().size(); i++) {
                Comida comida = venta.getListaComidaComprada().get(i);
                int cantidad = venta.getListaCantidadCadaComidaComprada().get(i);

                Object[] fila = {
                    venta.getCliente().getNombre(),
                    venta.getRestaurante().getNombre(),
                    comida.getTituloComida(),
                    cantidad,
                    venta.getFechaCompra()
                };

                datosVentas.addRow(fila);
            }
        }
    }
    
    
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
            java.util.logging.Logger.getLogger(AppAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField TextFieldFecha;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.Button button5;
    private java.awt.Button button6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables
}
