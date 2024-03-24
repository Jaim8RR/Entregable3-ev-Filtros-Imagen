/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregable3ºev.filtros.imagen;
import java.io.File;
import java.util.Scanner;
/*TODO:
*girarDerecha-izquierda DONE
*FlipVertical-horizontal DONE
*Filtro caja
*Filtro negativo
*/
/**
 *
 * @author dev
 */
public class Imagen {

   private String formato;//deberia ser siempre este valor "P2"
     private String comentario;
     private int columnas;
     private int filas;
     private final int BLANCO_ABSOLUTO=255;
     private int pixeles[][];
     private double valorMaxColor;
     //in the next line i want a constructor which will read a file where the atributes are at.
    public Imagen(String rutaArchivo) {
        Scanner scFile = null;
        File fr = new File(rutaArchivo);
        this.formato = scFile.nextLine();
        this.comentario = scFile.nextLine();
        this.columnas = scFile.nextInt();
        this.filas = scFile.nextInt();
        this.valorMaxColor = scFile.nextInt();
        this.pixeles = new int[this.filas][this.columnas];
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                this.pixeles[i][j] = scFile.nextInt();
            }
        }
        if (this.valorMaxColor!=255) {
            normalizarColores();
            
        }
    }

  
//este constructor de abajo es para probar en testImagen
    public Imagen(String formato, String comentario, int columnas, int filas, int valorMaxColor, int[][] pixeles) {
        this.formato = formato;
        this.comentario = comentario;
        this.columnas = columnas;
        this.filas = filas;
        this.valorMaxColor= valorMaxColor;
        this.pixeles = pixeles;
        if (valorMaxColor!=255) {
            System.out.println("Muestro antes de generar valorMaxColor: "+valorMaxColor);
            mostrarPixeles();
            normalizarColores();
            System.out.println("-------------");
                    
        }
    }
   public void voltearPixelesNoventaGradosDer() {
        int[][] pixelesVolteados = new int[this.columnas][this.filas];
        for (int i = 0; i < this.columnas; i++) {//columnas
            for (int j = 0; j < this.filas; j++) {//filas
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
    public void invertirColores(){
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                this.pixeles[i][j]=BLANCO_ABSOLUTO-this.pixeles[i][j];
            }
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
        return BLANCO_ABSOLUTO;
    }

    

    public int[][] getPixeles() {
        return pixeles;
    }

    public void setPixeles(int[][] pixeles) {
        this.pixeles = pixeles;
    }

    private void normalizarColores() {
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                this.pixeles[i][j]=(int)(this.pixeles[i][j]*BLANCO_ABSOLUTO/valorMaxColor);
            }
        }
    }

 

}
