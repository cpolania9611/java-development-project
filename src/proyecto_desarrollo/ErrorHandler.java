package proyecto_desarrollo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ErrorHandler {
    private static final String LOG_FILE = "error_log.txt"; // Path for the error log file

    // Logs errors to a specified log file
    public static void logError(String errorMessage) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println(errorMessage); // Write the error message to the log file
        } catch (IOException e) {
            System.err.println("Failed to log error: " + e.getMessage());
        }
    }
}
