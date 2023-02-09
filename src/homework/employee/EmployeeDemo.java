package homework.employee;

public class EmployeeDemo {

    public static void main(String[] args) {
        EmployeeStorage employeeStorage = new EmployeeStorage();
        boolean addEmployees = true;

        employeeStorage.unitTestEmployee();

        while (addEmployees) {
            String command = employeeStorage.startCommands();
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
                default:
                    System.out.println("Please enter the trust command!");
            }
        }
    }
}
