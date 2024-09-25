package proyecto_desarrollo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SalesDataHandler {
    private Map<Long, String> salesMen = new HashMap<>(); // Map to store salesmen
    private Map<Integer, String> products = new HashMap<>(); // Map to store products

    // Reads salesmen files from the specified directory
    public void readSalesMenFiles(String directoryPath) throws IOException {
        File dir = new File(directoryPath);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    // Read the header
                    if ((line = reader.readLine()) != null) {
                        // Process the salesman line
                        String[] headerParts = line.split(";");
                        long id = Long.parseLong(headerParts[1]);
                        salesMen.put(id, headerParts[0]);
                    }
                    // Read the sales
                    while ((line = reader.readLine()) != null) {
                        // Process each sale line
                        String[] parts = line.split(";");
                        int productId = Integer.parseInt(parts[0]);
                        int quantity = Integer.parseInt(parts[1]);
                        // Logic to process the sale can be added here
                    }
                }
            }
        }
    }

    // Reads the salesman information file
    public void readSalesManInfoFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String docType = parts[0];
                long numDoc = Long.parseLong(parts[1]);
                String name = parts[2];
                String lastName = parts[3];
                // Store the salesman information if needed
                salesMen.put(numDoc, name + " " + lastName);
            }
        }
    }

    // Reads the products file
    public void readProductsFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int productId = Integer.parseInt(parts[0]);
                String productName = parts[1];
                double price = Double.parseDouble(parts[2]);
                // Store the product information
                products.put(productId, productName + ";" + price);
            }
        }
    }

    public Map<Long, String> getSalesMen() {
        return salesMen; // Return the salesmen map
    }

    public Map<Integer, String> getProducts() {
        return products; // Return the products map
    }
}
