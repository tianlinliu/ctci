/**
 * A magic index in an array A[1...n - 1] is defined to be an index such that A[i] = i.
 * Given a sorted array of distinct integers, wite a method to find a magic index,
 * if one exists, in array A.
 *
 * FOLLOW UP
 * What if the values are not distinct?
 */

public class Solution3_magicNum {
    public static int magicNum(int[] A) {
        if (A == null || A.length == 0) return -1;

        return findNum(A, 0, A.length - 1);
    }

    private static int findNum(int[] A, int low, int high) {
        if (low > high) return - 1;

        int mid = low + (high - low) / 2;
        if (A[mid] == mid) {
            return mid;
        } else if (A[mid] > mid) {
            return findNum(A, low, mid - 1);
        } else {
            return findNum(A, mid + 1, high);
        }
    }

    public static int magicNumWithDup(int[] A) {
        if (A == null || A.length == 0) return -1;

        return magicNumWithDup(A, 0, A.length - 1);
    }

    private static int magicNumWithDup(int[] A, int low, int high) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;
        if (A[mid] == mid) {
            return mid;
        }

        int left = magicNumWithDup(A, low, Math.min(A[mid], mid));
        if (left != -1) {
            return left;
        }

        int right = magicNumWithDup(A, Math.max(A[mid], mid), high);
        /*
        if (right != -1) {
            return right;
        }

        return -1;
        */
        return right;
    }

    public static void main(String[] args) {
        int[] A = new int[] {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        System.out.println(magicNum(A));

        int[] B = new int[] {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        System.out.println(magicNumWithDup(B));
    }
}