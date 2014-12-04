/**
 * Write a method to compute all permutations of a string of unique characters.
 */
import java.util.ArrayList;

public class Solution5_permuteString {
    public static ArrayList<String> permute(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null) return result;

        permuteHelper(str, "", result);
        return result;
    }

    private static void permuteHelper(String str, String permutation, ArrayList<String> result) {
        if (permutation.length() == str.length()) {
            result.add(permutation);
        }

        for (int i = 0; i < str.length(); i++) {
            if (permutation.contains(String.valueOf(str.charAt(i)))) { // convert a char to CharSequence (String)
                continue;
            }

            permuteHelper(str, permutation + str.charAt(i), result);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> result = permute("abc");
        System.out.println(result.toString());
    }
}