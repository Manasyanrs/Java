package homework.homework8;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(6);
        dynamicArray.add(125);
        dynamicArray.print();

        System.out.println(dynamicArray.getByIndex(6));
        System.out.println(dynamicArray.getByIndex(2));

        dynamicArray.deleteByIndex(5);
        dynamicArray.print();

        dynamicArray.set(0, 785);
        dynamicArray.print();

        dynamicArray.add(2, 7);
        dynamicArray.print();

        System.out.println(dynamicArray.exists(12));
        System.out.println(dynamicArray.exists(7));

        dynamicArray.add(2);
        dynamicArray.print();

        System.out.println(dynamicArray.getIndexByValue(2));
        dynamicArray.length();

    }
}
