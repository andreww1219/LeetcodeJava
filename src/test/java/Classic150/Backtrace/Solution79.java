package Classic150.Backtrace;


// 单词搜索
public class Solution79 {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private boolean dfs(char[][] board, boolean[][] vis,
                        String word, StringBuilder sb,
                        int row, int col) {
        if (sb.length() == word.length())
            return true;
        if (row < 0 || row >= board.length
            || col < 0 || col >= board[0].length
            || vis[row][col]
            || word.charAt(sb.length()) != board[row][col])
            return false;
        sb.append(board[row][col]);
        vis[row][col] = true;
        for (int[] dir: dirs)
            if (dfs(board, vis, word, sb, row + dir[0], col + dir[1]))
                return true;
        vis[row][col] = false;
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] vis = new boolean[rows][cols];
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < cols; ++j)
                if (dfs(board, vis, word, new StringBuilder(), i, j))
                    return true;
        return false;
    }
}
