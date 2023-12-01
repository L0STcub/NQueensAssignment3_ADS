public class NQueensPuzzle {
    private int n;

    public NQueensPuzzle(int n) {
        this.n = n;
    }

    public void solveNQueens() {
        int[][] board = new int[n][n];

        if (!solveNQueensUtil(board, 0)) {
            System.out.println("Solution does not exist");
        } else {
            printSolution(board);
        }
    }

    private boolean solveNQueensUtil(int[][] board, int col) {
        if (col >= n) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQueensUtil(board, col + 1)) {
                    return true;
                }
                board[i][col] = 0; // BACKTRACK
            }
        }
        return false;
    }

    private boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; j >= 0 && i < n; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private void printSolution(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
    }
}
