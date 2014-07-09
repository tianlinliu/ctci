/**
 * Question 1.8:
 * Assume you have a method isSubstring which check if one word is a substring of
 * another. Given two strings, s1 and s2, write code to chech if s2 is a rotation
 * of s1 using only one call to isSubstring.
 */
 public class Solution8_isRotation {
    /**
     * s2 will always be the substring of s1s1.
     *
     * Time: O(1)
     * Space: O(n)
     */
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() <= 1 && s1.length() != s2.length()) return false;

        return isSubstring(s1 + s1, s2);

    }

    public static boolean isSubstring(String str, String sub) {
        return str.indexOf(sub) >= 0;
    }

    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }
 }