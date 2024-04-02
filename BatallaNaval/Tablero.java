package BatallaNaval;

import java.util.Random;

public class Tablero {
    static final int filas = 4;
    static final int columnas = 4;
    static final char mar = '-';
    static final char barco = 'B';

    static void inicializarTablero(char[][] tablero) {
        Random rand = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = mar;
            }
        }

        System.out.println("Jugador 1 eliga sus barcos");
        for (int k = 0; k < 3; k++) {
            int fila = rand.nextInt(filas);
            int columna = rand.nextInt(columnas);
            tablero[fila][columna] = barco;
        }
    }

    //Este método muestra el tablero de juego en la consola.
    static void mostrarTablero(char[][] tablero) {
        System.out.println("  1 2 3 4");
        for (int i = 0; i < filas; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        char[][] tablero = new char[filas][columnas];
        inicializarTablero(tablero);
        mostrarTablero(tablero);
    }
}
