package homework.homework10.medicalCenter.models;

import homework.homework10.medicalCenter.Profession;

public class Doctor extends Person {
    private Profession profession;
    private String email;
    private final String[] patientsId = new String[1];
    private int patientsSize;


    public Doctor(String id, String name, String surname, String phoneNumber, Profession profession, String email) {
        super(id, name, surname, phoneNumber);
        this.profession = profession;
        this.email = email;
    }

    public void setPatientsId(String patientId) {
        patientsId[patientsSize++] = patientId;
    }

    public int getPatientsSize() {
        return patientsSize;
    }

    public String[] getPatientsId() {
        return patientsId;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = Profession.valueOf(profession);
    }

    public void setEmail(String email) {
        this.email = email;

    }

    @Override
    public String toString() {
        return "Doctor{" +
                super.toString() +
                "profession='" + profession + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
