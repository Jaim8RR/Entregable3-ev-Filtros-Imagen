/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entregable3ºev.filtros.imagen;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Entregable3ºev Filtros Imagen\img\imagen.pgm
 *
 * @author dev
 */
public class FiltrosImagen {

    static Scanner entradaTerminal = new Scanner(System.in);// esto es para leer la entrada (terminal)
    static Imagen pgm;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        cargarArchivo();
        menuOpcionesImagen();

    }

    private static void cargarArchivo() {
        boolean cargaIncorrecta;
        do {

            System.out.print("Ingresa la ruta del tu archivo:");
            try {
                pgm = new Imagen(entradaTerminal.nextLine());

                cargaIncorrecta = false;
            } catch (NumberFormatException e) {
                System.out.println("El formato del fichero es incorrecto");
                cargaIncorrecta = true;
            } catch (FileNotFoundException e) {
                System.out.println("La ruta del archivo no es la adecuada");
                cargaIncorrecta = true;

            } catch (Exception e) {
                System.out.println("Se ha producido un error inesperado");
                cargaIncorrecta = true;
            }

        } while (cargaIncorrecta);
    }

    private static void menuOpcionesImagen() {
        String opcionFiltro, rutaGuardarImagen;
        do {// Menu que indicará las diferentes opciones que tiene nuestra clase imagen
            System.out.println("Elige qué filtro deseas aplicar a la imagen:");
            System.out.println("1.- Filtro negativo");
            System.out.println("2.- Girar imagen derecha");
            System.out.println("3.- Girar imagen izquierda");
            System.out.println("4.- Voltear imagen verticalmente");
            System.out.println("5.- Voltear imagen horizontalmente");
            System.out.println("6.- Filtro caja");
            System.out.println("7.- Guardar imagen");
            System.out.println("8.- Salir");
            opcionFiltro = entradaTerminal.nextLine();
            switch (opcionFiltro) {
                case "1":
                    pgm.invertirColores();
                    break;
                case "2":
                    pgm.voltearPixelesNoventaGradosDer();
                    break;
                case "3":
                    pgm.voltearPixelesNoventaGradosIzq();
                    break;
                case "4":
                    pgm.voltearPixelesVerticalmente();
                    break;
                case "5":
                    pgm.voltearPixelesHorizontalmente();
                    break;
                case "6":
                    pgm.filtroCaja();
                    break;
                case "7":
                    System.out.println("Introduce la ruta donde guardar la imagen: ");
                    rutaGuardarImagen = entradaTerminal.nextLine();
                    try {
                        pgm.guardarPGM(rutaGuardarImagen);
                    } catch (IOException e) {
                        System.out.println("Error al guardar la imagen");
                        e.printStackTrace();
                    }
                    break;
                case "8":
                    System.out.println("Adios!");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (!opcionFiltro.equals("8"));

    }

}
