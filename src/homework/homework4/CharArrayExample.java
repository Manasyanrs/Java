package homework.homework4;

public class CharArrayExample {
    public static void main(String[] args) {
        char[] chars = {'j', 'a', 'v', 'a', 'l', 'o', 'v', 'e',};
        char[] chars3 = {'j', 'a', 'v', 'a', 'l', 'o', 'l', 'y'};
        char[] text = {' ', ' ', 'b', 'a', 'r', 'e', 'v', ' ', ' ' };
        char c = 'o';
        boolean flag = false;
        int countCharC = 0;
        for (char element : chars) {
            if (c == element) {
                countCharC += 1;
            }
        }
        System.out.println("Count symbol 'c' in chars = " + countCharC);
        if (chars.length % 2 == 0) {
            System.out.println("\nBetween symbols is chars " + chars[chars.length / 2 - 1] + " and " + chars[chars.length / 2]);
        } else {
            System.out.println("\nAs chars length is odd take 3 symbols:");
            System.out.println("Between symbols is chars " + chars[chars.length / 2 - 1] + " , " + chars[chars.length / 2] + " and " + chars[chars.length / 2 + 1]);
        }

        System.out.print("\nDoes 'ly' end with chars3: ");
        if (chars3[chars3.length - 2] == 'l' && chars3[chars3.length - 1] == 'y') {
            flag = true;
        }

        System.out.print(flag);
        System.out.println();
        System.out.print("\nLetter(s) in text is: ");

        for (char letter : text) {
            if (letter != ' ') {
                System.out.print("'" + letter + "', ");
            }
        }
    }
}
