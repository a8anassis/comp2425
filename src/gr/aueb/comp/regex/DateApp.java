package gr.aueb.comp.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Convert dates from GR Format to US Format.
 */
public class DateApp {

    public static void main(String[] args) {
        String s = "12/10/2015";

        Pattern pattern = Pattern.compile("^(\\d{2})/(\\d{2})/(\\d{4})$");
        Matcher matcher = pattern.matcher(s);

        if (matcher.matches()) {
            String day = matcher.group(1);
            String month = matcher.group(2);
            String year = matcher.group(3);

            String formattedUSDate = year + "/" + month + "/" + day;
            System.out.println(formattedUSDate);
        } else {
            System.out.println("Pattern not matches.");
        }
    }


}
