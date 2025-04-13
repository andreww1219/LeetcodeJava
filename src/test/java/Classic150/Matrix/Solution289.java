package Classic150.Matrix;


// 生命游戏
public class Solution289 {
    private final int[][] AROUND = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };
    private boolean inArea(int[][] board, int i, int j) {
        return i >= 0 && i < board.length
                && j >= 0 && j < board[0].length;
    }
    private int alive(int[][] board, int i, int j) {
        if (!inArea(board, i, j) || board[i][j] == 0 || board[i][j] == 2)
            return 0;
        return 1;
    }
    private void update(int[][] board, int i, int j) {
        int aliveCells = 0;
        for (int[] offset: AROUND)
            aliveCells += alive(board, i + offset[0], j + offset[1]);
        if (board[i][j] == 1 && (aliveCells < 2 || aliveCells > 3))
            board[i][j] = 3;    // 活细胞濒死
        else if (board[i][j] == 0 && aliveCells == 3)
            board[i][j] = 2;    // 死细胞复活
    }
    private void confirm(int[][] board, int i, int j) {
        if (board[i][j] == 2) board[i][j] = 1;
        if (board[i][j] == 3) board[i][j] = 0;
    }
    public void gameOfLife(int[][] board) {
        // 0 死细胞, 1 活细胞, 2 复活细胞, 3 濒死细胞
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                update(board, i, j);
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                confirm(board, i, j);
    }
}
