
package Interfaces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel
 */
public class Envios extends javax.swing.JDialog {
    static Archivos.Salida producto;
    static Calculos.Cajas caja;
    static Archivos.SalidaCajas cajas;
    
    
    public Envios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pedido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultado = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        enviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ENVIOS");
        setMaximumSize(new java.awt.Dimension(700, 500));
        setMinimumSize(new java.awt.Dimension(700, 500));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nº Pedido");

        resultado.setColumns(20);
        resultado.setRows(5);
        resultado.setMaximumSize(new java.awt.Dimension(690, 400));
        resultado.setMinimumSize(new java.awt.Dimension(690, 400));
        jScrollPane1.setViewportView(resultado);

        jButton1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton1.setText("CONSULTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        enviar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        enviar.setText("ENVIAR");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(enviar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * evento de consulta de pedido
     * 
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Imprime();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * evento de envío de pedido
     * @param evt 
     */
    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
       if(Enviar())
       {
           BufferedWriter escribir;
           try {
               escribir = new BufferedWriter(new FileWriter("src/Datos/envios.txt",true));
               escribir.write(pedido.getText());
               escribir.newLine(); //salto de linea
               escribir.close();
               JOptionPane aviso = new JOptionPane();
               JOptionPane.showMessageDialog(aviso, "PEDIDO ENVIADO", "Aviso", JOptionPane.INFORMATION_MESSAGE);
               pedido.setText("");
               resultado.setText("");
           } catch (IOException ex) {
               System.out.println("error");
           }
           
       
       }
       else
       {
          
       }
        
    }//GEN-LAST:event_enviarActionPerformed
    
    /**
     * Imprime en pantalla el pedido que introduce el usuario
     */
    public static void Imprime()
    {
        String pedidos = pedido.getText();
        int num = Integer.parseInt(pedidos); //numero de pedido
       
        cajas = new Archivos.SalidaCajas();
        int lar = 0,anch = 0,alt = 0;
        int n = 0;
        int numeroCaja = 0;
        int unidadesCajas = 0;
        try{
        producto = new Archivos.Salida(num); //productos
        
        
        try {
             
            resultado.setText(""); //en cada consulta de pedido nuevo limpia la pantalla
            resultado.append("-------------------------PEDIDO Nº: "+num+"-----------------------------\n");
            while(true)
            {
                resultado.append("  Producto nº: "+n+"\n  Descripcion: "+producto.DescripcionPedido(n)+"\n    Alto: "+producto.altura()+"   Ancho: "+producto.anchura()+" Largo: "+producto.largura()+ "\n  Cantidad: "+producto.cantidad()+"\n");
                n++;
            }
          
        } catch (IOException ex) {
            
            resultado.append("----------------------- FIN PEDIDO -------------------------------");
        }
        }catch (FileNotFoundException ex) {
            JOptionPane aviso = new JOptionPane();
            JOptionPane.showMessageDialog(aviso, "NO EXISTE EL PEDIDO CONSULTADO", "Aviso", JOptionPane.ERROR_MESSAGE);
            resultado.setText("");
        }
    }
    
    /**
     * calcula el numero de cajas necesarias para el envío
     */
    public static void CalculoCajas()
    {
        String pedidos = pedido.getText();
        int num = Integer.parseInt(pedidos); //numero de pedido
        //producto = new Archivos.Salida(num); //productos
        cajas = new Archivos.SalidaCajas();
        
        
    
    }
    
    /**
     * Guarda en fichero el numero de pedido enviado
     */
    public static boolean Enviar()
    {
        try {
            
            BufferedReader leer = new BufferedReader(new FileReader("src/Datos/envios.txt"));
            
            
            while(leer.ready())
            {
                
                if(leer.readLine().equals(pedido.getText()))
                {
                    JOptionPane aviso = new JOptionPane();
                    JOptionPane.showMessageDialog(aviso, "EL PEDIDO NUMERO "+pedido.getText()+" YA HA SIDO ENVIADO", "Aviso", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                
            }
            
            
            
        } catch (IOException ex) {
            JOptionPane aviso = new JOptionPane();
            JOptionPane.showMessageDialog(aviso, "NO ENCUENTRA EL ARCHIVO", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
           
            
         return true;

    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enviar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextField pedido;
    private static javax.swing.JTextArea resultado;
    // End of variables declaration//GEN-END:variables
}
