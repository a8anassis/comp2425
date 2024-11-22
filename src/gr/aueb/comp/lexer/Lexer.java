package gr.aueb.comp.lexer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lexer implements ILexer {

    private static Scanner in;
    private final static Map<String, TokenClass> tokens = new HashMap<>();

    static {
        for (TokenClass tokenClass : TokenClass.values()) {
            tokens.put(tokenClass.getLexeme(), tokenClass);
        }
    }

    public Lexer(File inputString) throws FileNotFoundException {
        in = new Scanner(inputString);
    }

    Pattern pattern = Pattern.compile("(\\s+|^.?)|--|-|\\+\\+|\\+|>=|>|<=|<|==|=|!=|!" +
            "\\bif\\b|\\belse\\b|\\bwhile\\b|\\bfor\\b|([a-zA-Z][a-zA-Z0-9]*)|(\\d+)|.");

    @Override
    public TokenClass nextToken() throws FileNotFoundException {
        String matcher = in.findWithinHorizon(pattern, 0);
        String lexeme;

        if (matcher == null) {
            return TokenClass.EOF;
        }

//        if (in.match().group() != null) {
//            return nextToken();
//        }

        if (in.match().group(1) != null) {
            return nextToken();
        }

        if (in.match().group(2) != null) {
            return TokenClass.ID;
        }

        if (in.match().group(3) != null) {
            return TokenClass.NUM;
        }

        lexeme = in.match().group();
        TokenClass tokenClass = tokens.get(lexeme);
        return (tokenClass == null) ? TokenClass.ERROR : tokenClass;
    }
}
