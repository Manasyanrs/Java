package homework.homework10.medicalCenter;

import java.util.Scanner;

public class MedicalCenter {
    private static final GeneralCommand GENERAL_COMMAND = new GeneralCommand();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (GENERAL_COMMAND.printCommands(SCANNER)) ;
    }
}
