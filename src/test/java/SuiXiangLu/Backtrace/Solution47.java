package SuiXiangLu.Backtrace;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 全排列 II
public class Solution47 {
    // 初见，无排序双数组版
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private boolean[] vis = new boolean[32];

    private void backtrace1(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        boolean[] used = new boolean[32];
        for (int i = 0; i < nums.length; ++i) {
            if (!vis[i] && !used[nums[i] + 10]) {
                vis[i] = true;
                path.add(nums[i]);
                backtrace1(nums);
                path.remove(path.size() - 1);
                vis[i] = false;
                used[nums[i] + 10] = true;
            }
        }
    }
    public List<List<Integer>> permuteUnique1(int[] nums) {
        backtrace1(nums);
        return result;
    }

    // 标准题解 排序单数组版

    private void backtrace2(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            // 同一层使用过该数字
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backtrace2(nums, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }

        }
    }
    public List<List<Integer>> permuteUnique2(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backtrace2(nums, used);
        return result;
    }
}
