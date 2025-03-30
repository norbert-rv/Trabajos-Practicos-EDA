package trabajoPractico2;

import java.util.Arrays;

/**
 *
 * @author norberto
 */
public class Punto4_c {

    public static void main(String[] args) {
        int[][] matriz1;
        int[][] matriz2;

        /*
        Calculo del tiempo de ejecucion medio para valores crecientes de n: 2, 5, 10, 100, 1000
         */
        int[] entradas = {2, 5, 10, 100, 500, 1000};

        for (int entrada : entradas) {
            matriz1 = new int[entrada][entrada];
            matriz2 = new int[entrada][entrada];

            Punto4.llenarMatrizAleatorio(matriz1, entrada);
            Punto4.llenarMatrizAleatorio(matriz2, entrada);

            /*
            Producto de matrices cuadradas calculando el tiempo de ejecución con System.nanoTime().
            El tiempo de ejecución media del método se va a mostrar por pantalla.
            Ejecuto el método un número finito de veces para calcular el valor medio. La desviación
            estándar es alta. Con 100 repeticiones de hace menor pero sigue siendo significante.
             */
            int nroRepeticiones;
            
            if (entrada < 1000) {
                nroRepeticiones = 100;
            } else {
                nroRepeticiones = 10;
            }
            
            long sumaTiempos = 0;
            long tiempoInicial;
            long tiempoFinal;

            for (int i = 0; i < nroRepeticiones; i++) {
                tiempoInicial = System.nanoTime();
                Punto4.productoMatricesCuadradas(matriz1, matriz2, entrada);
                tiempoFinal = System.nanoTime();
                sumaTiempos += (tiempoFinal - tiempoInicial);
            }

            double tiempoPromedio = sumaTiempos / (double) nroRepeticiones;

            System.out.println("El tiempo de ejecución medio del método para una matriz de orden n igual a " + entrada + " fue de: " + tiempoPromedio + " ns (" + (tiempoPromedio / 1_000_000) + " ms)");
        }
    }
}
