public class Main {
    public static void main(String[] args) {
        int boardSize = 22; // SET BOARD SIZE, 2 AND 3 WILL THROW EXCEPTION
        NQueensPuzzle nQueens = new NQueensPuzzle(boardSize);
        nQueens.solveNQueens();
    }
}
