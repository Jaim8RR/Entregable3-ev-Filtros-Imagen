/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entregable3ºev.filtros.imagen;

import java.io.File;
import java.util.Scanner;


/**
 *
 * @author dev
 */
public class FiltrosImagen {
    static Scanner entradaTerminal = new Scanner(System.in);//esto es para leer la entrada (terminal)
    static Scanner scFile = null;//esto es para leer archivos
    //    scFile = new Scanner(f/*esto es un archivo(ruta)*/);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            menuFiltros();
        } catch (NotFileException ex) {
            ex.getMessage();
        }
       
    }

    private static void menuFiltros() throws NotFileException {
        System.out.print("Ingresa la ruta del tu archivo:");
         File imagen = new File(entradaTerminal.nextLine());
         if (imagen.isFile()) {
             leerArchivo(imagen);
            
        } else throw new NotFileException("No es un archivo, revisa la ruta porfavor pajarraco.");
         
        
        
    }

    private static void leerArchivo(File imagen) {
                File f = new File("./DAW.txt");
        Scanner scFile = null;
        //aqui un try catch whit resources

        
    }
    
}
