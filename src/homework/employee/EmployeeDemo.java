package homework.employee;

import java.util.Scanner;

public class EmployeeDemo {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean addEmployees = true;
        boolean userID = true;

        EmployeeStorage employeeStorage = new EmployeeStorage();

        //Start for test
        Employee user1 = new Employee("User1", "surName", "1",
                123.3, "TestUser", "QA");
        employeeStorage.addEmployee(user1);
        Employee user2 = new Employee("user2", "user2SurName", "16",
                12345, "Ak47", "Constructor");
        employeeStorage.addEmployee(user2);
        // End

        while (addEmployees) {
            System.out.print("\nPress 0 for exit.\n" +
                    "Press 1 add employee.\n" +
                    "Press 2 print all employees.\n" +
                    "Press 3 search employee by employee ID.\n" +
                    "Press 4 search employee by company name.\n" +
                    "Make a choice: ");
            String command = console.nextLine();
            System.out.println();
            switch (command) {
                case "0":
                    addEmployees = false;
                    break;
                case "1":
                    System.out.print("Please enter the name: ");
                    String name = console.nextLine();

                    System.out.print("Please enter the surName: ");
                    String surName = console.nextLine();

                    System.out.print("Please enter the employeeID: ");
                    String employeeID = console.nextLine();

                    if (employeeStorage.isEmployeeID(employeeID)) {
                        while (userID) {
                            System.out.println("Sorry but this employeeID already exists.");
                            System.out.print("Please change the employeeID: ");
                            String changeEmployeeID = console.nextLine();
                            userID = employeeStorage.isEmployeeID(changeEmployeeID);
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
                    employeeStorage.addEmployee(employee);
                    System.out.println("\nUser created and add to data base.");
                    break;

                case "2":
                    employeeStorage.printEmployees();
                    break;
                case "3":
                    System.out.print("Please enter the employeeID: ");
                    String searchEmployeeByID = console.nextLine();
                    employeeStorage.searchEmployeeByEmployeeID(searchEmployeeByID);
                    break;
                case "4":
                    System.out.print("Please enter the employeeID: ");
                    String searchEmployeeByCompanyName = console.nextLine();
                    employeeStorage.searchEmployeeByCompanyName(searchEmployeeByCompanyName);
                    break;
                default:
                    System.out.println("Please enter the trust command!");
            }
        }
    }
}
