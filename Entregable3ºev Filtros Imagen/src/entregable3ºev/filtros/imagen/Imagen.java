/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregable3ºev.filtros.imagen;

/**
 *
 * @author dev
 */
public class Imagen {

   private String formato = "P2";
     private String comentario;
     private int columnas;
     private int filas;
     private int valorMaxColor;
     private int pixeles[][];

  

    public Imagen(String formato, String comentario, int columnas, int filas, int valorMaxColor, int[][] pixeles) {
        this.formato = formato;
        this.comentario = comentario;
        this.columnas = columnas;
        this.filas = filas;
        this.valorMaxColor = valorMaxColor;
        this.pixeles = pixeles;
    }
   public void voltearPixelesNoventaGradosDer() {
        int[][] pixelesVolteados = new int[this.columnas][this.filas];
        for (int i = 0; i < this.columnas; i++) {
            for (int j = 0; j < this.filas; j++) {
                pixelesVolteados[i][j] = this.pixeles[this.filas - j - 1][i];
            }
        }
        this.pixeles = pixelesVolteados;
        int aux = this.columnas;
        this.columnas = this.filas;
        this.filas = aux;
    }
    public void voltearPixelesNoventaGradosIzq() {
        int[][] pixelesVolteados = new int[this.columnas][this.filas];
        for (int i = 0; i < this.columnas; i++) {
            for (int j = 0; j < this.filas; j++) {
                pixelesVolteados[i][j] = this.pixeles[j][this.columnas - i - 1];
            }
        }
        this.pixeles = pixelesVolteados;
        int aux = this.columnas;
        this.columnas = this.filas;
        this.filas = aux;
    }
    public void voltearPixelesVerticalmente() {
        int[][] pixelesVolteados = new int[this.filas][this.columnas];
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                pixelesVolteados[i][j] = this.pixeles[i][this.columnas - j - 1];
            }
        }
        this.pixeles = pixelesVolteados;
    }
    public void voltearPixelesHorizontalmente() {
        int[][] pixelesVolteados = new int[this.filas][this.columnas];
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                pixelesVolteados[i][j] = this.pixeles[this.filas - i - 1][j];
            }
        }
        this.pixeles = pixelesVolteados;
    }


    public void mostrarPixeles() {//este metodo es para mostrar los pixeles para testing
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                System.out.print(this.pixeles[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getValorMaxColor() {
        return valorMaxColor;
    }

    public void setValorMaxColor(int valorMaxColor) {
        this.valorMaxColor = valorMaxColor;
    }

    public int[][] getPixeles() {
        return pixeles;
    }

    public void setPixeles(int[][] pixeles) {
        this.pixeles = pixeles;
    }

 

}
