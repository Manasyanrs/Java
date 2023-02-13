package homework.employee;

import java.util.Objects;


public class Employee {
    private String name;
    private String surName;
    private String employeeID;
    private double salary;
    private String company;
    private String position;
    boolean active = true;


    Employee() {

    }

    public Employee(String name, String surName, String employeeID, double salary, String company, String position) {
        this.name = name;
        this.surName = surName;
        this.employeeID = employeeID;
        this.salary = salary;
        this.company = company;
        this.position = position;

    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", salary=" + salary +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", active='" + active + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(surName, employee.surName) &&
                Objects.equals(employeeID, employee.employeeID) &&
                Objects.equals(company, employee.company) &&
                Objects.equals(position, employee.position) &&
                Objects.equals(active, employee.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, employeeID, salary, company, position, active);
    }
}
