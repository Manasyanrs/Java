package chapter2;

public class OperatorIf {
    public static void main(String[] args) {
        int digit = 10;
        if (digit > 0) {
            System.out.println("" + digit + " > 0 ");
            digit *= 2;
        }

        System.out.println(digit + " * 2 = " + digit);
    }
}
