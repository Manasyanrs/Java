package chapter7;

public class Test2 {
    int a;
    int b;

    Test2(int i, int j) {
        a = i;
        b = j;
    }

    void meth(int i, int j) {
        i *= 2;
        j /= 2;
    }

    void meth(Test2 o) {
        o.a *= 2;
        o.b /= 2;
    }
}
