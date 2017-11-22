
package Calculos;


public class Cajas {
   private static int largo;
   private static int ancho;
   private static int alto;
   
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
