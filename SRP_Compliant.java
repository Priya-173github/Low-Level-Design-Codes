import java.util.ArrayList;
import java.util.List;

/*
 SRP - Single Responsibility Principle
 Each class below has ONE responsibility and ONE reason to change.
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

// -------------------- ShoppingCart (Business Logic) --------------------
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

// -------------------- InvoicePrinter (Presentation Logic) --------------------
class InvoicePrinter {

    public void printInvoice(ShoppingCart cart) {
        System.out.println("Invoice:");
        for (Product product : cart.getProducts()) {
            System.out.println(product.name + " - $" + product.price);
        }
        System.out.println("Total: $" + cart.calculateTotalPrice());
    }
}

// -------------------- CartRepository (Persistence Logic) --------------------
class CartRepository {

    public void save(ShoppingCart cart) {
        System.out.println("Saving shopping cart to database...");
        System.out.println("Shopping cart saved to database.");
    }
}

// -------------------- Driver Class --------------------
public class SRP_Compliant {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 1500.0));
        cart.addProduct(new Product("Mouse", 50.0));

        InvoicePrinter printer = new InvoicePrinter();
        CartRepository repository = new CartRepository();

        printer.printInvoice(cart);
        repository.save(cart);
    }
}
