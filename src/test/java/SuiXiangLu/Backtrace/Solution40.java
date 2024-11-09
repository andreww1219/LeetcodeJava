package SuiXiangLu.Backtrace;

import java.util.*;

import static java.util.Arrays.sort;

// 组合总和 II
public class Solution40 {
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
            if (i > startIndex && candidates[i] == candidates[i - 1])
                continue;
            path.add(candidates[i]);
            sum += candidates[i];
            backtrace(candidates, target, i + 1);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates, target, 0);
        return result;
    }
}
