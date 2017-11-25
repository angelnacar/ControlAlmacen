
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
    
    
 }
