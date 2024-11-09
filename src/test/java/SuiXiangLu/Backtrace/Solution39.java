package SuiXiangLu.Backtrace;

import java.util.ArrayList;
import java.util.List;

// 组合总和
public class Solution39 {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int sum = 0;
    private void backtrace(int[] candidates, int target, int startIndex){
        if (target < sum) return;
        if (target == sum){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; ++i) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtrace(candidates, target, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrace(candidates, target, 0);
        return result;
    }
}
