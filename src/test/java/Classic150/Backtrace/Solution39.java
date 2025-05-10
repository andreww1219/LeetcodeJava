package Classic150.Backtrace;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 组合总和
public class Solution39 {
    List<List<Integer>> ans = new ArrayList<>();
    private void dfs(int[] candidates, int target, int cur, List<Integer> arr, int curSum) {
        if (curSum == target) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        int len = candidates.length;
        for (int i = cur; i < len && curSum + candidates[i] <= target; ++i) {
            curSum += candidates[i];
            arr.add(candidates[i]);
            dfs(candidates, target, i, arr, curSum);
            curSum -= candidates[i];
            arr.remove(arr.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), 0);
        return ans;
    }
}
