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
        try {
            cargarArchivo();
            menuOpcionesImagen();
        } catch (InvalidFormatException ex) {
            ex.getMessage();
        }

    }

    private static void cargarArchivo() throws InvalidFormatException {
        boolean cargaCorrecta = false;
        do {

            System.out.print("Ingresa la ruta del tu archivo:");
            File pgm = new File(entradaTerminal.nextLine());

            cargaCorrecta=leerArchivo(pgm);

        } while (cargaCorrecta);
    }

    private static boolean leerArchivo(File imagen) {
        String formato, comentario;
        int columnas, filas, valorMaxColor;
        formato = scFile.nextLine();
        if (formato.equals("F2")) {
            comentario = scFile.nextLine();
            columnas = scFile.nextInt();
            filas = scFile.nextInt();
            valorMaxColor = scFile.nextInt();
            int pixeles[][] = new int[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.println("introduce el valor de la fila " + i + " y la columna " + j);
                    pixeles[i][j] = scFile.nextInt();
                }
            }
            Imagen img = new Imagen(formato, comentario, columnas, filas, valorMaxColor, pixeles);
          }
          return true;

    }

    private static void menuOpcionesImagen() {

    }

}
