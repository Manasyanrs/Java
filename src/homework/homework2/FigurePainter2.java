package homework.homework2;

public class FigurePainter2 {
    public static void main(String[] args) {
        System.out.println("Figure number 1");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            for (int j = 4; j > i; j--) {
                System.out.print(" *");
            }
            System.out.println();
        }

        System.out.println("Figure number 2");

        for (int i = 0; i < 7; i++) {
            if (i <= 3) {
                for (int j = 4; j > i; j--) {
                    System.out.print(" ");
                }

                for (int j = 0; j <= i; j++) {
                    System.out.print("* ");
                }
            } else {
                for (int j = 7 - i; j <= 4; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < 7 - i; j++) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
