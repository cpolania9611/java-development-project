# University Project: Fundamental Concepts of Programming
## Politécnico Grancolombiano

This repository contains a Java project developed for the university course "Concepts of Programming". The project involves creating and managing various types of data files used for testing purposes. The software generates files with sales, salesman, and product information to facilitate data processing and analysis.

## Team Members

- **Andrés Camilo Polanía Lozano**
- **Alex Fernando Amaya Rincón**
- **Minelva Escobar Guerra**

## Project Description

The project is designed to meet the requirements for a university assignment. It includes a Java application that generates files with the following content:

1. **Sales File**: Contains sales data for individual salesmen. Each file includes random sales entries.
2. **Salesman Information File**: Contains information about salesmen, including their IDs and names.
3. **Products File**: Contains information about products, including IDs, names, and prices.

## File Generation

The software includes two main classes:

1. **GenerateInfoFiles**: This class is responsible for generating the following files:
   - **Sales File**: Created using the `createSalesMenFile` method.
   - **Salesman Information File**: Created using the `createSalesManInfoFile` method.
   - **Products File**: Created using the `createProductsFile` method.

### Methods

- `createSalesMenFile(int randomSalesCount, String name, long id)`: Generates a file with random sales data for a salesman.
- `createSalesManInfoFile(int salesmanCount)`: Generates a file with information about multiple salesmen.
- `createProductsFile(int productsCount)`: Generates a file with information about products.

## Usage

1. **Compile the Project**: Open the project in Eclipse or your preferred Java IDE.
2. **Run the Main Method**: Execute the `main` method in the `GenerateInfoFiles` class to generate the required files. Ensure that the `output` directory exists in the project root or modify the file paths accordingly.
3. **Verify Output**: Check the `output` directory for the generated files.

## Requirements

- **Java 8** or later
- **Eclipse IDE** (or any other Java IDE)

## Additional Information

- The generated files are used for testing purposes and can be adjusted according to specific requirements.
- Ensure that the `output` directory exists before running the program or adjust the file paths as needed.

## License

This project is for educational purposes and is intended to demonstrate programming concepts learned in the "Fundamental Concepts of Programming" course.

## Contact

For any questions or feedback, please contact:

- **Andrés Camilo Polanía Lozano**: anpolania2@poligran.edu.co
- **Alex Fernando Amaya Rincón**: alamayar@poligran.edu.co
- **Minelva Escobar Guerra**: miescobar1@poligran.edu.co