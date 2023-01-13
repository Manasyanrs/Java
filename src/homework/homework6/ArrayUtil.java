package homework.homework6;

public class ArrayUtil {
    void sortedArrayFromMinToMax(int[] array) {
        for (int startIndex = 0; startIndex < array.length; startIndex++) {
            for (int i = startIndex + 1; i < array.length; i++) {
                if (array[startIndex] > array[i]) {
                    int maxNumber = array[startIndex];
                    array[startIndex] = array[i];
                    array[i] = maxNumber;
                }
            }
        }
        for (int number : array) {
            System.out.print(number + ", ");
        }
        System.out.println();
    }

    void sortedArrayFromMaxToMin(int[] array) {
        for (int startIndex = 0; startIndex < array.length; startIndex++) {
            for (int i = startIndex + 1; i < array.length; i++) {
                if (array[startIndex] < array[i]) {
                    int minNumber = array[startIndex];
                    array[startIndex] = array[i];
                    array[i] = minNumber;
                }
            }
        }
        for (int number : array) {
            System.out.print(number + ", ");
        }
        System.out.println();
    }

    void deleteStartAndEndSpaces(char[] array) {
        int countSpace = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ' && array[array.length - 1 - i] == ' ') {
                countSpace += 2;
                array[i] = '*';
                array[array.length - 1 - i] = '*';

            } else if (array[i] == ' ' || array[array.length - 1 - i] == ' ') {
                countSpace++;
                if (array[i] == ' ') {
                    array[i] = '*';
                } else {
                    array[array.length - 1 - i] = '*';
                }
                break;

            } else {
                break;
            }
        }

        int resultIndex = 0;
        char[] result = new char[array.length - countSpace];
        for (char symbol : array) {
            if (symbol != '*') {
                result[resultIndex] = symbol;
                resultIndex++;
            }
        }

        for (char symbol : result) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
