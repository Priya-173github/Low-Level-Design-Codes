public class SingletonEager {

    // Eager initialization - instance created at class loading time
    private static final SingletonEager instance = new SingletonEager();

    // Private constructor
    private SingletonEager() {
        System.out.println("Singleton Constructor Called!");
    }

    // Public method to get the instance
    public static SingletonEager getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2); // true
    }
}
