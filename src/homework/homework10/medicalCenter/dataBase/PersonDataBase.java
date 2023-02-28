package homework.homework10.medicalCenter.dataBase;

import homework.homework10.medicalCenter.DateUtil.DateUtils;
import homework.homework10.medicalCenter.models.Doctor;
import homework.homework10.medicalCenter.models.Patient;
import homework.homework10.medicalCenter.models.Person;

import java.util.Date;

public class PersonDataBase {
    private Person[] personDataBase = new Person[2];
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

    public void addPerson(Person value) {
        try {
            personDataBase[size++] = value;

        } catch (ArrayIndexOutOfBoundsException e) {
            --size;
            extend();
            addPerson(value);
        }
    }

    public void deletePersonById(String personId) {
        for (int i = 0; i < size; i++) {
            if (personDataBase[i].getId().equals(personId)) {
                removePersonByIdInDateBase(i);
            }
        }
    }

    public boolean isEmptyDataBase() {
        return size != 0;
    }

    public void toDaysPatients() {
        for (int i = 0; i < size; i++) {
            if (personDataBase[i] instanceof Patient){
                Patient patient = (Patient) personDataBase[i];
                Date d = patient.getRegisterDate();
                if (DateUtils.dateToString(d).equals(DateUtils.dateToString(new Date()))) {
                    System.out.println(personDataBase[i]);
                }
            }
        }
    }

    public void printAllDoctors() {
        for (int i = 0; i < size; i++) {
            if (personDataBase[i] instanceof Doctor){
                System.out.println(personDataBase[i]);
            }
        }
    }

    public Person searchPersonByProfession(String personProfession) {
        for (int i = 0; i < size; i++) {
            if (personDataBase[i] instanceof Doctor){
                Doctor doctor = (Doctor) personDataBase[i];
                if (doctor.getProfession().name().equals(personProfession.toUpperCase())) {
                    return personDataBase[i];
                }
            }
        }
        System.out.print("Person by " + personProfession + " was not found. ");
        return null;
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

    public Doctor searchPersonByName(String personName) {
        for (int i = 0; i < size; i++) {
            if (personDataBase[i] instanceof Doctor){
                Doctor doctor = (Doctor) personDataBase[i];
                if (doctor.getName().equals(personName)) {
                    return doctor;
                }
            }
        }
        System.out.print("Person by name։ " + personName + " was not found. ");
        return null;
    }

    private void removePersonByIdInDateBase(int index) {
        Person[] result = new Person[size - 1];

        for (int i = 0; i < size - 1; i++) {
            if (i != index) {
                result[i] = personDataBase[i];
            } else {
                result[i] = personDataBase[i + 1];
            }
        }
        --size;
        personDataBase = result;
    }

    private void extend() {
        Person[] tmpPersonDataBase = new Person[personDataBase.length + 10];
        System.arraycopy(personDataBase, 0, tmpPersonDataBase, 0, personDataBase.length);
        personDataBase = tmpPersonDataBase;
    }

}
