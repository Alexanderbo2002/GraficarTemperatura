import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraficaTemperaturas {

    public static void main(String[] args) {
        int[] temperaturas = new int[24]; // Arreglo para almacenar las temperaturas
        try {
            // Leer las temperaturas desde el archivo data.dat
            Scanner scanner = new Scanner(new File("data.dat"));
            for (int i = 0; i < 24; i++) {
                if (scanner.hasNextInt()) {
                    temperaturas[i] = scanner.nextInt();
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            return;
        }

        // Imprimir encabezado
        System.out.println("Temperaturas para 24 horas:");
        System.out.println("  -30       0        30       60       90       120");
        
        // Graficar cada temperatura
        for (int temp : temperaturas) {
            imprimirLineaDeTemperatura(temp);
        }
    }

    // Función para imprimir una línea de la gráfica
    private static void imprimirLineaDeTemperatura(int temp) {
        System.out.printf("%4d |", temp);
        int numAsteriscos = (temp + 30) / 3; // Cada asterisco representa 3 grados

        for (int i = 0; i < numAsteriscos; i++) {
            System.out.print("*");
        }
        System.out.println(); // Nueva línea después de cada barra
    }
}
