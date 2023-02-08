package homework.employee;

public class EmployeeStorage {
    private Employee[] employees = new Employee[2];
    private int size = 0;

    public void addEmployee(Employee value) {
        if (size <= employees.length - 1) {
            employees[size] = value;
            size++;

        } else {
            extend();
            addEmployee(value);
        }
    }

    private void extend() {
        Employee[] newEmployees = new Employee[employees.length + 10];
        for (int i = 0; i < employees.length; i++) {
            newEmployees[i] = employees[i];
        }
        employees = newEmployees;
    }

    public void printEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean isEmployeeID(String employeeID) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(employeeID)) {
                return true;
            }
        }
        return false;
    }

    public void searchEmployeeByEmployeeID(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(id)) {
                System.out.println(employees[i].toString());
                return;
            }
        }
        System.out.println("Employee by id " + id + " was not found.");
    }

    public void searchEmployeeByCompanyName(String companyName) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompany().equals(companyName)) {
                System.out.println(employees[i]);
                return;
            }
        }
        System.out.println("Company by name " + companyName + " was not found.");
    }
}
