package gr.aueb.comp.lexer;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        File inputString = new File("C:\\tmp\\input-lexer.txt");

        try {
            ILexer javaLexer = new Lexer(inputString);

            while (true) {
                TokenClass tokenClass = javaLexer.nextToken();
                System.out.println(tokenClass);
                if (tokenClass == TokenClass.EOF) break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
