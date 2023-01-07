package homework.homework5;

public class ArraySpaceExample {
    public static void main(String[] args) {
        char[] spaceArray = {' ', 'c', 'a', 't', ' ', 'b', 'i', ' ', 'b', ' ', ' '};
        int countSpace = 0;
        for (int i = 0; i < spaceArray.length; i++) {
            if (spaceArray[i] == ' ' && spaceArray[spaceArray.length - 1 - i] == ' ') {
                countSpace += 2;
                spaceArray[i] = '*';
                spaceArray[spaceArray.length - 1 - i] = '*';

            } else if (spaceArray[i] == ' ' || spaceArray[spaceArray.length - 1 - i] == ' ') {
                countSpace++;
                if (spaceArray[i] == ' ') {
                    spaceArray[i] = '*';
                } else {
                    spaceArray[spaceArray.length - 1 - i] = '*';
                }
                break;

            } else {
                break;
            }
        }

        int resultIndex = 0;
        char result[] = new char[spaceArray.length - countSpace];
        for (char symbol : spaceArray) {
            if (symbol != '*') {
                result[resultIndex] = symbol;
                resultIndex++;
            }
        }

        for (char symbol : result) {
            System.out.print(symbol);
        }
    }
}
