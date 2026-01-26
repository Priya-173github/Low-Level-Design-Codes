// ISP COMPLIANT:
// Clients depend only on interfaces they actually use

// -------------------- Area Interface (2D & 3D) --------------------
interface AreaShape {
    double area();
}

// -------------------- Volume Interface (3D only) --------------------
interface VolumeShape {
    double volume();
}

// -------------------- Square (2D Shape) --------------------
class Square implements AreaShape {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}

// -------------------- Cube (3D Shape) --------------------
class Cube implements AreaShape, VolumeShape {

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
public class ISP_Compliant {

    public static void main(String[] args) {

        AreaShape square = new Square(5);
        System.out.println("Square Area: " + square.area());

        AreaShape cubeArea = new Cube(3);
        VolumeShape cubeVolume = new Cube(3);

        System.out.println("Cube Area: " + cubeArea.area());
        System.out.println("Cube Volume: " + cubeVolume.volume());
    }
}
