public class Singleton {

    // volatile ensures visibility across threads
    private static volatile Singleton instance;

    // private constructor
    private Singleton() {
        System.out.println("Singleton Constructor Called!");
    }

    public static Singleton getInstance() {
        if (instance == null) { // first check (no locking)
            synchronized (Singleton.class) {
                if (instance == null) { // second check (with locking)
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2); // true
    }
}
