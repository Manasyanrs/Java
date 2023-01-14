package homework.homework7;

public class Calculator {
    double plus(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    double minus(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    double divide(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            System.out.println("Exception: division by zero.\nNumber cannot be divided by zero");
            return -1;
        } else {
            return firstNumber / secondNumber;
        }
    }

    double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }
}
