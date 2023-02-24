package homework.homework10.medicalCenter.commands;

import homework.homework10.medicalCenter.MedicalCenter;

public interface Commands extends DoctorCommands {

    private static void isRun() {
        MedicalCenter.isRun = false;
    }

    static void printCommands() {
        System.out.print("\nPress 0 to exit: \n" +
                "Press 1 to add doctor: \n" +
                "Press 2 to search doctor by profession: \n" +
                "Press 3 to delete doctor by id: \n" +
                "Press 4 to change doctor data by id(բացի իդ-ից ամեն ինչ կարողանալու ենք փոխել): \n" +
                "Press 5 to add patient(ընտրելու եք բժշկին, բայց ստուգեք որ էդ ժամը զբաղված չլինի: \n" +
                "Press 6 to print all  patients by doctor: \n" +
                "Press 7 to print todays patients: \n" +
                "Make a choice: ");

        String command = DoctorCommands.scanner.nextLine();
        commandsHandler(command);
    }

    private static void commandsHandler(String command) {
        switch (command) {
            case "0":
                isRun();
                break;
            case "1":
                DoctorCommands.addDoctor();
                break;
            case "2":
                DoctorCommands.searchPersonByProfession();
                break;
            case "3":
                DoctorCommands.deletePersonById();
                break;
            case "4":
                DoctorCommands.changePersonDate();
                break;
            case "5":
                PatientsCommands.addPatient();
                break;
            case "6":
                DoctorCommands.printAllDoctorsPatients();
                break;
            case "7":
                PatientsCommands.toDaysPatients();
                break;

            default:
                System.out.println("Please enter the trust command!");
        }
    }
}
