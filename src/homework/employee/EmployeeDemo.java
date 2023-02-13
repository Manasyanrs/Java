package homework.employee;

import java.util.Scanner;

public class EmployeeDemo {

    public static void main(String[] args) {
        boolean addEmployees = true;

        EmployeeStorage employeeStorage = new EmployeeStorage();
        Scanner console = new Scanner(System.in);

        employeeStorage.unitTestEmployee();

        while (addEmployees) {
            employeeStorage.startCommands();
            String command = console.nextLine();

            switch (command) {
                case "0":
                    addEmployees = false;
                    break;
                case "1":
                    employeeStorage.createEmployee();
                    break;
                case "2":
                    employeeStorage.printEmployees();
                    break;
                case "3":
                    System.out.println(employeeStorage.searchEmployeeByEmployeeID());
                    break;
                case "4":
                    System.out.println(employeeStorage.searchEmployeeByCompanyName());
                    break;
                case "5":
                    employeeStorage.searchEmployeeBySalaryRange();
                    break;
                case "6":
                    employeeStorage.changeEmployeePositionById();
                    break;
                case "7":
                    employeeStorage.activeEmployee();
                    break;
                case "8":
                    employeeStorage.inactiveEmployeeById();
                    break;
                case "9":
                    employeeStorage.activeEmployeeById();
                    break;
                default:
                    System.out.println("Please enter the trust command!");
            }
        }
    }
}
