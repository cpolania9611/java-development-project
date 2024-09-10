package proyecto_desarrollo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateInfoFiles {
	public static void createSalesMenFile(int randomSalesCount, String name, long id) {
		try {
			String fileName = name + "_" + id + ".txt";
			File file = new File(fileName);
			PrintWriter writer = new PrintWriter(new FileWriter("output/" + file, true));
			writer.println("CC;" + id);
			Random rand = new Random();
			for (int i = 0; i < randomSalesCount; i++) {
				int productID = rand.nextInt(1000);
				int quantitySold = rand.nextInt(50) + 1;

				writer.println(productID + ";" + quantitySold + ";");
			}

			writer.close();
			System.out.println("Sales file created successfully");
		} catch (IOException e) {
			System.out.println("Error creating sales file: " + e.getMessage());
		}

	}

	public static void main(String[] args) {
		createSalesMenFile(5, "Juan Perez", 123456789);
	}
}
