package homework.employee;

import java.util.Scanner;

public class EmployeeStorage {
    Scanner console = new Scanner(System.in);
    private Employee[] employees = new Employee[2];
    private int size = 0;
    boolean userID = true;

    public void unitTestEmployee() {
        Employee user1 = new Employee("User1", "surName", "1",
                123.3, "TestUser", "QA");
        addEmployee(user1);
        Employee user2 = new Employee("user2", "user2SurName", "16",
                12345, "Ak47", "Constructor");
        addEmployee(user2);
    }

    public void startCommands() {
        System.out.print("\nPress 0 for exit.\n" +
                "Please input 1 add employee.\n" +
                "Please input 2 print all employees.\n" +
                "Please input 3 search employee by employee ID.\n" +
                "Please input 4 search employee by company name.\n" +
                "Please input 5 for search employee by salary range.\n" +
                "Please input 6 for change employee position by id.\n" +
                "Please input 7 for print only active employees.\n" +
                "Please input 8 for inactive employee by id.\n" +
                "Please input 9 for activate employee by id.\n" +
                "Make a choice: ");
    }

    private void addEmployee(Employee value) {
        if (size <= employees.length - 1) {
            employees[size] = value;
            size++;

        } else {
            extend();
            addEmployee(value);
        }
    }

    public void createEmployee() {
        System.out.print("Please enter the name: ");
        String name = console.nextLine();

        System.out.print("Please enter the surName: ");
        String surName = console.nextLine();

        System.out.print("Please enter the employeeID: ");
        String employeeID = console.nextLine();

        if (isEmployeeID(employeeID)) {
            while (userID) {
                System.out.println("Sorry but this employeeID already exists.");
                System.out.print("Please change the employeeID: ");
                String changeEmployeeID = console.nextLine();
                userID = isEmployeeID(changeEmployeeID);
                if (!userID) {
                    employeeID = changeEmployeeID;
                }
            }
        }

        System.out.print("Please enter the salary: ");
        String salary = console.nextLine();

        System.out.print("Please enter the company: ");
        String company = console.nextLine();

        System.out.print("Please enter the position: ");
        String position = console.nextLine();

        Employee employee = new Employee(name, surName, employeeID,
                Double.parseDouble(salary), company, position);
        addEmployee(employee);
        System.out.println("\nUser created and add to data base.");
    }

    private void extend() {
        Employee[] newEmployees = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, newEmployees, 0, employees.length);
        employees = newEmployees;
    }

    public void printEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    private boolean isEmployeeID(String employeeID) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(employeeID)) {
                return true;
            }
        }
        return false;
    }

    public Employee searchEmployeeByEmployeeID() {
        System.out.print("Please enter the employeeID: ");
        String searchEmployeeByID = console.nextLine();
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(searchEmployeeByID)) {
                return employees[i];
            }
        }
        System.out.print("Employee by id " + searchEmployeeByID + " was not found. ");
        return null;
    }

    public Employee searchEmployeeByCompanyName() {
        System.out.print("Please enter the employeeID: ");
        String searchEmployeeByCompanyName = console.nextLine();
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompany().equals(searchEmployeeByCompanyName)) {
                return employees[i];
            }
        }
        System.out.print("Company by name " + searchEmployeeByCompanyName + " was not found. ");
        return null;
    }

    public void searchEmployeeBySalaryRange() {
        boolean isFound = true;
        System.out.print("Please input minimum salary ");
        double minimumSalary = console.nextDouble();
        System.out.print("Please input maximum salary ");
        double maximumSalary = console.nextDouble();
        for (Employee employee : employees) {
            if (employee.getSalary() <= minimumSalary || employee.getSalary() <= maximumSalary) {
                System.out.println(employee);
                isFound = false;
            }
        }
        if (isFound) {
            System.out.println("The range from " + minimumSalary + " to "
                    + maximumSalary + " employee(s) were not found.");
        }
    }

    public void changeEmployeePositionById() {
        Employee foundEmployee = searchEmployeeByEmployeeID();
        if (foundEmployee != null) {
            System.out.print("Please enter the employee position : ");
            String employeePosition = console.nextLine();
            foundEmployee.setPosition(employeePosition);
        }
    }

    public void activeEmployee() {
        boolean isActiveEmployee = true;
        for (Employee employee : employees) {
            if (employee.isActive()) {
                isActiveEmployee = false;
                System.out.println(employee);
            }
        }
        if (isActiveEmployee) {
            System.out.println("Active employees were not found.");
        }
    }

    public void inactiveEmployeeById() {
        Employee inactiveEmployeeById = searchEmployeeByEmployeeID();
        if (inactiveEmployeeById != null) {
            inactiveEmployeeById.setActive(false);
            System.out.println("Employee by " + inactiveEmployeeById.getEmployeeID() + " id change active to false.");
        }
    }

    public void activeEmployeeById() {
        Employee inactiveEmployeeById = searchEmployeeByEmployeeID();
        if (inactiveEmployeeById != null) {
            inactiveEmployeeById.setActive(true);
            System.out.println("Employee by " + inactiveEmployeeById.getEmployeeID() + " id change active to true.");
        }
    }
}
