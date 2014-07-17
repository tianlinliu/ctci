/**
* Problem 1.4:
* Replace all spaces in a string with '%20'.
*/
public class Solution4_replaceSpaces {
    /**
     * Use built-in method String.replaceAll(String s, String replacement).
     */
    public static String replaceSpaces(String str, int length) {
        if (str == null) return null;
        str = str.trim();
        return str.replaceAll(" ", "%20");
    }

    /**
     * Iterate through the string, then use stringbuilder to build a new string.
     *
     * Time: O(N)
     * Space: O(N)
     */
    public static String replaceSpaces(String str, int length) {
        if (str == null) return null;
        str = str.trim();

        StringBuilder builder = new StringBuilder();
        char[] array = str.toCharArray();
        for (char c : array) {
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith     ", 13));
    }

}