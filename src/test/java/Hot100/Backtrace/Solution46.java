package Hot100.Backtrace;


import java.util.ArrayList;
import java.util.List;

// 全排列
public class Solution46 {
    List<List<Integer>> result = new ArrayList<>();

    private void backtrace(int[] nums, List<Integer> arr, boolean[] vis) {
        if (arr.size() == nums.length) {
            result.add(new ArrayList<>(arr));
            return;
        }
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (vis[i]) continue;
            arr.add(nums[i]);
            vis[i] = true;
            backtrace(nums, arr, vis);
            arr.remove(arr.size() - 1);
            vis[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        backtrace(nums, new ArrayList<>(), vis);
        return result;
    }
}
