/**
 * Question 1.5:
 * Implement a method to perform vasic string compression using the counts of
 * repeated characters.
 */

 public class Solution5_compress {
    /**
     * Iterate through the string, if the characters are same, add counter.
     *
     * Time: O(n)
     * Space: O(n)
     */
    public static String compress(String str) {
        if (str == null) return null;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            builder.append(current);

            int count = 1;
            while (i + 1 < str.length() && str.charAt(i + 1) == current) {
                count++;
                i++;
            }
            builder.append(count);
        }
        // if compressed string is not smaller than the original, return original string
        String result = builder.toString();
        return result.length() >= str.length() ? str : result;
    }

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
        System.out.println(compress("abcde"));
    }
 }