/**
 * Given a sorted array of strings which is interspersed with empty strings,
 * write a method to find the location of a given string.
 */

public class Solution5_SearchStr {
    /* binary search*/
    public static int search(String[] strs, String target) {
        if (strs == null || strs.length == 0 || target == null || target == "") return -1;

        int low = 0;
        int high = strs.length - 1;
        while (low <= high) {
            if (strs[low] == "") {
                low++;
                continue;
            }

            int mid = low + (high - low) / 2;
            while (strs[mid] == "") {
                mid--;
            }
            if (strs[mid].equals(target)) {
                return mid;
            }
            if (strs[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] strs = {"", "", "a", "", "b", "", "bb"};
        System.out.println(search(strs, "a"));
    }
}