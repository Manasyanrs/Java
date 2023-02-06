package chapter8;

abstract class AbstractA {
    abstract void callMe();

    void callMeToo() {
        System.out.println("Этo конкретный метод.");
    }
}


class AbstractB extends AbstractA {

    void callMe() {
        System.out.println("Реализация метода callMe() в классе AbstractB.");
    }
}