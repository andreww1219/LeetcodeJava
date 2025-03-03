package Hot100.Backtrace;


import java.util.ArrayList;
import java.util.List;

// 组合总和
public class Solution39 {
    List<List<Integer>> res = new ArrayList<>();
    private void backtrace(int[] candidates, int target, List<Integer> arr, int sum, int start) {
        if (start == candidates.length) return;
        if (sum == target) {
            res.add(new ArrayList<>(arr));
            return;
        }
        // 选择
        if (candidates[start] + sum <= target) {
            arr.add(candidates[start]);
            backtrace(candidates, target, arr, sum + candidates[start], start);
            arr.remove(arr.size() - 1);
        }
        // 不选择
        backtrace(candidates, target, arr, sum, start + 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrace(candidates, target, new ArrayList<>(), 0, 0);
        return res;
    }
}
