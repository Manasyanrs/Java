package homework.homework2;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] array = {2, 5, 8, 10, 32, 22, 11, 66, 12, 30, 88, 1};
        int max_digit = array[0];
        int min_digit = array[0];
        int digit;
        System.out.print("All array elements: ");
        for (int i = 1; i < array.length; i++) {
            max_digit = array[i] > max_digit ? array[i] : max_digit;
            min_digit = array[i] < min_digit ? array[i] : min_digit;
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        System.out.println("\nThe max digit in the array " + max_digit);
        System.out.println("The min digit in the array " + min_digit);

        System.out.print("\nEven number(s): ");
        int count_event_numbers = 0;
        for (int i = 0; i < array.length; i++) {
            digit = array[i] % 2;
            if (digit == 0) {
                System.out.print(array[i] + ", ");
                count_event_numbers++;
            }

        }

        System.out.print("\nOdd number(s): ");
        int count_odd_numbers = 0;
        int total_sum_array_elements = 0;

        for (int i = 0; i < array.length; i++) {
            total_sum_array_elements += array[i];
            digit = array[i] % 2;
            if (digit == 1) {
                System.out.print(array[i] + ", ");
                count_odd_numbers++;
            }
        }
        System.out.println("\nThe number of even number(s) in the array is " + count_event_numbers);
        System.out.println("The number of odd number(s) in the array is " + count_odd_numbers);
        int array_average_value = total_sum_array_elements / array.length;
        System.out.println("\nArray average value = " + array_average_value);
        System.out.println("Total sum of the array elements = " + total_sum_array_elements);
        System.out.println("\nFirs element of the array: " + array[0]);
        System.out.println("Array end element: " + array[array.length - 1]);
        if (array.length % 2 == 0) {
            int middle_elements[] = new int[2];
            for (int i = 0; i < 2; i++) {
                middle_elements[i] = array[(array.length - 1) / 2 + i];
            }
            System.out.println("Middle element of the array: " + middle_elements[0] + ", " + middle_elements[1]);

        } else {
            System.out.println("Middle element of the array: " + array[array.length / 2]);

        }
    }
}
