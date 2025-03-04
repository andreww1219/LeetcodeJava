package Hot100.Backtrace;


// 单词搜索
public class Solution79 {
    int[] dir_x = {0, 1, 0, -1};
    int[] dir_y = {1, 0, -1, 0};
    private boolean dfs(char[][] board, boolean[][] vis, String word, StringBuilder curWord, int x, int y) {
        if (word.length() < curWord.length()) return false;
        if (word.contentEquals(curWord)) return true;
        for (int i = 0; i < 4; ++i) {
            int xx = x + dir_x[i], yy = y + dir_y[i];
            if (xx < 0 || xx >= board.length || yy < 0 || yy >= board[0].length
                || vis[xx][yy]) continue;
            vis[xx][yy] = true;
            curWord.append(board[xx][yy]);
            if (dfs(board, vis, word, curWord, xx, yy))
                return true;
            vis[xx][yy] = false;
            curWord.deleteCharAt(curWord.length() - 1);
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                StringBuilder sb = new StringBuilder();
                boolean[][] vis = new boolean[board.length][board[0].length];
                sb.append(board[i][j]);
                vis[i][j] = true;
                if (dfs(board, vis, word, sb, i, j)) return true;
            }
        }
        return false;
    }
}
