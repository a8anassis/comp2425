package gr.aueb.comp.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordMatch {

    public static void main(String[] args) {
        String s = "#$aA12345!!";

        Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*()-]).{8,}$");
        Matcher matcher = pattern.matcher(s);

        if (matcher.matches()) {
            System.out.println(matcher.group());
        } else {
            System.out.println("Password is not strong");
        }
    }
}
