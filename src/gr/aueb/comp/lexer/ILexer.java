package gr.aueb.comp.lexer;

import java.io.FileNotFoundException;

public interface ILexer {

    TokenClass nextToken() throws FileNotFoundException;
}
