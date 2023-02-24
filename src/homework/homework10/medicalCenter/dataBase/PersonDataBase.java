package homework.homework10.medicalCenter.dataBase;

import homework.homework10.medicalCenter.models.Person;

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

    public int getSize() {
        return size;
    }

    public Person[] getPersonDataBase() {
        return personDataBase;
    }
}
