package proyecto_desarrollo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SalesmanInfoHandler {
    private Map<Long, String> salesmenInfo = new HashMap<>(); // Map to store salesman info

    // Reads salesman information from the specified file
    public void readSalesmanInfo(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) { // Ensure the line has the correct number of parts
                    String tipoDoc = parts[0];
                    long numDoc = Long.parseLong(parts[1]);
                    String nombre = parts[2];
                    String apellido = parts[3];
                    salesmenInfo.put(numDoc, nombre + " " + apellido); // Store salesman info
                } else {
                    ErrorHandler.logError("Invalid format in salesman info file: " + line);
                }
            }
        } catch (IOException e) {
            ErrorHandler.logError("Error reading salesman info file: " + e.getMessage());
        }
    }

    public Map<Long, String> getSalesmenInfo() {
        return salesmenInfo; // Return the map of salesman info
    }
}
