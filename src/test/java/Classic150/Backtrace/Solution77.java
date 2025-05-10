package Classic150.Backtrace;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 组合
public class Solution77 {
    private List<List<Integer>> ans;

    private void dfs(int n, int k, int cur, List<Integer> result) {
        if (result.size() == k) {
            ans.add(new ArrayList<>(result));
            return;
        }
        for (int i = cur; i <= n - (k - result.size()) + 1; ++i) {    // 剪枝
            result.add(i);
            dfs(n, k, i + 1, result);
            result.remove(result.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        dfs(n, k, 1, new LinkedList<>());
        return ans;
    }
}
