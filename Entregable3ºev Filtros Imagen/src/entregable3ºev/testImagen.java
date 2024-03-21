package entregable3ºev;

import java.util.Scanner;

import entregable3ºev.filtros.imagen.Imagen;

public class testImagen {
    public static void main(String[] args) {
        // scaner que nos dirá cada valor por terminal de la Imagen
        Scanner sc = new Scanner(System.in);
//        System.out.println("introduce el foramato");
//        String formato = sc.nextLine();
//        System.out.println("introduce el comentario");
//        String comentario = sc.nextLine();
//        System.out.println("introduce el numero de columnas");
//        int columnas = sc.nextInt();
//        System.out.println("introduce el numero de filas");
//        int filas = sc.nextInt();
//        System.out.println("introduce el valor maximo de color");
//        int valorMaxColor = sc.nextInt();
//        
String formato ="F2";
String comentario="fdf";
int filas =(int)(Math.random()*10+1);
int columnas =(int)(Math.random()*10+1);
int valorMaxColor=20;
        System.out.println("filas: "+filas);
        System.out.println("columnas: "+columnas);


        

        int pixeles[][] = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
               // System.out.println("introduce el valor de la fila " + i + " y la columna " + j);
                pixeles[i][j] = (int)(Math.random()*10);
            }
        }
        Imagen img = new Imagen(formato, comentario, columnas, filas, valorMaxColor, pixeles);
        System.out.println("-----1------");
        img.mostrarPixeles();
        img.voltearPixelesNoventaGradosIzq();
        System.out.println("-----volteamos izq------");
        img.mostrarPixeles();
        System.out.println("----volteamos der(como el principio)-------");
        img.voltearPixelesNoventaGradosDer();
        img.mostrarPixeles();
        System.out.println("-----volteamos der------");
        img.voltearPixelesNoventaGradosDer();
        img.mostrarPixeles();
        System.out.println("-----volteamos vertical------");
        img.voltearPixelesVerticalmente();
        img.mostrarPixeles();
        System.out.println("-----volteamos Horizontal------");
        img.voltearPixelesHorizontalmente();
        img.mostrarPixeles();
         System.out.println("-------------------------------");

    }

}
