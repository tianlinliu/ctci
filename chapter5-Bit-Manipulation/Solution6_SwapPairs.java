/**
 * Write a program to swap odd and even bits in an integer with as few instructions
 * as possible. (bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on)
 */

public class Solution6_SwapPairs {
    public static int swap(int num) {
        return ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1);
    }

    public static void main(String[] args) {
        System.out.println(swap(2));
    }
}