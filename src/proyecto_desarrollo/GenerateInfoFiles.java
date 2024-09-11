package proyecto_desarrollo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * This class provides methods to generate various types of information files
 * used for testing purposes. It creates sales files for salesmen, a file
 * containing salesman information, and a file with product information.
 */
public class GenerateInfoFiles {

	/**
	 * Creates a sales file for a given salesman with a specified number of random
	 * sales entries.
	 * 
	 * @param randomSalesCount The number of random sales entries to generate.
	 * @param name             The name of the salesman (used to create the
	 *                         filename).
	 * @param id               The ID of the salesman (used to create the filename
	 *                         and as part of the sales data).
	 */
	public static void createSalesMenFile(int randomSalesCount, String name, long id) {
		try {
			String fileName = name + "_" + id + ".txt";
			File file = new File("data/" + fileName);
			PrintWriter writer = new PrintWriter(new FileWriter(file, true));
			writer.println("CC;" + id);
			Random rand = new Random();
			for (int i = 0; i < randomSalesCount; i++) {
				int productID = rand.nextInt(1000);
				int quantitySold = rand.nextInt(50) + 1;
				writer.println(productID + ";" + quantitySold + ";");
			}
			writer.close();
			System.out.println("Sales file created successfully: " + fileName);
		} catch (IOException e) {
			System.out.println("Error creating sales file: " + e.getMessage());
		}
	}

	/**
	 * Creates a file containing information about salesmen.
	 * 
	 * @param salesmanCount The number of salesmen to generate information for.
	 */
	public static void createSalesManInfoFile(int salesmanCount) {
		try {
			File file = new File("SalesmanInfo.txt");
			PrintWriter writer = new PrintWriter(new FileWriter("data/" + file, true));
			String[] names = { "Juan", "Carlos", "María", "Ana", "Luis" };
			String[] surnames = { "García", "Pérez", "Rodríguez", "López", "Gómez" };
			Random rand = new Random();
			for (int i = 0; i < salesmanCount; i++) {
				String tipoDoc = "CC";
				long numDoc = 10000000 + rand.nextInt(90000000);
				String name = names[rand.nextInt(names.length)];
				String surname = surnames[rand.nextInt(surnames.length)];
				writer.println(tipoDoc + ";" + numDoc + ";" + name + ";" + surname);
			}
			writer.close();
			System.out.println("Salesman information file created successfully: " + file);
		} catch (IOException e) {
			System.out.println("Error creating salesman information file: " + e.getMessage());
		}
	}

	/**
	 * Creates a file containing information about products.
	 * 
	 * @param productsCount The number of products to generate information for.
	 */
	public static void createProductsFile(int productsCount) {
		try {
			File file = new File("ProductsInfo.txt");
			PrintWriter writer = new PrintWriter(new FileWriter("data/" + file, true));
			String[] productNames = { "Laptop", "Keyboard", "Mouse", "Monitor", "Printer" };
			Random rand = new Random();
			for (int i = 0; i < productsCount; i++) {
				int productID = i + 1;
				String productName = productNames[rand.nextInt(productNames.length)];
				double pricePerUnit = rand.nextDouble() * 100 + 10;
				writer.println(productID + ";" + productName + ";" + String.format("%.2f", pricePerUnit));
			}
			writer.close();
			System.out.println("Products file created successfully.");
		} catch (IOException e) {
			System.out.println("Error creating products file: " + e.getMessage());
		}
	}

	/**
	 * The main method to test file generation.
	 * 
	 * @param args Command line arguments (not used).
	 */
	public static void main(String[] args) {
		createSalesMenFile(5, "JuanPerez", 123456789);
		createSalesManInfoFile(10);
		createProductsFile(5);
	}
}
