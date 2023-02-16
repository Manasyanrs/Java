package homework.employee.mainCommandshandler;

import homework.employee.employeeStorage.EmployeeStorage;
import homework.employee.models.Employee;

import java.util.Date;
import java.util.Scanner;

import static homework.employee.dateUtils.DateUtils.parseToDate;
import static java.lang.Double.parseDouble;

public class CommandsHandler {
    private final EmployeeStorage employeeStorage = new EmployeeStorage();

    private final Scanner scanner = new Scanner(System.in);

    public void handle(String command) {
        switch (command) {
            case "1":
                createEmployee();
                break;
            case "2":
                employeeStorage.printEmployees();
                break;
            case "3":
                System.out.println(searchEmployeeByEmployeeId());
                break;
            case "4":
                searchEmployeeByCompanyName();
                break;
            case "5":
                handlerSalaryRange();
                break;
            case "6":
                changeEmployeePositionById();
                break;
            case "7":
                allActiveEmployees();
                break;
            case "8":
                inactiveEmployeeById();
                break;
            case "9":
                activeEmployeeById();
                break;
            default:
                System.out.println("Please enter the trust command!");
        }
    }
    private void activeEmployeeById() {
        Employee activeEmployeeById = searchEmployeeByEmployeeId();
        if (activeEmployeeById != null) {
            activeEmployeeById.setActive(true);
            System.out.println("Employee by " + activeEmployeeById.getEmployeeID() + " id change active to true.");
        }
    }

    private void inactiveEmployeeById() {
        Employee inactiveEmployeeById = searchEmployeeByEmployeeId();
        if (inactiveEmployeeById != null) {
            inactiveEmployeeById.setActive(false);
            System.out.println("Employee by " + inactiveEmployeeById.getEmployeeID() + " id change active to false.");
        }
    }

    private void changeEmployeePositionById() {
        Employee foundEmployee = searchEmployeeByEmployeeId();
        if (foundEmployee != null) {
            System.out.print("Please enter the employee position : ");
            String employeePosition = scanner.nextLine();
            foundEmployee.setPosition(employeePosition);
        }
    }

    private Employee searchEmployeeByEmployeeId() {
        System.out.print("Please enter the employee ID: ");
        String employeeId = scanner.nextLine();
        return employeeStorage.searchEmployeeByEmployeeID(employeeId);
    }

    private void handlerSalaryRange() {
        String resultSalaryRange;

        System.out.print("Please input minimum salary ");
        double minimumSalary = scanner.nextDouble();
        System.out.print("Please input maximum salary ");
        double maximumSalary = scanner.nextDouble();

        if (maximumSalary < minimumSalary || maximumSalary == minimumSalary) {
            resultSalaryRange = maximumSalary + "," + minimumSalary;
        } else {
            resultSalaryRange = minimumSalary + "," + maximumSalary;
        }

        employeeStorage.searchEmployeeBySalaryRange(resultSalaryRange.split(",")[0],
                resultSalaryRange.split(",")[1]);
    }

    private void createEmployee() {

        System.out.print("Please enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Please enter the surName: ");
        String surName = scanner.nextLine();

        System.out.print("Please enter the date of birthday(01/01/1234): ");
        Date birthDate = parseToDate(scanner.nextLine());

        String employeeID = getId();

        System.out.print("Please enter the salary: ");
        String salary = scanner.nextLine();

        System.out.print("Please enter the company: ");
        String company = scanner.nextLine();

        System.out.print("Please enter the position: ");
        String position = scanner.nextLine();

        Employee employee = new Employee(name, surName, employeeID, parseDouble(salary), company, position, new Date(), birthDate);
        employeeStorage.addEmployee(employee);
        System.out.println("\nUser created and add to data base.");
    }

    private String getId() {
        System.out.print("Please enter the employeeID: ");
        String employeeID = scanner.nextLine();
        if (employeeStorage.existsById(employeeID)) {
            System.out.println("Sorry but this employeeID already exists.");
            getId();
        }
        return employeeID;
    }

    private void allActiveEmployees() {
        employeeStorage.allActiveEmployees();
    }

    private void searchEmployeeByCompanyName() {
        System.out.print("Please enter the employees company name: ");
        String companyName = scanner.nextLine();
        System.out.println(employeeStorage.searchEmployeeByCompanyName(companyName));
    }
}
