
package Interfaces;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Clase principal con método main
 * @author Ángel Nácar
 */
public class Menu extends javax.swing.JFrame {

    
    public Menu() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        altas = new javax.swing.JMenu();
        embalajes = new javax.swing.JMenuItem();
        productos = new javax.swing.JMenuItem();
        pedidos = new javax.swing.JMenuItem();
        consultas = new javax.swing.JMenu();
        consultar = new javax.swing.JMenuItem();
        envios = new javax.swing.JMenu();
        enviar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU");
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setForeground(new java.awt.Color(0, 153, 204));

        altas.setText("ALTAS");
        altas.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        embalajes.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        embalajes.setText("EMBALAJES");
        embalajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                embalajesActionPerformed(evt);
            }
        });
        altas.add(embalajes);

        productos.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        productos.setText("PRODUCTOS");
        productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosActionPerformed(evt);
            }
        });
        altas.add(productos);

        pedidos.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        pedidos.setText("PEDIDOS");
        pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosActionPerformed(evt);
            }
        });
        altas.add(pedidos);

        jMenuBar1.add(altas);

        consultas.setText("CONSULTAS");
        consultas.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        consultar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        consultar.setText("CONSULTAR");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        consultas.add(consultar);

        jMenuBar1.add(consultas);

        envios.setText("ENVIOS");
        envios.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        enviar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        enviar.setText("ENVIAR");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });
        envios.add(enviar);

        jMenuBar1.add(envios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void embalajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_embalajesActionPerformed
       Embalajes embalaje = new Embalajes(this,true);
       embalaje.setVisible(true);
        
    }//GEN-LAST:event_embalajesActionPerformed

    private void productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosActionPerformed
        Productos producto = new Productos(this,true);
        producto.setVisible(true);
    }//GEN-LAST:event_productosActionPerformed

    private void pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosActionPerformed
        Pedidos pedido;
        try {
            pedido = new Pedidos(this,true);
            pedido.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_pedidosActionPerformed

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        Consultas consulta = new Consultas(this,true);
        consulta.setVisible(true);
    }//GEN-LAST:event_consultarActionPerformed

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        Envios envio = new Envios(this,true);
        envio.setVisible(true);
    }//GEN-LAST:event_enviarActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu altas;
    private javax.swing.JMenuItem consultar;
    private javax.swing.JMenu consultas;
    private javax.swing.JMenuItem embalajes;
    private javax.swing.JMenuItem enviar;
    private javax.swing.JMenu envios;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem pedidos;
    private javax.swing.JMenuItem productos;
    // End of variables declaration//GEN-END:variables
}
