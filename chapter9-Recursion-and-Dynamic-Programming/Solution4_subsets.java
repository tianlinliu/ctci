/**
 * Write a method to return all subsets of a set.
 */
import java.util.*;

public class Solution4_subsets {
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (set == null || set.size() == 0) return result;

        ArrayList<Integer> subset = new ArrayList<>();
        subsets(set, 0, subset, result);

        return result;
    }

    private static void subsets(ArrayList<Integer> set, int index, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<Integer>(subset));

        for (int i = index; i < set.size(); i++) {
            subset.add(set.get(i));
            subsets(set, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.toString());

        ArrayList<ArrayList<Integer>> result = subsets(set);
        for (ArrayList<Integer> s : result) {
            System.out.println(s.toString());
        }
    }
}