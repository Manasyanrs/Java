package chapter3;

public class ChristmasTree {
    public static void main(String[] args) {
        int countIterations = 1;
        for (int i = 10; i < 23; i += 1) {
            if (i <= 20){
                for (int j = 20; j > 0; j -= 1) {
                    if (j == i){
                        for (int k = 0; k < countIterations; k++) {
                            System.out.print("*");
                        }
                        countIterations += 2;
                    }
                    else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            else {
                System.out.println("         ***");
            }

        }
    }
}
