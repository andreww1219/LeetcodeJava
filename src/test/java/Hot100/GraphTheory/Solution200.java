package Hot100.GraphTheory;


import org.junit.Test;

// 岛屿数量
public class Solution200 {
    @Test
    public void test() {
        char[][] grid = {{'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}};
        numIslands1(grid);
    }
    // 初见
    public int numIslands1(char[][] grid) {
        // 将原矩阵围一圈'0'
        int rows = grid.length, cols = grid[0].length;
        char[][] extendedGrid = new char[rows + 2][cols + 2];
        for (int i = 0; i < cols + 2; ++i) {
            extendedGrid[0][i] = '0';
            extendedGrid[rows + 1][i] = '0';
        }
        for (int i = 0; i < rows + 2; ++i) {
            extendedGrid[i][0] = '0';
            extendedGrid[i][cols + 1] = '0';
        }
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < cols; ++j)
                extendedGrid[i + 1][j + 1] = grid[i][j];
        // 对每个格子做深搜
        boolean[][] vis = new boolean[rows + 2][cols + 2];
        for (int i = 0; i < rows + 2; ++i)
            for (int j = 0; j < cols + 2; ++j)
                vis[i][j] = false;
        int islands = 0;
        for (int i = 0; i < rows + 2; ++i)
            for (int j = 0; j < cols + 2; ++j)
                islands += dfs(extendedGrid, vis, i, j);
        return islands;
    }
    private int dfs(char[][] grid, boolean[][] vis, int i, int j) {
        if (vis[i][j] || grid[i][j] == '0') return 0;
        vis[i][j] = true;
        if (i + 1 < grid.length && grid[i + 1][j] == '1')
            dfs(grid, vis, i + 1, j);
        if (i - 1 >= 0 && grid[i - 1][j] == '1')
            dfs(grid, vis, i - 1, j);
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1')
            dfs(grid, vis, i, j + 1);
        if (j - 1 >= 0 && grid[i][j - 1] == '1')
            dfs(grid, vis, i, j - 1);
        return 1;
    }

    // 岛屿问题板子解法
    public int numIslands2(char[][] grid) {
        int cnt = 0;
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < cols; ++j)
                cnt += dfs(grid, i, j);
        return cnt;
    }
    private int dfs(char[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) return 0;
        if (grid[r][c] != '1') return 0;
        grid[r][c] = '2';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
        return 1;
    }
    private boolean inArea(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length
                && c >= 0 && c < grid[0].length;
    }
}
