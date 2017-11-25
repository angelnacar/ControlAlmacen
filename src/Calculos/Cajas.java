
package Calculos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Cajas {
   private static int largo;
   private static int ancho;
   private static int alto;
   static Archivos.SalidaCajas cajas;
   public Cajas(int largo,int ancho,int alto)
   {
       this.largo = largo;
       this.ancho = ancho;
       this.alto = alto;
   }
   
    /**
     *
     * @return
     */
    public int Volumen()
   {
       int vol = largo*ancho*alto;
       return vol;
   }
    
    public void Calcula(int vol,int largo, int ancho, int alto)
    {
        cajas = new Archivos.SalidaCajas();
        int contador = 0;
        int numCaja = 0;
        String caja="";
        boolean control = true;
       // ArrayList<String> listado = new ArrayList();
       try { 
        while(control)
        { 
           cajas.Construye(contador);
          
           int volumen = Integer.parseInt(cajas.altura().trim())*Integer.parseInt(cajas.anchura().trim())*Integer.parseInt(cajas.largura().trim());
           
           if(vol<volumen)
           {
               if(Integer.parseInt(cajas.largura().trim())*numCaja<= largo && Integer.parseInt(cajas.anchura().trim())*numCaja<= ancho && Integer.parseInt(cajas.anchura().trim())*numCaja<= ancho )
               {
                   numCaja++;
               JOptionPane aviso = new JOptionPane();
               JOptionPane.showMessageDialog(aviso, "UTILIZAR CAJA Nº:"+numCaja, "Cajas", JOptionPane.INFORMATION_MESSAGE);
               control = false;
               System.out.println("CAJAS A UTILIZAR");
                System.out.println(caja);
                System.out.println("Numero de cajas a utilizar "+numCaja);
               break;
               }
               else
               {
                   contador++;
                   numCaja++;
               }
           }
           else 
           {
               
               contador++;
                caja = "ALTURA "+cajas.altura()+" ANCHO "+cajas.anchura()+" LARGO "+cajas.largura();
                System.out.println("mas cajas");
           }
        }
        } catch (IOException ex) {
                
            }
    }
}
