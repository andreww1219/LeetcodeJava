package Hot100.Backtrace;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 子集
public class Solution78 {
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> set = new HashSet<>(); // 对元素去重

    private void backtrace(int[] nums, List<Integer> arr, int start) {
        result.add(new ArrayList<>(arr));
        int len = nums.length;
        for (int i = start; i < len; ++i) {
            if (set.contains(nums[i])) continue;
            arr.add(nums[i]);
            set.add(nums[i]);
            backtrace(nums, arr, i + 1);
            arr.remove(arr.size() - 1);
            set.remove(nums[i]);
        }
    }
    public List<List<Integer>> subsets1(int[] nums) {
        backtrace(nums, new ArrayList<>(), 0);
        return result;
    }
    // 题解
    List<Integer> arr = new ArrayList<>();
    private void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            result.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[cur]);
        dfs(cur + 1, nums); // 选中 cur
        arr.remove(arr.size() - 1);
        dfs(cur + 1, nums); // 不选中 cur
    }
    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0, nums);
        return result;
    }
}
