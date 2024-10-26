package Backtrace;


import java.util.ArrayList;
import java.util.List;

// 子集
public class Solution78 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void backtrace(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; ++i) {
            path.add(nums[i]);
            backtrace(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums, 0);
        return result;
    }
}
