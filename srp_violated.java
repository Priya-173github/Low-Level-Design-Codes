import java.util.ArrayList;
import java.util.List;

/*
 SRP - Single Responsibility Principle
 This class structure VIOLATES SRP because
 ShoppingCart handles:
 1. Business logic (total calculation)
 2. Presentation logic (printing invoice)
 3. Persistence logic (saving to DB)
*/

// Product class
class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// ShoppingCart class violating SRP
class ShoppingCart {

    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    // Responsibility 1: Business logic
    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.price;
        }
        return total;
    }

    // Responsibility 2: Presentation logic
    public void printInvoice() {
        System.out.println("Invoice:");
        for (Product product : products) {
            System.out.println(product.name + " - $" + product.price);
        }
        System.out.println("Total: $" + calculateTotalPrice());
    }

    // Responsibility 3: Persistence logic
    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
        System.out.println("Shopping cart saved to database.");
    }
}

// Driver class
public class srp_violated {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 1500.0));
        cart.addProduct(new Product("Mouse", 50.0));

        // Demonstrating SRP violation
        cart.printInvoice();
        cart.saveToDatabase();
    }
}
