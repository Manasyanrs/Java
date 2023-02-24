package homework.homework10.medicalCenter.dataBase;

import homework.homework10.medicalCenter.models.Doctor;
import homework.homework10.medicalCenter.models.Patient;
import homework.homework10.medicalCenter.models.Person;

import java.util.Date;

public class PersonDataBase {
    private static Person[] personDataBase = new Person[2];
    private int size = 0;

    public Person getPerson(String personId) {
        Person person = null;
        for (int i = 0; i < size; i++) {
            if (personDataBase[i].getId().equals(personId)) {
                person = personDataBase[i];
            }
        }
        return person;
    }

    public void printAllPerson() {
        if (isEmptyDataBase()) {
            for (int i = 0; i < size; i++) {
                System.out.println(personDataBase[i]);
            }
        } else {
            System.out.println("Data base is empty. ");
        }
    }

    public void printAllDoctors() {
        for (int i = 0; i < size; i++) {
            try {
                Doctor doctor = (Doctor) personDataBase[i];
                System.out.println(doctor.toString());
            } catch (ClassCastException e) {

            }
        }
    }

    public void toDaysPatients() {
        for (int i = 0; i < size; i++) {
            try {
                Patient patient = (Patient) personDataBase[i];
                if (patient.getRegisterDate().getDate() == new Date().getDate()) {
                    System.out.println(personDataBase[i]);
                }
            } catch (ClassCastException e) {

            }
        }
    }

    public void addPerson(Person value) {
        try {
            personDataBase[size++] = value;

        } catch (ArrayIndexOutOfBoundsException e) {
            --size;
            extend();
            addPerson(value);
        }
    }

    public Person searchPersonByProfession(String personProfession) {
        for (int i = 0; i < size; i++) {
            try {
                Doctor doctor = (Doctor) personDataBase[i];
                if (doctor.getProfession().equals(personProfession)) {
                    return personDataBase[i];
                }
            }catch (ClassCastException e){

            }

        }
        System.out.print("Person by id " + personProfession + " was not found. ");
        return null;
    }

    public void deletePersonById(String personId) {
        boolean isDonn = true;

        for (int i = 0; i < size; i++) {
            if (personDataBase[i].getId().equals(personId)) {
                personDataBase = removePersonById(personDataBase, i);
                isDonn = false;
            }
        }
        if (isDonn) {
            System.out.print("Person by id " + personId + " was not found. ");
        }
    }

    public boolean existsByPersonIdInDataBase(String personId) {
        for (int i = 0; i < size; i++) {
            if (personDataBase[i].getId().equals(personId)) {
                return true;
            }
        }
        return false;
    }

    public boolean changePersonDateInDataBaseById(String personId) {
        for (int i = 0; i < size; i++) {
            if (personDataBase[i].getId().equals(personId) && personDataBase[i] instanceof Doctor) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmptyDataBase() {
        if (size != 0) {
            return true;
        }
        return false;
    }

    public Doctor searchPersonByName(String personName) {
        for (int i = 0; i < size; i++) {
            try {
                Doctor doctor = (Doctor) personDataBase[i];
                if (doctor.getName().equals(personName)) {
                    return doctor;
                }
            } catch (ClassCastException e) {
            }

        }
        System.out.print("Person by name։ " + personName + " was not found. ");
        return null;
    }

    private Person[] removePersonById(Person[] person, int index) {
        Person[] result = new Person[person.length - 1];

        for (int i = 0; i < size; i++) {
            if (i != index) {
                result[i] = personDataBase[i];
            } else {
                result[i] = personDataBase[i + 1];
            }
        }
        --size;
        return result;
    }

    private void extend() {
        Person[] tmpPersonDataBase = new Person[personDataBase.length + 10];
        System.arraycopy(personDataBase, 0, tmpPersonDataBase, 0, personDataBase.length);
        personDataBase = tmpPersonDataBase;
    }
}
