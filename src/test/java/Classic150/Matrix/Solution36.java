package Classic150.Matrix;


// 有效的数独
public class Solution36 {
    private final int N = 9;
    private final int RANGE = 10;
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowVis = new boolean[N][RANGE];
        boolean[][] colVis = new boolean[N][RANGE];
        boolean[][] blockVis = new boolean[N][RANGE];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                if (rowVis[i][num] || colVis[j][num] || blockVis[i / 3 * 3 + j / 3][num])
                    return false;
                rowVis[i][num] = true;
                colVis[j][num] = true;
                blockVis[i / 3 * 3 + j / 3][num] = true;
            }
        }
        return true;
    }
}
