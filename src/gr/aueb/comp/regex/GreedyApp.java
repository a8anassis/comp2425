package gr.aueb.comp.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Greedy algorithm gor pattern recognition.
 */
public class GreedyApp {

    public static void main(String[] args) {

        String s = "login:alice;pass:12345;";

        Pattern pattern = Pattern.compile(".*?;");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
