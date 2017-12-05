
package Interfaces;


import javax.swing.JOptionPane;

/**
 *  Clase para el almacenamiento de embalajes. Hace una instancia de la clase Entrada 
 * @author angel
 */
public class Embalajes extends javax.swing.JDialog {
    private Archivos.Entrada entrada;
    
    public Embalajes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        largo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ancho = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        altura = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EMBALAJES");
        setMaximumSize(new java.awt.Dimension(300, 200));
        setMinimumSize(new java.awt.Dimension(300, 200));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LARGO");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ANCHO");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ALTURA");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(altura, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(ancho)
                    .addComponent(largo))
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(largo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ancho, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(altura, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        Datos();
    }//GEN-LAST:event_guardarActionPerformed

    /**
     * Guarda datos en embalajes y controla que las medidas no superen un tope
     */
    private  void Datos()
    {
        try //controla que el usuario meta numeros en medidas
      {
        if(Integer.parseInt(largo.getText().trim()) > 40) //controla las medidas de las cajas
        {
           JOptionPane aviso = new JOptionPane();
           JOptionPane.showMessageDialog(aviso, "LARGO MAXIMO 40 CM", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        else if(Integer.parseInt(ancho.getText().trim()) > 30)
        {
           JOptionPane aviso = new JOptionPane();
           JOptionPane.showMessageDialog(aviso, "ANCHO MAXIMO 20 CM", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        else if(Integer.parseInt(altura.getText().trim()) > 30)
        {
           JOptionPane aviso = new JOptionPane();
           JOptionPane.showMessageDialog(aviso, "ALTURA MAXIMO 30 CM", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
         entrada = new Archivos.Entrada(largo.getText(),ancho.getText(),altura.getText()); //instancia la clase entrada con el constructor de acceso a archivo de productos
        JOptionPane aviso = new JOptionPane();
        JOptionPane.showMessageDialog(aviso, "EMBALAJE GUARDADO ", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        altura.setText(""); //limpia los jlabel
        largo.setText("");
        ancho.setText("");
        
        }
    
      }catch(NumberFormatException e)
       {
           JOptionPane aviso = new JOptionPane();
           JOptionPane.showMessageDialog(aviso, "INTRODUZCA NUMEROS EN LAS MEDIDAS", "Aviso", JOptionPane.WARNING_MESSAGE);
       }
       
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField altura;
    private javax.swing.JTextField ancho;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField largo;
    // End of variables declaration//GEN-END:variables
}
