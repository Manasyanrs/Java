package homework.homework10.medicalCenter.models;

import homework.homework10.medicalCenter.commands.DoctorCommands;

import java.util.Date;

public class Doctor extends Person implements DoctorCommands {
    private String profession;
    private String email;
    private String[] patientsId = new String[5];
    private int patientsSize;


    public Doctor(String id, String name, String surname, String phoneNumber, String profession, String email) {
        super(id, name, surname, phoneNumber);
        this.profession = profession;
        this.email = email;
    }

    public void setPatientsId(String patientsId) {
        this.patientsId[patientsSize++] = patientsId;
    }


    public void doctorPatients() {
        if (patientsSize != 0) {
            for (int i = 0; i < patientsSize; i++) {
                System.out.println(personDB.getPerson(patientsId[i]));
            }
        } else {
            System.out.println("This doctor das not have patients");
        }
    }

    public boolean patientsTime(Doctor person, Date time, int date) {
        boolean isFreeTime = true;
        String registerPatientsTime = "";

        for (int i = 0; i < patientsSize; i++) {
            Patient patient = (Patient) personDB.getPerson(patientsId[i]);
            Date registerTime = patient.getRegisterTime();
            Date registerDate = patient.getRegisterDate();

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

        return isFreeTime;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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
