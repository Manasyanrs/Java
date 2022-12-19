package homework.homework1;

public class FigurePainter {
    public static void main(String[] args) {
        System.out.println("Figure 1\n");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\nFigure 2\n");
        int iterations = 5;
        for (int i = 0; i < 5; i++) {
            iterations -= 1;

            for (int j = 0; j < 5; j++) {
                if (j >= iterations) {
                    System.out.print("* ");

                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println("\nFigure 3\n");
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
