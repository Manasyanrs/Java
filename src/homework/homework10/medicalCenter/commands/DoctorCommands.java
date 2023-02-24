package homework.homework10.medicalCenter.commands;

import homework.homework10.medicalCenter.models.Doctor;
import homework.homework10.medicalCenter.models.Person;
import homework.homework10.medicalCenter.dataBase.PersonDataBase;

import java.util.Scanner;

public interface DoctorCommands {
    Scanner scanner = new Scanner(System.in);
    PersonDataBase personDB = new PersonDataBase();


    static void addDoctor() {
        String createDoctorId = getDoctorId();

        System.out.print("Please enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Please enter the surName: ");
        String surName = scanner.nextLine();

        System.out.print("Please enter the doctor phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Please enter the doctor profession: ");
        String doctorProfession = scanner.nextLine();

        System.out.print("Please enter the doctors email: ");
        String email = scanner.nextLine();

        Doctor doctor = new Doctor(createDoctorId, name, surName, phoneNumber, doctorProfession, email);
        personDB.addPerson(doctor);
    }

    static void searchPersonByProfession() {
        System.out.print("Please enter the doctor profession: ");
        String profession = scanner.nextLine();
        System.out.println(personDB.searchPersonByProfession(profession));
    }

    static void deletePersonById() {
        if (personDB.isEmptyDataBase()) {
            personDB.printAllPerson();
            System.out.print("Please enter the doctor id for delete: ");
            String doctorId = scanner.nextLine();
            personDB.deletePersonById(doctorId);
        } else {
            System.out.println("Data base is empty. ");
        }
    }

    static void changePersonDate() {
        if (personDB.isEmptyDataBase()) {
            personDB.printAllDoctors();
            System.out.print("Please enter person id by change date: ");
            String changePersonId = scanner.nextLine();
            if (personDB.changePersonDateInDataBaseById(changePersonId)) {
                changePersonDateById(changePersonId);
            }else {
                System.out.println("Try again:");
            }
        } else {
            System.out.println("Data base is empty. ");
        }
    }

    static void printAllDoctorsPatients() {
        if (personDB.isEmptyDataBase()) {
            personDB.printAllDoctors();
            System.out.print("Please enter a doctor ID to view patients: ");
            String doctorId = scanner.nextLine();
            Doctor doctor = getDoctorById(doctorId);
            if (doctor != null) {
                doctor.doctorPatients();
            }
        } else {
            System.out.println("Data base is empty.");
        }
    }

    private static String getDoctorId() {
        System.out.print("Please enter the doctor id: ");
        String doctorId = scanner.nextLine();
        if (personDB.existsByPersonIdInDataBase(doctorId)) {
            System.out.println("Sorry but this doctor id already exists.");
            getDoctorId();
        }
        return doctorId;
    }

    private static Doctor getDoctorById(String personId) {
        try {
            Person person = personDB.getPerson(personId);
            return (Doctor) person;
        } catch (NullPointerException e) {
            System.out.println("Person by id: " + personId + " not found.");
        }
        return null;
    }

    private static void changePersonDateById(String personId) {
        Doctor doctor = getDoctorById(personId);
        changeDate:
        while (true) {
            System.out.println(doctor);
            System.out.print("Press 0 to exit\n" +
                    "Press 1 to change person name \n" +
                    "Press 2 to change person surname \n" +
                    "Press 3 to change person phone number \n" +
                    "Press 4 to change person profession \n" +
                    "Press 5 to change person email \n" +
                    "Make a choice: ");
            String changePersonDateCommand = scanner.nextLine();
            if (changePersonDateCommand.equals("0")) {
                break changeDate;
            }
            changePersonDateCommandsHandler(doctor, changePersonDateCommand);
        }
    }

    private static void changePersonDateCommandsHandler(Doctor doctor, String command) {
        switch (command) {
            case "1":
                System.out.print("Please enter the person new name: ");
                String newName = scanner.nextLine();
                doctor.setName(newName);
                break;
            case "2":
                System.out.print("Please enter the person new sur name: ");
                String newSurName = scanner.nextLine();
                doctor.setSurname(newSurName);
                break;
            case "3":
                System.out.print("Please enter the person new phone number: ");
                String newPhoneNumber = scanner.nextLine();
                doctor.setPhoneNumber(newPhoneNumber);
                break;
            case "4":
                System.out.print("Please enter the person new profession: ");
                String newProfession = scanner.nextLine();
                doctor.setProfession(newProfession);
                break;
            case "5":
                System.out.print("Please enter the person new email: ");
                String newEmail = scanner.nextLine();
                doctor.setEmail(newEmail);
                break;
            default:
                System.out.println("Please enter the trust command!");
        }
    }
}
