package proyecto_desarrollo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProductInfoHandler {
    private Map<Integer, String> productsInfo = new HashMap<>(); // Map to store product info

    // Reads product information from the specified file
    public void readProductInfo(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) { // Ensure the line has the correct number of parts
                    int productId = Integer.parseInt(parts[0]);
                    String productName = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    productsInfo.put(productId, productName + ";" + price); // Store product info
                } else {
                    ErrorHandler.logError("Invalid format in product info file: " + line);
                }
            }
        } catch (IOException e) {
            ErrorHandler.logError("Error reading product info file: " + e.getMessage());
        }
    }

    public Map<Integer, String> getProductsInfo() {
        return productsInfo; // Return the map of product info
    }
}
