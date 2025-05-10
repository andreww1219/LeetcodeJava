package Classic150.Backtrace;


// N皇后II
public class Solution52 {
    boolean[] colVis;
    boolean[] diagVis1; // x+y
    boolean[] diagVis2; // x-y+n-1
    int ans = 0;
    private void dfs(int n, int row) {
        if (row == n) {
            ans++;
            return;
        }
        for (int col = 0; col < n; ++col) {
            if (colVis[col] || diagVis1[row + col] || diagVis2[row - col + n - 1])
                continue;
            colVis[col] = true;
            diagVis1[row + col] = true;
            diagVis2[row - col + n - 1] = true;
            dfs(n, row + 1);
            colVis[col] = false;
            diagVis1[row + col] = false;
            diagVis2[row - col + n - 1] = false;
        }
    }
    public int totalNQueens(int n) {
        colVis = new boolean[n];
        diagVis1 = new boolean[2 * n - 1];
        diagVis2 = new boolean[2 * n - 1];
        dfs(n, 0);
        return ans;
    }
}
