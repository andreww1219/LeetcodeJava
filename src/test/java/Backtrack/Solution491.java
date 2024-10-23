package Backtrack;

import java.util.*;

// 非递减子序列
public class Solution491 {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private void backtrace(int[] nums, int startIndex) {
        if (path.size() >= 2)
            result.add(new ArrayList<>(path));
        // set 去重
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; ++i) {
            if (set.contains(nums[i]))
                continue;
            if (path.isEmpty() ||
                path.get(path.size() - 1) <= nums[i]) {
                path.add(nums[i]);
                backtrace(nums, i + 1);
                path.remove(path.size() - 1);
                set.add(nums[i]);
            }
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrace(nums, 0);
        return result;
    }
}
