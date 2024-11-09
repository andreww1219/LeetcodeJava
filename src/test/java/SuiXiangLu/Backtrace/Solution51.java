package SuiXiangLu.Backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// N 皇后
public class Solution51 {
    @Test
    public void test() {
        solveNQueens1(4);
        System.out.println(result);
    }
    // 初见，使用二维数组记录访问
    private List<List<String>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private void fill(boolean[][] board, int x, int y, boolean val) {
        for (int i = 0; i < board.length; ++i)
            board[x][i] = val;
        for (int i = 0; i < board.length; ++i)
            board[i][y] = val;
        int delX = 1, delY = 1;
        while (true) {
            boolean modified = false;
            if (!outOfRange(board, x + delX, y + delY)) { modified = true; board[x + delX][y + delY] = val;}
            if (!outOfRange(board, x + delX, y - delY)) { modified = true; board[x + delX][y - delY] = val;}
            if (!outOfRange(board, x - delX, y + delY)) { modified = true; board[x - delX][y + delY] = val;}
            if (!outOfRange(board, x - delX, y - delY)) { modified = true; board[x - delX][y - delY] = val;}
            if (!modified) break;
            delX++;delY++;
        }
    }
    private boolean outOfRange(boolean[][] board, int x, int y){
        return x < 0 || x >= board.length || y < 0 || y >= board.length;
    }

    private void backtrace1(int row, boolean[][] board) {
        int len = board.length;
        if (path.size() == len) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < len; ++i) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < len; ++j) {
                    if (j == path.get(i))
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                res.add(sb.toString());
            }
            result.add(res);
            return;
        }
        for (int col = 0; col < len; ++col) {
            if (board[row][col]) {
                boolean[][] newBoard = new boolean[len][len];
                for (int i = 0; i < len; ++i)
                    for (int j = 0; j < len; ++j)
                        newBoard[i][j] = board[i][j];
                fill(newBoard, row, col, false);
                path.add(col);
                backtrace1(row + 1, newBoard);
                path.remove(path.size() - 1);
            }
        }
    }
    public List<List<String>> solveNQueens1(int n) {
        boolean[][] board = new boolean[n][n];
        for (boolean[] booleans : board) {
            Arrays.fill(booleans, true);
        }
        backtrace1(0, board);
        return result;
    }

    // 行、列、主副对角线分别使用单个数组

    private boolean[] row;
    private boolean[] col;
    private boolean[] dg;   // x + y
    private boolean[] udg;  // y - x + len - 1

    private void storeResult(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            char[] str = new char[n];
            Arrays.fill(str, '.');
            str[path.get(i)] = 'Q';
            res.add(String.copyValueOf(str));
        }
        result.add(res);
    }
    private void backtrace2(int x, int n) {
        if (path.size() == n) {
            storeResult(n);
            return;
        }
        for (int y = 0; y < n; ++y) {
            if (row[x] && col[y] && dg[x + y] && udg[y - x + n - 1]) {
                row[x] = col[y] = dg[x + y] = udg[y - x + n - 1] = false;
                path.add(y);
                backtrace2(x + 1, n);
                path.remove(path.size() - 1);
                row[x] = col[y] = dg[x + y] = udg[y - x + n - 1] = true;
            }
        }
    }
    public List<List<String>> solveNQueens2(int n) {
        row = new boolean[n];
        col = new boolean[n];
        dg = new boolean[2 * n - 1];
        udg = new boolean[2 * n - 1];
        Arrays.fill(row, true);
        Arrays.fill(col, true);
        Arrays.fill(dg, true);
        Arrays.fill(udg, true);
        backtrace2(0, n);
        return result;
    }
}
