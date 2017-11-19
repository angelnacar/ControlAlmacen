
package Archivos;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Angel
 */
public class Salida {
    private static File fichero;
    private static RandomAccessFile acceso;
    private static String descripcion;
    private String altura,ancho,largo;
    
    public Salida()
    {
        fichero = new File("C:\\Users\\Angel\\Documents\\NetBeansProjects\\ProyectoTrimestre\\src\\Datos\\productos.dat");
        try {
            acceso = new RandomAccessFile(fichero,"r");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Salida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String Descripcion(int n) throws EOFException, IOException 
    {
       
        
        char aux,aux2,aux3;
        char nombre[] = new char[20];
        char alt[] = new char[4];
        char an[] = new char[4];
        char lar[] = new char[4];
        
        acceso.seek(n);
        for(int i = 0;i<nombre.length;i++) //almacena nombre
            {
            aux = acceso.readChar();
            nombre[i] = aux;
          }
        for(int k = 0;k<alt.length;k++)
        {
            aux2 = acceso.readChar();
            alt[k] = aux2;
        }
        altura = new String(alt);
        descripcion = new String(nombre);
        return descripcion;
   }
    public String altura()
    {
        return altura;
    }
    
    
}
