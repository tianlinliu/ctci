/**
 * Write an algorithm to print all ways of arranging eight queens on an 8*8 chess
 * board so that none of them share the same row, column or diagonal. In this case,
 * "diagonal" means all diagonals, not just the two that bisect the board.
 */
import java.util.*;

public class Solution9_EightQueens {
    public ArrayList<Integer[]> eightQueens(int gridSize) {
        ArrayList<Integer[]> result = new ArrayList<>();
        if (gridSize <= 0) return result;

        Integer[] columns = new Integer[gridSize];
        placeQueens(gridSize, 0, columns, result);
        return result;
    }

    public void placeQueens(int gridSize, int row, Integer[] columns, ArrayList<Integer[]> result) {
        if (row == gridSize) {
            System.out.println(row);
            result.add(columns.clone());
            return;
        }

        for (int col = 0; col < gridSize; col++) {
            if (checkValid(columns, row, col)) {
                System.out.println("check " + col + " " + row);

                columns[row] = col;
                placeQueens(gridSize, row + 1, columns, result);
            }
        }
    }

    private boolean checkValid(Integer[] columns, int row1, int column1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int column2 = columns[row2];
            if (column1 == column2) {
                return false;
            }

            int columnDistance = Math.abs(column2 - column1);
            int rowDistance = row1 - row2;
            if (columnDistance == rowDistance) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution9_EightQueens board = new Solution9_EightQueens();
        ArrayList<Integer[]> result = board.eightQueens(3);
        System.out.println(result.size());
        for (Integer[] i : result) {
            System.out.println(i.toString());
        }
    }
}