package proyecto_desarrollo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGenerator {
    private static Map<Long, Double> salesReport = new HashMap<>(); // Map to store sales report
    private static Map<String, Integer> productSales = new HashMap<>(); // Map to store product sales

    // Generates a sales report and writes it to the specified output path
    public static void generateSalesReport(String outputPath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
            // Sort the sales report map by total amount collected
            salesReport = salesReport.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            for (Map.Entry<Long, Double> entry : salesReport.entrySet()) {
                writer.println(entry.getKey() + ";" + entry.getValue());
            }
        }
    }

    // Generates a product report and writes it to the specified output path
    public static void generateProductReport(String outputPath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
            // Sort the product sales map by quantity sold
            productSales = productSales.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            for (Map.Entry<String, Integer> entry : productSales.entrySet()) {
                writer.println(entry.getKey() + ";" + entry.getValue());
            }
        }
    }

    // Method to add sales data to the report
    public static void addSale(Long salesmanId, double amount) {
        salesReport.put(salesmanId, salesReport.getOrDefault(salesmanId, 0.0) + amount);
    }

    // Method to add product sales data to the report
    public static void addProductSale(String productName, int quantity) {
        productSales.put(productName, productSales.getOrDefault(productName, 0) + quantity);
    }
}
