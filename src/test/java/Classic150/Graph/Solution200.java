package Classic150.Graph;


// 岛屿数量
public class Solution200 {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < cols; ++j)
                ans += dfs(grid, i, j);
        return ans;
    }
    private int dfs(char[][] grid, int row, int col) {
        if (!inArea(grid, row, col)) return 0;
        if (grid[row][col] != '1') return 0;
        grid[row][col] = '2';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
        return 1;
    }
    private boolean inArea(char[][] grid, int row, int col) {
        return row >= 0 && row < grid.length
                && col >= 0 && col < grid[0].length;
    }
}
