package homework.homework10.medicalCenter.models;

import java.util.Date;

import static homework.homework10.medicalCenter.DateUtil.DateUtils.dateToString;
import static homework.homework10.medicalCenter.DateUtil.DateUtils.timeToString;

public class Patient extends Person {
    private Doctor doctor;
    private Date registerDate;
    private Date registerTime;

    public Patient(String id, String name, String surname, String phoneNumber, Doctor doctor, Date registerDate, Date registerTime) {
        super(id, name, surname, phoneNumber);
        this.doctor = doctor;
        this.registerDate = registerDate;
        this.registerTime = registerTime;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    @Override
    public String toString() {
        return super.toString() + doctor +
                ", registerDate= " + dateToString(registerDate) +
                ", registerTime= " + timeToString(registerTime);
    }

}
