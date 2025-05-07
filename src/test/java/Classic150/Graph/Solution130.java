package Classic150.Graph;


import org.junit.Test;

// 被围绕的区域
public class Solution130 {
    @Test
    public void test() {
        char[][] board = {
            {'O','X','X','O','X'},
            {'X','O','O','X','O'},
            {'X','O','X','O','X'},
            {'O','X','O','O','O'},
            {'X','X','O','X','O'}
        };
        solve(board);
    }
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; ++row) {
            dfs(board, row, 0);
            dfs(board, row, cols - 1);
        }
        for (int col = 0; col < cols; ++col) {
            dfs(board, 0, col);
            dfs(board, rows - 1, col);
        }
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (board[row][col] == 'O')
                    board[row][col] = 'X';
                else if (board[row][col] == 'o')
                    board[row][col] = 'O';
            }
        }
    }
    private void dfs(char[][] board, int row, int col) {
        // 返回是否被包围
        if (!inArea(board, row, col)) return;
        if (board[row][col] != 'O') return;
        board[row][col] = 'o';  //标记
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
    private boolean inArea(char[][] board, int row, int col) {
        return row >= 0 && row < board.length
                && col >= 0 && col < board[0].length;
    }
}
