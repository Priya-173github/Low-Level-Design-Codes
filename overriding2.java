class Parent {
    static void show() {
        System.out.println("Parent static method");
    }
}

class Child extends Parent {
    static void show() {
        System.out.println("Child static method");
    }
}

public class overriding2 {
    public static void main(String[] args) {

        Parent p = new Parent();
        Parent pc = new Child();
        Child c = new Child();

        p.show();   // ?
        pc.show();  // ?
        c.show();   // ?
    }
}
