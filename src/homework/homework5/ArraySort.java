package homework.homework5;

public class ArraySort {
    public static void main(String[] args) {
        int[] numbers = {43, -3, 55, 5, -9, 0, 12, 5, 65, 123};

        for (int startIndex = 0; startIndex < numbers.length; startIndex++) {
            for (int i = startIndex + 1; i < numbers.length; i++) {
                if (numbers[startIndex] < numbers[i]) {
                    int minNumber = numbers[startIndex];
                    numbers[startIndex] = numbers[i];
                    numbers[i] = minNumber;
                }
            }
        }
        for (int number : numbers) {
            System.out.print(number + ", ");
        }
        System.out.println();

        for (int startIndex = 0; startIndex < numbers.length; startIndex++) {
            for (int i = startIndex + 1; i < numbers.length; i++) {
                if (numbers[startIndex] > numbers[i]) {
                    int maxNumber = numbers[startIndex];
                    numbers[startIndex] = numbers[i];
                    numbers[i] = maxNumber;
                }
            }
        }
        for (int number : numbers) {
            System.out.print(number + ", ");
        }
    }
}
