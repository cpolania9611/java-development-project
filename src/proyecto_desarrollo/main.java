package proyecto_desarrollo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SalesDataHandler dataHandler = new SalesDataHandler();
        SalesDataProcessor dataProcessor = new SalesDataProcessor();
        SalesmanInfoHandler salesmanInfoHandler = new SalesmanInfoHandler();
        ProductInfoHandler productInfoHandler = new ProductInfoHandler();

        try {
            // Leer archivos generados
            salesmanInfoHandler.readSalesmanInfo("salesmen.txt");
            productInfoHandler.readProductsFile("products.txt");
            dataHandler.readSalesMenFiles("sales.txt");

            // Procesar ventas
            var salesTotal = dataProcessor.processSalesFile("sales.txt", salesmanInfoHandler, productInfoHandler);
            System.out.println("Reportes generados con éxito.");
        } catch (IOException e) {
            System.err.println("Error al procesar los archivos: " + e.getMessage());
        }
    }
}
