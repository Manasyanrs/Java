package chapter12;

public class AnnotationsMethods {
    @MyAnno(str = "Пример аннотации", val = 100)
    public static void main(String[] args) {
        System.out.println("Annotation methods");
    }
}
