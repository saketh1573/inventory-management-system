import java.util.*;

class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class InventoryManagementSystem {
    Map<String, Product> inventory;

    public InventoryManagementSystem() {
        this.inventory = new HashMap<>();
    }

    // Product Management
    public void addProduct(String name, double price, int quantity) {
        Product product = new Product(name, price, quantity);
        inventory.put(name, product);
        System.out.println("Product added: " + product.name);
    }

    public void updateProduct(String name, double price, int quantity) {
        if (inventory.containsKey(name)) {
            Product product = inventory.get(name);
            product.price = price;
            product.quantity = quantity;
            System.out.println("Product updated: " + product.name);
        } else {
            System.out.println("Product not found: " + name);
        }
    }

    public void removeProduct(String name) {
        if (inventory.containsKey(name)) {
            inventory.remove(name);
            System.out.println("Product removed: " + name);
        } else {
            System.out.println("Product not found: " + name);
        }
    }

    // Stock Tracking
    public void checkStock(String name) {
        if (inventory.containsKey(name)) {
            Product product = inventory.get(name);
            System.out.println("Stock for " + product.name + ": " + product.quantity);
        } else {
            System.out.println("Product not found: " + name);
        }
    }

    // Sales Recording
    public void recordSale(String name, int quantitySold) {
        if (inventory.containsKey(name)) {
            Product product = inventory.get(name);
            if (product.quantity >= quantitySold) {
                product.quantity -= quantitySold;
                System.out.println("Sale recorded: " + quantitySold + " units of " + product.name);
            } else {
                System.out.println("Insufficient stock for sale: " + product.name);
            }
        } else {
            System.out.println("Product not found: " + name);
        }
    }

    // Report Generation
    public void generateReport() {
        System.out.println("===== Inventory Report =====");
        for (Product product : inventory.values()) {
            System.out.println(product.name + " - Price: $" + product.price + " | Stock: " + product.quantity);
        }
        System.out.println("=============================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManagementSystem ims = new InventoryManagementSystem();

        while (true) {
            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Check Stock");
            System.out.println("5. Record Sale");
            System.out.println("6. Generate Report");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter initial stock quantity: ");
                    int quantity = scanner.nextInt();
                    ims.addProduct(name, price, quantity);
                    break;

                case 2:
                    System.out.print("Enter product name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Enter new stock quantity: ");
                    int newQuantity = scanner.nextInt();
                    ims.updateProduct(updateName, newPrice, newQuantity);
                    break;

                case 3:
                    System.out.print("Enter product name to remove: ");
                    String removeName = scanner.nextLine();
                    ims.removeProduct(removeName);
                    break;

                case 4:
                    System.out.print("Enter product name to check stock: ");
                    String checkStockName = scanner.nextLine();
                    ims.checkStock(checkStockName);
                    break;

                case 5:
                    System.out.print("Enter product name for sale: ");
                    String saleName = scanner.nextLine();
                    System.out.print("Enter quantity sold: ");
                    int quantitySold = scanner.nextInt();
                    ims.recordSale(saleName, quantitySold);
                    break;

                case 6:
                    ims.generateReport();
                    break;

                case 7:
                    System.out.println("Exiting Inventory Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}
