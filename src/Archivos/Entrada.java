/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

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
public class Entrada{
    private static File fichero;
    private static RandomAccessFile acceso;
    private static int id, posicion, fin = 0;
    private static int largo,ancho,altura;
    private static String descripcion;
    private static StringBuffer des,lar,an,al;
    
    
    public Entrada(String descripcion,int largo,int ancho, int altura)
    {
        
        fichero = new File("C:\\Users\\Angel\\Documents\\NetBeansProjects\\ProyectoTrimestre\\src\\Datos\\productos.dat");
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
            
            acceso.writeChars(descripcion); //Inserta descripcion
            acceso.writeInt(largo);
            acceso.writeInt(ancho);
            acceso.writeInt(altura);
            
            
        } catch (FileNotFoundException ex) {
            JOptionPane aviso = new JOptionPane();
            JOptionPane.showMessageDialog(aviso, "NO ENCUENTRA EL ARCHIVO", "Aviso", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane aviso = new JOptionPane();
            JOptionPane.showMessageDialog(aviso, "NO PUEDE ACCEDER AL ARCHIVO", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }
}
