package chapter2;

public class MultiplicationTable {
    public static void main(String[] args) {
        for(int first_number = 1; first_number < 10; ++first_number) {
            for(int second_number = 2; second_number < 10; ++second_number) {
                int result = second_number * first_number;
                System.out.print("" + second_number + " x " + first_number + " = " + result + "     ");
            }

            System.out.println();
        }

        System.out.println("End the process multiplication table");
    }
}
