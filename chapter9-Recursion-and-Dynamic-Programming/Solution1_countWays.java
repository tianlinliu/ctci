/**
 * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps,
 * or 3 steps at a time. Implement a method to count how many possible ways the child can
 * run up the stairs.
 */

public class Solution1_countWays {
    // recursion.
    public static int count_recursive(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        return  count_recursive(n - 1) + count_recursive(n - 2) + count_recursive(n - 3);
    }


    // memoization.
    public static int count_memo(int n) {
        if (n < 0) return -1;

        int[] cache = new int[n + 1];

        return count_memo(n, cache);
    }

    private static int count_memo(int n, int[] cache) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        if (cache[n] != 0) return cache[n];

        cache[n] = count_memo(n - 1, cache) + count_memo(n - 2, cache) + count_memo(n - 3, cache);
        return cache[n];
    }


    // bottom-up dp.
    public static int count_dp(int n) {
        if (n == 0) return 1;
        if (n <= 2) return n;

        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        cache[2] = 2;

        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
        }

        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(count_recursive(3));
        System.out.println(count_memo(3));
        System.out.println(count_dp(3));
    }
}
