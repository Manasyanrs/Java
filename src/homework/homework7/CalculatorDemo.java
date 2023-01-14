package homework.homework7;

public class CalculatorDemo {
    public static void main(String[] args) {
        double[] array = {1.2, 14, 22.3, 59, 0, 589, 4.5};
        Calculator calculate = new Calculator();
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            System.out.println(array[i] + " + " + array[index] + " = " + calculate.plus(array[i], array[index]));
            System.out.println(array[i] + " - " + array[index] + " = " + calculate.minus(array[i], array[index]));
            double divide = calculate.divide(array[i], array[index]);

            if (divide != -1) {
                System.out.println(array[i] + " / " + array[index] + " = " + divide);
            }
            System.out.println(array[i] + " * " + array[index] + " = " + calculate.multiply(array[i], array[index]));
            System.out.println();
            index++;
        }
    }
}
