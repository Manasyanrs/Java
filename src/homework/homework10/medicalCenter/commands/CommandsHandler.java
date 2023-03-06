package homework.homework10.medicalCenter.commands;

import java.util.Scanner;

public interface CommandsHandler extends DoctorCommands, PatientsCommands {

    default boolean printCommands(Scanner scanner) {
        System.out.print("\nPress 0 to exit: \n" +
                "Press 1 to add doctor: \n" +
                "Press 2 to search doctor by profession: \n" +
                "Press 3 to delete doctor by id: \n" +
                "Press 4 to change doctor data by id(բացի իդ-ից ամեն ինչ կարողանալու ենք փոխել): \n" +
                "Press 5 to add patient(ընտրելու եք բժշկին, բայց ստուգեք որ էդ ժամը զբաղված չլինի: \n" +
                "Press 6 to print all  patients by doctor: \n" +
                "Press 7 to print todays patients: \n" +
                "Make a choice: ");

        String command = scanner.nextLine();

        commandsHandler(command);

        return !command.equals("0");
    }

    private void commandsHandler(String command) {
        switch (command) {
            case "0":
                break;
            case "1":
                addDoctor();
                break;
            case "2":
                searchPersonByProfession();
                break;
            case "3":
                deleteDoctorById();
                break;
            case "4":
                changePersonDate();
                break;
            case "5":
                addPatient();
                break;
            case "6":
                printAllDoctorsPatients();
                break;
            case "7":
                toDaysPatients();
                break;
            default:
                System.out.println("Please enter the trust command!");
        }
    }
}
