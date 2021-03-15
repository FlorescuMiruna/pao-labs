package pao.polimorfism;

// Dynamic Method Binding

class A{
    int x = 10;

    void m1(){
        System.out.println("Inside A's m1 method");
    }
}
class B extends A{
    int x = 20;

    void m1(){
        System.out.println("Inside B's m1 method");
    }
}

class C extends A{

    void m1(){
        System.out.println("Inside C's m1 method");
    }
}
public class DynamicMethodBinding {
    public static void main(String[] args) {

        A a = new A();
        B b = new B();
        C c = new C();

        A ref; // or A ref = new A()
        ref = a;

        //ref.m1();
        //System.out.println(ref.x); // runtime polymorphism cannot be achieved by data members

        ref = b;
        b.m1();
        System.out.println(ref.x); // runtime polymorphism cannot be achieved by data members

        System.out.println(b.x); // B b = new B()

        ref = c; // eq of: A a = new C(), upcasting
        // calling C's version of m1()
        ref.m1();
        System.out.println(ref.x); // runtime polymorphism cannot be achieved by data members

        A aDressedAsB = new B();
        A aDressedAsC = new C();

//        B bDressedAsA = (B) new A(); // downcasting -> ClassCastException

        B bDressedAsA1 = null;
        if (bDressedAsA1 instanceof A) {
            bDressedAsA1 = (B) a;
        }

    }

}
