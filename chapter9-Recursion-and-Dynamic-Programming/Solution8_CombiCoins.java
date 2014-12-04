/**
 * Given an infinite number of quarters(25 cents), dimes(10 cents), nickels(5 cents),
 * and pennies(1 cent), write code to calculate the number of ways of representing n cents.
 */

public class Solution8_CombiCoins {
    public static int countWays(int n) {
        int[] coins = {25, 10, 5, 1};

        return count(coins, 0, n);
    }

    private static int count(int[] coins, int index, int n) {
        if (index >= 3) return 1;

        int count = 0;
        int maxNum = n / coins[index];
        for (int i = 0; i <= maxNum; i++) {
            count += count(coins, index + 1, n - coins[index] * i);
        }

        return count;
    }

    public static int countWays_dp(int n) {
        int[] coins = {25, 10, 5, 1};
        int[][] cache = new int[4][n + 1];

        return count(coins, cache, 0, n);
    }

    private static int count(int[] coins, int[][] cache, int index, int n) {
        if (cache[index][n] != 0) return cache[index][n];


    }

    public static void main(String[] args) {
        System.out.println(countWays(5));
    }
}