package homework.employee;

import homework.employee.mainCommandshandler.CommandsHandler;

import java.text.ParseException;
import java.util.Scanner;

public class EmployeeDemo {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CommandsHandler commandsHandler = new CommandsHandler();
    private static boolean flag = true;
    public static void main(String[] args) throws ParseException {
        while (flag){
            startCommands();
            String command = scanner.nextLine();
            if (command.equals("0")){
                flag = false;
                break;
            }
            commandsHandler.handle(command);
        }
    }

    private static void startCommands() {
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
}
