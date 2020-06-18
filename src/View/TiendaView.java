package View;

import Excepciones.ArticuloNoEncontradoException;
import Excepciones.ListaArticulosLlenaException;
import Excepciones.ListaArticulosVaciaException;
import Excepciones.ListaPaquetesLlenaException;
import Excepciones.ListaPaquetesVaciaException;
import Excepciones.PaqueteNoEncontradoException;
import Model.Cliente.Cliente;
import Model.Tienda.Tienda;
import Patrones.Decorator.Articulo;
import Patrones.Decorator.Paquete;
import Patrones.Iterator.Iterator;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author VICTOR
 */
public class TiendaView extends javax.swing.JFrame {

    private Tienda tienda;
    private Cliente cliente;
    private CentroComercialView centroComercialView;

    /**
     * Creates new form MenuPrincipal
     */
    public TiendaView(Tienda tienda, Cliente cliente, CentroComercialView centroComercialView) {
        this.tienda = tienda;
        this.cliente = cliente;
        this.centroComercialView = centroComercialView;

        //Realización de la entrada del cliente a la tienda.
        tienda.entrar(cliente);
        
        initComponents();
        this.setLocationRelativeTo(null);

        //Inicialización de los elementos de la vista.
        nombreTiendaLabel.setText(tienda.getNombre());
        añadirArticuloButton.setEnabled(false);
        eliminarArticuloButton.setEnabled(false);
        añadirPaqueteButton.setEnabled(false);
        eliminarPaqueteButton.setEnabled(false);

        mostrarArticulos();
        mostrarPaquetes();
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        articulosTable = new javax.swing.JTable();
        regresarButton = new javax.swing.JButton();
        nombreTiendaLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        paquetesTable = new javax.swing.JTable();
        instruccionesLabel = new javax.swing.JLabel();
        añadirPaqueteButton = new javax.swing.JButton();
        eliminarPaqueteButton = new javax.swing.JButton();
        eliminarArticuloButton = new javax.swing.JButton();
        añadirArticuloButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(252, 86, 50));

        articulosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Articulo", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        articulosTable.getTableHeader().setReorderingAllowed(false);
        articulosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                articulosTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(articulosTable);
        if (articulosTable.getColumnModel().getColumnCount() > 0) {
            articulosTable.getColumnModel().getColumn(0).setResizable(false);
            articulosTable.getColumnModel().getColumn(0).setPreferredWidth(550);
            articulosTable.getColumnModel().getColumn(1).setResizable(false);
            articulosTable.getColumnModel().getColumn(1).setPreferredWidth(77);
        }

