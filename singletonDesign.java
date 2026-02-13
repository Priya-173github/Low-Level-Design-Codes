class Test {

    private Test() {
        System.out.println("Inside constructor");
    }

    static Test instance;

    public static Test getInstance() {
        if (instance != null) {
            return new Test();
        }
        return instance;
    }
}

public class singletonDesign {
    public static void main(String[] args) {
        Test t1 = Test.getInstance();
        Test t2 = Test.getInstance();

        System.out.println(t1 == t2);
    }
}