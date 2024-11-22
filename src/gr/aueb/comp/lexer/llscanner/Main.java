package gr.aueb.comp.lexer.llscanner;

public class Main {

    public static void main(String[] args) {
        String[] tokens = {"if", "(", "5", "==", "5", ")", "System.out.println(\"X\")"};
        ILang lang = new LangImpl(tokens);

        lang.S();
        if (lang.isEmptyStack()) {
            System.out.println("Success");
        }
    }
}
