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
public class SalidaCajas {
    private static File fichero;
    private static RandomAccessFile acceso;
    private String altura,ancho,largo,cantidad;
    
    public SalidaCajas() 
    {
        fichero = new File("C:\\Users\\cursomulti\\Documents\\NetBeansProjects\\ControlAlmacen\\src\\Datos\\embalajes.dat");
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
    public void Construye(int n) throws EOFException, IOException 
    {
       
        
        char aux2,aux3,aux4;
        
        char alt[] = new char[4];
        char an[] = new char[4];
        char lar[] = new char[4];
        
        acceso.seek(n*24);
       
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
        
        
        altura = new String(alt);
        ancho = new String(an);
        largo = new String(lar);
        
        
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
}