package homework.homework9;

public class BraceCheckerTest {
    public static void main(String[] args) {

        BraceChecker text = new BraceChecker("Hello from [Java)");
        text.check();
        BraceChecker text1 = new BraceChecker("[({})](}Hello] [from] [Java)");
        text1.check();
        BraceChecker text2 = new BraceChecker("[({FALSE})](Hello] from [Java)");
        text2.check();
        BraceChecker text3 = new BraceChecker("[({TRUE})](Hello) from [Java]");
        text3.check();
        BraceChecker text4 = new BraceChecker("} Hello from} (Java)");
        text4.check();
        BraceChecker text5 = new BraceChecker("[[]");
        text5.check();
        BraceChecker text6 = new BraceChecker("Hello user. I am BraceCheckerTest class in JAVA");
        text6.check();
    }
}
