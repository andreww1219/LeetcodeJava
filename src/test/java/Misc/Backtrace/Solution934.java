package Misc.Backtrace;
// 最短的桥
public class Solution934 {
    public int shortestBridge(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean flag = false;
        // 将一座岛染成2
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 1) {
                    initDfs(grid, i, j);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        // 从所有2出发，bfs扩展找到通往1的道路
        int cnt = 0;
        boolean[][] vis = new boolean[rows][cols];
        while (true) {
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    if (vis[i][j] || grid[i][j] != 2) continue;
                    vis[i][j] = true;
                    if (check(grid, vis, i + 1, j)) return cnt;
                    if (check(grid, vis, i - 1, j)) return cnt;
                    if (check(grid, vis, i, j + 1)) return cnt;
                    if (check(grid, vis, i, j - 1)) return cnt;
                }
            }
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    if (grid[i][j] == 3) grid[i][j] = 2;
                }
            }
            cnt++;
        }
    }
    private void initDfs(int[][] grid, int i, int j) {
        if (!inArea(grid, i, j)) return;
        if (grid[i][j] != 1) return;
        grid[i][j] = 2;
        initDfs(grid, i + 1, j);
        initDfs(grid, i - 1, j);
        initDfs(grid, i, j + 1);
        initDfs(grid, i, j - 1);
    }
    private boolean check(int[][] grid, boolean[][] vis, int i, int j) {
        if (!inArea(grid, i, j) || grid[i][j] == 2) return false;
        if (grid[i][j] == 1) return true;
        grid[i][j] = 3;
        return false;
    }
    private boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length
                && j >= 0 && j < grid[0].length;
    }
}
