package chapter10;

public class Exc2 {
    public static void main(String[] args) {
        int d;
        int a;

        try {
            d = 0;
            a = 42 / d;
            System.out.println("Это не будет выведеною");
        } catch (ArithmeticException e) {
            System.out.println("Дeлeниe на ноль.");
        }
        System.out.println("Пocлe оператора catch.");
    }
}
