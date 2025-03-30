/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoPractico2;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Escriba un programa en Java que calcule el producto de 2 matrices cuadradas de 
 * orden n x n.
 * 
 * @author norberto
 */
public class Punto4 {
    public static void main (String[] args) {
        int n = 0;
        int[][] matriz1;
        int[][] matriz2;
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingresar el orden n de la matriz cuadrada: ");
            n = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Dato ingresado inválido. " + e.getMessage());
        }
        
        matriz1 = new int[n][n];
        matriz2 = new int[n][n];
        
        Punto4.llenarMatrizAleatorio(matriz1, n);
        Punto4.llenarMatrizAleatorio(matriz2, n);
        
        System.out.println("\nMatriz 1:");
        System.out.println(Arrays.deepToString(matriz1));
        System.out.println("\nMatriz 2:\n");
        System.out.println(Arrays.deepToString(matriz2));
        
        /*
        Producto de matrices cuadradas calculando el tiempo de ejecución con System.nanoTime().
        El tiempo de ejecución del método se va a mostrar por pantalla.
        */
        long tiempoInicial = System.nanoTime();
        int[][] producto = Punto4.productoMatricesCuadradas(matriz1, matriz2, n);
        System.out.println("\nMatriz producto:");
        System.out.println(Arrays.deepToString(producto) + "\n");
        long tiempoFinal = System.nanoTime();
        long tiempoEjecucion = tiempoFinal - tiempoInicial;
        System.out.println("El tiempo de ejecución del método fue de: " + tiempoEjecucion + " ns (" + (tiempoEjecucion / 1000000) + " ms)");
       
    }
    
    /**
     * 
     * Hace el producto entre dos matrices cuadradas de orden nxn. Para cada elemento [i][j]
     * de la matriz resultante suma el producto entre el elemento [k][x] de la primera matriz
     * por el elemento [x][k] de la segunda matriz.
     * 
     * @param matriz1 La primera matriz.
     * @param matriz2 La segunda matriz.
     * @param n El orden de las matrices cuadradas.
     * @return El producto entre matriz1 y matriz2.
     */
    public static int[][] productoMatricesCuadradas(int[][] matriz1, int[][] matriz2, int n) {
        int[][] producto = new int[n][n];
        
         for (int i = 0; i < n; i++) {
             for (int j = 0; j < n; j++) {
                 producto[i][j] = 0;
                 for (int k = 0; k < n; k++) {
                     producto[i][j] += matriz1[i][k] * matriz2[k][j];
                 }
             }
         } 
         
        return producto;
    }
    
    /**
     * 
     * Llenar matriz cuadrada entera con valores aleatorios entre 0 y 100. 
     * 
     * @param matriz Matriz que se llenará con números aleatorios.
     * @param n Orden de la matriz.
     */
    public static void llenarMatrizAleatorio(int[][] matriz, int n) {
        int limiteInf = 0;
        int limiteSup = 100;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = (int)(Math.random() * (limiteSup - limiteInf)) + limiteInf;
            }
        }
    }
}
