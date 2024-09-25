package proyecto_desarrollo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SalesDataProcessor {
    // Map to store product sales count
    private Map<Integer, Integer> productSalesCount;

    public SalesDataProcessor() {
        this.productSalesCount = new HashMap<>();
    }

    // Method to process a sales file
    public Map<Long, Double> processSalesFile(String filePath, SalesmanInfoHandler salesmanInfoHandler, ProductInfoHandler productInfoHandler) {
        Map<Long, Double> salesTotal = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] firstLine = br.readLine().split(";");
            long salesmanId = Long.parseLong(firstLine[1]); // Get the salesman's ID from the first line

            // Process each subsequent line for product sales
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 2) {
                    int productId = Integer.parseInt(parts[0]);
                    int quantitySold = Integer.parseInt(parts[1]);

                    // Validate product ID and quantity
                    if (productInfoHandler.getProductsInfo().containsKey(productId) && quantitySold > 0) {
                        // Update total sales for the salesman
                        salesTotal.merge(salesmanId, productInfoHandler.getProductsInfo().get(productId).getPrice() * quantitySold, Double::sum);
                        // Update product sales count
                        productSalesCount.merge(productId, quantitySold, Integer::sum);
                    } else {
                        ErrorHandler.logError("Invalid product ID or quantity for product ID: " + productId);
                    }
                }
            }
        } catch (IOException e) {
            ErrorHandler.logError("Error reading sales file: " + e.getMessage());
        }

        return salesTotal;
    }

    // Getter for product sales count
    public Map<Integer, Integer> getProductSalesCount() {
        return productSalesCount;
    }
}
