package gr.aueb.comp.lexer.llscanner;

/**
 * S -> if E S else S | {S} | System.out.println("X")
 * E -> (num == num)
 */
public interface ILang {

    void S();
    void E();
    boolean isEmptyStack();
}
