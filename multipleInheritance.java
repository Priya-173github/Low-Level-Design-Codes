/// How multiple inheritance fails
// class A {
//     void show() {
//         System.out.println("A");
//     }
// }

// class B {
//     void show() {
//         System.out.println("B");
//     }
// }

// //  INVALID in Java
// class C extends A, B { }

interface A {
    void show();
}

interface B {
    void show();
}

// Allowed
class C implements A, B {

    public void show() {
        System.out.println("C implementation");
    }
}

public class multipleInheritance{
    public static void main(String[] args) {
        C obj = new C();
        obj.show();
    }
}

