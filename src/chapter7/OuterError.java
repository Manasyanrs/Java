package chapter7;

public class OuterError {
    int outerX = 100;

    void test() {
        Inner inner = new Inner();
        inner.display();
    }

    class Inner {
        int y = 10;

        void display() {
            System.out.println("display(): outherX = " + outerX);
        }
    }

    void showY() {
//        System.out.println(y); //ошибка , переменная у здесь неизвестна
    }
}
