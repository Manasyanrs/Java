package homework.homework9;

public class BraceChecker {
    final private SymbolStack stackSymbol = new SymbolStack();
    final private String text;
    private boolean flag = true;
    private int wordIndex = 0;


    BraceChecker(String text) {
        this.text = text;
    }

    void check() {
        String[] words = text.split(" ");
        wordIteration:
        for (String word : words) {
            wordIndex += word.length() + 1;

            if (word.startsWith("]") || word.startsWith("}") || word.startsWith(")")) {
                flag = false;
                wordIndex -= word.length() + 1;
                System.out.println("Error: Does not open but closed " + word.charAt(0) + " at " + wordIndex + ".");
                break;

            } else if (word.startsWith("[") || word.startsWith("{") || word.startsWith("(")) {
                flag = false;
                wordIndex -= word.length() + 1;

                for (int i = wordIndex; i < text.length(); i++) {
                    wordIndex++;
                    switch (text.charAt(i)) {
                        case 40:
                        case 91:
                        case 123: {
                            stackSymbol.pushCharacterToTheStack(text.charAt(i));
                            break;
                        }
                        case 41:
                        case 93:
                        case 125: {
                            if (stackSymbol.removeCharacterFromStack(text.charAt(i))) {
                                break;
                            } else {
                                System.out.println(i + ".");
                                break wordIteration;
                            }
                        }
                    }
                }
                if (stackSymbol.getTos() > -1) {
                    System.out.println("Error: opened " + stackSymbol.getStackChar() +
                            " but does not closed " + " at " + wordIndex + ".");

                } else if (stackSymbol.getTos() == -1) {
                    System.out.println("All characters are correct.");
                }
                break;
            }
        }
        if (flag) {
            System.out.println("Text contains no characters.");
        }
    }
}
