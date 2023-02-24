package homework.homework10.medicalCenter.models;

public abstract class Person {
    private final String id;
    private String name;
    private String surname;
    private String phoneNumber;

    Person(String id, String name, String surname, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "id= " + id + ", name= " + name + ", surname= " + surname + ", phoneNumber= " + phoneNumber + " ";
    }
}
