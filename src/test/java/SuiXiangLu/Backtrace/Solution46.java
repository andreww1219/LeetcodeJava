package SuiXiangLu.Backtrace;

import java.util.ArrayList;
import java.util.List;

// 全排列
public class Solution46 {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private boolean[] vis = new boolean[32];
    private void backtrace(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!vis[nums[i] + 10]) {
                vis[nums[i] + 10] = true;
                path.add(nums[i]);
                backtrace(nums);
                path.remove(path.size() - 1);
                vis[nums[i] + 10] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        backtrace(nums);
        return result;
    }
}
