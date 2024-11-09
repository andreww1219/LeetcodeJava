package SuiXiangLu.Backtrace;

import java.util.Arrays;

// 解数独
public class Solution37 {
    private boolean[][] row = new boolean[9][9];
    private boolean[][] col = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];

    private boolean backtrace(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.')
                    continue;
                for (char ch = '1'; ch <= '9'; ++ch) {
                    int num = ch - '0';
                    if (board[i][j] == '.'
                            && row[i][num - 1]
                            && col[j][num - 1]
                            && block[i / 3][j / 3][num - 1]) {
                        board[i][j] = ch;
                        row[i][num - 1] = false;
                        col[j][num - 1] = false;
                        block[i / 3][j / 3][num - 1] = false;
                        if (backtrace(board)) return true;
                        board[i][j] = '.';
                        row[i][num - 1] = true;
                        col[j][num - 1] = true;
                        block[i / 3][j / 3][num - 1] = true;
                    }
                }
                return false;
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i)
            Arrays.fill(row[i], true);
        for (int i = 0; i < 9; ++i)
            Arrays.fill(col[i], true);
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                Arrays.fill(block[i][j], true);
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    row[i][board[i][j] - '0' - 1] = false;
                    col[j][board[i][j] - '0' - 1] = false;
                    block[i / 3][j / 3][board[i][j] - '0' - 1] = false;
                }
            }
        }
        backtrace(board);
    }
}
