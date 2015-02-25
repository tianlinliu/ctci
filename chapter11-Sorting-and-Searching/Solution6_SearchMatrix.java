/**
 * Given an M*N matrix in which each row and each column is sorted
 * in ascending order, writhe a method to find an element.
 */

// uncompleted.
public class Solution6_SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int[] row = matrix[mid];
            if (row[0] <= targe && row[n - 1] >= target) {
                return Arrays.binarySearch(row, target) >= 0;
            }
            if (row[0] > target) {
                high = mid - 1;
            } else if (row[n - 1] < target) {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}