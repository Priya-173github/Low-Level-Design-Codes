import java.util.ArrayList;
import java.util.List;

/*
 OCP COMPLIANT:
 - New persistence types can be added by EXTENDING classes
 - Existing code remains UNCHANGED
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

// -------------------- Printer --------------------
class ShoppingCartPrinter {

    public void printInvoice(ShoppingCart cart) {
        System.out.println("Invoice:");
        for (Product product : cart.getProducts()) {
            System.out.println(product.name + " - $" + product.price);
        }
        System.out.println("Total: $" + cart.calculateTotalPrice());
    }
}

// -------------------- Persistence Abstraction --------------------
interface Persistence {
    void save(ShoppingCart cart);
}

// -------------------- SQL Persistence --------------------
class SQLPersistence implements Persistence {

    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saving shopping cart to SQL database...");
    }
}

// -------------------- MongoDB Persistence --------------------
class MongoPersistence implements Persistence {

    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saving shopping cart to MongoDB...");
    }
}

// -------------------- File Persistence --------------------
class FilePersistence implements Persistence {

    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saving shopping cart to a file...");
    }
}

// -------------------- Driver Class --------------------
public class OCP_Compliant {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 1500.0));
        cart.addProduct(new Product("Mouse", 50.0));

        ShoppingCartPrinter printer = new ShoppingCartPrinter();
        printer.printInvoice(cart);

        // OCP in action
        Persistence sql = new SQLPersistence();
        Persistence mongo = new MongoPersistence();
        Persistence file = new FilePersistence();

        sql.save(cart);
        mongo.save(cart);
        file.save(cart);

        // ✅ To add Cassandra:
        // class CassandraPersistence implements Persistence { ... }
        // NO existing code changes needed
    }
}
