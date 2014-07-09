/**
* Problem 1.4:
* Replace all spaces in a string with '%20'.
*/
public class Solution4_replaceSpaces {
    public static String replaceSpaces(String str, int length) {
        if (str == null) return null;
        str = str.trim();
        return str.replaceAll(" ", "%20");
    }



    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith     ", 13));
    }

}