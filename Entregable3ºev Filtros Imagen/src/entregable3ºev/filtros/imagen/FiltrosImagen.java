/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entregable3ºev.filtros.imagen;

import com.Exceptions.InvalidFormatException;
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
        
            cargarArchivo();
            menuOpcionesImagen();
        
       
        }

   

    private static void cargarArchivo() {
        boolean cargaCorrecta = false;
        do {

            System.out.print("Ingresa la ruta del tu archivo:");
            Imagen pgm = new Imagen(entradaTerminal.nextLine());
            // File pgm = new File(entradaTerminal.nextLine());
            cargaCorrecta=true;

        } while (cargaCorrecta);
    }

    

    private static void menuOpcionesImagen() {

    }

}
