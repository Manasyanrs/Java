package chapter14;

public class HierDemo2 {
    public static void main(String[] args) {
        GenExtendsNonGen<String> w =
                new GenExtendsNonGen<>("Welcome", 47);
        System.out.print(w.getOb() + " ");
        System.out.println(w.getNum());
    }
}
