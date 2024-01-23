import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Price: $");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();

                    inventoryManager.addProduct(productId, productName, price, quantity);
                    break;

                case 2:
                    System.out.print("Enter Product ID to remove: ");
                    int removeProductId = scanner.nextInt();
                    inventoryManager.removeProduct(removeProductId);
                    break;

                case 3:
                    inventoryManager.displayInventory();
                    break;

                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}

class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int productId;
    private String productName;
    private double price;
    private int quantity;

    public Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Price: $" + price + ", Quantity: " + quantity;
    }
}

class InventoryManager {
    private ArrayList<Product> inventory;
    private final String FILE_NAME = "inventory.ser";

    public InventoryManager() {
        this.inventory = new ArrayList<>();
        loadInventoryFromFile();
    }

    public void addProduct(int productId, String productName, double price, int quantity) {
        Product newProduct = new Product(productId, productName, price, quantity);
        inventory.add(newProduct);
        saveInventoryToFile();
        System.out.println("Product added to the inventory.");
    }

    public void removeProduct(int productId) {
        for (Product product : inventory) {
            if (product.getProductId() == productId) {
                inventory.remove(product);
                saveInventoryToFile();
                System.out.println("Product removed from the inventory.");
                return;
            }
        }
        System.out.println("Product with ID " + productId + " not found in the inventory.");
    }

    public void displayInventory() {
        System.out.println("\nInventory:");
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    private void saveInventoryToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(inventory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadInventoryFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                inventory = (ArrayList<Product>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            // Ignore if file doesn't exist or couldn't be loaded
        }
    }
}