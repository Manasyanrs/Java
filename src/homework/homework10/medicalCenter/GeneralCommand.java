package homework.homework10.medicalCenter;

import homework.homework10.medicalCenter.commands.CommandsHandler;
import homework.homework10.medicalCenter.dataBase.PersonDataBase;
import homework.homework10.medicalCenter.models.Doctor;
import homework.homework10.medicalCenter.models.Patient;
import homework.homework10.medicalCenter.models.Person;

import java.util.Date;
import java.util.Scanner;

import static homework.homework10.medicalCenter.DateUtil.DateUtils.parseToDate;
import static homework.homework10.medicalCenter.DateUtil.DateUtils.parseToTime;

public class GeneralCommand implements CommandsHandler {
    Scanner scanner = new Scanner(System.in);
    PersonDataBase personDB = new PersonDataBase();

    public void addDoctor() {
        String createDoctorId = getPersonId();

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

    public void searchPersonByProfession() {
        System.out.print("Please enter the doctor profession: ");
        String profession = scanner.nextLine();
        System.out.println(searchPersonByProfession(profession));
    }

    public void deleteDoctorById() {
        if (personDB.isEmptyDataBase()) {
            printAllDoctors();
            System.out.print("Please enter the doctor id for delete: ");
            String doctorId = scanner.nextLine();
            Doctor doctor = getDoctorById(doctorId);
            if (doctor != null) {
                for (int i = 0; i < doctor.getPatientsSize(); i++) {
                    personDB.deletePersonById(doctor.getPatientsId()[i]);
                }
                personDB.deletePersonById(doctorId);
            }
        } else {
            System.out.println("Data base is empty. ");
        }

    }

    public void printAllDoctorsPatients() {
        if (personDB.isEmptyDataBase()) {
            printAllDoctors();
            System.out.print("Please enter a doctor ID to view patients: ");
            String doctorId = scanner.nextLine();
            Doctor doctor = getDoctorById(doctorId);
            if (doctor != null) {
                doctorPatients(doctor);
            }
        } else {
            System.out.println("Data base is empty.");
        }
    }

    public void changePersonDate() {
        if (personDB.isEmptyDataBase()) {
            printAllDoctors();
            System.out.print("Please enter person id by change date: ");
            String changePersonId = scanner.nextLine();
            if (changePersonDateInDataBaseById(changePersonId)) {
                utilsChangePersonDate(changePersonId);
            } else {
                System.out.println("Try again:");
            }
        } else {
            System.out.println("Data base is empty. ");
        }
    }

    private void utilsChangePersonDate(String personId) {
        Doctor doctor = getDoctorById(personId);

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
                break;
            }
            changePersonDateCommandsHandler(doctor, changePersonDateCommand);
        }
    }

    private Doctor getDoctorById(String personId) {
        try {
            Person doctor = personDB.getPerson(personId);
            return (Doctor) doctor;
        } catch (NullPointerException e) {
            System.out.println("Doctor by id: " + personId + " not found.");
        }
        return null;
    }

    private void changePersonDateCommandsHandler(Doctor doctor, String command) {
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

    private void doctorPatients(Doctor doctor) {
        if (doctor.getPatientsSize() != 0) {
            for (int i = 0; i < doctor.getPatientsSize(); i++) {
                System.out.println(personDB.getPerson(doctor.getPatientsId()[i]));
            }
        } else {
            System.out.println("This doctor das not have patients");
        }
    }

    private boolean patientsTime(Doctor person, Date time, int date) {
        boolean isFreeTime = true;
        String registerPatientsTime = "";
        for (int i = 0; i < person.getPatientsSize(); i++) {
            Patient patient = (Patient) personDB.getPerson(person.getPatientsId()[i]);
            Date registerDate = patient.getRegisterDate();
            Date registerTime = patient.getRegisterTime();

            registerPatientsTime += registerTime.getHours() + " : " +
                    registerTime.getMinutes() + ",";

            if (date != registerDate.getDate()) {
                return true;
            } else {
                if (time.getMinutes() - 29 <= registerTime.getMinutes() &&
                        registerTime.getHours() >= time.getHours()) {
                    isFreeTime = false;
                }
            }
        }
        if (!isFreeTime) {
            System.out.println("Patients time to doctor " + person.getName());
            for (String patientsTime : registerPatientsTime.split(",")) {
                System.out.println(patientsTime);
            }
        }
        return !isFreeTime;
    }


    // Patients commands
    public void addPatient() {
        String createPersonId = getPersonId();

        System.out.print("Please enter the patient name: ");
        String name = scanner.nextLine();

        System.out.print("Please enter the patient surName: ");
        String surName = scanner.nextLine();

        System.out.print("Please enter the patient phone number: ");
        String phoneNumber = scanner.nextLine();

        Doctor doctor = chooseADoctor();
        if (doctor == null) {
            System.out.println("We not have a doctor. Good By");
            return;

        }
        Date checkDate = checkDate();
        while (checkDate == null) {
            checkDate = checkDate();
        }

        Date checkTime = checkTime(doctor, checkDate.getDate());

        Patient patient = new Patient(createPersonId, name, surName, phoneNumber, doctor, checkDate, checkTime);
        personDB.addPerson(patient);
        doctor.setPatientsId(createPersonId);
    }

    private Date checkDate() {
        System.out.print("Please pick a slot(25/01/2022): ");
        String pickASlot = scanner.nextLine();

        try {
            return parseToDate(pickASlot);

        } catch (RuntimeException e) {
            System.out.println("Please enter tne correct date(25/01/2022):");
        }
        return null;
    }

    private Date checkTime(Doctor person, int checkDate) {
        System.out.print("Please check the time(13:10) ");
        String checkTime = scanner.nextLine();

        try {
            Date isCorrect = parseToTime(checkTime);
            if (isCorrect == null || patientsTime(person, isCorrect, checkDate)) {
                System.out.println("Please pick another slot 30 minutes later.");
                checkTime(person, checkDate);
            }

            return isCorrect;

        } catch (RuntimeException e) {
            System.out.println("Please enter the correct time(15:25)");
            checkTime(person, checkDate);
        }
        return null;
    }

    private Doctor chooseADoctor() {
        printAllDoctors();

        System.out.print("Please choose a doctor by name: ");
        String chooseADoctor = scanner.nextLine();
        Doctor chooseDoctor = searchPersonByName(chooseADoctor);
        if (chooseDoctor == null) {
            System.out.println("Please enter the correct doctor name.");
        }
        return chooseDoctor;
    }

    private String getPersonId() {
        System.out.print("Please enter the person id: ");
        String personId = scanner.nextLine();
        if (existsByPersonIdInDataBase(personId)) {
            System.out.println("Sorry but this id already exists.");
            getPersonId();
        }
        return personId;
    }


    //DB commands
    public void toDaysPatients() {
        for (int i = 0; i < personDB.getSize(); i++) {
            try {
                Patient patient = (Patient) personDB.getPersonDataBase()[i];

                if (patient.getRegisterDate().getDate() == new Date().getDate()) {
                    System.out.println(personDB.getPersonDataBase()[i]);
                }
            } catch (ClassCastException e) {
            }
        }
    }

    private void printAllDoctors() {
        for (int i = 0; i < personDB.getSize(); i++) {
            try {
                Doctor doctor = (Doctor) personDB.getPersonDataBase()[i];
                System.out.println(doctor.toString());
            } catch (ClassCastException e) {

            }
        }
    }

    private Person searchPersonByProfession(String personProfession) {
        for (int i = 0; i < personDB.getSize(); i++) {
            try {
                Doctor doctor = (Doctor) personDB.getPersonDataBase()[i];
                if (doctor.getProfession().equals(personProfession)) {
                    return personDB.getPersonDataBase()[i];
                }
            } catch (ClassCastException e) {

            }

        }
        System.out.print("Person by id " + personProfession + " was not found. ");
        return null;
    }

    private boolean existsByPersonIdInDataBase(String personId) {
        for (int i = 0; i < personDB.getSize(); i++) {
            if (personDB.getPersonDataBase()[i].getId().equals(personId)) {
                return true;
            }
        }
        return false;
    }

    private boolean changePersonDateInDataBaseById(String personId) {
        for (int i = 0; i < personDB.getSize(); i++) {
            if (personDB.getPersonDataBase()[i].getId().equals(personId) && personDB.getPersonDataBase()[i] instanceof Doctor) {
                return true;
            }
        }
        return false;
    }

    private Doctor searchPersonByName(String personName) {
        for (int i = 0; i < personDB.getSize(); i++) {
            try {
                Doctor doctor = (Doctor) personDB.getPersonDataBase()[i];
                if (doctor.getName().equals(personName)) {
                    return doctor;
                }
            } catch (ClassCastException e) {
            }

        }
        System.out.print("Person by name։ " + personName + " was not found. ");
        return null;
    }
}