        regresarButton.setText("Regresar");
        regresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarButtonActionPerformed(evt);
            }
        });

        nombreTiendaLabel.setBackground(new java.awt.Color(252, 86, 50));
        nombreTiendaLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        nombreTiendaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreTiendaLabel.setText("CentroFMAT");

        paquetesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paquete", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        paquetesTable.getTableHeader().setReorderingAllowed(false);
        paquetesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paquetesTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(paquetesTable);
        if (paquetesTable.getColumnModel().getColumnCount() > 0) {
            paquetesTable.getColumnModel().getColumn(0).setResizable(false);
            paquetesTable.getColumnModel().getColumn(0).setPreferredWidth(550);
            paquetesTable.getColumnModel().getColumn(1).setResizable(false);
            paquetesTable.getColumnModel().getColumn(1).setPreferredWidth(77);
        }

        instruccionesLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        instruccionesLabel.setText("Seleccione una articulo/paquete y presione el botón \"Añadir a carrito\" o \"Eliminar de carrito\":");

        añadirPaqueteButton.setText("Añadir a carrito");
        añadirPaqueteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirPaqueteButtonActionPerformed(evt);
            }
        });

        eliminarPaqueteButton.setText("Eliminar de carrito");
        eliminarPaqueteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPaqueteButtonActionPerformed(evt);
            }
        });

        eliminarArticuloButton.setText("Eliminar de carrito");
        eliminarArticuloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarArticuloButtonActionPerformed(evt);
            }
        });

        añadirArticuloButton.setText("Añadir a carrito");
        añadirArticuloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirArticuloButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(añadirArticuloButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(eliminarArticuloButton, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(regresarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(añadirPaqueteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(eliminarPaqueteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(instruccionesLabel)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(nombreTiendaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreTiendaLabel)
                .addGap(9, 9, 9)
                .addComponent(instruccionesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarArticuloButton)
                    .addComponent(añadirArticuloButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regresarButton)
                    .addComponent(añadirPaqueteButton)
                    .addComponent(eliminarPaqueteButton))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed
        tienda.salir(cliente);
        dispose();
        centroComercialView.setVisible(true);
    }//GEN-LAST:event_regresarButtonActionPerformed

    private void articulosTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_articulosTableMouseClicked
        articuloSeleccionadoIndex = articulosTable.getSelectedRow();
        añadirArticuloButton.setEnabled(true);
        eliminarArticuloButton.setEnabled(true);
    }//GEN-LAST:event_articulosTableMouseClicked

    private void paquetesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paquetesTableMouseClicked
        paqueteSeleccionadoIndex = paquetesTable.getSelectedRow();
        añadirPaqueteButton.setEnabled(true);
        eliminarPaqueteButton.setEnabled(true);
    }//GEN-LAST:event_paquetesTableMouseClicked

    private void añadirPaqueteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirPaqueteButtonActionPerformed
        Iterator paquetesIterator = tienda.getPaquetesIterator();

        int counter = 0;
        while (paquetesIterator.hasNext() && counter <= paqueteSeleccionadoIndex) {
            Paquete paquete = (Paquete) paquetesIterator.next();
            if (counter == paqueteSeleccionadoIndex) {
                try {
                    tienda.addPaqueteACarrito(cliente.getCarritoCompras(), paquete);
                    JOptionPane.showMessageDialog(null, "*El paquete ha sido añadido al carrito con éxito.", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
                } catch (ListaPaquetesLlenaException ex) {
                    JOptionPane.showMessageDialog(null, "El carrito de compras está lleno (capacidad máxima: 25 productos).", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            }
            counter++;
        }
    }//GEN-LAST:event_añadirPaqueteButtonActionPerformed

    private void eliminarPaqueteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPaqueteButtonActionPerformed
        Iterator paquetesIterator = tienda.getPaquetesIterator();

        int counter = 0;
        while (paquetesIterator.hasNext() && counter <= paqueteSeleccionadoIndex) {
            Paquete paquete = (Paquete) paquetesIterator.next();
            if (counter == paqueteSeleccionadoIndex) {
                try {
                    tienda.removePaqueteDeCarrito(cliente.getCarritoCompras(), paquete);
                    JOptionPane.showMessageDialog(null, "*El paquete ha sido eliminado del carrito con éxito.", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
                } catch (ListaPaquetesVaciaException | PaqueteNoEncontradoException ex) {
                    JOptionPane.showMessageDialog(null, "El carrito está vacío o el paquete no se encuentra en él.", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            }
            counter++;
        }
    }//GEN-LAST:event_eliminarPaqueteButtonActionPerformed

    private void eliminarArticuloButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarArticuloButtonActionPerformed
        Iterator articulosIterator = tienda.getArticulosIterator();

        int counter = 0;
        while (articulosIterator.hasNext() && counter <= articuloSeleccionadoIndex) {
            Articulo articulo = (Articulo) articulosIterator.next();
            if (counter == articuloSeleccionadoIndex) {
                try {
                    tienda.removeArticuloDeCarrito(cliente.getCarritoCompras(), articulo);
                    JOptionPane.showMessageDialog(null, "*El articulo ha sido eliminado del carrito con éxito.", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
                } catch (ListaArticulosVaciaException | ArticuloNoEncontradoException ex) {
                    JOptionPane.showMessageDialog(null, "El carrito está vacío o el artículo no se encuentra en él.", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            }
            counter++;
        }
    }//GEN-LAST:event_eliminarArticuloButtonActionPerformed

    private void añadirArticuloButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirArticuloButtonActionPerformed
        Iterator articulosIterator = tienda.getArticulosIterator();

        int counter = 0;
        while (articulosIterator.hasNext() && counter <= articuloSeleccionadoIndex) {
            Articulo articulo = (Articulo) articulosIterator.next();
            if (counter == articuloSeleccionadoIndex) {
                try {
                    tienda.addArticuloACarrito(cliente.getCarritoCompras(), articulo);
                    JOptionPane.showMessageDialog(null, "*El articulo ha sido añadido al carrito con éxito.", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
                } catch (ListaArticulosLlenaException ex) {
                    JOptionPane.showMessageDialog(null, "El carrito de compras está lleno (capacidad máxima: 25 productos).", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            }
            counter++;
        }

    }//GEN-LAST:event_añadirArticuloButtonActionPerformed

    public void mostrarArticulos() {
        String tabla[][] = new String[tienda.getArticulos().size()][2];

        Iterator articulosIterator = tienda.getArticulosIterator();
        int i = 0;
        while (articulosIterator.hasNext()) {
            Articulo articulo = (Articulo) articulosIterator.next();
            tabla[i][0] = articulo.getNombre();
            tabla[i][1] = "$" + String.format("%.2f", articulo.getPrecio());
            i++;
        }

        articulosTable.setModel(new javax.swing.table.DefaultTableModel(
                tabla,
                new String[]{
                    "Articulo", "Precio"}
        ));
    }

    public void mostrarPaquetes() {
        String tabla[][] = new String[tienda.getPaquetes().size()][2];

        Iterator paquetesIterator = tienda.getPaquetesIterator();
        int i = 0;
        while (paquetesIterator.hasNext()) {
            Paquete paquete = (Paquete) paquetesIterator.next();
            tabla[i][0] = paquete.getNombre();
            tabla[i][1] = "$" + String.format("%.2f", paquete.getPrecio());
            i++;
        }

        paquetesTable.setModel(new javax.swing.table.DefaultTableModel(
                tabla,
                new String[]{
                    "Paquete", "Precio"}
        ));
    }

    private int articuloSeleccionadoIndex = -1;
    private int paqueteSeleccionadoIndex = -1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable articulosTable;
    public javax.swing.JButton añadirArticuloButton;
    public javax.swing.JButton añadirPaqueteButton;
    public javax.swing.JButton eliminarArticuloButton;
    public javax.swing.JButton eliminarPaqueteButton;
    public javax.swing.JLabel instruccionesLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel nombreTiendaLabel;
    public javax.swing.JTable paquetesTable;
    public javax.swing.JButton regresarButton;
    // End of variables declaration//GEN-END:variables
}
