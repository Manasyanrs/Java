package chapter14;

public class Gen5<T extends Number> {
    T ob;
    T[] vals;

    Gen5(T o, T[] nums) {
        ob = o;
        vals = nums;
    }

}
