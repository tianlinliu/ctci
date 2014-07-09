/**
* Problem 1.1:
* Determine if a string has all unique characters.
*/

public class Solution1_isUniqueChars {
    /**
     * Iterate through the string(char array), if it doesn't appear set the flag
     * to ture, if it has appeared return false.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean isUniqueChars(String str) {
        if (str == null || str.length() > 256) return false;

        boolean[] charFlags = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);  //?
            if (!charFlags[index]) {
                charFlags[index] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // unique string returns true
        assert (isUniqueChars("abcdef") == true);

        // empty string is unique.
        assert (isUniqueChars(null) == true);

        // normal test
        assert (isUniqueChars("aaaaa") == false);

    }
}
