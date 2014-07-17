/**
* Problem 1.1:
* Determine if a string has all unique characters.
*/

import java.util.HashSet;

public class Solution1_isUniqueChars {
    /**
     * Assume the input is ASCII code.
     * Iterate through the string, if it doesn't appear set the flag to ture,
     * if it has appeared return false.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static boolean isUniqueChars_ascii(String str) {
        if (str == null || str.length() > 256) return false;

        boolean[] charFlags = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);
            if (!charFlags[index]) {
                charFlags[index] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Assume the input is Unicode. Use two methods for unicode:
     * 1. String.codePointAt(int index): Returns the character (Unicode code point)
     *    at the specified index.
     * 2. Character.charCount(codePoint): Determines the number of char values needed to
     *    represent the specified character (Unicode code point).
     *
     * Time: O(n)
     * Space: O(n)
     */
    public static boolean isUniqueChars_unicode(String str) {
        if (str == null) return false;

        HashSet<Integer> set = new HashSet<Integer>();
        int i = 0;
        while (i < str.length()) {
            int cp = str.codePointAt(i);
            i += Character.charCount(cp);
            if (!set.contains(cp)) {
                set.add(cp);
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // unique string returns true
        assert (isUniqueChars_ascii("abcdef") == true);

        // empty string is unique.
        assert (isUniqueChars_ascii(null) == true);

        // normal test
        assert (isUniqueChars_ascii("aaaaa") == false);

    }
}
