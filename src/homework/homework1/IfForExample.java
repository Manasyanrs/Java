package homework.homework1;

public class IfForExample {
    public static void main(String[] args) {
        int first_number = 25;
        int second_number = 30;
        int count_iterations;

        if (first_number > second_number) {
            System.out.println("Max digit = " + first_number);
            count_iterations = first_number - second_number;
            int[] numbers = new int[count_iterations + 1];

            for (int i = 0; i <= count_iterations; i++) {
                numbers[i] = second_number + i;
            }
            for (int i = 0; i <= count_iterations; i++) {
                System.out.print(numbers[i] + ", ");
            }
            System.out.println();
        }
        if (first_number < second_number) {
            System.out.println("Max digit = " + second_number);
            count_iterations = second_number - first_number;
            int[] numbers = new int[count_iterations + 1];
            for (int i = 0; i <= count_iterations; i++) {
                numbers[i] = first_number + i;
            }
            for (int i = 0; i <= count_iterations; i++) {
                System.out.print(numbers[i] + ", ");
            }
            System.out.println();
        } else {
            System.out.println(first_number + " = " + second_number);
        }

        char a;
        a = 145;
        System.out.println("The number 145 will be in the symbol -->" + a);
        char b;
        b = 299;
        System.out.println("The number 299 will be in the symbol -->" + b);
        int first_digit = 25;
        int second_digit = 32;
        if (first_digit == second_digit) {
            System.out.println(first_digit + " = " + second_digit);
        } else {
            System.out.println(first_digit + " != " + second_digit);
        }
    }
}
