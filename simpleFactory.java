// ===== PRODUCT INTERFACE =====
interface Burger {
    void prepare();
}

// ===== CONCRETE PRODUCTS =====
class BasicBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Burger with bun and patty.");
    }
}

class StandardBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettuce.");
    }
}

class PremiumBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Premium Burger with gourmet bun, double patty, extra cheese, and special sauce.");
    }
}

// ===== SIMPLE FACTORY =====
class BurgerFactory {

    public static Burger createBurger(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Burger type cannot be null");
        }

        switch (type.toLowerCase()) {
            case "basic":
                return new BasicBurger();
            case "standard":
                return new StandardBurger();
            case "premium":
                return new PremiumBurger();
            default:
                throw new IllegalArgumentException("Invalid burger type: " + type);
        }
    }
}

// ===== CLIENT =====
public class simpleFactory {

    public static void main(String[] args) {

        // Order Standard Burger
        Burger burger1 = BurgerFactory.createBurger("standard");
        burger1.prepare();

        // Order Basic Burger
        Burger burger2 = BurgerFactory.createBurger("basic");
        burger2.prepare();

        // Order Premium Burger
        Burger burger3 = BurgerFactory.createBurger("premium");
        burger3.prepare();
    }
}
