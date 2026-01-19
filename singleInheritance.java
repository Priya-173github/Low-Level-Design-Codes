// Superclass
class Vehicle {

    public int speed = 100;        // public
    protected int mileage = 20;    // protected
    private int engineNo = 9999;   // private

    // public method to access private variable
    public int getEngineNo() {
        return engineNo;
    }
}

// Subclass
class Car extends Vehicle {

    void display() {

        System.out.println(speed);     //  public → accessible
        System.out.println(mileage);   //  protected → accessible via inheritance

        // System.out.println(engineNo);  private → NOT accessible

        // correct way to access private data
        System.out.println(getEngineNo()); //  via public method
    }
}

public class singleInheritance {
    public static void main(String[] args) {

        Car c = new Car();
        c.display();

        System.out.println(c.speed);   //  public → accessible
        // System.out.println(c.mileage);  protected → not via object (outside subclass)
        // System.out.println(c.engineNo); private → never accessible
    }
}
