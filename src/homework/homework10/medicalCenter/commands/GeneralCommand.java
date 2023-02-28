package homework.homework10.medicalCenter.commands;

import homework.homework10.medicalCenter.Profession;
import homework.homework10.medicalCenter.dataBase.PersonDataBase;
import homework.homework10.medicalCenter.models.Doctor;
import homework.homework10.medicalCenter.models.Patient;
import homework.homework10.medicalCenter.models.Person;

import java.util.Date;
import java.util.Scanner;

import static homework.homework10.medicalCenter.DateUtil.DateUtils.parseToDate;
import static homework.homework10.medicalCenter.DateUtil.DateUtils.parseToTime;

public class GeneralCommand implements CommandsHandler {
    PersonDataBase person = new PersonDataBase();
    Scanner scanner = new Scanner(System.in);

    public void addDoctor() {
        String createDoctorId = getPersonId();

        System.out.print("Please enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Please enter the surName: ");
        String surName = scanner.nextLine();

        System.out.print("Please enter the doctor phone number: ");
        String phoneNumber = scanner.nextLine();

        Profession profession = doctorProfession();

        System.out.print("Please enter the doctors email: ");
        String email = scanner.nextLine();

        person.addPerson(new Doctor(createDoctorId, name, surName, phoneNumber, profession, email));
        System.out.println("Doctor is created.");

    }

    private Profession doctorProfession() {
        System.out.println("Please choose the doctor profession: ");
        Profession[] values = Profession.values();
        for (Profession value : values) {
            System.out.println(value.ordinal() + 1 + ": " + value.name());
        }
        String scanner = this.scanner.nextLine();
        for (Profession value : values) {
            if (scanner.toUpperCase().equals(value.name()) || "1".equals(scanner) ||
                    "2".equals(scanner) || "3".equals(scanner) || "4".equals(scanner)) {
                return Profession.valueOf(value.name());
            }
        }
        System.out.println("Please input correct value of doctors profession. ");
        doctorProfession();
        return null;
    }

    public void searchPersonByProfession() {
        System.out.print("Please enter the doctor profession: ");
        String profession = scanner.nextLine();
        System.out.println(person.searchPersonByProfession(profession));
    }

    public void deleteDoctorById() {
        if (person.isEmptyDataBase()) {
            person.printAllDoctors();
            System.out.print("Please enter the doctor id for delete: ");
            String doctorId = scanner.nextLine();
            Doctor doctor = getDoctorById(doctorId);
            if (doctor != null) {
                for (int i = 0; i < doctor.getPatientsSize(); i++) {
                    person.deletePersonById(doctor.getPatientsId()[i]);
                }
                person.deletePersonById(doctorId);
            }
        } else {
            System.out.println("Data base is empty. ");
        }

    }

    public void printAllDoctorsPatients() {
        if (person.isEmptyDataBase()) {
            person.printAllDoctors();
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
        if (person.isEmptyDataBase()) {
            person.printAllDoctors();
            System.out.print("Please enter person id by change date: ");
            String changePersonId = scanner.nextLine();
            if (person.changePersonDateInDataBaseById(changePersonId)) {
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
            Person doctor = person.getPerson(personId);
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
                System.out.println(person.getPerson(doctor.getPatientsId()[i]));
            }
        } else {
            System.out.println("This doctor das not have patients");
        }
    }

    private boolean patientsTime(Doctor doctor, Date time, int date) {
        boolean isFreeTime = true;
        String registerPatientsTime = "";

        for (int i = 0; i < doctor.getPatientsSize(); i++) {
            Patient patient = (Patient) person.getPerson(doctor.getPatientsId()[i]);

            Date registerDate = patient.getRegisterDate();
            Date registerTime = patient.getRegisterTime();

            registerPatientsTime += registerTime;

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
            System.out.println("Patients time to doctor " + doctor.getName());
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
        person.addPerson(patient);
        doctor.setPatientsId(createPersonId);
    }

    @Override
    public void toDaysPatients() {
        person.toDaysPatients();
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
        person.printAllDoctors();

        System.out.print("Please choose a doctor by name: ");
        String chooseADoctor = scanner.nextLine();
        Doctor chooseDoctor = person.searchPersonByName(chooseADoctor);
        if (chooseDoctor == null) {
            System.out.println("Please enter the correct doctor name.");
        }
        return chooseDoctor;
    }

    private String getPersonId() {
        System.out.print("Please enter the person id: ");
        String personId = scanner.nextLine();
        if (person.existsByPersonIdInDataBase(personId)) {
            System.out.println("Sorry but this id already exists.");
            getPersonId();
        }
        return personId;
    }

}
