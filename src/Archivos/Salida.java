
package Archivos;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * 
 * @author Angel
 */
public class Salida {
    private static File fichero;
    private static RandomAccessFile acceso;
    private static String descripcion;
    private String altura,ancho,largo,cantidad;
    
    public Salida() 
    {
        fichero = new File("src/Datos/productos.dat");
        try {
            acceso = new RandomAccessFile(fichero,"r");
        } catch (FileNotFoundException ex) {
            JOptionPane aviso = new JOptionPane();
            JOptionPane.showMessageDialog(aviso, "NO ENCUENTRA EL ARCHIVO", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Abre el archivo de pedido indicado por el usuario
     * @param numero 
     */
    public Salida(int numero) 
    {
        fichero = new File("src/Datos/pedido"+numero+".dat");
        try {
            acceso = new RandomAccessFile(fichero,"r");
        } catch (FileNotFoundException ex) {
            JOptionPane aviso = new JOptionPane();
            JOptionPane.showMessageDialog(aviso, "NO ENCUENTRA EL ARCHIVO", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Deveuelve los datos de cada producto
     * @param n
     * @return
     * @throws EOFException
     * @throws IOException 
     */
    public String Descripcion(int n) throws EOFException, IOException 
    {
       
        
        char aux,aux2,aux3,aux4;
        char nombre[] = new char[20];
        char alt[] = new char[4];
        char an[] = new char[4];
        char lar[] = new char[4];
        
        acceso.seek(n*64);
        for(int i = 0;i<nombre.length;i++) //almacena nombre
            {
            aux = acceso.readChar();
            nombre[i] = aux;
          }
        for(int k = 0;k<alt.length;k++)
        {
            aux2 = acceso.readChar();
            lar[k] = aux2;
        }
        
        for(int m = 0;m<alt.length;m++)
        {
            aux3 = acceso.readChar();
            an[m] = aux3;
        }
        
        for(int z = 0;z<alt.length;z++)
        {
            aux4 = acceso.readChar();
            alt[z] = aux4;
        }
        
        descripcion = new String(nombre);
        altura = new String(alt);
        ancho = new String(an);
        largo = new String(lar);
        
        return descripcion;
   }
    
    public String DescripcionPedido(int n) throws EOFException, IOException 
    {
       
        
        char aux,aux2,aux3,aux4,aux5;
        char nombre[] = new char[20];
        char alt[] = new char[4];
        char an[] = new char[4];
        char lar[] = new char[4];
        char can[] = new char[4];
        
        acceso.seek(n*72);
        for(int i = 0;i<nombre.length;i++) //almacena nombre
            {
            aux = acceso.readChar();
            nombre[i] = aux;
          }
        for(int k = 0;k<alt.length;k++)
        {
            aux2 = acceso.readChar();
            lar[k] = aux2;
        }
        
        for(int m = 0;m<alt.length;m++)
        {
            aux3 = acceso.readChar();
            an[m] = aux3;
        }
        
        for(int z = 0;z<alt.length;z++)
        {
            aux4 = acceso.readChar();
            alt[z] = aux4;
        }
        for(int s = 0;s<can.length;s++)
        {
            aux5 = acceso.readChar();
            can[s] = aux5;
        }
        
        descripcion = new String(nombre);
        altura = new String(alt);
        ancho = new String(an);
        largo = new String(lar);
        cantidad = new String(can);
        
        return descripcion;
   }
    public String altura()
    {
        return altura;
    }
    
    public String anchura()
    {
        return ancho;
    }
    
    public String largura()
    {
        return largo;
    }
    
    public String cantidad()
    {
        return cantidad;
    }
    /**
     * Devuelve los datos para la tabla de pedidos
     * @param cantidad
     * @return 
     */
    public String[] toArrayString(String cantidad)
    {
        
        String[] s = {descripcion,largo,ancho,altura,cantidad};
        
        return (s); 
    }
    
    
}
