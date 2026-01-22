import java.util.ArrayList;
import java.util.List;

/*
 OCP VIOLATION:
 Persistence logic is controlled using conditionals.
 Adding a new persistence type REQUIRES modifying this class.
*/

// -------------------- Product --------------------
class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// -------------------- ShoppingCart --------------------
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

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.price;
        }
        return total;
    }
}

// -------------------- ShoppingCartPrinter --------------------
class ShoppingCartPrinter {

    public void printInvoice(ShoppingCart cart) {
        System.out.println("Invoice:");
        for (Product product : cart.getProducts()) {
            System.out.println(product.name + " - $" + product.price);
        }
        System.out.println("Total: $" + cart.calculateTotalPrice());
    }
}

// -------------------- Persistence Service (OCP VIOLATED) --------------------
class PersistenceService {

    public void save(ShoppingCart cart, String type) {

        if (type.equalsIgnoreCase("SQL")) {
            System.out.println("Saving shopping cart to SQL database...");
        } 
        else if (type.equalsIgnoreCase("MONGO")) {
            System.out.println("Saving shopping cart to MongoDB...");
        } 
        else if (type.equalsIgnoreCase("FILE")) {
            System.out.println("Saving shopping cart to file...");
        } 
        else {
            System.out.println("Invalid persistence type!");
        }
    }
}

// -------------------- Driver Class --------------------
public class OCP_Violated {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 1500.0));
        cart.addProduct(new Product("Mouse", 50.0));

        ShoppingCartPrinter printer = new ShoppingCartPrinter();
        printer.printInvoice(cart);

        PersistenceService persistenceService = new PersistenceService();

        persistenceService.save(cart, "SQL");
        persistenceService.save(cart, "MONGO");
        persistenceService.save(cart, "FILE");

        // ❌ To add Cassandra:
        // Must MODIFY PersistenceService class → OCP violation
    }
}
