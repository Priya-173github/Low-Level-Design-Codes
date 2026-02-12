
// ===== PRODUCT INTERFACE =====
interface Burger {
    void prepare();
}

// ===== NORMAL BURGERS =====
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

// ===== WHEAT BURGERS =====
class BasicWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Wheat Burger with whole wheat bun and lean patty.");
    }
}

class StandardWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Standard Wheat Burger with whole wheat bun, lean patty, cheese, and fresh veggies.");
    }
}

class PremiumWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Premium Wheat Burger with artisan whole wheat bun, organic double patty, olive oil, and organic greens.");
    }
}

// ===== ABSTRACT CREATOR =====
abstract class BurgerFactory {
    public abstract Burger createBurger(String type);
}

// ===== CONCRETE CREATOR 1 =====
class SingBurgerFactory extends BurgerFactory {
    @Override
    public Burger createBurger(String type) {
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
                throw new IllegalArgumentException("Invalid burger type for SingBurger: " + type);
        }
    }
}

// ===== CONCRETE CREATOR 2 =====
class KingBurgerFactory extends BurgerFactory {
    @Override
    public Burger createBurger(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Burger type cannot be null");
        }

        switch (type.toLowerCase()) {
            case "basic":
                return new BasicWheatBurger();
            case "standard":
                return new StandardWheatBurger();
            case "premium":
                return new PremiumWheatBurger();
            default:
                throw new IllegalArgumentException("Invalid burger type for KingBurger: " + type);
        }
    }
}

// ===== CLIENT =====
public class factoryMethod {
    public static void main(String[] args) {

        // Normal Burgers
        BurgerFactory singFactory = new SingBurgerFactory();
        Burger burger1 = singFactory.createBurger("basic");
        burger1.prepare();

        System.out.println("-----");

        // Wheat Burgers
        BurgerFactory kingFactory = new KingBurgerFactory();
        Burger burger2 = kingFactory.createBurger("premium");
        burger2.prepare();
    }
}
