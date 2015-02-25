/**
 * Given two sorted arrays, A and B, where A has a large enough buffer at
 * the end to hold B. Write a method to merge B into A in sorted order.
 */
import java.util.*;

public class Solution1_Merge {
    /* Merge two arrays from the largest numbers and insert them from the
    * end of A. Comparing to inserting from the beginning, we don't need to
    * move the whole array of A.
    * Time: O(m + n)
    * Space: O(1)
    */
    public static void merge(int[] A, int[] B) {
        if (B == null || B.length == 0) return;

        int r = A.length - 1;
        int b = B.length - 1;
        int a = r - b - 1;
        while (a >= 0 && b >= 0) {
            if (A[a] >= B[b]) {
                A[r--] = A[a--];
            } else {
                A[r--] = B[b--];
            }
        }

        while (b >= 0) {
            A[r--] = B[b--];
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 5, 0, 0};
        int[] B = {3, 4};
        merge(A, B);
        System.out.println(Arrays.toString(A));
    }
}