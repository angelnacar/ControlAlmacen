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
    private static String largo,ancho,altura;
    private static String descripcion;
    private static StringBuffer des,lar,an,al;
    
    /**
     * Guarda productos
     * @param descripcion
     * @param largo
     * @param ancho
     * @param altura 
     */
    public Entrada(String descripcion,String largo,String ancho, String altura)
    {
        
        fichero = new File("C:\\Users\\cursomulti\\Documents\\NetBeansProjects\\ControlAlmacen\\src\\Datos\\productos.dat"); //ruta al archivo, cambia según la máquina
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
        fichero = new File("C:\\Users\\cursomulti\\Documents\\NetBeansProjects\\ControlAlmacen\\src\\Datos\\embalajes.dat"); //ruta al archivo, cambia según la máquina
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
}
