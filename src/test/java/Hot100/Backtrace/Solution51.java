package Hot100.Backtrace;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// N皇后
public class Solution51 {
    boolean[] colVis;
    boolean[] diag1Vis; // 维度为2*len-1, 下标为x+y
    boolean[] diag2Vis; // 维度为2*len-1, 下标为x-y+len-1

    List<List<String>> ans = new ArrayList<>();
    List<String> ret = new ArrayList<>();

    private void dfs(int n, int row) {
        if (row == n) {
            ans.add(new ArrayList<>(ret));
            return;
        }
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        StringBuilder sb = new StringBuilder(new String(chars));
        for (int col = 0; col < n; ++col) {
            if (colVis[col] || diag1Vis[row + col] || diag2Vis[row - col + n - 1])
                continue;
            sb.setCharAt(col, 'Q');
            ret.add(sb.toString());
            colVis[col] = true;
            diag1Vis[row + col] = true;
            diag2Vis[row - col + n - 1] = true;
            dfs(n, row + 1);    // 进入下一层搜索
            sb.setCharAt(col, '.');
            ret.remove(ret.size() - 1);
            colVis[col] = false;
            diag1Vis[row + col] = false;
            diag2Vis[row - col + n - 1] = false;
        }
    }
    public List<List<String>> solveNQueens(int n) {
        colVis = new boolean[n];
        diag1Vis = new boolean[2 * n - 1];
        diag2Vis = new boolean[2 * n - 1];
        dfs(n, 0);
        return ans;
    }
}
