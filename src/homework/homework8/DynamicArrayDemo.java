package homework.homework8;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();

        System.out.println("Length of after to methods dynamicArray.extent = " + dynamicArray.length());

        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(6);
        dynamicArray.add(125);
        dynamicArray.print();
        System.out.println("\n" + dynamicArray.getByIndex(6));
        System.out.println(dynamicArray.getByIndex(2));

        System.out.println("\nLength of before to methods dynamicArray.extent = " + dynamicArray.length());
    }
}
