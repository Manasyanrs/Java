package homework.homework10.medicalCenter.commands;

import homework.homework10.medicalCenter.models.Doctor;
import homework.homework10.medicalCenter.models.Patient;

import java.util.Date;

import static homework.homework10.medicalCenter.DateUtil.DateUtils.*;

public interface PatientsCommands extends DoctorCommands {

    static void addPatient() {
        String createPersonId = getPersonId();

        System.out.print("Please enter the patient name: ");
        String name = scanner.nextLine();

        System.out.print("Please enter the patient surName: ");
        String surName = scanner.nextLine();

        System.out.print("Please enter the patient phone number: ");
        String phoneNumber = scanner.nextLine();

        Doctor doctor = chooseADoctor();
        if (doctor == null){
            System.out.println("We not have a doctor. Good By");
            return;

        }
        Date checkDate = checkDate();
        while (checkDate == null){
            checkDate = checkDate();
        }

        Date checkTime = checkTime(doctor, checkDate.getDate());
        while (checkTime == null){
            checkTime = checkTime(doctor, checkDate.getDate());
        }

        Patient patient = new Patient(createPersonId, name, surName, phoneNumber, doctor, checkDate, checkTime);
        personDB.addPerson(patient);
        doctor.setPatientsId(createPersonId);
    }

    static void toDaysPatients() {
        personDB.toDaysPatients();
    }

    private static Date checkDate(){
        System.out.print("Please pick a slot(25/01/2022): ");
        String pickASlot = scanner.nextLine();

        try {
            return parseToDate(pickASlot);

        } catch (RuntimeException e) {
            System.out.println("Please enter tne correct date(25/01/2022):");
        }
        return null;
    }

    private static Date checkTime(Doctor person, int checkDate) {
        System.out.print("Please check the time(13:10) ");
        String checkTime = scanner.nextLine();

        try {
            Date isCorrect = parseToTime(checkTime);

            if (!person.patientsTime(person, isCorrect, checkDate)) {
                System.out.println("Please pick another slot 30 minutes later.");
                return checkTime(person, checkDate);

            }
            return isCorrect;

        } catch (RuntimeException e) {
            System.out.println("Please enter the correct time(15:25)");
        }
        return null;
    }

    private static Doctor chooseADoctor() {
        personDB.printAllDoctors();

        System.out.print("Please choose a doctor by name: ");
        String chooseADoctor = scanner.nextLine();
        Doctor chooseDoctor = personDB.searchPersonByName(chooseADoctor);
        if (chooseDoctor == null) {
            System.out.println("Please enter the correct doctor name.");
        }
        return chooseDoctor;
    }

    private static String getPersonId() {
        System.out.print("Please enter the patient id: ");
        String personId = scanner.nextLine();
        if (personDB.existsByPersonIdInDataBase(personId)) {
            System.out.println("Sorry but this id already exists.");
            getPersonId();
        }
        return personId;
    }
}
