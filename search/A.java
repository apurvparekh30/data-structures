abstract class C {
    int a;
    C(int a){
        this.a = a;
    }
}
class B extends C{
    int b = 100;
    B(int b){
        super(b);
    }
}

class A extends C {
    A(int a){
        super(a);
    }
    public static void main(String[] args) {
        A aa = new A(10);
        B bb = new B(12);
        System.out.println(bb.a);
        System.out.println(aa.a);
    }
}

