/**
 * Question 5.1:
 * Given two 32-bit numbers, N and M, and two bit positons, i and j. Write a method to
 * insert M into N such that M starts at bit j and ends at bit i. Assume that the bits j
 * through i have enough space to fit all of M.
 *
 * i = 2, j = 4, mask = 11100011
 *                         j i
 */

public class Solution1_UpdateBits {
    public static int updateBits(int n, int m, int i, int j) {
        //1.create a mask that sets bits from i to j to 0
        int mask = -1;
        // 11100000
        mask = mask << (j + 1);
        // 00000011
        int right = (1 << i) - 1;
        // 11100011, OR
        mask = mask | right;

        //2.clear the bits in  from i to j
        int cleard = n & mask;
        //3.set i to j position to number m
        return cleard | (m << i);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt("100000000", 2);
        int m = Integer.parseInt("11", 2);
        int result = updateBits(n, m, 2, 4);
        System.out.println(Integer.toBinaryString(result));
    }
}