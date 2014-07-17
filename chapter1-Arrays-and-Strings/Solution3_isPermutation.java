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
     * Space: O(n)
     */

     public static boolean isPermutation_count(String str1, String str2) {
        if (str1 == null || str2 == null) throw new IllegalArgumentException();

        if (str1.length() != str2.length()) return false;

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

     /**
      * Sort the strings, then compare two strings.
      *
      * Time: O(n)
      * Space: O(n)
      */
     public static boolean isPermutation_sort(String str1, String str2) {
        if (str1 == null || str2 == null) throw new IllegalArgumentException();

        if (str1.length() != str2.length()) return false;

        return sort(str1).equals(sort(str2));  // use string.equals(str) to compare!
     }

     private static String sort(String str) {
        char[] array = str.toCharArray();
        java.util.Arrays.sort(array);
        return new String(array);
     }

     /**
      * Use array to count.
      */
     public static boolean isPermutation_count2(String str1, String str2) {
        if (str1 == null || str2 == null) throw new IllegalArgumentException();

        if (str1.length() != str2.length()) return false;

        /* count characters in str1 */
        char[] count = new char[256];
        char[] char1 = str1.toCharArray();
        for (char c : char1) {
            count[c]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            if (--count[str2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
     }

     public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation_count2(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
     }

}