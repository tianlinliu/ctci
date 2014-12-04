/**
 * Implement an algorithm to print all valid(properly opened and closed) combinations
 * of n-pairs of parentheses.
 */

public class Solution6_generateParentheses {
    public static void generateParentheses(int n) {
        generateParentheses(n, n, "");
    }

    private static void generateParentheses(int left, int right, String str) {
        if (left < 0 || right < 0 || left > right) return;

        if (left == 0 && right == 0) {
            System.out.print(str + "\n");
        }

        generateParentheses(left - 1, right, str + "(");
        generateParentheses(left, right - 1, str + ")");
    }

    public static void main(String[] args) {
        generateParentheses(3);
    }
}