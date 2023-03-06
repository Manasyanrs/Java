package chapter12;

public @interface SameAnno {
    int value();
    int xyz() default 0;
}
