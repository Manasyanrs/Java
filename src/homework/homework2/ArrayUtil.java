package homework.homework2;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] array = {2, 5, 8, 10, 32, 22, 11, 66, 12, 30};
        int max_digit = array[0];
        int min_digit = array[0];
        System.out.println("All array elements");
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > max_digit) {
                max_digit = array[i];
            }
            if (array[i] < min_digit) {
                min_digit = array[i];
            }
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        System.out.println("\nThe max digit in the array " + max_digit);
        System.out.println("\nThe min digit in the array " + min_digit);
    }
}
