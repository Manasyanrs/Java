package homework.employee.employeeStorage;

import homework.employee.models.Employee;

public class EmployeeStorage {
    private Employee[] employees = new Employee[2];
    private int size = 0;

    public void addEmployee(Employee value) {
        if (size == employees.length) {
            extend();
        }
        employees[size++] = value;
    }

    public void printEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean existsById(String employeeID) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(employeeID)) {
                return true;
            }
        }
        return false;
    }

    public Employee searchEmployeeByEmployeeID(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(employeeId)) {
                return employees[i];
            }
        }
        System.out.print("Employee by id " + employeeId + " was not found. ");
        return null;
    }

    public Employee searchEmployeeByCompanyName(String companyName) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompany().equals(companyName)) {
                return employees[i];
            }
        }
        System.out.print("Company by name " + companyName + " was not found. ");
        return null;
    }

    public void searchEmployeeBySalaryRange(String minimumSalary, String maximumSalary) {
        boolean isFound = true;
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() <= Double.parseDouble(minimumSalary) ||
                    employees[i].getSalary() <= Double.parseDouble(maximumSalary)) {
                System.out.println(employees[i]);
                isFound = false;
            }
        }

        if (isFound) {
            System.out.println("The range from " + minimumSalary + " to "
                    + maximumSalary + " employee(s) were not found.");
        }
    }

    public void allActiveEmployees() {
        boolean isActiveEmployee = true;

        for (int i = 0; i < size; i++) {
            if (employees[i].isActive()) {
                isActiveEmployee = false;
                System.out.println(employees[i]);
            }
        }

        if (isActiveEmployee) {
            System.out.println("Active employees were not found.");
        }
    }

    private void extend() {
        Employee[] newEmployees = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, newEmployees, 0, employees.length);
        employees = newEmployees;
    }
}
