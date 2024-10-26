package Backtrace;

import java.util.ArrayList;
import java.util.List;

// 组合总和 III
public class Solution216 {
    // 初见
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int curSum = 0;
    private void backtrace(int k, int sum, int maxIndex) {
        if (path.size() == k){
            if (curSum == sum)
                result.add(new ArrayList<>(path));
            return;
        }
        // 最大不能超过 sum - curSum
        // 还缺少 k - path.size() 个数
        for (int i = Math.min(maxIndex, sum - curSum); i >= k - path.size(); --i) {
            path.add(i);
            curSum += i;
            backtrace(k, sum, i - 1);
            curSum -= i;
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
//        backtrace(k, n, 9);
        backtrace(n, k, 1, 0);
        return result;
    }
    // 标准题解
    private void backtrace(int targetSum, int k, int startIndex, int sum) {
        // 根据数值和剪枝
        if (sum > targetSum)
            return;
        if (path.size() == k){
            if (curSum == targetSum)
                result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; ++i) {
            path.add(i);
            curSum += i;
            backtrace(targetSum, k, sum, i - 1);
            curSum -= i;
            path.remove(path.size() - 1);
        }
    }
}
