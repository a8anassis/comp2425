package gr.aueb.comp.lexer.llscanner;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LangImpl implements ILang {

    Deque<String> stack;

    public LangImpl(String[] stack) {
        this.stack = new LinkedList<>(Arrays.asList(stack));
    }

    @Override
    public void S() {
        String token = stack.pop();
        System.out.println(token);
        String nextToken;

        switch (token) {
            case "if":
                E();
                S();
                nextToken = stack.pop();
                System.out.println(nextToken);
                if (!nextToken.equals("else")) {
                    System.out.println("Error. In \"else\"");
                    return;
                }
                S();
                break;
            case "{":
                S();
                nextToken = stack.pop();
                System.out.println(nextToken);
                if (!nextToken.equals("}")) {
                    System.out.println("Error. in \"}\"");
                    return;
                }
                break;
            case "System.out.println(\"X\")":
                break;
            default:
                System.out.println("Error. \"if\" or \"{\" or \"System.out.println\" was expected");
                break;
        }
    }

    @Override
    public void E() {
        String nextToken = stack.pop();
        System.out.println(nextToken);
        if (!nextToken.equals("(")) {
            System.out.println("Error. in \"(\"");
            return;
        }

        nextToken = stack.pop();
        System.out.println(nextToken);
        if (!nextToken.matches("\\d+")) {
            System.out.println("Error in num");
            return;
        }
        nextToken = stack.pop();
        System.out.println(nextToken);
        if (!nextToken.equals("==")) {
            System.out.println("Error. in \"==\"");
            return;
        }
        nextToken = stack.pop();
        System.out.println(nextToken);
        if (!nextToken.matches("\\d+")) {
            System.out.println("Error in num");
            return;
        }
        nextToken = stack.pop();
        System.out.println(nextToken);
        if (!nextToken.equals(")")) {
            System.out.println("Error. In \")\"");
            return;
        }
    }

    @Override
    public boolean isEmptyStack() {
        try {
            stack.pop();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }
}
