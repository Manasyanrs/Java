package homework.employee;

import java.util.Objects;

//        Դաշտերը դնում եք private, սարքում եք երկու կոնստրուկտոր,
//        մեկը դատարկ, մյուսը բոլոր տվյանելը ընդունող,
//          բոլորի համար  get/set մեթոդները, hashCode, equals, toString ն
//          էլ օվերրայդ կանեք, կարող եք օգտագործել generate-ը։
//        DynamicArray-ի նման սարքում եք EmployeeStorage ու նույն փեքիջում։

public class Employee {
    private String name;
    private String surName;
    private String employeeID;
    private double salary;
    private String company;
    private String position;


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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", salary=" + salary +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(surName, employee.surName) && Objects.equals(employeeID, employee.employeeID) && Objects.equals(company, employee.company) && Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, employeeID, salary, company, position);
    }
}
