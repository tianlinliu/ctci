/**
 * Write an algorithm such that if an element in an M*N matrix is 0, its entire
 * row and column are set to 0.
 */

 public class Solution7_setZeros {
    /**
     * Use two boolean arrays to record the positions of zeros, then examine them
     * to set rows and columns to zeros.
     *
     * Time: O(N^2)
     * Space: O(N)
     */
    public static void setZeros (int[][] matrix) {
        if (matrix == null) return;

        int row = matrix.length;
        int column = matrix[0].length;
        boolean[] rowFlags = new boolean[row];
        boolean[] columnFlags = new boolean[column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    rowFlags[i] = true;
                    columnFlags[j] = true;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            if (rowFlags[i]) {
                setRowZeros(matrix, i, column);
            }
        }

        for (int j = 0; j < column; j++) {
            if (columnFlags[j]) {
                setColumnZeros(matrix, row, j);
            }
        }
    }

    private static void setRowZeros(int[][] matrix, int row, int column){
        for (int i = 0; i < column; i++) {
            matrix[row][i] = 0;
        }
    }

    private static void setColumnZeros(int[][] matrix, int row, int column) {
        for (int i = 0; i < row; i++) {
            matrix[i][column] = 0;
        }
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
        setZeros(matrix);
        printMatrix(matrix);
    }

 }