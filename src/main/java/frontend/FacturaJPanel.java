/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import backend.Cliente;
import backend.Factura;
import backend.Pedido;
import backend.Producto;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author toapa
 */
public class FacturaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form FacturaJPanel
     */
    public FacturaJPanel() {
        initComponents();
        cargarPedidosDesdeBaseDeDatos();
        obtenerPedidoDesdeBaseDeDatos(0);
        
    }

   private void cargarPedidosDesdeBaseDeDatos() {
    Pedido pedido = new Pedido(0, null, null);
    List<Document> pedidos = pedido.consultarPedidoBDD();
    for (Document doc : pedidos) {
        int numeroPedido = doc.getInteger("#");
        jComboBoxPedido.addItem(String.valueOf(numeroPedido));
    }
}
   
private Pedido obtenerPedidoDesdeBaseDeDatos(int numeroPedido) {
    Pedido pedido = new Pedido(0, null, null); // Instancia de Pedido para obtener el pedido
    List<Document> pedidos = pedido.consultarPedidoBDD();
    for (Document doc : pedidos) {
        if (doc.getInteger("#") == numeroPedido) {
            // Construye el objeto Pedido con los datos del documento
            pedido.setNumeroPedido(doc.getInteger("#"));
            // Construye el objeto Cliente con los datos del documento
            Cliente cliente = new Cliente(
                doc.getString("Nombres"),
                doc.getString("Apellidos"),
                doc.getString("Telefono"),
                doc.getString("Email")
            );
            pedido.setCliente(cliente);
            // Construye el objeto Producto con los datos del documento
            Producto producto = new Producto(
                doc.getString("Producto"),
                doc.getString("Descripción"),
                doc.getDouble("Precio"),
                doc.getDouble("Codigo")
               
            );
            pedido.setProducto(producto);
            return pedido;
        }
    }
    return null;
}
   
    private void mostrarDatosFactura(Pedido pedido) {
    jTextFieldNombres.setText(pedido.getCliente().getNombres());
    jTextFieldApellidos.setText(pedido.getCliente().getApellidos());
    jTextFieldTelefono.setText(pedido.getCliente().getTelefono());
    jTextFieldEmail.setText(pedido.getCliente().getEmail());
    jLabelProducto.setText(pedido.getProducto().getProducto());
    jLabelPrecio.setText(String.valueOf(pedido.getProducto().getPrecio()));
    jLabelCodigo.setText(String.valueOf(pedido.getProducto().getCodigo_producto()));
    jTextPaneDescripcion.setText(pedido.getProducto().getDescripcion());

    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldNombres = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabelProducto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jComboBoxPedido = new javax.swing.JComboBox<>();
        jLabelCodigo = new javax.swing.JLabel();
        jButtonCancelarFactura = new javax.swing.JButton();
        jButtonConfirmarFactura = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneDescripcion = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(570, 660));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 162, 30));

        jButtonBuscar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(0, 153, 255));
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 80, 30));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("GENERAR FACTURA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jTextFieldTelefono.setPreferredSize(new java.awt.Dimension(180, 32));
        add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 180, 32));

        jTextFieldNombres.setPreferredSize(new java.awt.Dimension(180, 32));
        jTextFieldNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombresActionPerformed(evt);
            }
        });
        add(jTextFieldNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 180, 32));

        jTextFieldEmail.setPreferredSize(new java.awt.Dimension(180, 32));
        add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 180, 32));

        jTextFieldApellidos.setPreferredSize(new java.awt.Dimension(180, 32));
        add(jTextFieldApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 180, 32));

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enviado", "Entregado", "En Proceso" }));
        jComboBoxEstado.setPreferredSize(new java.awt.Dimension(180, 32));
        add(jComboBoxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 180, 32));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Seleccione el Pedido");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        jLabelProducto.setText("*NombreProducto*");
        add(jLabelProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, 20));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("Telf:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("Datos del Cliente");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("Nombres:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setText("Apellidos:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 255));
        jLabel8.setText("Estado:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 255));
        jLabel9.setText("E-mail:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 255));
        jLabel10.setText("Datos del Producto");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        jLabelPrecio.setText("*Precio*");
        add(jLabelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, -1, 20));

        jComboBoxPedido.setPreferredSize(new java.awt.Dimension(180, 32));
        jComboBoxPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPedidoActionPerformed(evt);
            }
        });
        add(jComboBoxPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 180, 32));

        jLabelCodigo.setText("*Código Producto*");
        add(jLabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, -1, 20));

        jButtonCancelarFactura.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButtonCancelarFactura.setForeground(new java.awt.Color(0, 153, 255));
        jButtonCancelarFactura.setText("Cancelar Factura");
        jButtonCancelarFactura.setPreferredSize(new java.awt.Dimension(180, 32));
        jButtonCancelarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarFacturaActionPerformed(evt);
            }
        });
        add(jButtonCancelarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 600, -1, -1));

        jButtonConfirmarFactura.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButtonConfirmarFactura.setForeground(new java.awt.Color(0, 153, 255));
        jButtonConfirmarFactura.setText("Confirmar Factura");
        jButtonConfirmarFactura.setPreferredSize(new java.awt.Dimension(180, 32));
        jButtonConfirmarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarFacturaActionPerformed(evt);
            }
        });
        add(jButtonConfirmarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 560, -1, -1));

        jScrollPane1.setViewportView(jTextPaneDescripcion);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 140, 60));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 255));
        jLabel11.setText("Producto:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, -1, -1));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 255));
        jLabel12.setText("Precio:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, -1, -1));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 255));
        jLabel13.setText("Código:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonCancelarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarFacturaActionPerformed

    private void jTextFieldNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombresActionPerformed

    private void jComboBoxPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPedidoActionPerformed
     String numeroPedidoSeleccionado = (String) jComboBoxPedido.getSelectedItem();
    if (numeroPedidoSeleccionado != null) {
        int numeroPedido = Integer.parseInt(numeroPedidoSeleccionado);
        Pedido pedido = obtenerPedidoDesdeBaseDeDatos(numeroPedido);
        if (pedido != null) {
            mostrarDatosFactura(pedido);
        }
    }  

    }//GEN-LAST:event_jComboBoxPedidoActionPerformed

    private void jButtonConfirmarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarFacturaActionPerformed
       String  nombres = jTextFieldNombres.getText();
       String apellidos = jTextFieldApellidos.getText();
       String email = jTextFieldEmail.getText();
       String telefono = jTextFieldTelefono.getText();
       String producto = jLabelProducto.getText();
       String descripcion = jTextPaneDescripcion.getText();
       Double precio = Double.parseDouble(jLabelPrecio.getText());
       Double codigo = Double.parseDouble(jLabelCodigo.getText());
       String estado = (String) jComboBoxEstado.getSelectedItem();
       
       Cliente cliente = new Cliente(nombres,apellidos,email,telefono);
       Producto producto1 = new Producto(producto,descripcion,precio,codigo);
       
       Pedido pedido = new Pedido(0,cliente,producto1);
       Factura factura = new Factura(cliente,producto1,pedido,estado);
       
       factura.guardarFacturaBDD(0);
       
       
       jTextFieldNombres.setText("");
       jTextFieldApellidos.setText("");
       jTextFieldEmail.setText("");
       jTextFieldTelefono.setText("");
       jLabelProducto.setText("");
       jTextPaneDescripcion.setText("");
       jLabelPrecio.setText("");
       jLabelCodigo.setText("");
    }//GEN-LAST:event_jButtonConfirmarFacturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelarFactura;
    private javax.swing.JButton jButtonConfirmarFactura;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JComboBox<String> jComboBoxPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombres;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JTextPane jTextPaneDescripcion;
    // End of variables declaration//GEN-END:variables
}
