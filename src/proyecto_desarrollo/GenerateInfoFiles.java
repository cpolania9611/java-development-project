package proyecto_desarrollo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {
    public static void main(String[] args) {
        String salesmenFile = "salesmen.txt";
        String productsFile = "products.txt";
        String salesFile = "sales.txt";

        try {
            generateSalesmenFile(salesmenFile);
            generateProductsFile(productsFile);
            generateSalesFile(salesFile);
            System.out.println("Archivos generados con éxito.");
        } catch (IOException e) {
            System.err.println("Error al generar los archivos: " + e.getMessage());
        }
    }

    private static void generateSalesmenFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Generar datos de vendedores
            for (int i = 1; i <= 10; i++) {
                writer.write("Vendedor" + i + ";" + (1000 + i) + "\n"); // Ejemplo: Vendedor1;1001
            }
        }
    }

    private static void generateProductsFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Generar datos de productos
            for (int i = 1; i <= 5; i++) {
                writer.write(i + ";Producto" + i + ";" + (10.0 * i) + "\n"); // Ejemplo: 1;Producto1;10.0
            }
        }
    }

    private static void generateSalesFile(String filePath) throws IOException {
        Random rand = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Generar datos de ventas
            for (int i = 0; i < 20; i++) {
                writer.write(rand.nextInt(5) + 1 + ";" + (1 + rand.nextInt(10)) + "\n"); // Ejemplo: 1;5
            }
        }
    }
}
