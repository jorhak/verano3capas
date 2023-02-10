/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.capas.presentacion;

import com.capas.negocio.NFactura;
import com.capas.negocio.NProducto;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilidades.Fecha;

/**
 *
 * @author jorhak
 */
public class PFactura extends javax.swing.JFrame {

    /**
     * Creates new form PFactura
     */
    NFactura negocio;
    NProducto nproducto;

    boolean isAgregar;

    public PFactura() {
        initComponents();
        negocio = new NFactura();
        nproducto = new NProducto();

        isAgregar = true;
        textNro.setVisible(false);

        ListaProductos(nproducto.Listar());
        Actualizar(negocio.Listar());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelCantidad = new javax.swing.JLabel();
        labelPrecio = new javax.swing.JLabel();
        textCantidad = new javax.swing.JTextField();
        textPrecio = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTable();
        btnQuitar = new javax.swing.JButton();
        labelTotalPagar = new javax.swing.JLabel();
        labelDinero = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelNit = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelMontoTotal = new javax.swing.JLabel();
        textNit = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        textMontoTotal = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnObtener = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaFactura = new javax.swing.JTable();
        textNro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitulo.setFont(new java.awt.Font("Pacifico", 0, 24)); // NOI18N
        labelTitulo.setText("FACTURA");

        jPanel1.setBackground(new java.awt.Color(51, 102, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Lista Producto"));

        labelCantidad.setText("Cantidad:");

        labelPrecio.setText("Precio:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaProducto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(labelPrecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCantidad)
                    .addComponent(labelPrecio)
                    .addComponent(textCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(296, 296, 296))
        );

        jPanel2.setBackground(new java.awt.Color(51, 0, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Detalle Factura"));

        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaDetalle);

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        labelTotalPagar.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        labelTotalPagar.setForeground(new java.awt.Color(255, 255, 255));
        labelTotalPagar.setText("Total a pagar:");

        labelDinero.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        labelDinero.setForeground(new java.awt.Color(255, 255, 255));
        labelDinero.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnQuitar)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelTotalPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDinero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnQuitar)
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelTotalPagar)
                        .addGap(18, 18, 18)
                        .addComponent(labelDinero)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Factura"));

        labelNit.setText("Nit:");

        labelNombre.setText("Nombre:");

        labelMontoTotal.setText("Monto Total:");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnObtener.setText("Obtener");
        btnObtener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerActionPerformed(evt);
            }
        });

        tablaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablaFactura);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelNit)
                                .addGap(46, 46, 46)
                                .addComponent(textNit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(labelMontoTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textNro, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnRegistrar)
                                .addGap(36, 36, 36)
                                .addComponent(btnModificar)
                                .addGap(42, 42, 42)
                                .addComponent(btnEliminar)
                                .addGap(37, 37, 37)
                                .addComponent(btnObtener)))
                        .addGap(0, 63, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNit)
                    .addComponent(labelMontoTotal)
                    .addComponent(textNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnObtener))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(labelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int fila = tablaProducto.getSelectedRow();
        Map<String, String> detalle = new LinkedHashMap<>();
        if (fila >= 0) {
            int cantidad = Integer.parseInt(textCantidad.getText());
            double precio = Double.parseDouble(textPrecio.getText());
            String codigoProducto = tablaProducto.getValueAt(fila, 0).toString();

            detalle.put("cantidad", String.valueOf(cantidad));
            detalle.put("precio", String.valueOf(precio));
            detalle.put("codigoProducto", codigoProducto);

            double total = Double.parseDouble(labelDinero.getText());
            total += precio * cantidad;
            labelDinero.setText(String.valueOf(total));

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado la fila para obtener el producto.");
        }

        AgregarDetalle(detalle);

        double valor = Double.parseDouble(labelDinero.getText());
        BigDecimal bd = new BigDecimal(valor).setScale(1, RoundingMode.HALF_UP);

        textMontoTotal.setText(String.valueOf(bd));

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int fila = tablaDetalle.getSelectedRow();
        Map<String, String> detalle = new LinkedHashMap<>();
        if (fila >= 0) {
            int cantidad = Integer.parseInt(tablaDetalle.getValueAt(fila, 0).toString());
            Double precio = Double.parseDouble(tablaDetalle.getValueAt(fila, 1).toString());
            String codigoProducto = tablaDetalle.getValueAt(fila, 2).toString();
            double valor = precio;
            detalle.put("cantidad", String.valueOf(cantidad));
            detalle.put("precio", String.valueOf(valor));
            detalle.put("codigoProducto", codigoProducto);

            double total = Double.parseDouble(labelDinero.getText());
            total -= valor * cantidad;
            labelDinero.setText(String.valueOf(total));

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado la fila para quitar el detalle.");
        }
        double valor = Double.parseDouble(labelDinero.getText());
        BigDecimal bd = new BigDecimal(valor).setScale(1, RoundingMode.HALF_UP);

        textMontoTotal.setText(String.valueOf(bd));
        QuitarDetalle(fila);
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        Map<String, String> cabecera = Cabecera();
        List<Map<String, String>> cuerpo = Cuerpo();

        negocio.setDato(cabecera);
        negocio.setDatoItems(cuerpo);

        Map<String, String> factura = negocio.Registrar();
        if (factura != null) {
            List<Map<String, String>> items = negocio.RegistrarItems(factura.get("nro"));
        }
        Actualizar(negocio.Listar());
        Limpiar();
        isAgregar = true;
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tablaFactura.getSelectedRow();
        if (fila >= 0) {
            String NroFactura = tablaFactura.getValueAt(fila, 0).toString();
            if (negocio.EliminarItems(NroFactura)) {
                negocio.Eliminar(NroFactura);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado la fila para borrar la factura.");
        }
        Actualizar(negocio.Listar());
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnObtenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerActionPerformed
        int fila = tablaFactura.getSelectedRow();
        if (fila >= 0) {
            textNro.setText(tablaFactura.getValueAt(fila, 0).toString());
            textNit.setText(tablaFactura.getValueAt(fila, 1).toString());
            textNombre.setText(tablaFactura.getValueAt(fila, 2).toString());
            textMontoTotal.setText(tablaFactura.getValueAt(fila, 4).toString());

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado la fila para obtener la factura.");
        }

        List<Map<String, String>> datos = negocio.BuscarItems(tablaFactura.getValueAt(fila, 0).toString());

        BuscarItens(datos);
    }//GEN-LAST:event_btnObtenerActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Map<String, String> cabecera = Cabecera();

        negocio.setDato(cabecera);


        Map<String, String> factura = negocio.Modificar();

        Actualizar(negocio.Listar());
    }//GEN-LAST:event_btnModificarActionPerformed

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
            java.util.logging.Logger.getLogger(PFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnObtener;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelDinero;
    private javax.swing.JLabel labelMontoTotal;
    private javax.swing.JLabel labelNit;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTotalPagar;
    private javax.swing.JTable tablaDetalle;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JTable tablaProducto;
    private javax.swing.JTextField textCantidad;
    private javax.swing.JTextField textMontoTotal;
    private javax.swing.JTextField textNit;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textNro;
    private javax.swing.JTextField textPrecio;
    // End of variables declaration//GEN-END:variables

    private void Actualizar(List<Map<String, String>> datos) {
        DefaultTableModel mode = new DefaultTableModel();
        mode.addColumn("Nro");
        mode.addColumn("Nit");
        mode.addColumn("Nombre");
        mode.addColumn("Fecha");
        mode.addColumn("Monto total");
        tablaFactura.setModel(mode);

        String dato[] = new String[5];

        for (int i = 0; i < datos.size(); i++) {
            Map<String, String> row = datos.get(i);

            dato[0] = row.getOrDefault("nro", "0");
            dato[1] = row.getOrDefault("nit", "");
            dato[2] = row.getOrDefault("nombre", "");
            dato[3] = row.getOrDefault("fecha", "");
            dato[4] = row.getOrDefault("montoTotal", "0.0");
            mode.addRow(dato);

        }
    }

    private void ListaProductos(List<Map<String, String>> datos) {
        DefaultTableModel mode = new DefaultTableModel();
        mode.addColumn("Codigo");
        mode.addColumn("Nombre");
        tablaProducto.setModel(mode);

        String dato[] = new String[2];

        for (int i = 0; i < datos.size(); i++) {
            Map<String, String> row = datos.get(i);

            dato[0] = row.getOrDefault("codigo", "0");
            dato[1] = row.getOrDefault("nombre", "");
            mode.addRow(dato);

        }
    }

    DefaultTableModel mode = new DefaultTableModel();

    private void AgregarDetalle(Map<String, String> dato) {
        if (isAgregar) {
            mode.addColumn("Cantidad");
            mode.addColumn("Precio");
            mode.addColumn("Codigo Producto");
            tablaDetalle.setModel(mode);
            isAgregar = false;
        }

        String detalle[] = new String[3];

        detalle[0] = dato.getOrDefault("cantidad", "0");
        detalle[1] = dato.getOrDefault("precio", "0.0");
        detalle[2] = dato.getOrDefault("codigoProducto", "0");
        mode.addRow(detalle);
    }

    private void QuitarDetalle(int fila) {
        mode.removeRow(fila);
    }

    private Map<String, String> Cabecera() {
        Map<String, String> dato = new LinkedHashMap();
        dato.put("nro", textNro.getText());
        dato.put("nit", textNit.getText());
        dato.put("nombre", textNombre.getText());
        dato.put("fecha", Fecha.getFecha());
        dato.put("montoTotal", textMontoTotal.getText());
        return dato;
    }

    private List<Map<String, String>> Cuerpo() {
        List<Map<String, String>> lista = new LinkedList<>();
        for (int i = 0; i < tablaDetalle.getRowCount(); i++) {
            Map<String, String> dato = new LinkedHashMap<>();
            dato.put("cantidad", tablaDetalle.getValueAt(i, 0).toString());
            dato.put("precio", tablaDetalle.getValueAt(i, 1).toString());
            dato.put("codigoProducto", tablaDetalle.getValueAt(i, 2).toString());
            lista.add(dato);
        }
        return lista;
    }

    private void Limpiar() {
        mode.setRowCount(0);
        mode.setColumnCount(0);
        textCantidad.setText("");
        textPrecio.setText("");
        textNit.setText("");
        textMontoTotal.setText("");
        textNombre.setText("");
        textNro.setText("");
    }
    
    private void BuscarItens(List<Map<String,String>> datos){
        DefaultTableModel mode = new DefaultTableModel();
        mode.addColumn("Cantidad");
        mode.addColumn("Precio");
        mode.addColumn("Codigo Producto");
        tablaDetalle.setModel(mode);

        String detalle[] = new String[3];
        for (int i = 0; i < datos.size(); i++) {
            Map<String, String> dato = datos.get(i);
            detalle[0] = dato.getOrDefault("cantidad", "0");
            detalle[1] = dato.getOrDefault("precio", "0.0");
            detalle[2] = dato.getOrDefault("codigoProducto", "0");
            mode.addRow(detalle);
        }
    }
}
