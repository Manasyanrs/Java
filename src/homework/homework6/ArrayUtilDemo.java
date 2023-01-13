package homework.homework6;

public class ArrayUtilDemo {
    public static void main(String[] args) {
        int[] array = {2, 5, 8, 10, 88, 22, 11, 66, 12, 30, 6, 4, 3};
        char[] spaceArray = {' ', 'c', 'a', 't', ' ', 'b', 'i', ' ', 'b', ' ', ' '};


        ArrayUtil sortArray = new ArrayUtil();
        System.out.println("Called method \"sorted array from min. to max.\":");
        sortArray.sortedArrayFromMinToMax(array);

        System.out.println("\nCalled method \"sorted array from max. to min.\":");
        sortArray.sortedArrayFromMaxToMin(array);

        System.out.println("\nCalled method \"delete start and end spaces from the array\":");
        sortArray.deleteStartAndEndSpaces(spaceArray);
    }
}
