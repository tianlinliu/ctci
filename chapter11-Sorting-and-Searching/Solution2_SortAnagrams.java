/**
 * Write a method to sort an array of strings so that all the anagrams are
 * next to each other.
 */
import java.util.*;

public class Solution2_SortAnagrams {
    /* Use a hash table to map the string. For each string, first sort it
     * alphabetical as the key. Then check if the hash table contains this
     * key, if not, add a new key with the string as value; if it does, add
     * the string to the list of its key.
     * Time: O(n log n)
     * Space: O(n)
     */
    public static void sortAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return;

        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = sort(s);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            } else {
                List<String> list = map.get(key);
                list.add(s);
                map.put(key, list);
            }
        }

        int i = 0;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            for (String s : list) {
                strs[i++] = s;
            }
        }
    }

    private static String sort(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        String[] strs = {"abc", "cba", "ba", "ab", ""};
        sortAnagrams(strs);
        System.out.println(Arrays.toString(strs));
    }
}