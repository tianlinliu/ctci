/**
 * Question 1.6:
 * Given an image represented by an N*N matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees.
 */

 public class Solution6_rotate {
    /**
     * Create a new matrix, copy each value to the rotated position.
     *
     * Time:O(n^2)
     * Space: O(n)
     */
    public static int[][] rotate(int[][] matrix) {
        if (matrix == null) return null;

        int n = matrix.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - 1 - i] = matrix[i][j];
            }
        }
        return result;
    }

    /**
     * Hold the value in the top line, then let top = left, left = bottom,
     * bottom = right, right = temp.
     *
     * Time: O(N^2)
     * Space: O(1)
     */
    public static int[][] rotate2(int[][] matrix, int n) {
        if (matrix == null) return null;

        for (int i = 0; i <= n / 2; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i][j];
                matrix[n - i][j] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[i][n - j];
                matrix[i][n - j] = temp;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Matrix = ");
        for (int[] row: matrix) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        printMatrix(rotate2(new int[][] {{1, 2}, {3, 4}}, 2));
    }
 }