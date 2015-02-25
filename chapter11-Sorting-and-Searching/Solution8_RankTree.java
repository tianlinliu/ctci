
public class Solution8_RankTree {
    public static void main(String[] args) {
        RankTree tree = new RankTree();
        int[] nums = {5, 2, 1, 4, 7, 200, 2, 100, 6};
        for (int i : nums) {
            tree.track(i);
        }

        for (int i : nums) {
            System.out.println(i + " " + tree.getRankOfNumber(i));
        }
    }
}