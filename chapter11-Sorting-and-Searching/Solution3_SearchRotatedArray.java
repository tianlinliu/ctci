/**
 * Given a sorted array of n integers that has been rotated unknown times,
 * write code to find an element in the array. Assume the arraywas
 * originally sorted in increasing order.
 */

public class Solution3_SearchRotatedArray {
    /* Assume no duplicates.
     * Use binary search, but first determine which half is sorted.
     */
    public static int search(int[] A, int target) {
        if (A.length == 0) return -1;

        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] >= A[low]) { // left half is sorted.
                if (A[low] <= target && A[mid] > target) { // target is located in left half.
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (A[mid] < target && A[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int searchWithDup(int[] A, int target) {
        if (A.length == 0) return -1;

        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == target) return mid;
            if (A[low] == A[mid]) {
                low++;
            } else if (A[low] < A[mid]) {
                if (A[low] <= target && A[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (A[mid] < target && A[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1, 1, 1, 1};
        //System.out.println(search(A, 1));
        System.out.println(searchWithDup(A, 1));
    }
}