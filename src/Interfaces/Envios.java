
package Interfaces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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
    static int unidadesCajas = 0;
    static ArrayList<Archivos.Salida> listaProductos;
    static ArrayList<Archivos.SalidaCajas> listaCajas;
    
    
    public Envios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cajas = new Archivos.SalidaCajas(); //inicializa objeto caja
        listaCajas = new ArrayList();
        listaCajas.add(cajas); 
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
       try
       {
        Imprime();
       }catch(NumberFormatException e)
       {
           JOptionPane aviso = new JOptionPane();
          JOptionPane.showMessageDialog(aviso, "INTRODUZCA UN NUMERO DE PEDIDO", "Aviso", JOptionPane.WARNING_MESSAGE);
       }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * evento de envío de pedido
     * @param evt 
     */
    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
       
        if(ComprobarPedido())
         {
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
               CalculoCajas();
               pedido.setText("");
               resultado.setText("");
           } catch (IOException ex) {
               System.out.println("error");
           }
           
           }
            else
            {
                JOptionPane aviso = new JOptionPane();
                JOptionPane.showMessageDialog(aviso, "EL PEDIDO NUMERO "+pedido.getText()+" YA HA SIDO ENVIADO", "Aviso", JOptionPane.ERROR_MESSAGE);
                pedido.setText("");
                resultado.setText("");
            }
       }
       else
       {
          JOptionPane aviso = new JOptionPane();
          JOptionPane.showMessageDialog(aviso, "NO PUEDE ENVIAR UN PEDIDO QUE NO EXISTE", "Aviso", JOptionPane.ERROR_MESSAGE);
          pedido.setText("");
          resultado.setText("");
          
       }
        
    }//GEN-LAST:event_enviarActionPerformed
    
    /**
     * Imprime en pantalla el pedido que introduce el usuario
     */
    public static void Imprime() throws NumberFormatException
    {
        String pedidos = pedido.getText();
        int num = Integer.parseInt(pedidos); //numero de pedido, inicializa el pedido que pasa el usuario
        int n = 0;
        try{
        producto = new Archivos.Salida(num); //productos
        listaProductos = new ArrayList();
        listaProductos.add(producto); //guarda en un array el pedido que se va a enviar
        
        try {
             
            resultado.setText(""); //en cada consulta de pedido nuevo limpia la pantalla
            resultado.append("-------------------------PEDIDO Nº: "+num+"-----------------------------\n");
            while(true)
            {
                resultado.append("  Producto nº: "+n+"\n  Descripcion: "+producto.DescripcionPedido(n)+"\n    Alto: "+producto.altura()+"   Ancho: "+producto.anchura()+" Largo: "+producto.largura()+ "\n  Cantidad: "+producto.cantidad()+"\n");
                unidadesCajas+= Integer.parseInt(producto.cantidad().trim());
                n++;
            }
          
        } catch (IOException ex) { //finaliza la lectura del archivo
            
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
       int n = 0;
       
       int contadorNumerico =0;
        String contador = listaProductos.get(0).cantidad();
        contadorNumerico = Integer.parseInt(contador.trim());
       
           
           int caja = 0;
           int producto = 0;
           int unidadesCajas = 1; //controla el numero de cajas de la misma medida
       
           while(unidadesCajas > 0)
               {
                   
           try {
               listaCajas.get(0).Construye(caja);
                    try{
               
               listaProductos.get(0).DescripcionPedido(producto);
               
               if(Integer.parseInt(listaProductos.get(0).altura().trim()) <= Integer.parseInt(listaCajas.get(0).altura().trim()) && Integer.parseInt(listaProductos.get(0).anchura().trim())*Integer.parseInt(listaProductos.get(0).cantidad().trim()) <= Integer.parseInt(listaCajas.get(0).anchura().trim()) && Integer.parseInt(listaProductos.get(0).largura().trim())*Integer.parseInt(listaProductos.get(0).cantidad().trim()) <= Integer.parseInt(listaCajas.get(0).largura().trim()))
                           {
                               System.out.println("NECESITA "+unidadesCajas+ " CAJAS CON: ALTURA: "+listaCajas.get(0).altura()+" ANCHURA: "+listaCajas.get(0).anchura()+" LARGO "+listaCajas.get(0).largura());
                               System.out.println("PRODUCTO "+listaProductos.get(0).DescripcionPedido(producto)+" ALTURA "+listaProductos.get(0).altura()+" ANCHURA "+listaProductos.get(0).anchura()+" LARGO "+listaProductos.get(0).largura()+" CANTIDAD "+listaProductos.get(0).cantidad());
                               producto++;
                               listaProductos.get(0).DescripcionPedido(producto);
                               unidadesCajas--;
                               
                              
                               
                           }
                           else 
                           {
                               caja++;
                               //listaCajas.get(0).Construye(caja);
                                //System.out.println("NO LO ES");
                               //System.out.println("NECESITA "+unidadesCajas+ " CAJAS CON: ALTURA: "+listaCajas.get(0).altura()+" ANCHURA: "+listaCajas.get(0).anchura()+" LARGO "+listaCajas.get(0).largura());
                              // System.out.println("PRODUCTO "+listaProductos.get(0).DescripcionPedido(producto)+" ALTURA "+listaProductos.get(0).altura()+" ANCHURA "+listaProductos.get(0).anchura()+" LARGO "+listaProductos.get(0).largura()+" CANTIDAD "+listaProductos.get(0).cantidad());
                                //unidadesCajas++;
                                
                           }
               
           } catch (IOException ex) {
               //caja = 0;
               //producto = 0;
               System.out.println("PETA PRODUCTOS");
              break;
              
           }
           }catch(IOException e)
           {
           System.out.println("PETA CAJAS");
           break;
              
           }
           
              }
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
                    
                    return false;
                }
                
            }
            
            
            
        } catch (IOException ex) {
            JOptionPane aviso = new JOptionPane();
            JOptionPane.showMessageDialog(aviso, "NO ENCUENTRA EL ARCHIVO", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
           
            
         return true;

    }
    
    /**
     * Comprueba que exista el pedido a enviar
     * @return 
     */
    public static boolean ComprobarPedido()
    {
        try {
            BufferedReader leer2 = new BufferedReader(new FileReader("src/Datos/pedidos.txt"));
            
            while(leer2.ready())
            {
                if(leer2.readLine().equals(pedido.getText()))
                {
                    return true;
                }
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Envios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            return false;
        }
        return false;
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
