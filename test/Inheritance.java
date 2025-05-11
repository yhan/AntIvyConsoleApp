public class Inheritance {
}

class A {
    public void foo(){}
}
class B extends A {
    @Override // ths is optional but highly recommended. Compile time check
    public void foo(){
        System.out.println("B foo");
    }
}