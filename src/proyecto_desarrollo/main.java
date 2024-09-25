package proyecto_desarrollo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        // Define file paths for input files
        String salesmanInfoFilePath = "SalesmanInfo.txt";
        String productsInfoFilePath = "ProductsInfo.txt";
        String outputSalesReportFilePath = "output/SalesReport.txt";
        String outputProductsReportFilePath = "output/ProductsReport.txt";

        // Handlers for salesmen and products
        SalesmanInfoHandler salesmanInfoHandler = new SalesmanInfoHandler();
        ProductInfoHandler productInfoHandler = new ProductInfoHandler();

        // Read salesman and product info from files
        salesmanInfoHandler.readSalesmanInfo(salesmanInfoFilePath);
        productInfoHandler.readProductInfo(productsInfoFilePath);

        // Initialize a map to track total sales for each salesman
        Map<Long, Double> salesTotal = new HashMap<>();

        // Process sales files for each salesman
        File salesDirectory = new File("output");
        File[] salesFiles = salesDirectory.listFiles((dir, name) -> name.endsWith(".txt") && !name.equals("SalesmanInfo.txt") && !name.equals("ProductsInfo.txt"));

        if (salesFiles != null) {
            for (File salesFile : salesFiles) {
                SalesDataProcessor salesProcessor = new SalesDataProcessor();
                Map<Long, Double> salesData = salesProcessor.processSalesFile(salesFile.getPath(), salesmanInfoHandler, productInfoHandler);

                // Aggregate sales for each salesman
                for (Map.Entry<Long, Double> entry : salesData.entrySet()) {
                    salesTotal.merge(entry.getKey(), entry.getValue(), Double::sum);
                }
            }
        }

        // Generate the sales report file
        generateSalesReport(salesTotal, salesmanInfoHandler, outputSalesReportFilePath);
        // Generate the product sales report file
        generateProductSalesReport(outputProductsReportFilePath, salesProcessor.getProductSalesCount(), productInfoHandler);
    }

    // Generates a sales report for each salesman based on their total sales
    private static void generateSalesReport(Map<Long, Double> salesTotal, SalesmanInfoHandler salesmanInfoHandler, String outputFilePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath, true))) {
            salesTotal.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue())) // Sort by total sales in descending order
                .forEach(entry -> {
                    long salesmanId = entry.getKey();
                    double totalSales = entry.getValue();
                    String salesmanName = salesmanInfoHandler.getSalesmenInfo().get(salesmanId);
                    writer.println(salesmanName + ";" + totalSales);
                });
            System.out.println("Sales report generated successfully: " + outputFilePath);
        } catch (IOException e) {
            ErrorHandler.logError("Error generating sales report: " + e.getMessage());
        }
    }

    // Generates a product sales report based on the sales data
    private static void generateProductSalesReport(String outputFilePath, Map<Integer, Integer> productSalesCount, ProductInfoHandler productInfoHandler) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath, true))) {
            productSalesCount.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())) // Sort by quantity sold in descending order
                .forEach(entry -> {
                    int productId = entry.getKey();
                    int quantitySold = entry.getValue();
                    String productDetails = productInfoHandler.getProductsInfo().get(productId);
                    writer.println(productDetails + ";" + quantitySold);
                });
            System.out.println("Product sales report generated successfully: " + outputFilePath);
        } catch (IOException e) {
            ErrorHandler.logError("Error generating product sales report: " + e.getMessage());
        }
    }
}
