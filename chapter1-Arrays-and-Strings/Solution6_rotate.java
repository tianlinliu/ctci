/**
 * Question 1.6:
 * Given an image represented by an N*N matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees.
 */

 public class Solution6_rotate {
    /**
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

    private static void printMatrix(int[][] matrix) {
        System.out.println("Matrix = ");
        for (int[] row: matrix) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        printMatrix(rotate(new int[][] {{1, 2}, {3, 4}}));
    }
 }