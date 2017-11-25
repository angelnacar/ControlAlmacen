
package Archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;


/**
 *
 * @author Angel
 */
public class Entrada{
    private static File fichero;
    private static RandomAccessFile acceso;
    private static int id, posicion, fin = 0;
    private static String largo,ancho,altura;
    private static String descripcion,cantidad;
    private static StringBuffer des,lar,an,al,uni;
    private static int ped = 0;
   
    public Entrada()
    {
    
    }
    /**
     * Guarda productos
     * @param descripcion
     * @param largo
     * @param ancho
     * @param altura 
     */
    public Entrada(String descripcion,String largo,String ancho, String altura)
    {
        
        fichero = new File("src/Datos/productos.dat"); //ruta al archivo, cambia según la máquina
        this.descripcion = descripcion;
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
        
        try {
            acceso = new RandomAccessFile(fichero,"rw");
            des = new StringBuffer(descripcion);
            lar = new StringBuffer(largo);
            an = new StringBuffer(ancho);
            al = new StringBuffer(altura);
            
            acceso.seek(acceso.length()); //marca donde empezar a escribir
            
            des.setLength(20); //20 caracteres para la descripcion
            lar.setLength(4);
            an.setLength(4);
            al.setLength(4);
            
            acceso.writeChars(des.toString()); //Inserta descripcion
            acceso.writeChars(lar.toString());
            acceso.writeChars(an.toString());
            acceso.writeChars(al.toString());
            
            
        } catch (FileNotFoundException ex) {
            JOptionPane aviso = new JOptionPane();
            JOptionPane.showMessageDialog(aviso, "NO ENCUENTRA EL ARCHIVO", "Aviso", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane aviso = new JOptionPane();
            JOptionPane.showMessageDialog(aviso, "NO PUEDE ACCEDER AL ARCHIVO", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Guarda embalajes
     * @param largo
     * @param ancho
     * @param altura 
     */
    public Entrada(String largo,String ancho, String altura)
    {
        fichero = new File("src/Datos/embalajes.dat"); //ruta al archivo, cambia según la máquina
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
        
        try {
            acceso = new RandomAccessFile(fichero,"rw");
            
            lar = new StringBuffer(largo);
            an = new StringBuffer(ancho);
            al = new StringBuffer(altura);
            
            acceso.seek(acceso.length()); //marca donde empezar a escribir
            
           
            lar.setLength(4);
            an.setLength(4);
            al.setLength(4);
            
            
            acceso.writeChars(lar.toString());
            acceso.writeChars(an.toString());
            acceso.writeChars(al.toString());
            
            
        } catch (FileNotFoundException ex) {
            JOptionPane aviso = new JOptionPane();
            JOptionPane.showMessageDialog(aviso, "NO ENCUENTRA EL ARCHIVO", "Aviso", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane aviso = new JOptionPane();
            JOptionPane.showMessageDialog(aviso, "NO PUEDE ACCEDER AL ARCHIVO", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Guarda pedidos en archivos con numeros incrementales
     * @param descripcion
     * @param largo
     * @param ancho
     * @param altura
     * @param cantidad
     * @param ped 
     */
    public Entrada(String descripcion,String largo,String ancho, String altura,String cantidad,int ped) throws IOException
    {
        
          String pedido = String.valueOf(ped);
          fichero = new File("src/Datos/pedido"+ped+".dat");
          BufferedWriter escribe = new BufferedWriter(new FileWriter("src/Datos/pedidos.txt",true)); //almacena el número del último pedido
          escribe.write(pedido);
          escribe.newLine();
          escribe.close();
          
       
        
        this.descripcion = descripcion;
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
        this.cantidad = cantidad;
        
        try {
            acceso = new RandomAccessFile(fichero,"rw");
            des = new StringBuffer(descripcion);
            lar = new StringBuffer(largo);
            an = new StringBuffer(ancho);
            al = new StringBuffer(altura);
            uni = new StringBuffer(cantidad);
            
            acceso.seek(acceso.length()); //marca donde empezar a escribir
            
            des.setLength(20); //20 caracteres para la descripcion
            lar.setLength(4);
            an.setLength(4);
            al.setLength(4);
            uni.setLength(4);
            
            acceso.writeChars(des.toString()); //Inserta descripcion
            acceso.writeChars(lar.toString());
            acceso.writeChars(an.toString());
            acceso.writeChars(al.toString());
            acceso.writeChars(uni.toString());
            
        } catch (FileNotFoundException ex) {
            JOptionPane aviso = new JOptionPane();
            JOptionPane.showMessageDialog(aviso, "NO ENCUENTRA EL ARCHIVO", "Aviso", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane aviso = new JOptionPane();
            JOptionPane.showMessageDialog(aviso, "NO PUEDE ACCEDER AL ARCHIVO", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
