// ISP VIOLATION:
// One interface forces all shapes to implement methods they don't need

// -------------------- Shape Interface --------------------
interface Shape {

    double area();

    // ❌ 2D shapes don't have volume
    double volume();
}

// -------------------- Square (2D Shape) --------------------
class Square implements Shape {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    // ❌ Forced to implement irrelevant method
    @Override
    public double volume() {
        throw new UnsupportedOperationException(
                "Volume not applicable for Square"
        );
    }
}

// -------------------- Cube (3D Shape) --------------------
class Cube implements Shape {

    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return 6 * side * side;
    }

    @Override
    public double volume() {
        return side * side * side;
    }
}

// -------------------- Client --------------------
public class ISP_Violated {

    public static void main(String[] args) {

        Shape square = new Square(5);
        System.out.println("Square Area: " + square.area());

        // ❌ Runtime failure
        System.out.println("Square Volume: " + square.volume());

        Shape cube = new Cube(3);
        System.out.println("Cube Area: " + cube.area());
        System.out.println("Cube Volume: " + cube.volume());
    }
}
