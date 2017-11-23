
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
    
    public void Calcula(int vol,int altura)
    {
        cajas = new Archivos.SalidaCajas();
        int contador = 0;
        int numCaja = 1;
        ArrayList<String> listado = new ArrayList();
       try { 
        while(true)
        {
           cajas.Construye(contador);
           contador++;
           int volumen = Integer.parseInt(cajas.altura().trim())*Integer.parseInt(cajas.anchura().trim())*Integer.parseInt(cajas.largura().trim());
           if(vol<volumen)
           {
               if(Integer.parseInt(cajas.altura().trim())<= altura)
               {
               JOptionPane aviso = new JOptionPane();
               JOptionPane.showMessageDialog(aviso, "UTILIZAR CAJA Nº:"+numCaja, "Cajas", JOptionPane.INFORMATION_MESSAGE);
               
               break;
               }
           }
           else if(vol>volumen)
           {
               numCaja++;
               String caja = "ALTURA "+cajas.altura()+" ANCHO "+cajas.anchura()+" LARGO "+cajas.largura();
               listado.add(caja);
               
           }
        }
        } catch (IOException ex) {
                System.out.println("CAJAS A UTILIZAR");
                for(int i = 0;i<listado.size();i++)
                {
                    System.out.println("caja "+i+" "+listado.get(i));
                }
            }
    }
}
