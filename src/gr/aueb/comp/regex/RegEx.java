package gr.aueb.comp.regex;

public class RegEx {

    public static void main(String[] args) {
//        String str = "red";
//        System.out.println(isRredOrGgreen(str));
        String s = "George Oikonomou";
        backReference(s);
    }


    /**
     * Ελέγχει αν το string εισόδου
     * είναι το "Red".
     *
     * @param s     input string
     * @return      true if it is Red, false otherwise
     */
    public static boolean isRed(String s) {
        return s.matches("Red");
    }

    /**
     * Ελέγχει αν το string εισόδου είναι
     * το "Red" ή το "Green".
     *
     * @param s     input string
     * @return      true if it is "Red" or "Green",
     *              false otherwise
     */
    public static boolean isRedOrGreen(String s) {
        return s.matches("Red|Green");
    }

    /**
     * Χρησιμοποιεί κλάσεις χαρακτήρων μέσα σε [].
     *
     * @param s
     * @return
     */
    public static boolean isRredOrGgreen(String s) {
        return s.matches("[Rr]ed|[Gg]reen");
    }

    /**
     * Χρησιμοποιεί κλάσεις χαρακτήρων μέσα σε []
     * με ranges.
     *
     * @param s
     * @return
     */
    public static boolean startsWithUppercaseEndsWithing(String s) {
        return s.matches("[A-Z]ing");
    }

    public static boolean startsWithUppercaseOrLowercaseEndsWithing(String s) {
        return s.matches("[A-Za-z]ing");
    }


    /*
     * Μεταχαρακτήρες:
     * .  -> οποισδήποτε χαρακτήρας (εκτός από \n).
     * ^  -> Αρχή ενός string. [^a]
     * $  -> Τέλος ενός string. Ένα string: ^$
     * \w -> χαρακτήρας λέξης. a-z, A-Z, 0-9, _
     * \W -> οποιοσδήποτε χαρακτήρας εκτός από χαρακτήρα λέξης.
     * \s -> whitespace (spaces, \t, \n).
     * \S -> οποιοσδήποτε χαρακτήρας δεν είναι whitespace. [\s\S] όλοι οι χαρακτήρες.
     * \d -> οποισδήποτε ψηφίο.
     * \D -> οποισδήποτε χαρακτήρας που δεν είναι ψηφίο.
     */

    /**
     * Recognises dates in the form of dd/mm/yyyy.
     *
     * @param s
     * @return
     */
    public static boolean hasTwoDigits(String s) {
        return s.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    /*
     * Ποσοδείκτες
     *
     *      *       -> 0 ή περισσότεροι
     *      +       -> 1 ή περισσότεροι
     *      ?       -> 0 ή 1
     *      {n}     -> n ακριβώς
     *      {n, m}  -> Μεταξύ n και m
     *      {n,}    -> Τουλάχιστον n
     *      {,m}    -> Όχι περισσότερες από m εμφανίσεις
     *
     */

    /**
     * yyyy-mm-dd
     *
     * @param s
     * @return
     */
    public static boolean isDate(String s) {
        return s.matches("\\d{4}-(0[1-9]|1[012])-\\d{2}");
    }

    public static boolean isHexColorCode(String s) {
        return s.matches("^#[0-9A-Fa-f]{6}|[0-9A-Fa-f]{3}$");
    }

    public static boolean isHTMLTag(String s) {
        return s.matches("^</?[\\w\\s=\"']+>$");
    }

    public static String replace(String s) {
        return s.replaceAll("\\s{2,}", " ");
    }

    public static String[] strSplit(String s) {
        String[] tokens = s.split("\\s+");
        return tokens;
    }

    public static void backReference(String s) {
        System.out.println(s);
        s = s.replaceAll("(.*)\\s+(.*)", "$2 $1");
        System.out.println(s);
    }



}
