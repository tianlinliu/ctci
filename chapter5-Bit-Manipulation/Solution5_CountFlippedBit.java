/**
 * Write a function to determine the number of bits you would need to flip to
 * convert Integer A to Integer B.
 */

public class Solution5_CountFlippedBit {
    public static int count(int a, int b) {
        int result = 0;
        for (int c = a ^ b; c != 0; c = c >> 1) {
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt("10011", 2);
        int b = Integer.parseInt("10000", 2);
        System.out.println(count(a, b));
    }
}