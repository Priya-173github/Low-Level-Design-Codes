interface A {
    default void show() {
        System.out.println("A");
    }
}

interface B {
    default void show() {
        System.out.println("B");
    }
}

class C implements A, B {
    public void show() {
        A.super.show(); // explicitly choose
    }
}

public class defaultMethods {
    public static void main(String[] args) {
        C obj = new C();
        obj.show();
    }
}
