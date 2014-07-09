/**
* Problem 1.3:
* Given two strings, write a method to decide if one is a permutation of the other.
*/

import java.util.HashMap;

public class Solution3_isPermutation {
    /**
     * Count the numbers of characters in the first string, then compare it with
     * the second one.
     *
     * Time: O(n)
     * Space: O(1)
     */

     public static boolean isPermutation(String str1, String str2) {
        if (str1.length() == 0 && str1.length() != str2.length()) return false;

        char[] char1 = str1.toCharArray();
        HashMap<Character, Integer> charHash = new HashMap<Character, Integer>();
        for (char c : char1) {
            if (charHash.containsKey(c)) {
                charHash.put(c, charHash.get(c) + 1);
            } else {
                charHash.put(c, 1);
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            char key = str2.charAt(i);
            if (charHash.containsKey(key)) {
                int freq = charHash.get(key);
                if (freq == 0) {
                    return false;
                } else {
                    charHash.put(key, --freq);
                }
            } else {
                return false;
            }
        }
        return true;
     }

     public static void main(String[] args) {
        assert (isPermutation("a", "b") == false);
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
     }

}