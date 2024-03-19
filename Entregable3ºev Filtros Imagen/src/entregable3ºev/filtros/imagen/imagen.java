/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregable3ºev.filtros.imagen;

/**
 *
 * @author dev
 */
public class imagen {

   private String formato = "P2";
     private String comentario;
     private int columnas;
     private int filas;
     private int valorMaxColor;
     private double pixeles[][];

    public imagen(String comentario, int columnas, int filas, int valorMaxColor) {
        this.comentario = comentario;
        this.columnas = columnas;
        this.filas = filas;
        this.valorMaxColor = valorMaxColor;
        this.pixeles = new double[columnas][filas];
    }

 

}
