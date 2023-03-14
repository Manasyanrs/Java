package homework.homework11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectionExample1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> listNames = new ArrayList<>();
        listNames.add("Tom");
        listNames.add("Mary");
        listNames.add("Mark");
        listNames.add("Adam");
        listNames.add("Eva");

        if (isNameInNamesList(listNames)) {
            System.out.println("Name is on the list.");
        } else {
            System.out.println("Name is not on the list.");
        }

        deleteNameIfNameInList(listNames);

    }

    public static boolean isNameInNamesList(List<String> listNames) {
        System.out.print("Input checked name: ");
        String strName = scanner.nextLine();
        return listNames.contains(strName);
    }

    public static void deleteNameIfNameInList(List<String> listNames) {
        System.out.println("\n" + listNames);
        System.out.print("Which name do you want to delete? ");
        String strName = scanner.nextLine();
        if (listNames.remove(strName)) {
            System.out.println(listNames);
            System.out.println(strName + " deleted in names list.");
        }else {
            System.out.println(strName + " is not on the list.");

        }
    }

//   TODO Ես միկը հասկացա բայց իրականացում չկարացա տաի
//    Գրեք կոդ, որ մարդը ներմուծի անուն, ու ինչ որ ինդեքս, դուք էդ ինդեքսի տակ տանեք էդ անունը դնեք.
}
