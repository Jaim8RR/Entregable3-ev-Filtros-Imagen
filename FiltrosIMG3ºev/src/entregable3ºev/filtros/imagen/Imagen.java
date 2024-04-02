/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregable3ºev.filtros.imagen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Imagen {

    private String formato;//deberia ser siempre este valor "P2"
    private String comentario;
    private int columnas;
    private int filas;
    private final int BLANCO_ABSOLUTO = 255;
    private double pixeles[][];
    private double valorMaxColor;

    public Imagen(String rutaArchivo) throws FileNotFoundException {

        File imagen = new File(rutaArchivo);
        Scanner scFile = new Scanner(imagen);
        this.formato = scFile.nextLine();
        this.comentario = scFile.nextLine();
        this.columnas = scFile.nextInt();
        this.filas = scFile.nextInt();
        this.valorMaxColor = scFile.nextInt();
        this.pixeles = new double[this.filas][this.columnas];
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                this.pixeles[i][j] = scFile.nextInt();
            }
        }
        if (this.valorMaxColor != 255) {
            normalizarColores();

        }
        scFile.close();

    }

    public void guardarPGM(String rutaNombre) throws IOException {
        FileWriter fw = new FileWriter(rutaNombre);
        fw.write(this.getFormato() + "\n");
        fw.write(this.comentario + "\n");
        fw.write(this.columnas + " ");
        fw.write(this.filas + "\n");
        fw.write(this.BLANCO_ABSOLUTO + "\n");//puesto que esta normalizado será 255
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                fw.write((int) this.pixeles[i][j] + "\n");
            }

        }
        fw.close();
    }

    private void normalizarColores() {
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                this.pixeles[i][j] = (int) (this.pixeles[i][j] * BLANCO_ABSOLUTO / valorMaxColor);
            }
        }
    }

    public void voltearPixelesNoventaGradosDer() {
        double[][] pixelesVolteados = new double[this.columnas][this.filas];
        for (int i = 0; i < this.columnas; i++) {//columnas
            for (int j = 0; j < this.filas; j++) {//filas
                pixelesVolteados[i][j] = this.pixeles[this.filas - j - 1][i];
            }
        }
        int aux = this.columnas;
        this.columnas = this.filas;
        this.filas = aux;
        this.pixeles = pixelesVolteados;

    }

    public void voltearPixelesNoventaGradosIzq() {
        double[][] pixelesVolteados = new double[this.columnas][this.filas];
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
        double[][] pixelesVolteados = new double[this.filas][this.columnas];
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                pixelesVolteados[i][j] = this.pixeles[i][this.columnas - j - 1];
            }
        }
        this.pixeles = pixelesVolteados;
    }

    public void voltearPixelesHorizontalmente() {
        double[][] pixelesVolteados = new double[this.filas][this.columnas];
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                pixelesVolteados[i][j] = this.pixeles[this.filas - i - 1][j];
            }
        }
        this.pixeles = pixelesVolteados;
    }

    public void invertirColores() {
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                this.pixeles[i][j] = BLANCO_ABSOLUTO - this.pixeles[i][j];
            }
        }
    }

    public void filtroCaja() {
        double[][] pixelesFiltrados = new double[this.filas][this.columnas];
        for (int i = 0; i < this.filas; i++) {//estos dos blucles for es para ir pixel por pixel
            for (int j = 0; j < this.columnas; j++) {
                int sum = 0;//sum es la suma de los pixeles que estan alrededor del pixel actual
                int count = 0;//count es el numero de pixeles que estan alrededor del pixel actual
                for (int x = i - 1; x <= i + 1; x++) {//estos dos blucles for es para ir pixel por pixel alrededor del pixel actual
                    for (int y = j - 1; y <= j + 1; y++) {//aqui le quitamos uno  a x e y ya que las arrays empiezan en 0
                        if (x >= 0 && x < this.filas && y >= 0 && y < this.columnas) {//esto es para que no se salga de los limites de la imagen por eso se pone x<this.filas y y<this.columnas y x>=0 y y>=0(cubriendo  el maximo y los minimos)
                            sum += this.pixeles[x][y];//sumamos el pixel actual al sum
                            count++;//aumentamos el numero de pixeles
                        }
                    }
                }
                pixelesFiltrados[i][j] = sum / count;//y aqui guardamos la media de los pixeles alrededor del pixel actual
            }
        }
        this.pixeles = pixelesFiltrados;
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

    public double[][] getPixeles() {
        return pixeles;
    }

    public void setPixeles(double[][] pixeles) {
        this.pixeles = pixeles;
    }

}
