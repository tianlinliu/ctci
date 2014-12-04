/**
 * A robot sitting on the upper left corner of an X by Y grid. The robot can only move in
 * two directions: right and down. How many possible paths are there for the robot to go
 * from (0,0) to (X,Y)?
 *
 * FOLLOW UP:
 * Certain spots are "off limits", such that robo cannot step on them. Design
 * an algorithm to find a path for the robot from the top left to buttom right.
 */

public class Solution2_countPaths {
    public static int count(int X, int Y) {
        if (X <= 0 || Y <= 0) return 1;

        return count(X - 1, Y) + count(X, Y - 1);
    }

    // memo.
    public static int count_memo(int X, int Y) {
        int size = Math.max(X, Y);
        int[] cache = new int[size + 1];
        return count_memo(X, Y, size, cache);
    }

    private static int count_memo(int X, int Y, int size, int[] cache) {
        if (X <= 0 || Y <= 0) return 1;
        if (cache[size] != 0) return cache[size];

        cache[size] = count_memo(X - 1, Y, size, cache) + count_memo(X, Y - 1, size, cache);
        return cache[size];
    }

    // dp.
    public static int count_dp(int X, int Y) {
        if (X == 0 || Y == 0) return 1;

        int[][] cache = new int[X + 1][Y + 1];
        for (int i = 0; i <= X; i++) {
            cache[i][0] = 1;
        }
        for (int i = 0; i <= Y; i++) {
            cache[0][i] = 1;
        }

        for (int i = 1; i <= X; i++) {
            for (int j = 1; j <= Y; j++) {
                cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
            }
        }
        // 怎么算半个矩阵？
        return cache[X][Y];

    }



    public static void main(String[] args) {
        System.out.println(count(0, 1));
        System.out.println(count_memo(1, 1));
        System.out.println(count_dp(2, 2));
    }
}