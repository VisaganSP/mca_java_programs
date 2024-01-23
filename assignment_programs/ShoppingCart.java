import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    private ArrayList<ShoppingCartItem> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public void addItem(String name, double price, int quantity) {
        ShoppingCartItem newItem = new ShoppingCartItem(name, price, quantity);
        cartItems.add(newItem);
        System.out.println("Item added to the cart.");
    }

    public void removeItem(String name) {
        for (ShoppingCartItem item : cartItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                cartItems.remove(item);
                System.out.println("Item removed from the cart.");
                return;
            }
        }
        System.out.println("Item not found in the cart.");
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (ShoppingCartItem item : cartItems) {
            totalCost += item.getTotalCost();
        }
        return totalCost;
    }

    public void displayCart() {
        System.out.println("\nShopping Cart Items:");
        for (ShoppingCartItem item : cartItems) {
            System.out.println(item);
        }
        System.out.println("Total Cost: $" + calculateTotalCost());
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nShopping Cart Management");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Display Cart");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter item price: $");
                    double itemPrice = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int itemQuantity = scanner.nextInt();

                    shoppingCart.addItem(itemName, itemPrice, itemQuantity);
                    break;

                case 2:
                    System.out.print("Enter item name to remove: ");
                    String removeItemName = scanner.nextLine();
                    shoppingCart.removeItem(removeItemName);
                    break;

                case 3:
                    shoppingCart.displayCart();
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

class ShoppingCartItem {
    private String name;
    private double price;
    private int quantity;

    public ShoppingCartItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalCost() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Item: " + name + ", Price: $" + price + ", Quantity: " + quantity + ", Total Cost: $" + getTotalCost();
    }
}
