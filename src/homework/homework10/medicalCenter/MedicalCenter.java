package homework.homework10.medicalCenter;

import homework.homework10.medicalCenter.commands.Commands;

public class MedicalCenter implements Commands {
    public static boolean isRun = true;

    public static void main(String[] args) {

        while (isRun) {
            Commands.printCommands();
        }
    }
}
