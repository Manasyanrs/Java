package chapter2;

public class ForLoop {
    public static void main(String[] args) {
        int digit = 25;
        int count_iterations = 0;
        if (digit % 5 == 0) {
            System.out.println("True");

            for(digit = 25; digit >= 0; digit -= 5) {
                System.out.println(digit);
                ++count_iterations;
            }
        }

        System.out.println("Count operations the for loop = " + count_iterations);
    }
}
