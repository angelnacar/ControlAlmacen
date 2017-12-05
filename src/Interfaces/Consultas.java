
package Interfaces;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *  Clase para la consulta de envios y pedidos
 * @author angel nacar
 */
public class Consultas extends javax.swing.JDialog {

    
    public Consultas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        MostrarDatos();
        
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        resutlado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONSULTAS");
        setMaximumSize(new java.awt.Dimension(300, 200));
        setMinimumSize(new java.awt.Dimension(300, 200));
        setResizable(false);

        resutlado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUMERO DE PEDIDO", "ENVIADO"
            }
        ));
        jScrollPane1.setViewportView(resutlado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Muestra los datos en una tabla accediendo directamente a los archivos envios y pedidos donde se almacenan los numeros de estos.
     */
    private  void MostrarDatos()
    {
        DefaultTableModel dtm = (DefaultTableModel) resutlado.getModel();
        
        try {
            BufferedReader leer = new BufferedReader(new FileReader("src/Datos/envios.txt")); //archivo con los numeros de pedidos enviados
            BufferedReader leer2 = new BufferedReader(new FileReader("src/Datos/pedidos.txt")); //archivos con todos los pedidos, enviados y sin enviar
            
            
            try {
                while(leer.ready())
                {
                    
                    dtm.addRow(new Object[]{leer.readLine()," SI"});
               }
                while(leer2.ready())
                {
                    
                    dtm.addRow(new Object[]{leer2.readLine()," ?"});
               }
            } catch (IOException ex) {
                
            }
        } catch (FileNotFoundException ex) {
           JOptionPane aviso = new JOptionPane();
           JOptionPane.showMessageDialog(aviso, "NO HAY ENVIOS", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable resutlado;
    // End of variables declaration//GEN-END:variables
}
