package View;

import Excepciones.ListaArticulosLlenaException;
import Excepciones.ListaPaquetesLlenaException;
import Model.CentroComercial.CentroComercial;
import Model.Cliente.Cliente;
import Model.Tienda.Libreria;
import Model.Tienda.Tienda;
import Model.Tienda.Zapateria;
import Patrones.AbstractFactory.FactorySucursal;
import Patrones.AbstractFactory.FactorySucursalGrande;
import Patrones.AbstractFactory.FactorySucursalPequeña;
import Patrones.Decorator.Articulo;
import Patrones.Iterator.Iterator;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rafa_
 */
public class CentroComercialView extends javax.swing.JFrame {

    private CentroComercial centroComercial;
    private Cliente cliente;

    /**
     * Creates new form MenuPrincipal
     */
    public CentroComercialView() {
        this.setResizable(false);

        //Creación del centro comercial y de los clientes dentro.
        centroComercial = new CentroComercial("Comercial FMAT");
        centroComercial.entrar(new Cliente("Rafael Canto Vázquez"));
        centroComercial.entrar(new Cliente("Pedro Cruz de la Fuente"));

        //Creación del usuario (cliente) que utiliza el sistema.
        cliente = new Cliente("Edgar Aguilar Moguel");
        centroComercial.entrar(cliente);

        //Creación de los articulos de las tiendas del centro comercial.
        Articulo zapato1 = new Articulo("Vandana 857", "612203", 750);
        Articulo zapato2 = new Articulo("Flexi 402801", "629581", 900);
        Articulo zapato3 = new Articulo("CUSTOM STYLE 5017", "633896", 545);
        Articulo zapato4 = new Articulo("CHRISTIAN GALLERY 2116", "374723", 1220);
        Articulo zapato5 = new Articulo("Vertical 5193", "374722", 1400);
        Articulo zapato6 = new Articulo("Nike Air Max 90", "837231", 2899);
        Articulo zapato7 = new Articulo("Kyrie 6", "471293", 2799);
        Articulo zapato8 = new Articulo("Nike React Vision", "831828", 2599);
        Articulo zapato9 = new Articulo("Jordan ADG 2", "194828", 3299);
        Articulo zapato10 = new Articulo("Nike Blazer Low Leather", "437242", 1799);
        Articulo zapato11 = new Articulo("Nike CruzrOne", "437241", 2999);
        Articulo zapato12 = new Articulo("Air Jordan XXXIV Low", "423142", 13499);
        Articulo zapato13 = new Articulo("Jordan Break", "453422", 799);
        Articulo libro1 = new Articulo("Poseidon", "129391", 335);
        Articulo libro2 = new Articulo("Pedro Páramo", "821732", 250);
        Articulo libro3 = new Articulo("Confabulario", "319232", 290);
        Articulo libro4 = new Articulo("Diablo Guardián", "248182", 175);
        Articulo libro5 = new Articulo("Las batallas en el desierto", "912942", 510);
        Articulo libro6 = new Articulo("Harry Potter y la piedra filosofal", "418284", 350);
        Articulo libro7 = new Articulo("Harry Potter y las reliquias de la muerte", "328427", 400);
        Articulo libro8 = new Articulo("El Código da Vinci", "527238", 420);
        Articulo libro9 = new Articulo("Lo que el viento se llevó", "526363", 530);
        Articulo libro10 = new Articulo("El Alquimista", "457223", 280);
        Articulo libro11 = new Articulo("Don Quijote de la Mancha", "922831", 270);
        Articulo libro12 = new Articulo("Historia de dos ciudades", "331823", 600);
        Articulo libro13 = new Articulo("El señor de los Anillos", "922372", 575);

        //Creación de los paquetes de las tiendas del centro comercial.   
        ArrayList<Articulo> listaZapatos1 = new ArrayList<>();
        listaZapatos1.add(zapato1);
        listaZapatos1.add(zapato2);
        listaZapatos1.add(zapato3);
        ArrayList<Articulo> listaZapatos2 = new ArrayList<>();
        listaZapatos2.add(zapato6);
        listaZapatos2.add(zapato7);
        ArrayList<Articulo> listaZapatos3 = new ArrayList<>();
        listaZapatos3.add(zapato10);
        listaZapatos3.add(zapato13);
        ArrayList<Articulo> listaLibros1 = new ArrayList<>();
        listaLibros1.add(libro1);
        listaLibros1.add(libro5);
        ArrayList<Articulo> listaLibros2 = new ArrayList<>();
        listaLibros2.add(libro8);
        listaLibros2.add(libro10);
        listaLibros2.add(libro13);

        //Creacion de las sucursales (tiendas) del centro comercial.
        FactorySucursal factorySucursal = new FactorySucursalPequeña();
        Zapateria zapateria = factorySucursal.createZapateria();
        Libreria libreria = factorySucursal.createLibreria();

        zapateria.setNombre("Zapateria Impuls");
        zapateria.addObservador(centroComercial);
        try {
            zapateria.addArticulo(zapato1);
            zapateria.addArticulo(zapato2);
            zapateria.addArticulo(zapato3);
            zapateria.addArticulo(zapato4);
            zapateria.addArticulo(zapato5);
            zapateria.addPaquete(zapateria.crearPaquete(listaZapatos1, .25));
        } catch (ListaArticulosLlenaException ex) {
            JOptionPane.showMessageDialog(null, "La lista de articulos de la tienda está llena.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ListaPaquetesLlenaException ex) {
            JOptionPane.showMessageDialog(null, "La lista de paquetes de la tienda está llena.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        libreria.setNombre("Librería \"Porrúa\"");
        libreria.addObservador(centroComercial);
        try {
            libreria.addArticulo(libro1);
            libreria.addArticulo(libro2);
            libreria.addArticulo(libro3);
            libreria.addArticulo(libro4);
            libreria.addArticulo(libro5);
            libreria.addPaquete(libreria.crearPaquete(listaLibros1, .50));
        } catch (ListaArticulosLlenaException ex) {
            JOptionPane.showMessageDialog(null, "La lista de articulos de la tienda está llena.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ListaPaquetesLlenaException ex) {
            JOptionPane.showMessageDialog(null, "La lista de paquetes de la tienda está llena.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        centroComercial.addTienda(zapateria);
        centroComercial.addTienda(libreria);

        factorySucursal = new FactorySucursalGrande();
        zapateria = factorySucursal.createZapateria();
        libreria = factorySucursal.createLibreria();

        zapateria.setNombre("Zapatería NIKE");
        zapateria.addObservador(centroComercial);
        try {
            zapateria.addArticulo(zapato6);
            zapateria.addArticulo(zapato7);
            zapateria.addArticulo(zapato8);
            zapateria.addArticulo(zapato9);
            zapateria.addArticulo(zapato10);
            zapateria.addArticulo(zapato11);
            zapateria.addArticulo(zapato12);
            zapateria.addArticulo(zapato13);
            zapateria.addPaquete(zapateria.crearPaquete(listaZapatos2, .15));
            zapateria.addPaquete(zapateria.crearPaquete(listaZapatos3, .65));
        } catch (ListaArticulosLlenaException ex) {
            JOptionPane.showMessageDialog(null, "La lista de articulos de la tienda está llena.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ListaPaquetesLlenaException ex) {
            JOptionPane.showMessageDialog(null, "La lista de paquetes de la tienda está llena.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        libreria.setNombre("Librería Gandhi");
        libreria.addObservador(centroComercial);
        try {
            libreria.addArticulo(libro6);
            libreria.addArticulo(libro7);
            libreria.addArticulo(libro8);
            libreria.addArticulo(libro9);
            libreria.addArticulo(libro10);
            libreria.addArticulo(libro11);
            libreria.addArticulo(libro12);
            libreria.addArticulo(libro13);
            libreria.addPaquete(libreria.crearPaquete(listaLibros2, .10));
        } catch (ListaArticulosLlenaException ex) {
            JOptionPane.showMessageDialog(null, "La lista de articulos de la tienda está llena.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ListaPaquetesLlenaException ex) {
            JOptionPane.showMessageDialog(null, "La lista de paquetes de la tienda está llena.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        centroComercial.addTienda(zapateria);
        centroComercial.addTienda(libreria);

        initComponents();
        this.setLocationRelativeTo(null);

        //Inicialización de los elementos de la vista.
        nombreClienteLabel.setText("Has ingresado como: " + cliente.getNombre());
        pagarCarritoComprasButton.setEnabled(false);
        eliminarCarritoComprasButton.setEnabled(false);
        ingresarTiendaButton.setEnabled(false);
        notificacionesTable.setEnabled(false);
        
        mostrarTiendas();
        mostrarNotificaciones();
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
        tiendasScrollPane = new javax.swing.JScrollPane();
        tiendasTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        solicitarCarritoComprasButton = new javax.swing.JButton();
        pagarCarritoComprasButton = new javax.swing.JButton();
        ingresarTiendaButton = new javax.swing.JButton();
        notificacionesScrollPane = new javax.swing.JScrollPane();
        notificacionesTable = new javax.swing.JTable();
        eliminarCarritoComprasButton = new javax.swing.JButton();
        nombreClienteLabel = new javax.swing.JLabel();
        instruccionesLabel = new javax.swing.JLabel();
        nombreCentroComercialLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(252, 86, 50));

        tiendasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tiendas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tiendasTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tiendasTableMouseClicked(evt);
            }
        });
        tiendasScrollPane.setViewportView(tiendasTable);

        jLabel3.setBackground(new java.awt.Color(252, 86, 50));
        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel3.setText("Carrito de Compras");

        solicitarCarritoComprasButton.setText("Solicitar carrito de compras");
        solicitarCarritoComprasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitarCarritoComprasButtonActionPerformed(evt);
            }
        });

        pagarCarritoComprasButton.setText("Ver/Pagar carrito de compras");
        pagarCarritoComprasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarCarritoComprasButtonActionPerformed(evt);
            }
        });

        ingresarTiendaButton.setText("Ingresar a Tienda");
        ingresarTiendaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarTiendaButtonActionPerformed(evt);
            }
        });

        notificacionesTable.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        notificacionesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Notificaciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        notificacionesScrollPane.setViewportView(notificacionesTable);

        eliminarCarritoComprasButton.setText("Eliminar carrito de compras");
        eliminarCarritoComprasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCarritoComprasButtonActionPerformed(evt);
            }
        });

        nombreClienteLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        nombreClienteLabel.setText("Has ingresado como:");

        instruccionesLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        instruccionesLabel.setText("Seleccione una tienda y presione el botón \"Ingresar a Tienda\":");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel3)
                                .addGap(86, 86, 86))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(solicitarCarritoComprasButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pagarCarritoComprasButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eliminarCarritoComprasButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(72, 72, 72)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notificacionesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreClienteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tiendasScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(instruccionesLabel)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(603, 603, 603)
                                .addComponent(ingresarTiendaButton)))))
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(nombreClienteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notificacionesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(solicitarCarritoComprasButton)
                        .addGap(18, 18, 18)
                        .addComponent(pagarCarritoComprasButton)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarCarritoComprasButton)))
                .addGap(10, 10, 10)
                .addComponent(instruccionesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(tiendasScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ingresarTiendaButton)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        nombreCentroComercialLabel.setBackground(new java.awt.Color(252, 86, 50));
        nombreCentroComercialLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        nombreCentroComercialLabel.setForeground(new java.awt.Color(255, 255, 255));
        nombreCentroComercialLabel.setText("Centro FMAT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nombreCentroComercialLabel)
                .addGap(254, 254, 254))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreCentroComercialLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(13, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pagarCarritoComprasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarCarritoComprasButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagarCarritoComprasButtonActionPerformed

    private void ingresarTiendaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarTiendaButtonActionPerformed
        if (selectedRowIndex != -1 && cliente.getCarritoCompras() != null) {
            Iterator tiendasIterator = centroComercial.getTiendasIterator();
            Tienda tienda = null;
            int counter = 0;
            while (tiendasIterator.hasNext() && counter < selectedRowIndex) {
                tienda = (Tienda) tiendasIterator.next();
            }
            new TiendaView(tienda, cliente, this).setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_ingresarTiendaButtonActionPerformed

    private void tiendasTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tiendasTableMouseClicked
        selectedRowIndex = tiendasTable.getSelectedRow();
        if (cliente.getCarritoCompras() != null && selectedRowIndex >= 0) {
            ingresarTiendaButton.setEnabled(true);
        } else {
            ingresarTiendaButton.setEnabled(false);
        }
    }//GEN-LAST:event_tiendasTableMouseClicked

    private void solicitarCarritoComprasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solicitarCarritoComprasButtonActionPerformed
        cliente.setCarritoCompras(centroComercial.getCarrito());
        pagarCarritoComprasButton.setEnabled(true);
        eliminarCarritoComprasButton.setEnabled(true);
        if (selectedRowIndex >= 0) {
            ingresarTiendaButton.setEnabled(true);
        } else {
            ingresarTiendaButton.setEnabled(false);
        }
    }//GEN-LAST:event_solicitarCarritoComprasButtonActionPerformed

    private void eliminarCarritoComprasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarCarritoComprasButtonActionPerformed
        centroComercial.cancelarCarrito(cliente);
        pagarCarritoComprasButton.setEnabled(false);
        eliminarCarritoComprasButton.setEnabled(false);
        ingresarTiendaButton.setEnabled(false);
    }//GEN-LAST:event_eliminarCarritoComprasButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CentroComercialView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CentroComercialView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CentroComercialView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CentroComercialView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CentroComercialView().setVisible(true);
            }
        });
    }

    public void mostrarTiendas() {
        String tabla[][] = new String[centroComercial.getTiendas().size()][1];

        Iterator tiendasIterator = centroComercial.getTiendasIterator();
        int i = 0;
        while (tiendasIterator.hasNext()) {
            Tienda tienda = (Tienda) tiendasIterator.next();
            tabla[i][0] = tienda.getNombre();
            i++;
        }

        tiendasTable.setModel(new javax.swing.table.DefaultTableModel(
                tabla,
                new String[]{
                    "Tiendas",}
        ));
    }

    public void mostrarNotificaciones() {
        String tabla[][] = new String[cliente.getNotificaciones().size()][1];

        ArrayList<String> notificaciones = cliente.getNotificaciones();

        for (int i = 0; i < notificaciones.size(); i++) {
            tabla[i][0] = notificaciones.get(i);
        }

        notificacionesTable.setModel(new javax.swing.table.DefaultTableModel(
                tabla,
                new String[]{
                    "Notificaciones",}
        ));
    }

    private int selectedRowIndex = -1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton eliminarCarritoComprasButton;
    public javax.swing.JButton ingresarTiendaButton;
    public javax.swing.JLabel instruccionesLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel nombreCentroComercialLabel;
    public javax.swing.JLabel nombreClienteLabel;
    private javax.swing.JScrollPane notificacionesScrollPane;
    public javax.swing.JTable notificacionesTable;
    public javax.swing.JButton pagarCarritoComprasButton;
    public javax.swing.JButton solicitarCarritoComprasButton;
    private javax.swing.JScrollPane tiendasScrollPane;
    public javax.swing.JTable tiendasTable;
    // End of variables declaration//GEN-END:variables
}
