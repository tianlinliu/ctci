/**
 * Write an algorithm such that if an element in an M*N matrix is 0, its entire
 * row and column are set to 0.
 */

 public class Solution7_setZeros {
    /**
     *
     */
    public static int[][] setZeros (int[][] matrix) {
        if (matrix == null) return null;

        int row = matrix.length;
        int column = matrix[0].length;
        int[][] result = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    for (int r = 0; r < row; r++) {
                        result[i][r] = 0;
                    }
                    for (int c = 0; c < column; c++) {
                        result[c][j] = 0;
                    }
                }
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
        int[][] matrix = new int[][] {{11, 12, 13, 14}, {21, 22, 23, 24},
            {31, 32, 0, 34}, {41, 42, 43, 44}};
        printMatrix(matrix);
        printMatrix(setZeros(matrix));
    }

 }