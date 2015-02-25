/**
 * Write a function to swap a number in place.
 */

public class Solution1_SwapNumbers {
    public static void swap(int A, int B) {
        A = A - B;
        B = B + A;
        A = B - A;

        System.out.println(A + " " + B);

    }

    public static void swap_bit(int A, int B) {
        A = A ^ B;
        B = A ^ B;
        A = A ^ B;

        System.out.println(A + " " + B);

    }

    public static void main(String[] args) {
        int A = 2;
        int B = 7;
        swap(A, B);
        swap_bit(A, B);
    }
}