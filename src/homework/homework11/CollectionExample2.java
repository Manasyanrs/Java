package homework.homework11;

import java.util.*;

import java.util.Collections;

public class CollectionExample2 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> namesList = new ArrayList<>();

    public static void main(String[] args) {

        addNames(5);
        printUniqueNamesFromList();
        System.out.println();
        addNamesAndPrintSortedList(10);
    }

    static void addNames(int enterCountInputNames) {
        System.out.println();
        for (int i = 0; i < enterCountInputNames; i++) {
            System.out.print("Input " + (i + 1) + " name: ");
            String inputName = scanner.nextLine();
            namesList.add(inputName);
        }
    }

    static void printUniqueNamesFromList() {
        Set<String> genericNamesList = new TreeSet<>(getNamesList());
        System.out.println(genericNamesList);
    }

    static void addNamesAndPrintSortedList(int enterCountInputNames) {
        List<String> sortedNamesList = new LinkedList<>();

        for (int i = 0; i < enterCountInputNames; i++) {
            System.out.print("Input " + (i + 1) + " name: ");
            String inputName = scanner.nextLine();
            sortedNamesList.add(inputName);
        }
        Collections.sort(sortedNamesList);
        System.out.println(sortedNamesList);
    }

    public static List<String> getNamesList() {
        return namesList;
    }
}
