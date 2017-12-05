
package Interfaces;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase para la creación de pedidos
 * @author angel
 */
public class Pedidos extends javax.swing.JDialog {
    
     Archivos.Salida salida; 
     Archivos.Entrada entrada;
     String numeroPedido = "";
     int contadorPedidos = 0; //controla el numero de productos maximo que se puede enviar por pedido
     BufferedReader leer;
    
    public Pedidos(java.awt.Frame parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        salida = new Archivos.Salida(); //instancia un objeto salida con el constructor de enlace al archivo productos
        int n = 0;
        
     try{
        while(true) //hasta que lance excepcion
        {
            
        eleccion.addItem(salida.Descripcion(n)); //carga el jcombobox con los nombres de los productos disponibles en stock
        n += 1;
       
        }
     }catch(EOFException e)
     {
         
} 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        eleccion = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cantidad = new javax.swing.JComboBox<>();
        añadir = new javax.swing.JButton();
        guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PEDIDOS");
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        tabla.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPCION", "LARGO", "ANCHO", "ALTO", "CANTIDAD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUCTO");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CANTIDAD");

        cantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        añadir.setText("AÑADIR");
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });

        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(eleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añadir)
                    .addComponent(guardar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed
        
        AñadirPedidos();
        
    }//GEN-LAST:event_añadirActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        ultimoPedido();
        GuardarPedido();
    }//GEN-LAST:event_guardarActionPerformed
       
        
        
    /**
     * Metodo para el volcado de los datos de cada producto solicitado por el usuario, en cada fila de la tabla
     */
    private  void AñadirPedidos()
    {
        contadorPedidos++; //maximo 10 pedidos
        if(contadorPedidos < 10)
        {
        int item = eleccion.getSelectedIndex();
        
        
        String unidades = (String)cantidad.getSelectedItem();
        try {
            salida.Descripcion(item); //construye producto con la referencia pasada por parámetro 
            
        } catch (IOException ex) {
            
        }
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        dtm.addRow(salida.toArrayString(unidades)); //vuelva datos por fila
        }else
        {
        
        JOptionPane aviso = new JOptionPane();
        JOptionPane.showMessageDialog(aviso, "NO SE PUEDEN AGREGAR MAS PRODUCTOS, MAX 10", "Aviso", JOptionPane.ERROR_MESSAGE);
        
        }
    
    }
    
    private void GuardarPedido()
    {
        /**
         * Guarda el pedido generado por el usuario en un archivo pedido con el numero que le corresponda. 
         */
        for(int i=0;i<tabla.getRowCount();i++)
        {
         
        String descripcion=tabla.getValueAt(i, 0).toString();
        String largo=tabla.getValueAt(i, 1).toString();
        String ancho=tabla.getValueAt(i, 2).toString();
        String alto=tabla.getValueAt(i, 3).toString();
        String cantidad=tabla.getValueAt(i, 4).toString();
        
        entrada = new Archivos.Entrada(descripcion,largo,ancho,alto,cantidad,Integer.parseInt(numeroPedido.trim())+1); //en cada iteracion guarda el producto de cada fila en el archivo pedidoX
        contadorPedidos = 0; //vuelve a 0  cuando el pedido ha sido enviado 
       
       }                                       
        int ped = Integer.parseInt(numeroPedido.trim()) + 1; //Muestra el numero de pedido que ha sido guardado
        JOptionPane aviso = new JOptionPane();
        JOptionPane.showMessageDialog(aviso, "PEDIDO Nº:"+ped+" GUARDADO", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    
    }
    
    /**
     * Lee el archivo pedidos para saber cuál ha sido el último pedido creado y lo guarda en la variable global numeroPedido que después utilizará guardarpedido para sumarle 1 
     */
    private void ultimoPedido()
    {
        try {
            
            leer = new BufferedReader(new FileReader("src/Datos/pedidos.txt"));
                    while(leer.ready())
                    {
                    numeroPedido = leer.readLine();
                        
                    }
                    leer.close();
                
                
                } catch (FileNotFoundException ex) {
                     JOptionPane aviso = new JOptionPane();
                     JOptionPane.showMessageDialog(aviso, "NO ENCUENTRA EL ARCHIVO", "Aviso", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane aviso = new JOptionPane();
            JOptionPane.showMessageDialog(aviso, "NO PUEDE LEER EL ARCHIVO", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadir;
    private javax.swing.JComboBox<String> cantidad;
    private javax.swing.JComboBox<String> eleccion;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
