package homework.homework9;

public class SymbolStack {
    private int tos = -1;
    final private char[] chars = new char[10];

    void pushCharacterToTheStack(char symbol) {
        chars[++tos] = symbol;
    }

    char getStackChar() {
        return chars[tos];
    }

    boolean removeCharacterFromStack(char charSymbol) {
        if (charSymbol == chars[tos] + 1 || charSymbol == chars[tos] + 2) {
            tos--;
            return true;
        }
        System.out.print("Error: opened " + getStackChar() + " but closed " + charSymbol + " at ");

        return false;
    }

    int getTos() {
        return tos;
    }
}
